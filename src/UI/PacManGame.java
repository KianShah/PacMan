package UI;

import Model.PacMan;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class PacManGame {
    private JFrame frame;
    private PMGame game;

    private final int FRAME_WIDTH = 300;
    private final int FRAME_HEIGHT = 500;
    private final int INTERVAL = 50;
    private boolean gameOver = false;

    // Sets up PacMan game
    PacManGame() {
        game = new PMGame();
        frame = new JFrame("PacMan");
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

        try {
            frame.setIconImage(ImageIO.read(new File("PacMan.png")));
        }
        catch (IOException e){
            // do nothing
        }

        drawObjects();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        addTimer();
    }

    private void drawObjects() {
        LayoutManager manager = new GridLayout(50,30);
        JPanel panel = new JPanel();
        frame.setLayout(manager);

        JLabel PM_Label = new JLabel(PacMan.getInstance().getImage());
        frame.getContentPane().add(PM_Label);
        JLabel Wall_Label = new JLabel(new ImageIcon("Wall.png"));
        frame.getContentPane().add(Wall_Label);
    }

    private void addTimer() {
        Timer t = new Timer(INTERVAL, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!gameOver) {
                    game.update();
                }
            }
        });

        t.start();
    }

    /*
     * A key handler to respond to key events
     */
    private class KeyHandler extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent event) {
            game.keyPressed(event.getKeyCode());
        }
    }

    public static void main(String[] args) {
        new PacManGame();
    }
}
