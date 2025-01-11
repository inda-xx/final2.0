import os
import re
import sys
import subprocess
from openai import OpenAI

def main(api_key, branch_name):
    if not api_key:
        print("Error: OpenAI API key is missing.")
        sys.exit(1)

    client = OpenAI(api_key=api_key)

    # Ensure we are on the correct branch
    try:
        subprocess.run(["git", "checkout", branch_name], check=True)
    except subprocess.CalledProcessError as e:
        print(f"Error checking out branch {branch_name}: {e}")
        sys.exit(1)

    # Read the solution code from the .hidden_tasks directory
    solution_files = []
    try:
        for filename in os.listdir(".hidden_tasks"):
            if filename.endswith(".java"):
                with open(os.path.join(".hidden_tasks", filename), "r") as file:
                    solution_files.append(file.read())
    except FileNotFoundError:
        print("Error: Solution files not found in .hidden_tasks directory.")
        sys.exit(1)

    if not solution_files:
        print("Error: No Java solution files found in .hidden_tasks.")
        sys.exit(1)

    solution = "\n\n".join(solution_files)

    # Example tests to inspire the model (not to be directly copied)
    example_tests = """
    import org.junit.Test;

    import static org.junit.Assert.assertArrayEquals;
    import static org.junit.Assert.assertEquals;

    /**
    * Test cases for the Arrays class
    * NOTE: We do not require the students to handle edge cases such as
    * empty arrays, so these cases are not tested.
    */
    public class ArraysTest {
        private final int[] intArrayWithNegativeNumbers = new int[] {0, -1, -2, -3, -4, -5};
        private final int[] intArrayWithPositiveNumbers = new int[] {1, 2, 3, 4, 5, 0};
        private final double[] doubleArrayWithNegativeNumbers = new double[] {0, -1, -2, -3, -4, -5};
        private final double[] doubleArrayWithPositiveNumbers = new double[] {0, 1, 2, 3, 4, 5};


        @Test
        public void intAveragePositiveNumbersGivesExpectedResult() {
            int expected = java.util.Arrays.stream(intArrayWithPositiveNumbers).sum() /
                        intArrayWithPositiveNumbers.length;
            assertEquals(expected, Arrays.average(intArrayWithPositiveNumbers));
        }

        @Test
        public void intAverageNegativeNumbersGivesExpectedResult() {
            int expected = java.util.Arrays.stream(intArrayWithNegativeNumbers).sum() /
                        intArrayWithNegativeNumbers.length;
            assertEquals(expected, Arrays.average(intArrayWithNegativeNumbers));
        }

        @Test
        public void doubleAveragePositiveNumbersGivesExpectedResult() {
            double expected = java.util.Arrays.stream(doubleArrayWithPositiveNumbers).sum() /
                            doubleArrayWithPositiveNumbers.length;
            assertEquals(expected, Arrays.average(doubleArrayWithPositiveNumbers), 0);
        }

        @Test
        public void doubleAverageNegativeNumbersGivesExpectedResult() {
            double expected = java.util.Arrays.stream(doubleArrayWithNegativeNumbers).sum() /
                            doubleArrayWithNegativeNumbers.length;
            assertEquals(expected, Arrays.average(doubleArrayWithNegativeNumbers), 0);
        }

        @Test
        public void smallestElementFindsSmallestInPositiveNumbers() {
            int expected = java.util.Arrays.stream(intArrayWithPositiveNumbers).min().orElse(0);
            assertEquals(expected, Arrays.smallestElement(intArrayWithPositiveNumbers));
        }

        @Test
        public void smallestElementFindsSmallestInNegativeNumbers() {
            int expected = java.util.Arrays.stream(intArrayWithNegativeNumbers).min().orElse(0);
            assertEquals(expected, Arrays.smallestElement(intArrayWithNegativeNumbers));
        }

        @Test
        public void reverseCorrectlyCreatesReversedCopy() {
            int[] reversed = Arrays.reverse(intArrayWithPositiveNumbers);
            assertEquals(intArrayWithPositiveNumbers.length, reversed.length);
            for (int i = 0; i < reversed.length; i++)
                assertEquals(intArrayWithPositiveNumbers[i], reversed[reversed.length - i - 1]);
        }

        @Test
        public void reverseDoesNotModifyOriginalArray() {
            int[] original = java.util.Arrays.copyOf(intArrayWithPositiveNumbers,
                                                    intArrayWithPositiveNumbers.length);
            Arrays.reverse(intArrayWithPositiveNumbers);
            assertArrayEquals(original, intArrayWithPositiveNumbers);
        }

        @Test
        public void evenNumbersGivesCorrectResultForPositiveNumbers() {
            int[] expected = java.util.Arrays.stream(intArrayWithPositiveNumbers)
                                            .filter(i -> i % 2 == 0)
                                            .toArray();
            assertArrayEquals(expected, Arrays.evenNumbers(intArrayWithPositiveNumbers));
        }

        @Test
        public void evenNumbersGivesCorrectResultForNegativeNumbers() {
            int[] expected = java.util.Arrays.stream(intArrayWithNegativeNumbers)
                                            .filter(i -> i % 2 == 0)
                                            .toArray();
            assertArrayEquals(expected, Arrays.evenNumbers(intArrayWithNegativeNumbers));
        }

        @Test
        public void evenNumbersDoesNotModifyOriginalArray() {
            int[] original = java.util.Arrays.copyOf(intArrayWithPositiveNumbers,
                                                    intArrayWithPositiveNumbers.length);
            Arrays.evenNumbers(intArrayWithPositiveNumbers);
            assertArrayEquals(original, intArrayWithPositiveNumbers);
        }
    }



    import org.junit.Test;

    import static org.junit.Assert.assertEquals;

    import java.util.*;
    import java.util.stream.IntStream;

    /**
    * Test for SetTheory
    */
    public class SetTheoryTest {

        private static final int MIN = 0;
        private static final int MAX = 100;
        private static final List<Integer> UNIVERSE = IntStream.range(MIN, MAX).boxed().toList();

        @Test
        public void generateSetCorrectlyCreatesUniverse() {
            List<Integer> expected = IntStream.range(MIN, MAX).boxed().toList();
            List<Integer> actual = SetTheory.generateSet(MIN, MAX);
            assertEquals(expected, actual);
        }

        @Test
        public void generateSetCorrectlyCreatesInterval() {
            List<Integer> expected = IntStream.range(67, 89).boxed().toList();
            List<Integer> actual = SetTheory.generateSet(67, 89);
            assertEquals(expected, actual);
        }
        @Test
        public void generateSetReturnsEmptySetWhenMinIsGreaterThanMax() {
            List<Integer> actual = SetTheory.generateSet(2, 1);
            assertEquals(Collections.emptyList(), actual);
        }

        @Test
        public void generateSetReturnsEmptySetWhenMinIsEqualToMax() {
            List<Integer> actual = SetTheory.generateSet(1, 1);
            assertEquals(Collections.emptyList(), actual);
        }

        @Test
        public void generateSetReturnsExpectedResultWhenMaxIsGreaterThan100() {
            List<Integer> expected = IntStream.range(50, MAX).boxed().toList();
            List<Integer> actual = SetTheory.generateSet(50, 101);
            assertEquals(expected, actual);
        }

        @Test
        public void generateSetReturnsExpectedResultWhenMinIsLessThan0() {
            List<Integer> expected = IntStream.range(MIN, 50).boxed().toList();
            List<Integer> actual = SetTheory.generateSet(-1, 50);
            assertEquals(expected, actual);
        }

        @Test
        public void unionReturnsExpectedResultWhenSetsOverlap() {
            List<Integer> a = IntStream.range(10, 55).boxed().toList();
            List<Integer> b = IntStream.range(50, 90).boxed().toList();

            Set<Integer> expected =  new HashSet<>(a);
            expected.addAll(b);
            List<Integer> actual = SetTheory.union(new ArrayList<>(a), new ArrayList<>(b));

            assertEquals(expected.stream().toList(), actual);
        }

        @Test
        public void unionReturnsExpectedResultWhenSetsAreDisjoint() {
            List<Integer> a = IntStream.range(10, 50).boxed().toList();
            List<Integer> b = IntStream.range(55, 90).boxed().toList();

            Set<Integer> expected =  new HashSet<>(a);
            expected.addAll(b);
            List<Integer> actual = SetTheory.union(new ArrayList<>(a), new ArrayList<>(b));

            assertEquals(expected.stream().toList(), actual);
        }

        @Test
        public void intersectionReturnsExpectedResultWhenSetsOverlap() {
            List<Integer> a = IntStream.range(10, 55).boxed().toList();
            List<Integer> b = IntStream.range(50, 90).boxed().toList();

            Set<Integer> expected =  new HashSet<>(a);
            expected.retainAll(b);
            List<Integer> actual = SetTheory.intersection(new ArrayList<>(a), new ArrayList<>(b));

            assertEquals(expected.stream().toList(), actual);
        }

        @Test
        public void intersectionReturnsEmptyListWhenSetsAreDisjoint() {
            List<Integer> a = IntStream.range(10, 50).boxed().toList();
            List<Integer> b = IntStream.range(55, 90).boxed().toList();
            List<Integer> actual = SetTheory.intersection(new ArrayList<>(a), new ArrayList<>(b));

            assertEquals(Collections.emptyList(), actual);
        }

        @Test
        public void complementReturnsEmptySetWhenInputIsUniverse() {
            assertEquals(Collections.emptyList(), SetTheory.complement(new ArrayList<>(UNIVERSE)));
        }

        @Test
        public void complementReturnsExpectedResultForInterval() {
            List<Integer> set = IntStream.range(45, 67).boxed().toList();
            var expected = new HashSet<>(UNIVERSE);
            expected.removeAll(set);
            assertEquals(expected.stream().toList(), SetTheory.complement(new ArrayList<>(set)));
        }

        @Test
        public void cardinalityReturnsCorrectValueForUniverse() {
            assertEquals(UNIVERSE.size(), SetTheory.cardinality(new ArrayList<>(UNIVERSE)));
        }

        @Test
        public void cardinalityReturnsCorrectValueForEmptySet() {
            assertEquals(0, SetTheory.cardinality(new ArrayList<>()));
        }

        @Test
        public void cardinalityOfUnionReturnsCorrectValueForOverlappingSets() {
            int actual = SetTheory.cardinalityOfUnion(new ArrayList<>(UNIVERSE), new ArrayList<>(UNIVERSE));
            assertEquals(UNIVERSE.size(), actual);
        }

        @Test
        public void cardinalityOfUnionReturnsCorrectValueForDisjointSets() {
            List<Integer> a = IntStream.range(MIN, 21).boxed().toList();
            List<Integer> b = IntStream.range(50, 67).boxed().toList();
            int actual = SetTheory.cardinalityOfUnion(new ArrayList<>(a), new ArrayList<>(b));
            assertEquals(a.size() + b.size(), actual);
        }

        @Test
        public void cardinalityOfUnionReturnsCorrectValueWhenBothSetsAreEmpty() {
            assertEquals(0, SetTheory.cardinalityOfUnion(new ArrayList<>(), new ArrayList<>()));
        }
    }


    """

    # Combine the solution into a single prompt for test generation
    prompt = (
        "You are part of a task generation system to create weekly tasks for CS1 studnets"
        "Your specific duty is to create tests based on the solution files so the studnets can run them to ensure they have fullfilled the tasks goals."
        f"Given the following Java solution, generate a set of high-quality unit tests. "
        f"Ensure the tests are thorough, robust, and cover all edge cases, including invalid inputs, boundary conditions, and performance considerations. "
        f"Ensure the tests use the correct imports and that each class is placed in the correct file as per Java naming conventions.\n\n"
        f"### Solution\n{solution}\n\n"
        f"### Example Tests (for inspiration only)\n{example_tests}\n\n"
        "IMPORTANT: The response must be plain Java code with no markdown formatting or ```java blocks. Ensure that the response is ready to be saved directly as a .java file."
        "Make sure all the right imports are always included."
    )

    response_content = generate_with_retries(client, prompt, max_retries=3)
    if response_content is None:
        print("Error: Failed to generate the tests after multiple retries.")
        sys.exit(1)

    # Write the generated tests to appropriate Java files in the gen_test directory
    gen_test_dir = os.path.join("gen_test")
    write_generated_tests_to_files(gen_test_dir, response_content)

    # Commit and push changes
    commit_and_push_changes(branch_name, gen_test_dir)

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
            print(f"Error generating the tests: {e}")
            if attempt < max_retries - 1:
                print("Retrying...")
    return None

def write_generated_tests_to_files(directory, code_content):
    """
    Write generated Java tests to separate files based on class names.
    Ensures that import statements and public class declarations are correctly handled.
    """
    # Split the code into blocks starting with 'public class' or similar
    file_blocks = re.split(r'(?=public\s+class\s+\w+\s*{)', code_content)

    for block in file_blocks:
        if not block.strip():
            continue  # Skip empty blocks

        # Extract class name
        class_name_match = re.search(r'public\s+class\s+([A-Za-z_]\w*)\s*{', block)
        if class_name_match:
            class_name = class_name_match.group(1)
        else:
            print(f"Skipping block due to missing class name in block: {block[:50]}")
            continue

        # Ensure the block has matching braces
        if block.count('{') != block.count('}'):
            print(f"Skipping block due to unmatched braces in class {class_name}.")
            continue

        # Construct the file content
        package_declaration = "package test;\n\n"
        imports = (
            "import org.junit.Before;\n"
            "import org.junit.Test;\n"
            "import static org.junit.Assert.*;\n\n"
        )
        file_content = package_declaration + imports + block

        file_name = f"{class_name}.java"
        file_path = os.path.join(directory, file_name)

        # Ensure the directory exists
        os.makedirs(directory, exist_ok=True)

        try:
            with open(file_path, "w") as java_file:
                java_file.write(file_content)
            print(f"Successfully wrote {file_name}")
        except IOError as e:
            print(f"Error writing file {file_name}: {e}")

def commit_and_push_changes(branch_name, directory):
    try:
        subprocess.run(["git", "config", "--global", "user.email", "actions@github.com"], check=True)
        subprocess.run(["git", "config", "--global", "user.name", "github-actions"], check=True)

        subprocess.run(["git", "add", directory], check=True)
        subprocess.run(["git", "commit", "-m", "Add generated tests"], check=True)
        subprocess.run(
            ["git", "push", "--set-upstream", "origin", branch_name],
            check=True,
            env=dict(os.environ, GIT_ASKPASS='echo', GIT_USERNAME='x-access-token', GIT_PASSWORD=os.getenv('GITHUB_TOKEN'))
        )
    except subprocess.CalledProcessError as e:
        print(f"Error committing and pushing changes: {e}")
        sys.exit(1)

if len(sys.argv) != 3:
    print("Error: Missing required command line arguments 'api_key' and 'branch_name'")
    sys.exit(1)

api_key = sys.argv[1]
branch_name = sys.argv[2]

main(api_key, branch_name)
