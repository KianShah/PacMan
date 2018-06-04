package UI;

import Model.GhostAbstract;
import Model.PMGame;
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

    public static final int FRAME_WIDTH = 960;
    public static final int FRAME_HEIGHT = 1080;
    private final int INTERVAL = 40;

    // Sets up PacMan game
    PacManGame() {
        game = PMGame.getGame();
        frame = new JFrame("PacMan");

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  // defines what happens when window closes
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);                       // sets size of frame
        centreFrame();

        try {frame.setIconImage(ImageIO.read(new File("Images/PacMan Images/PacManEAST.png")));}
        catch (IOException e){                                  // Sets the window icon to an image of PacMan
            System.out.println("IOException thrown");
        }

        frame.addKeyListener(new KeyHandler());
        drawObjects();
        frame.setVisible(true);         // Makes frame visible
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
     * Draws all of the objects necessary in the new window frame:
     * EFFECTS: Draws PacMan and ghosts
     * MODIFIES: frame
     */
    private void drawObjects() {
//        LayoutManager manager = new GridLayout(50,30);
//        frame.setLayout(manager);

        addPacMan();
        addGhosts();
    }

    // Removes PacMan and ghost labels from frame
    private void removeObjects() {
        // TODO
    }


    // Adds a timer to perform operations at every INTERVAL ms
    private void addTimer() {
        Timer t = new Timer(INTERVAL, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!game.isGameOver()) {
                    game.update();
                }
                drawObjects();
            }
        });

        t.start();  // starts timer, ends when gameoOver = true
    }

    // Add PacMan label
    private void addPacMan() {
        JLabel PM_Label = new JLabel(PacMan.getInstance().getImage());
        frame.getContentPane().add(PM_Label);
        PM_Label.setBounds(game.getPacMan().getPos().x,
                game.getPacMan().getPos().y,
                game.getPacMan().getImage().getIconWidth()*2,
                game.getPacMan().getImage().getIconHeight()*2);
    }

    private void addGhosts() {
        for (GhostAbstract ghost : game.getGhosts())
            addGhost(ghost);
    }

    private void addGhost(GhostAbstract ghost) {
        JLabel label = new JLabel(ghost.getImage());
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
