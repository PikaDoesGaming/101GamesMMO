package com.thewaveearthsociety.gfx;

import javax.swing.*;
import java.awt.*;

public class Display {

    public static int tickcount = 0;
    private static JFrame frame;
    private Canvas canvas;

    private int frames;
    private int ticks;

    private String title;
    private int width, height;

    public Display(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;

        frame = new JFrame(title);
        createDisplay();
    }

    public void tick(int frames, int ticks){
        this.frames = frames;
        this.ticks = ticks;
        frame.setTitle(title + " FPS: " + frames + " | " + "Ticks: " + ticks);
    }

    private void createDisplay(){
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));

        frame.add(canvas);
        frame.pack();
    }

    public Canvas getCanvas(){
        return canvas;
    }
}
