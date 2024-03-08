package insightfulu.imagespackage;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SingleImage extends ImageView {
    public SingleImage(String source) throws FileNotFoundException {
        File imageFile = new File(source);
        Image image = new Image(new FileInputStream(imageFile));
        setImage(image);
        setPreserveRatio(true);
    }
}