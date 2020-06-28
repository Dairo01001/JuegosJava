package pingpong;

import javax.swing.JFrame;

public class Main {
    
    final static int ANCHO = 1000, ALTO = 500;
    
    public Main(){
        JFrame ventana = new JFrame();
        ventana.setSize(ALTO, ANCHO);
        ventana.setBounds(0, 0, ANCHO, ALTO);
        ventana.setVisible(true);
        ventana.setResizable(false);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setTitle("PING PONG");
        
        GamePlay gamePlay = new GamePlay();
        ventana.add(gamePlay);
    }
    
    
    
    public static void main(String[] args) {
        new Main();
    }
}
