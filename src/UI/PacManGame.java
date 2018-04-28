package UI;

import Model.PacMan;

import javax.swing.*;

public class PacManGame {

    private JFrame frame;
    private PacMan pacMan;

    // Sets up PacMan game
    PacManGame() {
        frame = new JFrame("PacMan");
        frame.setSize(1366, 768);

        JLabel label = new JLabel(pacMan.getImage());
        frame.getContentPane().add(label);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new PacManGame();
    }
}
