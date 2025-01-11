import sys
import os
import requests
from openai import OpenAI  


def main(pr_number, test_results_file):
    # Prepare the prompt
    prompt = (
        "A student has submitted their solution for a programming assignment, and their code passed all the tests.\n\n"
        "Provide a congratulatory message to the student, do not make it too rosy or too long but simple, and suggest some further readings or topics they can explore to deepen their understanding."
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
                    "content": "You are a helpful instructor providing positive feedback to a student."
                },
                {"role": "user", "content": prompt}
            ],
            max_tokens=300,
            temperature=0.7,
        )
        message = response.choices[0].message.content.strip()
    except Exception as e:
        print(f"Error generating message: {e}")
        sys.exit(1)

    # Post the message as a comment on the PR
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
    data = {'body': message}

    r = requests.post(comment_url, json=data, headers=headers)
    if r.status_code == 201:
        print('Message posted successfully.')
    else:
        print(f'Failed to post message: {r.status_code} {r.text}')
        sys.exit(1)

    # Optionally, merge the PR
    # Note: Automatic merging should be used with caution
    # Uncomment the following code if you want to automatically merge the PR
    # merge_url = f"https://api.github.com/repos/{repo}/pulls/{pr_number}/merge"
    # merge_response = requests.put(merge_url, headers=headers)
    # if merge_response.status_code == 200:
    #     print('Pull request merged successfully.')
    # else:
    #     print(f'Failed to merge pull request: {merge_response.status_code} {merge_response.text}')
    #     sys.exit(1)

if __name__ == "__main__":
    if len(sys.argv) != 3:
        print("Usage: python generate_compliment_and_merge.py <pr_number> <test_results_file>")
        sys.exit(1)
    pr_number = sys.argv[1]
    test_results_file = sys.argv[2]
    main(pr_number, test_results_file)
