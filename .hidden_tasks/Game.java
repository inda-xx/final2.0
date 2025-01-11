import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        GameGrid grid = new GameGrid();
        try {
            grid.populateGridFromFile("gameData.txt");
            Scanner scanner = new Scanner(System.in);

            boolean isGameOver = false;
            while (!isGameOver) {
                grid.drawGrid();
                System.out.println("Your score: " + grid.getPlayer().getScore());
                System.out.print("Enter move (W/A/S/D): ");
                String move = scanner.nextLine();
                grid.movePlayer(move);

                isGameOver = grid.checkCollisions();

                if (grid.getItems().isEmpty()) {
                    System.out.println("Congratulations! You collected all items!");
                    isGameOver = true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading game data file: " + e.getMessage());
        }
    }
}