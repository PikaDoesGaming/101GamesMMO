package com.thewaveearthsociety.entities.creatures;

import com.thewaveearthsociety.game.Game;
import com.thewaveearthsociety.gfx.Animation;
import com.thewaveearthsociety.gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature {

    private Animation anDown;
    private Animation anUp;
    private Animation anLeft;
    private Animation anRight;

    private int direction = 0;

    private Game game;

    public Player(Game game, float x, float y) {
        super(x, y, Creature.D_WIDTH * 4, Creature.D_HEIGHT * 4);
        this.game = game;

        //Animations
        anDown = new Animation(135, Assets.player_down);
        anLeft = new Animation(135, Assets.player_left);
        anUp = new Animation(135, Assets.player_up);
        anRight = new Animation(135, Assets.player_right);
    }

    @Override
    public void tick() {
        anDown.tick();
        anUp.tick();
        anLeft.tick();
        anRight.tick();
        getInput();
        move();
    }

    private void getInput() {
        xMove = 0;
        yMove = 0;

        if (game.getKeyHandler().up)
            yMove = -speed;
        if (game.getKeyHandler().down)
            yMove = speed;
        if (game.getKeyHandler().left)
            xMove = -speed;
        if (game.getKeyHandler().right)
            xMove = speed;
    }

    public BufferedImage getCurrentAnimation() {
        if (xMove != 0 || yMove != 0) {
            if (xMove < 0) {
                direction = 1;
                return anLeft.getCurrent();
            } else if (xMove > 0) {
                direction = 3;
                return anRight.getCurrent();
            } else if (yMove < 0) {
                direction = 2;
                return anUp.getCurrent();
            } else {
                direction = 0;
                return anDown.getCurrent();
            }
        } else return Assets.player_standing[direction];
    }


    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimation(), (int)x, (int)y, width, height, null);

    }
}