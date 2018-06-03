package com.thewaveearthsociety.handler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    private boolean[] keys;
    public boolean up, down, left, right;

    public KeyHandler() {
        keys = new boolean[256];
    }

    public void tick() {
        up = keys[KeyEvent.VK_W] || keys[KeyEvent.VK_UP];

        down = keys[KeyEvent.VK_S] || keys[KeyEvent.VK_DOWN];

        left = keys[KeyEvent.VK_A] || keys[KeyEvent.VK_LEFT];

        right = keys[KeyEvent.VK_D] || keys[KeyEvent.VK_RIGHT];

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

}
