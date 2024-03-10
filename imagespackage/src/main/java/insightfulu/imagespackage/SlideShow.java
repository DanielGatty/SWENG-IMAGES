package insightfulu.imagespackage;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * SlideShow class represents all of the functionality for 
 * manipulating a series of images, displaying them in a
 * sequential manner
 */
public class SlideShow {
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
    private int slideCurrent;
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
            image.changeX(slideXPosition);
            image.changeY(slideYPosition);
            if (slideWidth == 0 && slideHeight == 0) {
                slideWidth = image.getImageWidth();
                slideHeight = image.getImageHeight();
            } else {
                image.changeWidth(slideWidth);
                image.changeHeight(slideHeight);
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
            newImage.changeX(slideXPosition);
            newImage.changeY(slideYPosition);
            if (slideWidth == 0 && slideHeight == 0) {
                slideWidth = newImage.getImageWidth();
                slideHeight = newImage.getImageHeight();
            } else {
                newImage.changeWidth(slideWidth);
                newImage.changeHeight(slideHeight);
            }
            slides.add(newImage);
            ++slideLength;
        }
        updateSlideShow();
    }

    public void removeImage(int index) {
        slides.remove(index);
        --slideLength;
        updateSlideShow();
    }

    public void changeX(double xPos) {
        slideXPosition = xPos;
        for (SingleImage image: slides) {
            image.changeX(xPos);
        }
        updateSlideShow();
    }

    public void changeY(double yPos) {
        slideYPosition = yPos;  
        for (SingleImage image: slides) {
            image.changeY(yPos);
        }
        updateSlideShow();
    }

    public void changeWidth(double width) {
        slideWidth = width;
        for (SingleImage image: slides) {
            image.changeWidth(width);
        }
        updateSlideShow();
    }

    public void changeHeight(double height) {
        slideHeight = height;
        for (SingleImage image: slides) {
            image.changeHeight(height);
        }
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
    }

    public SingleImage getImage(int index) {
        return slides.get(index);
    }

    public double getX() {
        return slideXPosition;
    }

    public double getY() {
        return slideYPosition;
    }

    public double getWidth() {
        return slideWidth;
    }

    public double getHeight() {
        return slideHeight;
    }

    public double getDuration() {
        return slideDuration;
    }

    public Direction getDirection() {
        return slideDirection;
    }

    public int getLength() {
        return slideLength;
    }

    public boolean isPlaying() {
        return isPlaying;
    }
}
