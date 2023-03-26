package gui;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Buttons {

    GamePanel gp;

    BufferedImage atlas;
    BufferedImage buttonImg[];
    BufferedImage buttonImgHover[];

    InputStream is = getClass().getResourceAsStream("/buttons.png");

    Rectangle button[];

    int buttonHeight = 32;
    int buttonWidth = 64;

    public boolean buildPressed = false;

    public Buttons(GamePanel gp) {
        this.gp = gp;

        buttonImg = new BufferedImage[1];
        buttonImgHover = new BufferedImage[1];
        button = new Rectangle[1];

        loadImage();
    }

    public void loadImage() {
        try {

            atlas = ImageIO.read(is);

            buttonImg[0] = atlas.getSubimage(1, 1, buttonWidth, buttonHeight);
            buttonImgHover[0] = atlas.getSubimage( 2 + buttonWidth, 1, buttonWidth, buttonHeight);
            button[0] = new Rectangle(0, 0, buttonWidth, buttonHeight);

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void checkMouse() {
        for (int i=0;i<button.length;i++) {
            if (button[i].contains(gp.mouse)) {
                if (gp.mouseListener.leftClick) {
                    onButtonPress(i);
                }
            }
        }
    }

    public void onButtonPress(int button) {
        switch (button) {
            case 0:
                if (!buildPressed) { buildPressed = true; }
                else { buildPressed = false; }

                gp.tilesManager.currentItem = 3;
                break;
        }
    }

    public void draw(Graphics2D g2d) {
        for (int i=0;i<button.length;i++) {
            if (button[i].contains(gp.mouse)) {
                g2d.drawImage(buttonImgHover[i], button[i].x, button[i].y, null);
            }else {
                g2d.drawImage(buttonImg[i], button[i].x, button[i].y, null);
            }
        }
    }
}
