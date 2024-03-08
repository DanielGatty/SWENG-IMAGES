package insightfulu.imagespackage;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SingleImage extends ImageView {
    private double IMAGE_WIDTH;
    private double IMAGE_HEIGHT;

    public SingleImage(String source) throws FileNotFoundException {
        File imageFile = new File(source);
        Image image = new Image(new FileInputStream(imageFile));
        IMAGE_WIDTH = image.getWidth();
        IMAGE_HEIGHT = image.getHeight();
        setImage(image);
        setPreserveRatio(true);
    }

    public SingleImage(String source, double xPos, double yPos) throws FileNotFoundException {
        File imageFile = new File(source);
        Image image = new Image(new FileInputStream(imageFile));
        IMAGE_WIDTH = image.getWidth();
        IMAGE_HEIGHT = image.getHeight();
        setImage(image);
        setPreserveRatio(true);
        setX(xPos);
        setY(yPos);
    }

    public double getImageWidth() {
        return IMAGE_WIDTH;
    }

    public double getImageHeight() {
        return IMAGE_HEIGHT;
    }
}