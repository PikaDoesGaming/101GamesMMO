package com.thewaveearthsociety.game;

import com.thewaveearthsociety.gfx.Display;
import com.thewaveearthsociety.gfx.ImageLoader;
import com.thewaveearthsociety.gfx.SpriteSheet;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable {

    private String title;
    private int width,height;

    private Graphics g;

    private boolean running;
    private int tickCount = 0;

    private SpriteSheet spriteSheet;
    private BufferedImage sprite;
    private Display display;

    public Game(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
    }

    private void init() {
        display = new Display(title, width, height);
        sprite = ImageLoader.loadImage("/textures/SpriteSheet.png");
        spriteSheet = new SpriteSheet(sprite);
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

            if (System.currentTimeMillis() - lastTimer >= 1000) {
                lastTimer += 1000;
                frames = 0;
                ticks = 0;
            }
        }
    }

    private void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        // Clear screen
        g.clearRect(0, 0, getWidth(), getHeight());

        // Draw area
        g.drawImage(spriteSheet.crop(0, 0, 16, 16),5 ,5 ,null);

        // show
        bs.show();
        g.dispose();

    }

    private void tick() {
        tickCount++;
    }

}



