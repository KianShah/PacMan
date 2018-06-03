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
    private JLabel PM_Label;

    public static final int FRAME_WIDTH = 960;
    public static final int FRAME_HEIGHT = 1080;
    private final int INTERVAL = 40;
    private boolean gameOver = false;

    // Sets up PacMan game
    PacManGame() {
        game = PMGame.getGame();
        frame = new JFrame("PacMan");

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        centreFrame();

        try {frame.setIconImage(ImageIO.read(new File("PacManEAST.png")));}
        catch (IOException e){}

        frame.addKeyListener(new KeyHandler());
        drawObjects();
        frame.setVisible(true);
        addTimer();
    }

    /*
     *  Centres frame within window
     */
    private void centreFrame() {
        Dimension scrn = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((scrn.width - FRAME_WIDTH) / 2, (scrn.height - FRAME_HEIGHT) / 2);
    }

    /*
     * Draws all of the objects necessary in the new window frame
     */
    private void drawObjects() {
//        LayoutManager manager = new GridLayout(50,30);
//        frame.setLayout(manager);

        addPacMan();
    }

    private void removeObjects() {
        if (PM_Label != null)
            frame.remove(PM_Label);
    }


    private void addTimer() {
        Timer t = new Timer(INTERVAL, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeObjects();
                if (!gameOver) {
                    game.update();
                }
                drawObjects();
            }
        });

        t.start();
    }

    private void addPacMan() {
        PM_Label = new JLabel(PacMan.getInstance().getImage());
        frame.add(PM_Label);
        PM_Label.setBounds(game.getPacMan().getPos().x,
                game.getPacMan().getPos().y,
                game.getPacMan().getImage().getIconWidth()*2,
                game.getPacMan().getImage().getIconHeight()*2);
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
