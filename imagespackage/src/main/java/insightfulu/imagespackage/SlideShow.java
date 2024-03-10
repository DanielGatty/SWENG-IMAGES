package insightfulu.imagespackage;

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
    private boolean hasChanged;

    public SlideShow() {
        slides = new ArrayList<SingleImage>();
        slideXPosition = 0;
        slideYPosition = 0;
        slideWidth = 0;
        slideHeight = 0;
        slideDuration = 1;
        slideDirection = Direction.FORWARD;
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
        isPlaying = false;
        hasChanged = false;
    }

    public void addImage(SingleImage ... images) {

    }

    public void addImage(String ... images) {

    }

    public void removeImage(int index) {

    }

    public void changeX(double xPos) {

    }

    public void changeY(double yPos) {

    }

    public void changeWidth(double width) {

    }

    public void changeHeight(double height) {

    }

    public void changeDuration(double duration) {

    }

    public void changeDirection(Direction direction) {

    }

    public void stop() {

    }

    public void play() {

    }

    private void startSlideShow() {

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
