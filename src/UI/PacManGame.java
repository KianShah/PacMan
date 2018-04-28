package UI;

import Model.PacMan;
import util.Pos;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PacManGame {
    public Pos initialPos;

    private JFrame frame;
    private final int width = 300;
    private final int height = 500;

    private PacMan pacMan;

    // Sets up PacMan game
    PacManGame() {

        initialPos = new Pos(50, 50);
        pacMan = new PacMan(initialPos);
        frame = new JFrame("PacMan");
        frame.setSize(width, height);
        try {
            frame.setIconImage(ImageIO.read(new File("strawberry.jpg"));
        }
        catch (IOException){
            fail("IOException thrown");
        }

        drawObjects();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void drawObjects() {
        JLabel PM_Label = new JLabel(pacMan.getImage());
        frame.getContentPane().add(PM_Label);
        LayoutManager manager = new GridLayout(50,30);
        JLabel Wall_Label = new JLabel(new ImageIcon("Wall.png"));
        frame.getContentPane().add(Wall_Label);
//        manager.addLayoutComponent("Wall", Wall_Label);
    }

    public static void main(String[] args) {
        new PacManGame();
    }
}
