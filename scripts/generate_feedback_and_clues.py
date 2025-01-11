import sys
import os
import requests
from openai import OpenAI  # Assuming you're using a client-based approach

def main(pr_number, test_results_file):
    # Read test results
    with open(test_results_file, 'r') as f:
        test_results = f.read()
    
    # Prepare the prompt
    prompt = (
        f"The student's code failed the following tests:\n\n{test_results}\n\n"
        "Provide constructive and concise feedback to help the student understand what went wrong and how to fix it."
    )

    # Initialize OpenAI client
    api_key = os.getenv('OPENAI_API_KEY')
    if not api_key:
        print("Error: OPENAI_API_KEY is not set.")
        sys.exit(1)

    client = OpenAI(api_key=api_key)

    # Call OpenAI API using the new format
    try:
        response = client.chat.completions.create(
            model="chatgpt-4o-latest",
            messages=[
                {
                    "role": "system",
                    "content": "You are a helpful instructor providing constructive feedback to a student.",
                    "content": "You are instructive but to the point and concise with your help and do not reveal the whole answer to the students but provide hints so that they can get there."
                },
                {"role": "user", "content": prompt}
            ],
            max_tokens=500,
            temperature=0.7,
        )
        feedback = response.choices[0].message.content.strip()
    except Exception as e:
        print(f"Error generating feedback: {e}")
        sys.exit(1)

    # Post the feedback as a comment on the PR
    gh_token = os.getenv('GH_TOKEN') or os.getenv('GITHUB_TOKEN')
    if not gh_token:
        print("Error: GH_TOKEN or GITHUB_TOKEN is not set.")
        sys.exit(1)

    repo = os.getenv('GITHUB_REPOSITORY')
    if not repo:
        print("Error: GITHUB_REPOSITORY is not set.")
        sys.exit(1)

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
    if len(sys.argv) != 3:
        print("Usage: python generate_feedback_and_clues.py <pr_number> <test_results_file>")
        sys.exit(1)
    pr_number = sys.argv[1]
    test_results_file = sys.argv[2]
    main(pr_number, test_results_file)
