package com.thewaveearthsociety.gfx;

import java.awt.image.BufferedImage;

public class Assets {

    private static final int width=16, height=16;
    public static BufferedImage grass, dirt, stone;

    public static void init(){
        SpriteSheet sheet= new SpriteSheet(ImageLoader.loadImage("/textures/SpriteSheet.png"));
        grass = sheet.crop(16, 16, width, height);
        dirt = sheet.crop(176, 16, width, height);
        stone = sheet.crop(256, 0, width, height);
    }

}
