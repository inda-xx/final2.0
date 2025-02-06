public class ScoreManager {
    private int highScore = 0;

    public ScoreManager() {
        loadHighScore();
    }

    public void saveHighScore(int score) {
        if (score > highScore) {
            highScore = score;
            try (FileWriter writer = new FileWriter("highscore.txt")) {
                writer.write(String.valueOf(highScore));
            } catch (IOException e) {
                System.out.println("Error saving high score.");
            }
        }
    }

    public void loadHighScore() {
        try (BufferedReader reader = new BufferedReader(new FileReader("highscore.txt"))) {
            highScore = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            System.out.println("No previous high score found.");
        }
    }

    public int getHighScore() { return highScore; }
}