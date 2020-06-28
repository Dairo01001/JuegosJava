package pingpong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePlay extends JPanel implements KeyListener, ActionListener {

    private boolean juego = false;
    private boolean gameOver = false;

    private int score1 = 0;
    private int score2 = 0;

    private final Timer timer;
    private final int tiempo = 7;

    private int player1X = Main.ANCHO - 25;
    private int player1Y = Main.ALTO / 2 - 75;

    private int player2X = 5;
    private int player2Y = Main.ALTO / 2 - 75;

    private int bolaX = 300;
    private int bolaY = 300;
    private int dirBolaX = 2;
    private int dirBolaY = 3;

    private boolean up1 = false;
    private boolean up2 = false;
    private boolean down1 = false;
    private boolean down2 = false;

    public GamePlay() {
        setFocusable(true);
        addKeyListener(this);
        timer = new Timer(tiempo, this);
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        moverBola();
        moverJugadores();
        colisiones();

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Main.ANCHO, Main.ALTO);

        g.setColor(Color.WHITE);
        g.fillRect(player1X, player1Y, 15, 100);

        g.setColor(Color.WHITE);
        g.fillRect(player2X, player2Y, 15, 100);

        g.setColor(Color.RED);
        g.fillOval(bolaX, bolaY, 20, 20);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Consoles", Font.BOLD, 22));
        g.drawString("Score: " + score2, 30, 20);
        g.drawString("Score: " + score1, 860, 20);

        if (!juego && !gameOver) {
            g.drawString("PRESS ENTER TO START", 340, 150);
        }

        if (gameOver) {
            if (score1 == score2) {
                g.drawString("EMPATE", 480, 130);
            } else if (score1 > score2) {
                g.drawString("WINNER: JUGADOR 1", 480, 130);
            } else {
                g.drawString("WINNER: JUGADOR 2", 480, 130);
            }
            g.drawString("PRESS ENTER PARA REINICIAR", 340, 190);

        }
    }

    public void moverBola() {
        if (juego) {
            bolaX += dirBolaX;
            bolaY += dirBolaY;

            if (bolaX > Main.ANCHO - 30) {
                gameOver();
            }
            if (bolaX < 0) {
                gameOver();
            }
            if (bolaY > Main.ALTO - 50) {
                dirBolaY = -dirBolaY;
            }
            if (bolaY < 0) {
                dirBolaY = -dirBolaY;
            }
        }
    }

    public void moverJugadores() {
        if (juego) {
            if (up1) {
                if (player1Y < 10) {
                    player1Y = 10;
                } else {
                    player1Y -= 3;
                }
            }
            if (down1) {
                if (player1Y > 360) {
                    player1Y = 360;
                } else {
                    player1Y += 3;
                }
            }
            if (up2) {
                if (player2Y < 10) {
                    player2Y = 10;
                } else {
                    player2Y -= 3;
                }
            }
            if (down2) {
                if (player2Y > 360) {
                    player2Y = 360;
                } else {
                    player2Y += 3;
                }
            }
        }
    }

    public void colisiones() {
        if (new Rectangle(bolaX, bolaY, 20, 20).intersects(new Rectangle(player1X, player1Y, 15, 100))) {
            dirBolaX = -dirBolaX;
            score1++;
        }
        if (new Rectangle(bolaX, bolaY, 20, 20).intersects(new Rectangle(player2X, player2Y, 15, 100))) {
            dirBolaX = -dirBolaX;
            score2++;
        }
    }

    public void reiniciar() {
        juego = false;
        gameOver = false;

        score1 = 0;
        score2 = 0;

        player1X = Main.ANCHO - 25;
        player1Y = Main.ALTO / 2 - 75;

        player2X = 5;
        player2Y = Main.ALTO / 2 - 75;

        bolaX = 300;
        bolaY = 300;

        dirBolaX = 2;
        dirBolaY = 3;

        up1 = false;
        up2 = false;
        down1 = false;
        down2 = false;

        timer.start();
    }

    public void gameOver() {
        gameOver = true;
        juego = false;
        timer.stop();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            up1 = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            down1 = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            up2 = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            down2 = true;
        }

        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            juego = true;
            if (gameOver) {
                reiniciar();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            up1 = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            down1 = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            up2 = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            down2 = false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        timer.start();
    }

}
