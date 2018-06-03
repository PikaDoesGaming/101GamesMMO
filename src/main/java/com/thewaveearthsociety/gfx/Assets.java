package com.thewaveearthsociety.gfx;

import java.awt.image.BufferedImage;

public class Assets {

    private static final int width = 16, height = 16;
    public static BufferedImage grass, dirt, stone;
    public static BufferedImage[] player_down;
    public static BufferedImage[] player_up;
    public static BufferedImage[] player_left;
    public static BufferedImage[] player_right;
    public static BufferedImage[] player_standing;

    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/SpriteSheet.png"));
        grass = sheet.crop(16, 16, width, height);
        dirt = sheet.crop(176, 16, width, height);
        stone = sheet.crop(256, 0, width, height);

        player_standing = new BufferedImage[4];
        player_down = new BufferedImage[6];
        player_left = new BufferedImage[4];
        player_right = new BufferedImage[4];
        player_up = new BufferedImage[4];

        //Player Standing
        player_standing[0] = sheet.crop(0, height*7, width*2, height*2);
        player_standing[1] = sheet.crop(0, height*9, width*2, height*2);
        player_standing[2] = sheet.crop(0, height*11, width*2, height*2);
        player_standing[3] = sheet.crop(0, height*13, width*2, height*2);

        //Player Down
        player_down[0] = sheet.crop(width*4, height*7, width*2, height*2);
        player_down[1] = sheet.crop(width*2, height*7, width*2, height*2);
        player_down[2] = sheet.crop(width*4, height*7, width*2, height*2);
        player_down[3] = sheet.crop(width*6, height*7, width*2, height*2);
        player_down[4] = sheet.crop(width*8, height*7, width*2, height*2);
        player_down[5] = sheet.crop(width*6, height*7, width*2, height*2);

        //Player Left
        player_left[0] = sheet.crop(width*2, height*9, width*2, height*2);
        player_left[1] = sheet.crop(width*4, height*9, width*2, height*2);
        player_left[2] = sheet.crop(width*6, height*9, width*2, height*2);
        player_left[3] = sheet.crop(width*8, height*9, width*2, height*2);

        //Player Up
        player_up[0] = sheet.crop(width*2, height*11, width*2, height*2);
        player_up[1] = sheet.crop(width*4, height*11, width*2, height*2);
        player_up[2] = sheet.crop(width*6, height*11, width*2, height*2);
        player_up[3] = sheet.crop(width*8, height*11, width*2, height*2);

        //Player Right
        player_right[0] = sheet.crop(width*2, height*13, width*2, height*2);
        player_right[1] = sheet.crop(width*4, height*13, width*2, height*2);
        player_right[2] = sheet.crop(width*6, height*13, width*2, height*2);
        player_right[3] = sheet.crop(width*8, height*13, width*2, height*2);
    }
}

