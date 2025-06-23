package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Enemy {
    private String type;
    private int x;
    private int y;
    private int damage;

    public Enemy(String type, int x, int y, int damage) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.damage = damage;
    }

    public String getType() { return type; }

    public int getX() { return x; }

    public int getY() { return y; }

    public int getDamage() { return damage; }
}



// GameState.java

public enum GameState {
    START,
    PLAYING,
    GAME_OVER,
    WIN
}