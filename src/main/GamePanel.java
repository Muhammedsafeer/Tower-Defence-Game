package main;

import map.TilesManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel{

    public final int tilesTextureSize = 32;
    public final int scale = 2;
    public final int tileSize = tilesTextureSize * scale;

    public final int screenCol = 16;
    public final int screenRow = 9;

    public final int screenWidth = screenCol * tileSize;
    public final int screenHeight = screenRow * tileSize;

    public GameLoop gameLoop = new GameLoop(this);
    public TilesManager tilesManager = new TilesManager(this);

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
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

        tilesManager.draw(g2d);

        g2d.dispose();

    }
}
