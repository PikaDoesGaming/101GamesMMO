package com.thewaveearthsociety.gfx;

import java.awt.image.BufferedImage;

public class SpriteSheet {

    private BufferedImage spriteSheet;

    public SpriteSheet(BufferedImage spriteSheet){
        this.spriteSheet = spriteSheet;
    }

    public BufferedImage crop(int x, int y,int width, int height){
        return spriteSheet.getSubimage(x, y, width, height);
    }

}
