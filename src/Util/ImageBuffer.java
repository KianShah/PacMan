package Util;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ImageBuffer {

    /**
     * Returns an ImageIcon object built from the image found at the given filepath
     * @param filepath
     * @param cl
     * @return
     */
    public static ImageIcon getImage(String filepath, Class cl) {
        try {
            Image image = ImageIO.read(cl.getResource(filepath));
            return new ImageIcon(image);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
