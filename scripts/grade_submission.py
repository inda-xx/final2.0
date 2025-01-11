import os
import sys
import openai
import requests

def main(api_key, pull_request_number):
    if not api_key:
        print("Error: OpenAI API key is missing.")
        sys.exit(1)

    openai.api_key = api_key

    # Read the student's code from the task template location
    try:
        with open("src/template_code.java", "r") as file:
            student_code = file.read()
    except FileNotFoundError:
        print("Error: template_code.java file not found.")
        sys.exit(1)

    # Read the solution code
    try:
        with open("src/.hidden_tasks/new_task_solution.java", "r") as file:
            solution_code = file.read()
    except FileNotFoundError:
        print("Error: new_task_solution.java file not found.")
        sys.exit(1)

    # Create prompt for evaluating the code
    prompt = (f"Evaluate the following student's code based on the solution provided. "
              "Give feedback on the correctness, efficiency, and coding style. "
              "Point out any errors and suggest improvements.\n\n"
              f"### Student's Code\n```java\n{student_code}\n```\n\n"
              f"### Solution Code\n```java\n{solution_code}\n```\n")

    # Call OpenAI API to evaluate the student's code
    try:
        response = openai.Completion.create(
            model="chatgpt-4o-latest",
            prompt=prompt,
            max_tokens=500
        )
        feedback = response.choices[0].text.strip()
    except Exception as e:
        print(f"Error generating feedback: {e}")
        sys.exit(1)

    # Post the feedback as a comment on the pull request
    repo_name = os.getenv('GITHUB_REPOSITORY')
    github_token = os.getenv('GITHUB_TOKEN')
    headers = {
        "Authorization": f"token {github_token}",
        "Accept": "application/vnd.github.v3+json"
    }
    comment_url = f"https://api.github.com/repos/{repo_name}/issues/{pull_request_number}/comments"
    comment_body = {
        "body": feedback
    }
    response = requests.post(comment_url, json=comment_body, headers=headers)
    if response.status_code != 201:
        print(f"Error posting comment: {response.status_code} {response.text}")
        sys.exit(1)

if len(sys.argv) != 3:
    print("Error: Missing required command line arguments 'api_key' and 'pull_request_number'")
    sys.exit(1)

api_key = sys.argv[1]
pull_request_number = sys.argv[2]

main(api_key, pull_request_number)
