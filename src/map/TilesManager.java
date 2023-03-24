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
            {1, 1, 1 ,1 ,1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1 ,1 ,1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1 ,1 ,1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1 ,1 ,1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1 ,1 ,1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1 ,1 ,1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1 ,1 ,1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1 ,1 ,1, 1, 1, 1, 1, 1, 1},
            {2, 1, 1 ,1 ,1, 1, 1, 1, 1, 1, 2},
            {0, 2, 2 ,2, 2, 2, 2, 2, 2, 2, 0},
    };

    int worldCol = 11;
    int worldRow = 11;

    int worldPosX, worldPosY;

    public TilesManager(GamePanel gp) {
        this.gp = gp;

        tiles = new Tiles[2];

        loadTilesImg();
        setDefaultPos();
    }

    public void setDefaultPos() {
        worldPosX = 32;
        worldPosY = 0;
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

        }catch (IOException e) {
            e.printStackTrace();
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
            System.out.println(col + " : " + row);

            col++;
            if (col == worldCol) {
                col = 0;
                row++;
            }
        }
    }
}
