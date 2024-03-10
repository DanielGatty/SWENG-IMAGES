package insightfulu.imagespackage;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import javafx.scene.image.ImageView;

/**
 * SlideShow class represents all of the functionality for 
 * manipulating a series of images, displaying them in a
 * sequential manner
 */
public class SlideShow extends ImageView {
    public enum Direction {
        FORWARD,
        BACKWARD
    }

    private ArrayList<SingleImage> slides;
    private double slideXPosition;
    private double slideYPosition;
    private double slideWidth;
    private double slideHeight;
    private double slideDuration;
    private Direction slideDirection;
    private int slideLength;
    private volatile int slideCurrent;
    private boolean isPlaying;
    private volatile boolean hasChanged;

    public SlideShow() {
        slides = new ArrayList<SingleImage>();
        slideXPosition = 0;
        slideYPosition = 0;
        slideWidth = 0;
        slideHeight = 0;
        slideDuration = 1;
        slideDirection = Direction.FORWARD;
        slideLength = 0;
        slideCurrent = 0;
        isPlaying = false;
        hasChanged = false;
    }

    public SlideShow(double xPos, double yPos) {
        slides = new ArrayList<SingleImage>();
        slideXPosition = xPos;
        slideYPosition = yPos;
        slideWidth = 0;
        slideHeight = 0;
        slideDuration = 1;
        slideDirection = Direction.FORWARD;
        slideLength = 0;
        slideCurrent = 0;
        isPlaying = false;
        hasChanged = false;
    }

    public SlideShow(double xPos, double yPos, double width, double height) {
        slides = new ArrayList<SingleImage>();
        slideXPosition = xPos;
        slideYPosition = yPos;
        slideWidth = width;
        slideHeight = height;
        slideDuration = 1;
        slideDirection = Direction.FORWARD;
        slideLength = 0;
        slideCurrent = 0;
        isPlaying = false;
        hasChanged = false;
    }

    public SlideShow(double xPos, double yPos, double width, double height, double duration) {
        slides = new ArrayList<SingleImage>();
        slideXPosition = xPos;
        slideYPosition = yPos;
        slideWidth = width;
        slideHeight = height;
        slideDuration = duration;
        slideDirection = Direction.FORWARD;
        slideLength = 0;
        slideCurrent = 0;
        isPlaying = false;
        hasChanged = false;
    }

    public SlideShow(double xPos, double yPos, double width, double height, double duration, Direction direction) {
        slides = new ArrayList<SingleImage>();
        slideXPosition = xPos;
        slideYPosition = yPos;
        slideWidth = width;
        slideHeight = height;
        slideDuration = duration;
        slideDirection = direction;
        slideLength = 0;
        slideCurrent = 0;
        isPlaying = false;
        hasChanged = false;
    }

    public void addImage(SingleImage ... images) {
        for (SingleImage image: images) {
            if (slideWidth == 0 && slideHeight == 0) {
                slideWidth = image.getImageWidth();
                slideHeight = image.getImageHeight();
            }
            slides.add(image);
            ++slideLength;
        }
        updateSlideShow();
    }

    public void addImage(String ... images) throws FileNotFoundException {
        SingleImage newImage;
        for (String image: images) {
            newImage = new SingleImage(image);
            if (slideWidth == 0 && slideHeight == 0) {
                slideWidth = newImage.getImageWidth();
                slideHeight = newImage.getImageHeight();
            } 
            slides.add(newImage);
            ++slideLength;
        }
        updateSlideShow();
    }

    public void removeImage(int index) {
        // What happens when we remove a picture
        // send a has change = true to stop the slideshow
        // remove the index
        // if the index is less than the current index
        //  - decrement the current index
        // decrement the length
        hasChanged = true;
        slides.remove(index);
        if (index < slideCurrent) {
            --slideCurrent;
        }
        --slideLength;
        updateSlideShow();
    }

    public void changeX(double xPos) {
        slideXPosition = xPos;
        setX(xPos);
        updateSlideShow();
    }

    public void changeY(double yPos) {
        slideYPosition = yPos;  
        setY(yPos);
        updateSlideShow();
    }

    public void changeWidth(double width) {
        slideWidth = width;
        setFitWidth(width);
        updateSlideShow();
    }

    public void changeHeight(double height) {
        slideHeight = height;
        setFitHeight(height);
        updateSlideShow();
    }

    public void changeDuration(double duration) {
        slideDuration = duration;
        updateSlideShow();
    }

    public void changeDirection(Direction direction) {
        slideDirection = direction;
        updateSlideShow();
    }

    public void stop() {
        isPlaying = false;
        updateSlideShow();
    }

    public void play() {
        isPlaying = true;
        updateSlideShow();
    }

    private void updateSlideShow() {
        hasChanged = true;
        if (isPlaying) {
            new Thread (new Runnable() { public void run() {
                    hasChanged = false;
                    while (hasChanged == false) {
                        setImage(slides.get(slideCurrent).getImage());
                        try {
                            Thread.sleep((int) (slideDuration * 1000));
                        } catch (InterruptedException ie) {}
                        if (slideDirection == Direction.FORWARD) {
                            ++slideCurrent;
                        } else {
                            --slideCurrent;
                        }
                        slideCurrent %= slideLength;
                    }
                }
            }).start();
        }
    }

    public SingleImage getImage(int index) {
        return slides.get(index);
    }

    public double getSlideX() {
        return slideXPosition;
    }

    public double getSlideY() {
        return slideYPosition;
    }

    public double getSlideWidth() {
        return slideWidth;
    }

    public double getSlideHeight() {
        return slideHeight;
    }

    public double getSlideDuration() {
        return slideDuration;
    }

    public Direction getSlideDirection() {
        return slideDirection;
    }

    public int getSlideLength() {
        return slideLength;
    }

    public boolean isPlaying() {
        return isPlaying;
    }
}
