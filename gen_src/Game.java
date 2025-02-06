import java.util.List;  
import java.util.ArrayList;  

public class Game {  
    private List<Enemy> enemies;  
    private Player player;  

    public Game(int startX, int startY) {  
        // Initialize player  
    }  

    public void loadEnemiesFromFile(String filename) {  
        // Read enemy positions from file and add them to the list  
    }  

    public void checkForCollisions() {  
        // Check if player collides with any enemy and update score accordingly  
    }  

    public List<Enemy> getEnemies() {  
        return enemies;  
    }  

    public Player getPlayer() {  
        return player;  
    }  
}