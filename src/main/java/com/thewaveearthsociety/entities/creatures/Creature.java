package com.thewaveearthsociety.entities.creatures;

import com.thewaveearthsociety.entities.Entity;

public abstract class Creature extends Entity {

    public static final int D_HEALTH = 10;
    public static final float D_SPEED = 3.0f;
    public static final int D_WIDTH = 32, D_HEIGHT = 32;

    protected int health;
    protected float speed;
    protected float xMove, yMove;

    public Creature(float x, float y, int width, int height) {
        super(x, y, width, height);
        health = D_HEALTH;
        speed = D_SPEED;
        xMove = 0;
        yMove = 0;
    }

    public void move(){
        x += xMove;
        y += yMove;
    }

    //GETTERS AND SETTERS

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }
}
