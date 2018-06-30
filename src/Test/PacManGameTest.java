package Test;

import Model.PMGame;
import UI.PacManGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PacManGameTest {
    PacManGame pacManGame;
    JFrame frame;
    PMGame PMGame;

    @BeforeEach
    public void runBefore() {
        pacManGame = new PacManGame();
        frame = pacManGame.getFrame();
        PMGame = pacManGame.getGame();
    }

    @Test
    public void testConstructor() {
        assertEquals(7, frame.getContentPane().getComponents().length);
    }
}
