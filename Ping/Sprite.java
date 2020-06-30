package Ping;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 * @author Dairo Garcia Naranjo
 */
public class Sprite implements Constantes {

    private Image img;
    private int x;
    private int y;

    public Sprite(int x, int y, String nombre) {
        this.img = new ImageIcon(URL + nombre).getImage();
        this.x = x;
        this.y = y;
    }
    
    public Rectangle getRect(){
        return new Rectangle(x, y, img.getWidth(null), img.getHeight(null));
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
