import os
import sys
from openai import OpenAI

def sanitize_description(api_key, branch_name):
    if not api_key:
        print("Error: OpenAI API key is missing.")
        sys.exit(1)

    # Initialize OpenAI client
    client = OpenAI(api_key=api_key)

    # Read the existing task description
    task_file_path = os.path.join("tasks", "new_task.md")
    with open(task_file_path, "r") as file:
        task_description = file.read()

    # Generate sanitized description
    system_message = (
        "You are an experienced programming instructor tasked with refining a task description. "
        "The task must remain pedagogically valuable and aligned with the learning goals. "
        "Remove any explicit code solutions or overly detailed hints and replace them with subtle scaffolding hints. "
        "Ensure that the rest of the description remains unaltered and is still engaging for students."
    )
    user_message = (
        f"The following is the current task description:\n\n{task_description}\n\n"
        "Refine the task description to remove any explicit solutions while retaining subtle hints "
        "in the form of code snippets where necessary."
    )

    base_settings = {
        "model": "chatgpt-4o-latest",
        "temperature": 0.5,
        "max_tokens": 1500,
    }

    messages = [
        {"role": "system", "content": system_message},
        {"role": "user", "content": user_message},
    ]
    response = client.chat.completions.create(messages=messages, **base_settings)
    sanitized_description = response.choices[0].message.content

    # Overwrite the task description file
    with open(task_file_path, "w") as file:
        file.write(sanitized_description)

if __name__ == "__main__":
    if len(sys.argv) != 3:
        print("Error: Missing required arguments 'api_key' and 'branch_name'")
        sys.exit(1)

    api_key = sys.argv[1]
    branch_name = sys.argv[2]
    sanitize_description(api_key, branch_name)
