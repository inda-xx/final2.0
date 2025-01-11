import os
import sys
import subprocess
from openai import OpenAI

def main(api_key, branch_name):
    if not api_key:
        print("Error: OpenAI API key is missing.")
        sys.exit(1)

    client = OpenAI(api_key=api_key)

    # Read the existing solution code from .hidden_tasks directory
    solution_dir = ".hidden_tasks"
    solution_files = []
    try:
        for filename in os.listdir(solution_dir):
            if filename.endswith(".java"):
                with open(os.path.join(solution_dir, filename), "r") as file:
                    solution_files.append((filename, file.read()))
        if not solution_files:
            print("Error: No Java solution files found in .hidden_tasks.")
            sys.exit(1)
    except FileNotFoundError:
        print("Error: Solution files not found in .hidden_tasks directory.")
        sys.exit(1)

    # Generate a template from the solution for each file using OpenAI API
    for filename, solution_content in solution_files:
        template_content = generate_template_with_openai(client, solution_content)

        if not template_content:
            print(f"Error: Failed to generate template for {filename}. Using fallback.")
            template_content = generate_template_fallback(solution_content)

        # Write the final template to gen_src directory
        gen_src_dir = "gen_src"
        os.makedirs(gen_src_dir, exist_ok=True)
        file_path = os.path.join(gen_src_dir, filename)

        try:
            with open(file_path, "w") as template_file:
                template_file.write(template_content)
            print(f"Successfully created template for {filename}")
        except IOError as e:
            print(f"Error writing file {filename}: {e}")

    # Commit and push changes
    commit_and_push_changes(branch_name, gen_src_dir)

def generate_template_with_openai(client, solution_content):
    """
    Uses the OpenAI API to generate a code template by removing implementation details
    while retaining class and method signatures.
    """
    prompt = (
            "You are part of a task generation system to create weekly tasks for CS1 students."
            "Your goal is to create templates that provide a template for the studnets to solve their weekly tasks."
            "The template will be based on the solution files to the task, so you must strip away most of the code but still provide a good enough scaffolding for the studnets to slove their task"
            "The scaffolding should purely assist them in understanding the general expected structure, without in any way revealing the answer."
            "Given the following Java solution code, remove all implementation details and leave only the class and method signatures. "
            "Ensure that the structure is correct, add comments very sparsely and only in instances that it is absoltly necessary.\n\n"
            "### Solution Code:\n"
            f"{solution_content}\n\n"
            "IMPORTANT: The response must be plain Java code with no markdown formatting or ```java blocks. "
            "Remember to put the right code in the right java file and take consideration to the names of the java classes with condsideration to the file they are in."
    )

    template = generate_with_retries(client, prompt, max_retries=3)
    return template

def generate_with_retries(client, prompt, max_retries=3):
    for attempt in range(max_retries):
        try:
            response = client.chat.completions.create(
                model="chatgpt-4o-latest",
                messages=[
                    {"role": "system", "content": "You are a helpful assistant."},
                    {"role": "user", "content": prompt}
                ]
            )
            return response.choices[0].message.content.strip()
        except Exception as e:
            print(f"Error generating response: {e}")
            if attempt < max_retries - 1:
                print("Retrying...")
            else:
                return None

def generate_template_fallback(solution_content):
    """
    Fallback method to manually generate a template by removing method bodies.
    """
    template_lines = []
    in_method_body = False

    for line in solution_content.splitlines():
        stripped_line = line.strip()

        # Detect the start of a method (line ending with '{' but not class declaration)
        if stripped_line.endswith("{") and not stripped_line.startswith("class"):
            template_lines.append(line)  # Keep the method signature
            template_lines.append("    // TODO: Implement this method.")
            in_method_body = True
        elif in_method_body:
            # Detect the end of a method
            if stripped_line == "}":
                template_lines.append(line)  # Keep the closing brace
                in_method_body = False
            # Skip other lines inside the method body
            continue
        else:
            template_lines.append(line)  # Keep class structure and other elements

    return "\n".join(template_lines)

def commit_and_push_changes(branch_name, directory_path):
    if not branch_name:
        print("Error: Branch name is empty.")
        sys.exit(1)

    try:
        # Configure Git user
        subprocess.run(["git", "config", "--global", "user.email", "actions@github.com"], check=True)
        subprocess.run(["git", "config", "--global", "user.name", "github-actions"], check=True)

        # Fetch the latest changes from the remote
        subprocess.run(["git", "fetch", "origin"], check=True)

        # Check out the branch or create it if it doesn't exist
        subprocess.run(["git", "checkout", "-B", branch_name], check=True)

        # Stage changes and commit
        subprocess.run(["git", "add", directory_path], check=True)
        subprocess.run(["git", "commit", "-m", "Add generated template code"], check=True)

        # Push the changes
        subprocess.run(
            ["git", "push", "--set-upstream", "origin", branch_name],
            check=True,
            env=dict(os.environ, GIT_ASKPASS='echo', GIT_USERNAME='x-access-token', GIT_PASSWORD=os.getenv('GITHUB_TOKEN'))
        )
    except subprocess.CalledProcessError as e:
        print(f"Error committing and pushing changes: {e}")
        sys.exit(1)

if __name__ == "__main__":
    if len(sys.argv) != 3:
        print("Usage: python generate_template_code.py <api_key> <branch_name>")
        sys.exit(1)

    api_key = sys.argv[1]
    branch_name = sys.argv[2]

    main(api_key, branch_name)
