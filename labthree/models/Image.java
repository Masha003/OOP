package labthree.models;

import java.io.IOException;
import java.awt.image.BufferedImage;
import java.nio.file.Path;

import javax.imageio.ImageIO;

public class Image extends Document {
    
    public Image(Path path) {
        super(path);
    }

    public String getImageSize() {
        try {
            BufferedImage image = ImageIO.read(this);
            if (image != null) {
                int width = image.getWidth();
                int height = image.getHeight();
                return width + "x" + height;
            } else {
                return "No available size";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error getting image size";
        }
    }


    @Override
    public String getInformation() {
        return super.getInformation() + "\nImage size: " + getImageSize();
    }
}
