package Ping;

import javax.swing.JFrame;

/**
 * @author Dairo Garcia Naranjo
 */
public class Ventana extends JFrame implements Constantes {

    public Ventana() {
        initVentana();
        initComponentes();
    }

    private void initVentana() {
        this.setTitle("PingPong Neon");
        this.setSize(ANCHO, ALTO);
        this.setBounds(0, 0, ANCHO, ALTO);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initComponentes() {
        Panel panel = new Panel();
        this.add(panel);
    }
}
