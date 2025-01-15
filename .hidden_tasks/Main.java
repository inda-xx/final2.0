import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        Player player = new Player(0, 0);
        java.util.List<Enemy> enemies = new java.util.ArrayList<>();
        enemies.add(new Enemy(2, 2));
        enemies.add(new Enemy(3, 3));
        java.util.List<Item> items = new java.util.ArrayList<>();
        items.add(new Item(1, 1));
        items.add(new Item(4, 4));

        GameBoard gameBoard = new GameBoard(5, 5, player, enemies, items);

        while (!gameBoard.isGameOver()) {
            gameBoard.renderBoard();
            System.out.print("Enter move (UP/DOWN/LEFT/RIGHT): ");
            String move = scanner.nextLine();
            gameBoard.updateGameState(move);
            gameBoard.updateEnemyPositions();
        }

        scanner.close();
    }
}