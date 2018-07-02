package Util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class ImageBuffer {

    /**
     * Returns an ImageIcon object built from the image found at the given filepath
     * @param filepath
     * @param cl
     * @return
     */
    public static Image getImage(String filepath, Class cl) {
        try {
            return ImageIO.read(cl.getResource(filepath));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
