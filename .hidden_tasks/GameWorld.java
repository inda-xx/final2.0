import java.util.Random;

public class GameWorld {
    private char[][] grid;
    private int gridSize;

    public GameWorld(int gridSize) {
        this.gridSize = gridSize;
        grid = new char[gridSize][gridSize];
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                grid[i][j] = '-';
            }
        }
    }

    public void placePlayer(Player player) {
        grid[player.getX()][player.getY()] = 'P';
    }

    public void placeEnemy(Enemy enemy) {
        grid[enemy.getX()][enemy.getY()] = 'E';
    }

    public void placeCollectibles(int numCollectibles) {
        Random random = new Random();
        for (int i = 0; i < numCollectibles; i++) {
            int x, y;
            do {
                x = random.nextInt(gridSize);
                y = random.nextInt(gridSize);
            } while (grid[x][y] != '-');
            grid[x][y] = 'C';
        }
    }

    public void updatePlayerPosition(Player player, int oldX, int oldY) {
        grid[oldX][oldY] = '-';
        if (grid[player.getX()][player.getY()] == 'C') {
            player.increaseScore(10);
            System.out.println("You collected a coin! Current score: " + player.getScore());
        }
        grid[player.getX()][player.getY()] = 'P';
    }

    public void clearEnemyPosition(int x, int y) {
        grid[x][y] = '-';
    }

    public void updateEnemyPosition(Enemy enemy) {
        grid[enemy.getX()][enemy.getY()] = 'E';
    }

    public boolean detectCollision(Player player, Enemy enemy) {
        return player.getX() == enemy.getX() && player.getY() == enemy.getY();
    }

    public void displayGrid() {
        for (char[] row : grid) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}