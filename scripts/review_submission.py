import os
import sys
import requests 
from openai import OpenAI


def main():
    # Environment variables
    api_key = os.getenv('OPENAI_API_KEY')
    gh_token = os.getenv('GH_TOKEN') or os.getenv('GITHUB_TOKEN')
    repo = os.getenv('GITHUB_REPOSITORY')
    pr_number = os.getenv('GITHUB_PR_NUMBER')

    if not all([api_key, gh_token, repo, pr_number]):
        print("Error: Missing environment variables.")
        sys.exit(1)

    # Initialize OpenAI client
    client = OpenAI(api_key=api_key)

    # Read the task description from tasks/new_task.md
    try:
        with open('tasks/new_task.md', 'r') as f:
            task_description = f.read()
    except FileNotFoundError:
        print("Error: Task description file 'tasks/new_task.md' not found.")
        sys.exit(1)

    # Collect student's submission code from gen_src directory
    submission_code = ""
    for root, dirs, files in os.walk('gen_src'):
        for file in files:
            if file.endswith('.java'):
                file_path = os.path.join(root, file)
                with open(file_path, 'r') as code_file:
                    code_content = code_file.read()
                    submission_code += f"// File: {file_path}\n{code_content}\n\n"

    if not submission_code:
        print("Error: No Java files found in 'gen_src' directory.")
        sys.exit(1)

    # Prepare the prompt
    prompt = (
        "You are a Java programming instructor. A student has submitted code for the following assignment:\n\n"
        f"{task_description}\n\n"
        "Here is the student's submission:\n\n"
        f"{submission_code}\n\n"
        "Please review the student's code for correctness, code quality, and adherence to the assignment requirements. "
        "Check if the code compiles and meets the task objectives. "
        "Provide constructive feedback, pointing out any issues and suggesting improvements. Your suggestions should be subtle hints to help the student with their submission rather than revealing the answer. "
        "If the code is sound and correct, provide positive feedback and perhaps suggest advanced topics for further learning."
        "Keep your output to a point and be concise and effective in your answers."
    )

    # Call OpenAI API
    try:
        response = client.chat.completions.create(
            model="chatgpt-4o-latest",
            messages=[
                {
                    "role": "system",
                    "content": "You are a helpful and thorough Java programming instructor."
                },
                {"role": "user", "content": prompt}
            ],
            max_tokens=1000,
            temperature=0.7,
        )
        feedback = response.choices[0].message.content.strip()
    except Exception as e:
        print(f"Error generating feedback: {e}")
        sys.exit(1)

    # Post the feedback as a comment on the PR
    comment_url = f"https://api.github.com/repos/{repo}/issues/{pr_number}/comments"
    headers = {
        'Authorization': f'token {gh_token}',
        'Accept': 'application/vnd.github.v3+json'
    }
    data = {'body': feedback}

    r = requests.post(comment_url, json=data, headers=headers)
    if r.status_code == 201:
        print('Feedback posted successfully.')
    else:
        print(f'Failed to post feedback: {r.status_code} {r.text}')
        sys.exit(1)

if __name__ == "__main__":
    main()
