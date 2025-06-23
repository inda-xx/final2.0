package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTestHelper {

    public static void checkCollisionsSimulated(Player player, List<Enemy> enemies) {
        Iterator<Enemy> iter = enemies.iterator();
        while (iter.hasNext()) {
            Enemy enemy = iter.next();
            if (enemy.getX() == player.getX() && enemy.getY() == player.getY()) {
                player.takeDamage(enemy.getDamage());
                player.increaseScore(10);
                iter.remove();
            }
        }
    }
}



// Player.java

