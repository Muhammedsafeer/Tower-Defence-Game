package main;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel{

    public final int tilesTextureSize = 32;
    public final int scale = 2;
    public final int tileSize = tilesTextureSize * scale;

    public final int screenCol = 16;
    public final int screenRow = 9;

    public final int screenWidth = screenCol * tileSize;
    public final int screenHeight = screenRow * tileSize;

    GameLoop gameLoop = new GameLoop(this);

    int x = 100;

    private BufferedImage buffer;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
//        this.addMouseListener(ml);
        this.setFocusable(true);
        start();
    }

    public void start() {
        gameLoop.start();
    }

    public void update(double deltaTime) {

        System.out.println("Update");
        System.out.println(deltaTime);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // render game state
        g2d.setColor(Color.WHITE);
        g2d.drawString("Hello World", x, 100);

        g2d.dispose();

        System.out.println("Render");
    }
}
