package com.thewaveearthsociety.states;

import com.thewaveearthsociety.entities.creatures.Player;
import com.thewaveearthsociety.game.Game;

import java.awt.*;


public class GameState extends State {

    private Player player;

    public GameState(Game game){
        super(game);
        player = new Player(game,100, 100);
    }

    @Override
    public void tick() {
        player.tick();
    }

    @Override
    public void render(Graphics g) {
        player.render(g);
    }

}
