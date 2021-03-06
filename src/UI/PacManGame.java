package UI;

import Model.GhostAbstract;
import Model.PMGame;
import Model.PacMan;
import Model.Star;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/*
 * User interface for the PacManGame. Includes runnable main class that simply creates a new instance of the class
 */
public class PacManGame {
    private JFrame frame;
    private Timer timer;
    private PMGame game;

    public static final int FRAME_WIDTH = 960;
    public static final int FRAME_HEIGHT = 1080;
    private final int INTERVAL = 17;
    private final int TITLE_FONT_SIZE = 24;

    // Sets up PacMan game
    public PacManGame() {
        game = PMGame.getInstance();
        frame = new JFrame("PacMan");

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  // defines what happens when window closes
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);                       // sets size of frame
        centreFrame();
        frame.setIconImage(PacMan.PM_EAST);

        frame.addKeyListener(new KeyHandler());
        drawObjects();
        frame.setVisible(true);         // Makes frame visible
        addTimer();
    }

    /**
     *  Centres frame within window
     */
    private void centreFrame() {
        Dimension scrn = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((scrn.width - FRAME_WIDTH) / 2, (scrn.height - FRAME_HEIGHT) / 2);
    }

    /**
     * Draws all of the objects necessary in the new window frame:
     * EFFECTS: Draws PacMan and ghosts
     * MODIFIES: frame
     */
    private void drawObjects() {
        drawPacMan();
        drawGhosts();
        drawStars();
        makeTitle();
    }

    /**
     * Helper function for drawObjects()
     * Displays PacMan as a JLabel in the frame
     */
    private void drawPacMan() {
        JLabel PM_Label = new JLabel(new ImageIcon(PacMan.getInstance().getImage()));
        frame.getContentPane().add(PM_Label);
        PM_Label.setBounds(PacMan.getInstance().getPos().x,
                PacMan.getInstance().getPos().y,
                PacMan.getInstance().getImage().getWidth(null),
                PacMan.getInstance().getImage().getHeight(null));
    }

    /**
     * Helper function for drawObjects()
     * Displays all of the ghosts as JLabels in the frame
     */
    private void drawGhosts() {
        for (GhostAbstract ghost : game.getGhosts()) {
            JLabel label = new JLabel(new ImageIcon(ghost.getImage()));
            frame.getContentPane().add(label);
            label.setBounds(ghost.getPos().x,
                    ghost.getPos().y,
                    ghost.getImage().getWidth(null),
                    ghost.getImage().getHeight(null));
        }
    }

    /**
     * Helper function for drawObjects()
     * Displays all stars as JLabels in the frame
     */
    private void drawStars() {
        for (Star star : game.getStars()) {
            JLabel label = new JLabel(new ImageIcon(Star.image));
            frame.getContentPane().add(label);
            label.setBounds(star.pos.x,
                    star.pos.y,
                    Star.image.getWidth(null),
                    Star.image.getHeight(null));
        }
    }

    /**
     * Helper function for drawObjects()
     * Displays the title of the game as a JLabel in the frame
     */
    private void makeTitle() {
        JLabel label = new JLabel("PacMan", SwingConstants.CENTER);
        frame.getContentPane().add(label);
        label.setVerticalAlignment(SwingConstants.TOP);

        Font font = label.getFont();
        label.setFont(new Font(font.getName(), Font.PLAIN, TITLE_FONT_SIZE));
    }

    // Adds a timer to perform operations at every INTERVAL ms
    private void addTimer() {
        timer = new Timer(INTERVAL, e -> {
            if (game.isGameWon()) {
                stopTimer();
                YouWon();
            }

            else if (game.isGameOver()) {
                stopTimer();
                YouLost();
            }

            else {
                removeObjects();
                game.update();
                drawObjects();
                frame.revalidate();
            }
        });

        timer.start();  // starts timer, ends when gameOver = true
    }

    // Displays text "You Won!!!" on screen and final score
    private void YouWon() {
        String string = "You Won!!!          Total Score: ".concat(String.valueOf(game.getPoints()));
        JLabel label = new JLabel(string, SwingConstants.CENTER);
        frame.getContentPane().add(label);

        Font font = label.getFont();
        label.setFont(new Font(font.getName(), Font.PLAIN, TITLE_FONT_SIZE));
    }

    // Displays text "You lost :(" and final score
    private void YouLost() {
        String string = "Game Over :(          Final Score: ".concat(String.valueOf(game.getPoints()));
        JLabel label = new JLabel(string, SwingConstants.CENTER);
        frame.getContentPane().add(label);

        Font font = label.getFont();
        label.setFont(new Font(font.getName(), Font.PLAIN, TITLE_FONT_SIZE));
    }

    private void stopTimer() {
        timer.stop();
    }

    // Removes all labels from frame
    private void removeObjects() {
        frame.getContentPane().removeAll();
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

    // Getter methods (For testing only)
    public PMGame getGame() {return game;}
    public JFrame getFrame() {return frame;}

    // Runnable main method
    public static void main(String[] args) {
        new PacManGame();
    }


}
