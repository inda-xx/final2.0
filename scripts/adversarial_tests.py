import os
import re
import sys  # <-- Adding the missing import
from openai import OpenAI

def main(api_key, test_dir):
    if not api_key:
        print("Error: OpenAI API key is missing.")
        sys.exit(1)

    client = OpenAI(api_key=api_key)

    # Read all test files in the test directory
    test_files = [f for f in os.listdir(test_dir) if f.endswith('.java')]
    
    if not test_files:
        print("Error: No test files found in the test directory.")
        sys.exit(1)
    
    for test_file in test_files:
        test_file_path = os.path.join(test_dir, test_file)
        
        with open(test_file_path, "r") as file:
            test_content = file.read()

        # Send the test content to OpenAI for adversarial review and improvement
        improved_content = adversarial_review(client, test_content)

        # Save the improved test content
        with open(test_file_path, "w") as file:
            file.write(improved_content)
        
        print(f"Adversarial review completed for: {test_file}")

def adversarial_review(client, test_content):
    # Prepare a prompt that asks OpenAI to review the test file
    prompt = (
        "Review the following Java test code and make necessary improvements to ensure it is well-structured, follows proper test practices, "
        "and can be executed without issues. Make sure that there are no extraneous content like markdown blocks or incomplete class definitions. "
        "Ensure that imports, method names, and test annotations are correct. If there are unfinished or misplaced code sections, clean them up "
        "to make the test files function properly:\n\n"
        f"### Test Code:\n{test_content}\n\n"
        "IMPORTANT: Do not include markdown code blocks (` ``` `) in your response. Ensure that all test classes are properly structured and can be executed."
    )

    # Send the prompt to OpenAI and get the improved content
    improved_content = generate_with_retries(client, prompt)

    # Clean up markdown formatting or extraneous content if necessary
    improved_content = clean_up_test_code(improved_content)

    return improved_content

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
            print(f"Error generating improved test code: {e}")
            if attempt < max_retries - 1:
                print("Retrying...")
    return None

def clean_up_test_code(test_code):
    # Remove any markdown-like blocks (```java, ``` etc.)
    test_code = re.sub(r'```[\w]*', '', test_code)

    # Remove any misplaced file declarations (e.g., "Enemy.java:" or "Player.java:")
    test_code = re.sub(r'\w+\.java:', '', test_code)

    # Ensure that there are no unclosed curly braces
    open_braces = test_code.count('{')
    close_braces = test_code.count('}')
    if open_braces > close_braces:
        test_code += '}' * (open_braces - close_braces)

    # Remove extraneous or repeated imports, if any
    test_code = clean_up_imports(test_code)

    return test_code

def clean_up_imports(test_code):
    # Remove duplicate imports
    imports = re.findall(r'^\s*import .*;$', test_code, re.MULTILINE)
    unique_imports = list(set(imports))
    for imp in imports:
        test_code = test_code.replace(imp, '', 1)
    test_code = '\n'.join(unique_imports) + '\n' + test_code
    return test_code

if __name__ == "__main__":
    if len(sys.argv) != 3:
        print("Error: Missing required command line arguments 'api_key' and 'test_dir'")
        sys.exit(1)

    api_key = sys.argv[1]
    test_dir = sys.argv[2]

    main(api_key, test_dir)