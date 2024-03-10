package insightfulu.imagespackage;

import java.util.ArrayList;

/*
 * Methods of slideshow
 * 1. Add images to slide show (use varargs to do it all in one go)
 * 2. Add images to slide show (use varargs to do it all in one go, 
 *    this one is just string file names, not objects this time)
 * 3. Remove an image from the slideshow
 * 4. Change x position of the slideshow
 * 5. Change y position of the slideshow
 * 6. Change width of the slideshow
 * 7. Change height of the slideshow
 * 8. Change timings of slideshow
 * 9. Change direction of slideshow
 * 10. Stop the slideshow
 * 11. Start the slideshow again
 * 
 * Will also need
 * 1. getter for a particular image (let the user provide an index)
 * 2. getter for x position of slideshow
 * 3. getter for y position of slideshow
 * 4. getter for width of slideshow
 * 5. getter for height of slideshow
 * 6. getter for timings of slideshow
 * 7. getter for slideshow direction
 * 8. getter for length of slideshow
 * 9. getter for playing status of slideshow
 * 10. A method that will start the thread up that will start the slideshow
 */

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
    }
}
