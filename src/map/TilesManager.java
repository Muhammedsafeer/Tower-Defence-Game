package map;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class TilesManager {

    GamePanel gp;
    Tiles[] tiles;

    BufferedImage img;

    int[][] island = {
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1 ,1 ,1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1 ,1 ,1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1 ,1 ,1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1 ,1 ,1, 17, 1, 1, 1, 1, 1},
            {1, 1, 1 ,1 ,1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1 ,1 ,1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1 ,1 ,1, 1, 1, 1, 1, 1, 1},
            {2, 1, 1 ,1 ,1, 1, 1, 1, 1, 1, 2},
            {0, 2, 2 ,2, 2, 2, 2, 2, 2, 2, 0},
    };

    int worldCol = 11;
    int worldRow = 11;

    int worldPosX, worldPosY;

    public int currentItem = 0;

    int keyBoardMovementSpeed;

    public TilesManager(GamePanel gp) {
        this.gp = gp;

        tiles = new Tiles[17];

        loadTilesImg();
        setDefaultPos();
    }

    public void setDefaultPos() {
        worldPosX = -2 * gp.tileSize;
        worldPosY = 32;

        keyBoardMovementSpeed = 5;
    }

    public void camera() {
        if (gp.keyListener.up) {
            worldPosY -= keyBoardMovementSpeed;
        }
        if (gp.keyListener.down) {
            worldPosY += keyBoardMovementSpeed;
        }
        if (gp.keyListener.left) {
            worldPosX -= keyBoardMovementSpeed;
        }
        if (gp.keyListener.right) {
            worldPosX += keyBoardMovementSpeed;
        }

        worldPosX += gp.mouseListener.dx * 4;
        worldPosY += gp.mouseListener.dy * 4;

        gp.mouseListener.dx = 0;
        gp.mouseListener.dy = 0;

        gp.mouseListener.initialMouseX = gp.mouseListener.mouseX;
        gp.mouseListener.initialMouseY = gp.mouseListener.mouseY;

        if (gp.keyListener.tPressed) {
            setDefaultPos();
        }
    }

    public void loadTilesImg() {
        try {

            InputStream is = getClass().getResourceAsStream("/tiles.png");
            img = ImageIO.read(is);

            // Grass
            tiles[0] = new Tiles();
            tiles[0].img = img.getSubimage(1, 1,
                    gp.tilesTextureSize, gp.tilesTextureSize);

            // Grass Side
            tiles[1] = new Tiles();
            tiles[1].img = img.getSubimage(2 + gp.tilesTextureSize, 1,
                    gp.tilesTextureSize, gp.tilesTextureSize);

            // Mining Area
            tiles[2] = new Tiles();
            tiles[2].img = img.getSubimage(3 + (gp.tilesTextureSize * 2), 1,
                    gp.tilesTextureSize, gp.tilesTextureSize);

            // Fence 1
            tiles[3] = new Tiles();
            tiles[3].img = img.getSubimage(4 + (gp.tilesTextureSize * 3), 1,
                    gp.tilesTextureSize, gp.tilesTextureSize);
            //Fence 2
            tiles[4] = new Tiles();
            tiles[4].img = img.getSubimage(5 + (gp.tilesTextureSize * 4), 1,
                    gp.tilesTextureSize, gp.tilesTextureSize);
            //Fence 3
            tiles[5] = new Tiles();
            tiles[5].img = img.getSubimage(6 + (gp.tilesTextureSize * 5), 1,
                    gp.tilesTextureSize, gp.tilesTextureSize);
            //Fence 4
            tiles[6] = new Tiles();
            tiles[6].img = img.getSubimage(7 + (gp.tilesTextureSize * 6), 1,
                    gp.tilesTextureSize, gp.tilesTextureSize);
            //Fence 5
            tiles[7] = new Tiles();
            tiles[7].img = img.getSubimage(8 + (gp.tilesTextureSize * 7), 1,
                    gp.tilesTextureSize, gp.tilesTextureSize);
            //Fence 6
            tiles[8] = new Tiles();
            tiles[8].img = img.getSubimage(9 + (gp.tilesTextureSize * 8), 1,
                    gp.tilesTextureSize, gp.tilesTextureSize);
            //Fence 7
            tiles[9] = new Tiles();
            tiles[9].img = img.getSubimage(10 + (gp.tilesTextureSize * 9), 1,
                    gp.tilesTextureSize, gp.tilesTextureSize);
            //Fence 8
            tiles[10] = new Tiles();
            tiles[10].img = img.getSubimage(1, 2 + gp.tilesTextureSize,
                    gp.tilesTextureSize, gp.tilesTextureSize);
            //Fence 9
            tiles[11] = new Tiles();
            tiles[11].img = img.getSubimage(2 + gp.tilesTextureSize, 2 + gp.tilesTextureSize,
                    gp.tilesTextureSize, gp.tilesTextureSize);
            //Fence 10
            tiles[12] = new Tiles();
            tiles[12].img = img.getSubimage(3 + (gp.tilesTextureSize * 2), 2 + gp.tilesTextureSize,
                    gp.tilesTextureSize, gp.tilesTextureSize);
            //Fence 11
            tiles[13] = new Tiles();
            tiles[13].img = img.getSubimage(4 + (gp.tilesTextureSize * 3), 2 + gp.tilesTextureSize,
                    gp.tilesTextureSize, gp.tilesTextureSize);
            //Fence 12
            tiles[14] = new Tiles();
            tiles[14].img = img.getSubimage(5 + (gp.tilesTextureSize * 4), 2 + gp.tilesTextureSize,
                    gp.tilesTextureSize, gp.tilesTextureSize);
            //Fence 13
            tiles[15] = new Tiles();
            tiles[15].img = img.getSubimage(6 + (gp.tilesTextureSize * 5), 2 + gp.tilesTextureSize,
                    gp.tilesTextureSize, gp.tilesTextureSize);


            // Castle
            is = getClass().getResourceAsStream("/castle.png");
            tiles[16] = new Tiles();
            tiles[16].img = ImageIO.read(is);

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void placeCurrentItem() {
        // Get the mouse position
        int mouseX = gp.mouseListener.mouseX;
        int mouseY = gp.mouseListener.mouseY;

        // Get the world position of the mouse
        int worldMouseX = mouseX + worldPosX;
        int worldMouseY = mouseY + worldPosY;

        // get which block the mouse is over
        int blockX = worldMouseX / gp.tileSize;
        int blockY = worldMouseY / gp.tileSize;

        if (gp.buttons.buildPressed) {
            if (gp.mouseListener.scrollingUp) {
                currentItem += 1;
            }
            if (gp.mouseListener.scrollingDown) {
                currentItem -= 1;
            }

            if (currentItem != 0) {
                if (gp.mouseListener.leftClick) {
                    try {
                        island[blockY][blockX] = currentItem + 1;
                    }catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Cannot Place there");
                    }
                }
            }
        }
    }

    public void draw(Graphics2D g2d) {
        int col = 0;
        int row = 0;
        while (col < worldCol && row < worldRow) {

            int worldX = col * gp.tileSize - worldPosX;
            int worldY = row * gp.tileSize - worldPosY;


            if (island[row][col] != 0) {
                g2d.drawImage(tiles[island[row][col] - 1].img,
                        worldX, worldY,
                        gp.tileSize, gp.tileSize, null);
            }

            col++;
            if (col == worldCol) {
                col = 0;
                row++;
            }
        }

        // Get the mouse position
        int mouseX = gp.mouseListener.mouseX;
        int mouseY = gp.mouseListener.mouseY;

        // Get the world position of the mouse
        int worldMouseX = mouseX + worldPosX;
        int worldMouseY = mouseY + worldPosY;

        // get which block the mouse is over
        int blockX = worldMouseX / gp.tileSize;
        int blockY = worldMouseY / gp.tileSize;

        // Draw the current item transparently
        if (currentItem != 0) {
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
            g2d.drawImage(tiles[currentItem].img,
                    blockX * gp.tileSize - worldPosX,
                    blockY * gp.tileSize - worldPosY,
                    gp.tileSize, gp.tileSize, null);
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        }
    }
}