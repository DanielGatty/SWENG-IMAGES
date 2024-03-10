package insightfulu.imagespackage;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import insightfulu.imagespackage.SlideShow.Direction;

import java.io.FileNotFoundException;

public class SlideShowTest extends ApplicationTest {

    private SlideShow slideShow;
    private String filePath;
    private String filePath2;
    private String filePath3;
    private double defaultX;
    private double defaultY;
    private double defaultWidth;
    private double defaultHeight;
    private double defaultDuration;
    private Direction defaultDirection;

    @BeforeEach
    void setUp() {
        filePath = "src/main/resources/images/stockimage.jpg";
        filePath2 = "src/main/resources/images/stockimage2.jpg";
        filePath3 = "src/main/resources/images/stockimage3.jpg";
        defaultX = 200;
        defaultY = 200;
        defaultWidth = 600;
        defaultHeight = 800;
        defaultDuration = 1.5;
        defaultDirection = Direction.BACKWARD;
    }

    @Test
    void testDefaultConstructor() {
        slideShow = new SlideShow();
        assertAll(
            () -> assertNotNull(slideShow),
            () -> assertEquals(0, slideShow.getSlideX()),
            () -> assertEquals(0, slideShow.getSlideY()),
            () -> assertEquals(0, slideShow.getSlideWidth()),
            () -> assertEquals(0, slideShow.getSlideHeight()),
            () -> assertEquals(1, slideShow.getSlideDuration()),
            () -> assertEquals(Direction.FORWARD, slideShow.getSlideDirection()),
            () -> assertEquals(false, slideShow.isPlaying())
        );
    }

    @Test
    void testPositionConstructor() {
        slideShow = new SlideShow(defaultX, defaultY);
        assertAll(
            () -> assertNotNull(slideShow),
            () -> assertEquals(defaultX, slideShow.getSlideX()),
            () -> assertEquals(defaultY, slideShow.getSlideY()),
            () -> assertEquals(0, slideShow.getSlideWidth()),
            () -> assertEquals(0, slideShow.getSlideHeight()),
            () -> assertEquals(1, slideShow.getSlideDuration()),
            () -> assertEquals(Direction.FORWARD, slideShow.getSlideDirection()),
            () -> assertEquals(false, slideShow.isPlaying())
        );
    }

    @Test
    void testSizeConstructor() {
        slideShow = new SlideShow(defaultX, defaultY, defaultWidth, defaultHeight);
        assertAll(
            () -> assertNotNull(slideShow),
            () -> assertEquals(defaultX, slideShow.getSlideX()),
            () -> assertEquals(defaultY, slideShow.getSlideY()),
            () -> assertEquals(defaultWidth, slideShow.getSlideWidth()),
            () -> assertEquals(defaultHeight, slideShow.getSlideHeight()),
            () -> assertEquals(1, slideShow.getSlideDuration()),
            () -> assertEquals(Direction.FORWARD, slideShow.getSlideDirection()),
            () -> assertEquals(false, slideShow.isPlaying())
        );
    }

    @Test
    void testDurationConstructor() {
        slideShow = new SlideShow(defaultX, defaultY, defaultWidth, defaultHeight, defaultDuration);
        assertAll(
            () -> assertNotNull(slideShow),
            () -> assertEquals(defaultX, slideShow.getSlideX()),
            () -> assertEquals(defaultY, slideShow.getSlideY()),
            () -> assertEquals(defaultWidth, slideShow.getSlideWidth()),
            () -> assertEquals(defaultHeight, slideShow.getSlideHeight()),
            () -> assertEquals(defaultDuration, slideShow.getSlideDuration()),
            () -> assertEquals(Direction.FORWARD, slideShow.getSlideDirection()),
            () -> assertEquals(false, slideShow.isPlaying())
        );
    }

    @Test
    void testDirectionConstructor() {
        slideShow = new SlideShow(defaultX, defaultY, defaultWidth, defaultHeight, 
        defaultDuration, defaultDirection);
        assertAll(
            () -> assertNotNull(slideShow),
            () -> assertEquals(defaultX, slideShow.getSlideX()),
            () -> assertEquals(defaultY, slideShow.getSlideY()),
            () -> assertEquals(defaultWidth, slideShow.getSlideWidth()),
            () -> assertEquals(defaultHeight, slideShow.getSlideHeight()),
            () -> assertEquals(defaultDuration, slideShow.getSlideDuration()),
            () -> assertEquals(defaultDirection, slideShow.getSlideDirection()),
            () -> assertEquals(false, slideShow.isPlaying())
        );

    }

    @Test
    void testAddingSingleImages() throws FileNotFoundException {
        SingleImage image1 = new SingleImage(filePath);
        SingleImage image2 = new SingleImage(filePath2);
        SingleImage image3 = new SingleImage(filePath3);
        slideShow = new SlideShow();
        slideShow.addImage(image1, image2, image3);
        assertAll(
            () -> assertEquals(image1, slideShow.getImage(0)),
            () -> assertEquals(image2, slideShow.getImage(1)),
            () -> assertEquals(image3, slideShow.getImage(2)),
            () -> assertEquals(image1.getSourceWidth(), slideShow.getSlideWidth()),
            () -> assertEquals(image1.getSourceHeight(), slideShow.getSlideHeight())
        );
    }

    @Test
    void testAddingStringImages() throws FileNotFoundException {
        SingleImage image1 = new SingleImage(filePath);
        SingleImage image2 = new SingleImage(filePath2);
        SingleImage image3 = new SingleImage(filePath3);
        slideShow = new SlideShow();
        slideShow.addImage(filePath, filePath2, filePath3);
        assertAll(
            () -> assertEquals(image1.getSourceHeight(), slideShow.getImage(0).getSourceHeight()),
            () -> assertEquals(image2.getSourceHeight(), slideShow.getImage(1).getSourceHeight()),
            () -> assertEquals(image3.getSourceHeight(), slideShow.getImage(2).getSourceHeight()),
            () -> assertEquals(image1.getSourceWidth(), slideShow.getSlideWidth()),
            () -> assertEquals(image1.getSourceHeight(), slideShow.getSlideHeight())
        );
    }

    @Test
    void testRemoveImages() throws FileNotFoundException {
        slideShow = new SlideShow();
        slideShow.addImage(filePath, filePath2, filePath3);
        assertEquals(3, slideShow.getSlideLength());
        slideShow.removeImage(0);
        assertEquals(2, slideShow.getSlideLength());
        slideShow.removeImage(0);
        assertEquals(1, slideShow.getSlideLength());
        slideShow.removeImage(0);
        assertEquals(0, slideShow.getSlideLength());
    }

    @Test
    void testChangeX() {
        slideShow = new SlideShow();
        slideShow.changeSlideX(defaultX);
        assertEquals(defaultX, slideShow.getSlideX());
    }

    @Test
    void testChangeY() {
        slideShow = new SlideShow();
        slideShow.changeSlideY(defaultY);
        assertEquals(defaultY, slideShow.getSlideY());

    }

    @Test
    void testChangeWidth() {
        slideShow = new SlideShow();
        slideShow.changeSlideWidth(defaultWidth);
        assertEquals(defaultWidth, slideShow.getSlideWidth());
    }

    @Test
    void testChangeHeight() {
        slideShow = new SlideShow();
        slideShow.changeSlideHeight(defaultHeight);
        assertEquals(defaultHeight, slideShow.getSlideHeight());
    }
    
    @Test
    void testChangeDuration() {
        slideShow = new SlideShow();
        slideShow.changeSlideDuration(defaultDuration);
        assertEquals(defaultDuration, slideShow.getSlideDuration());
    }

    @Test
    void testChangeDirection() {
        slideShow = new SlideShow();
        slideShow.changeSlideDirection(defaultDirection);
        assertEquals(defaultDirection, slideShow.getSlideDirection());
    }

    @Test
    void testPlayAndStop() throws FileNotFoundException {
        slideShow = new SlideShow();
        slideShow.addImage(filePath, filePath2, filePath3);
        slideShow.play();
        assertEquals(true, slideShow.isPlaying());
        slideShow.stop();
        assertEquals(false, slideShow.isPlaying());
    }

    @Test
    void testPlayForward() throws FileNotFoundException, InterruptedException {
        slideShow = new SlideShow();
        slideShow.addImage(filePath, filePath2, filePath3);
        slideShow.play();
        assertEquals(0, slideShow.getSlideCurrent());
        Thread.sleep(1100);
        assertEquals(1, slideShow.getSlideCurrent());
        Thread.sleep(1100);
        assertEquals(2, slideShow.getSlideCurrent());
        Thread.sleep(1100);
        assertEquals(0, slideShow.getSlideCurrent());
    }

    @Test 
    void testPlayBackward() throws FileNotFoundException, InterruptedException {
        slideShow = new SlideShow();
        slideShow.addImage(filePath, filePath2, filePath3);
        slideShow.changeSlideDirection(defaultDirection);
        slideShow.play();
        assertEquals(0, slideShow.getSlideCurrent());
        Thread.sleep(1100);
        assertEquals(2, slideShow.getSlideCurrent());
        Thread.sleep(1100);
        assertEquals(1, slideShow.getSlideCurrent());
        Thread.sleep(1100);
        assertEquals(0, slideShow.getSlideCurrent());
    }
}
