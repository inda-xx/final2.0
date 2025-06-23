package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Player {
    private int x;
    private int y;
    private int health;
    private int score;

    public Player(int x, int y, int health) {
        this.x = x;
        this.y = y;
        this.health = health;
        this.score = 0;
    }

    public void move(String direction) {
        switch (direction.toLowerCase()) {
            case "up": y++; break;
            case "down": y--; break;
            case "left": x--; break;
            case "right": x++; break;
        }
    }

    public void takeDamage(int amount) {
        health -= amount;
        if (health < 0) {
            health = 0;
        }
    }

    public void increaseScore(int amount) {
        score += amount;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public int getX() { return x; }

    public int getY() { return y; }

    public int getHealth() { return health; }

    public int getScore() { return score; }
}



// Enemy.java

