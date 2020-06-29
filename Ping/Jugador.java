package Ping;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 * @author Dairo Garcia Naranjo
 */
public class Jugador implements Constantes {

    private final Image img;
    private int x;
    private int y;
    private int score;
    private Rectangle rect;

    public Jugador(int x, int y, String nombre) {
        this.img = new ImageIcon(URL + nombre).getImage();
        this.x = x;
        this.y = y;
        this.score = 0;
        this.rect = new Rectangle(x, y, this.img.getWidth(null), this.img.getHeight(null));
    }

    public Image getImg() {
        return img;
    }

    public Rectangle getRect() {
        return rect;
    }

    public int getX() {
        return x;
    }

    public int getScore() {
        return score;
    }

    public void setScore() {
        this.score++;
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

    public void mover(Rectangle r) {
        if (r.contains(this.rect)){
            x++;
            y++;
        }
        System.out.println(x + " " + y);
    }
}
