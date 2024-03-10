package insightfulu.imagespackage;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import javafx.scene.image.Image;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SingleImageTest extends ApplicationTest {

    private SingleImage singleImage;
    private String filePath;
    private String filePath2;
    private double defaultX;
    private double defaultY;
    private double defaultScale;
    private double defaultAngle;
    private double defaultDelay;
    private double defaultDuration;

    @BeforeEach
    void setUp() {
        filePath = "src/main/resources/images/stockimage.jpg";
        filePath2 = "src/main/resources/images/stockimage2.jpg";
        defaultX = 200;
        defaultY = 200;
        defaultScale = 0.5;
        defaultAngle = 45;
        defaultDelay = 1;
        defaultDuration = 1;
    }

    // Testing the constructor for specifying just the source
    @Test
    void testSourceConstructor() throws FileNotFoundException {
        singleImage = new SingleImage(filePath);
        File imageFile = new File(filePath);
        Image image = new Image(new FileInputStream(imageFile));
        assertAll(
            () -> assertNotNull(singleImage),
            () -> assertEquals(image.getWidth(), singleImage.getSourceWidth()),
            () -> assertEquals(image.getHeight(), singleImage.getSourceHeight()),
            () -> assertEquals(true, singleImage.isPreserveRatio())
        );
    }

    // Testing the constructor for specifying source and position
    @Test
    void testPositionConstructor() throws FileNotFoundException {
        singleImage = new SingleImage(filePath, defaultX, defaultY);
        File imageFile = new File(filePath);
        Image image = new Image(new FileInputStream(imageFile));
        assertAll(
            () -> assertNotNull(singleImage),
            () -> assertEquals(image.getWidth(), singleImage.getSourceWidth()),
            () -> assertEquals(image.getHeight(), singleImage.getSourceHeight()),
            () -> assertEquals(true, singleImage.isPreserveRatio()),
            () -> assertEquals(defaultX, singleImage.getImageX()),
            () -> assertEquals(defaultY, singleImage.getImageY())
        );
    }

    // Testing the constructor for specifying source, position and scale
    @Test
    void testScaleConstructor() throws FileNotFoundException {
        singleImage = new SingleImage(filePath, defaultX, defaultY, defaultScale);
        File imageFile = new File(filePath);
        Image image = new Image(new FileInputStream(imageFile));
        assertAll(
            () -> assertNotNull(singleImage),
            () -> assertEquals(image.getWidth(), singleImage.getSourceWidth()),
            () -> assertEquals(image.getHeight(), singleImage.getSourceHeight()),
            () -> assertEquals(true, singleImage.isPreserveRatio()),
            () -> assertEquals(defaultX, singleImage.getImageX()),
            () -> assertEquals(defaultY, singleImage.getImageY()),
            () -> assertEquals(defaultScale, singleImage.getImageScale())
        );
    }


    // Testing the constructor for specifying source, position, scale and angle
    @Test
    void testAngleConstructor() throws FileNotFoundException {
        singleImage = new SingleImage(filePath, defaultX, defaultY, defaultScale, defaultAngle);
        File imageFile = new File(filePath);
        Image image = new Image(new FileInputStream(imageFile));
        assertAll(
            () -> assertNotNull(singleImage),
            () -> assertEquals(image.getWidth(), singleImage.getSourceWidth()),
            () -> assertEquals(image.getHeight(), singleImage.getSourceHeight()),
            () -> assertEquals(true, singleImage.isPreserveRatio()),
            () -> assertEquals(defaultX, singleImage.getImageX()),
            () -> assertEquals(defaultY, singleImage.getImageY()),
            () -> assertEquals(defaultScale, singleImage.getImageScale()),
            () -> assertEquals(defaultAngle, singleImage.getImageAngle())
        );
    }

    // Testing the constructor with delay
    @Test
    void testDelayConstructor() throws FileNotFoundException, InterruptedException {
        singleImage = new SingleImage(filePath, defaultX, defaultY, defaultScale, defaultAngle, defaultDelay);
        File imageFile = new File(filePath);
        Image image = new Image(new FileInputStream(imageFile));
        assertAll(
            () -> assertNotNull(singleImage),
            () -> assertEquals(image.getWidth(), singleImage.getSourceWidth()),
            () -> assertEquals(image.getHeight(), singleImage.getSourceHeight()),
            () -> assertEquals(true, singleImage.isPreserveRatio()),
            () -> assertEquals(defaultX, singleImage.getImageX()),
            () -> assertEquals(defaultY, singleImage.getImageY()),
            () -> assertEquals(defaultScale, singleImage.getImageScale()),
            () -> assertEquals(defaultAngle, singleImage.getImageAngle()),
            () -> assertEquals(false, singleImage.isVisible())
        );
        Thread.sleep(2000);
        assertEquals(true, singleImage.isVisible());
    }

    // Testing the constructor with delay and duration
    @Test 
    void testDurationConstructor() throws FileNotFoundException, InterruptedException {
        singleImage = new SingleImage(filePath, defaultX, defaultY, defaultScale, defaultAngle, 
        defaultDelay, defaultDuration);
        File imageFile = new File(filePath);
        Image image = new Image(new FileInputStream(imageFile));
        assertAll(
            () -> assertNotNull(singleImage),
            () -> assertEquals(image.getWidth(), singleImage.getSourceWidth()),
            () -> assertEquals(image.getHeight(), singleImage.getSourceHeight()),
            () -> assertEquals(true, singleImage.isPreserveRatio()),
            () -> assertEquals(defaultX, singleImage.getImageX()),
            () -> assertEquals(defaultY, singleImage.getImageY()),
            () -> assertEquals(defaultScale, singleImage.getImageScale()),
            () -> assertEquals(defaultAngle, singleImage.getImageAngle()),
            () -> assertEquals(false, singleImage.isVisible())
        );
        Thread.sleep(1500);
        assertEquals(true, singleImage.isVisible());
        Thread.sleep(1500);
        assertEquals(false, singleImage.isVisible());
    }

    // Testing the method for changing the source
    @Test
    void testChangeSource() throws FileNotFoundException {
        singleImage = new SingleImage(filePath);
        File imageFile = new File(filePath);
        Image image = new Image(new FileInputStream(imageFile));
        assertAll(
            () -> assertNotNull(singleImage),
            () -> assertEquals(image.getWidth(), singleImage.getSourceWidth()),
            () -> assertEquals(image.getHeight(), singleImage.getSourceHeight())
        );
        imageFile = new File(filePath2);
        Image image2 = new Image(new FileInputStream(imageFile));
        singleImage.changeSource(filePath2);
        assertAll(
            () -> assertNotNull(singleImage),
            () -> assertEquals(image2.getWidth(), singleImage.getSourceWidth()),
            () -> assertEquals(image2.getHeight(), singleImage.getSourceHeight())
        );
    }

    // Testing the method for changing x position of image
    @Test
    void testChangeX() throws FileNotFoundException {
        singleImage = new SingleImage(filePath, defaultX, defaultY);
        assertEquals(defaultX, singleImage.getImageX());
        singleImage.changeX(defaultX + 100);
        assertEquals(defaultX + 100, singleImage.getImageX());
    }

    // Testing the method for changing y position of image
    @Test
    void testChangeY() throws FileNotFoundException{
        singleImage = new SingleImage(filePath, defaultX, defaultY);
        assertEquals(defaultY, singleImage.getImageY());
        singleImage.changeY(defaultY + 100);
        assertEquals(defaultY + 100, singleImage.getImageY());

    }

    // Testing we can change the image scale
    @Test
    void testChangeScale() throws FileNotFoundException {
        singleImage = new SingleImage(filePath);
        singleImage.changeScale(defaultScale);
        assertAll(
            () -> assertEquals(defaultScale, singleImage.getImageScale()),
            () -> assertEquals(singleImage.getSourceWidth() * defaultScale, singleImage.getImageWidth()),
            () -> assertEquals(singleImage.getSourceHeight() * defaultScale, singleImage.getImageHeight()),
            () -> assertEquals(true, singleImage.isPreserveRatio())
        );
    }

    // Testing we can change the image width
    @Test
    void testChangeWidth() throws FileNotFoundException {
        singleImage = new SingleImage(filePath);
        singleImage.changeWidth(singleImage.getSourceWidth() / 2);
        assertAll(
            () -> assertEquals(singleImage.getSourceHeight(), singleImage.getImageHeight()),
            () -> assertEquals(singleImage.getSourceWidth() / 2, singleImage.getImageWidth()),
            () -> assertEquals(false, singleImage.isPreserveRatio())
        );
    }

    // Testing we can change the image height
    @Test
    void testChangeHeight() throws FileNotFoundException {
        singleImage = new SingleImage(filePath);
        singleImage.changeHeight(singleImage.getSourceHeight() / 2);
        assertAll(
            () -> assertEquals(singleImage.getSourceHeight() / 2, singleImage.getImageHeight()),
            () -> assertEquals(singleImage.getSourceWidth(), singleImage.getImageWidth()),
            () -> assertEquals(false, singleImage.isPreserveRatio())
        );
    }

    // Testing we can change the image angle
    @Test
    void testChangeAngle() throws FileNotFoundException {
        singleImage = new SingleImage(filePath, defaultX, defaultY, defaultScale, defaultAngle);
        assertEquals(defaultAngle, singleImage.getImageAngle());
        singleImage.changeAngle(defaultAngle + 60);
        assertEquals(defaultAngle + 60, singleImage.getImageAngle());
    }

    // Testing we can hide and show the image
    @Test
    void testHideAndShow() throws FileNotFoundException {
        singleImage = new SingleImage(filePath);
        assertEquals(true, singleImage.isVisible());
        singleImage.hide();
        assertEquals(false, singleImage.isVisible());
        singleImage.show();
        assertEquals(true, singleImage.isVisible());
    }
}
