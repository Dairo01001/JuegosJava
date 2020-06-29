package Ping;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;
/**
 * @author Dairo Garcia Naranjo
 */
public class Panel extends JPanel implements Constantes, KeyListener, ActionListener {
    
    private Jugador jugador;
    private  Timer clock;
    private int fps = 7;

    public Panel() {
        initPanel();
        initComponentes();
    }

    private void initPanel() {
        this.setFocusable(true);
    }

    private void initComponentes() {
        this.jugador = new Jugador(50, 50, "numeros.png");
        this.clock = new Timer(this.fps, this);
        this.clock.start();
    }
    
    @Override
    public void paint(Graphics g){
        
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, ANCHO, ALTO);
        
        g.drawImage(this.jugador.getImg(), this.jugador.getX(), this.jugador.getY(), null);
        
        this.jugador.mover(this.getBounds());
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.repaint();
        this.clock.start();
    }

}
