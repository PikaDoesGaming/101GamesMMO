package com.thewaveearthsociety.game;

import com.thewaveearthsociety.gfx.Assets;
import com.thewaveearthsociety.gfx.Display;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;


public class Game implements Runnable {

    private String title;
    private int width,height;

    private Graphics g;

    private boolean running;
    private int tickCount = 0;

    private Display display;

    public Game(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
    }

    //Initialise classes etc.
    private void init() {
        display = new Display(title, width, height);
        Assets.init();
    }

    public synchronized void start() {
        running = true;
        new Thread(this).start();
    }

    private synchronized void stop() {
        running = false;
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double nsPerTick = 1000000000D / 60D;

        int ticks = 0;
        int frames = 0;

        long lastTimer = System.currentTimeMillis();
        double delta = 0;

        init();

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / nsPerTick;
            lastTime = now;
            boolean shouldRender = false;
            while (delta >= 1) {
                ticks++;
                tick();
                delta -= 1;
                shouldRender = true;
            }

            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (shouldRender) {
                frames++;
                render();
            }
            //Resets ticks
            if (System.currentTimeMillis() - lastTimer >= 1000) {
                display.tick(frames, ticks);
                lastTimer += 1000;
                frames = 0;
                ticks = 0;
            }
        }
    }

    private void render() {
        //Buffer Strategy
        BufferStrategy bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        // Clear screen
        g.clearRect(0, 0, width, height);

        // Draw area
        g.drawImage(Assets.dirt, 10, 10, null);
        g.drawImage(Assets.grass, 36, 10, null);
        g.drawImage(Assets.stone, 62, 10, null);

        // show
        bs.show();
        g.dispose();

    }

    private void tick() {
        tickCount++;
    }

}



