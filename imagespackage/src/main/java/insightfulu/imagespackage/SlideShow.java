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

    // Member variables for the slideshow
    private ArrayList<SingleImage> slides;
    private double slideXPosition;
    private double slideYPosition;
    private double slideWidth;
    private double slideHeight;
    private double slideDuration;
    private Direction slideDirection;
    private volatile int slideCurrent;
    private boolean isPlaying;
    private volatile boolean hasChanged;

    /*
     * Constructor with no information specified. Just uses default
     * values for everything
     */
    public SlideShow() {
        slides = new ArrayList<SingleImage>();

        // Setting position
        slideXPosition = 0;
        slideYPosition = 0;
        setX(slideXPosition);
        setY(slideYPosition);

        // Setting dimensions
        slideWidth = 0;
        slideHeight = 0;
        setFitWidth(slideWidth);
        setFitHeight(slideHeight);

        // Setting initial values of the slide show
        slideDuration = 1;
        slideDirection = Direction.FORWARD;
        slideCurrent = 0;
        isPlaying = false;
        hasChanged = false;
    }

    /*
     * Constructor that specifies the position of the slideshow.
     * The rest is still just left as a default value
     */
    public SlideShow(double xPos, double yPos) {
        slides = new ArrayList<SingleImage>();

        // Setting position
        slideXPosition = xPos;
        slideYPosition = yPos;
        setX(slideXPosition);
        setY(slideYPosition);

        // Setting dimensions
        slideWidth = 0;
        slideHeight = 0;
        setFitWidth(slideWidth);
        setFitHeight(slideHeight);

        // Setting initial values of the slide show
        slideDuration = 1;
        slideDirection = Direction.FORWARD;
        slideCurrent = 0;
        isPlaying = false;
        hasChanged = false;
    }

    /*
     * Constructor with position and dimensions specified.
     */
    public SlideShow(double xPos, double yPos, double width, double height) {
        slides = new ArrayList<SingleImage>();

        // Setting position
        slideXPosition = xPos;
        slideXPosition = xPos;
        slideYPosition = yPos;
        setX(slideXPosition);
        setY(slideYPosition);

        // Setting dimensions
        slideWidth = width;
        slideHeight = height;
        setFitWidth(slideWidth);
        setFitHeight(slideHeight);

        // Setting initial values of the slide show
        slideDuration = 1;
        slideDirection = Direction.FORWARD;
        slideCurrent = 0;
        isPlaying = false;
        hasChanged = false;
    }

    /*
     * Constructor with position, dimensions and slide duration specified
     */
    public SlideShow(double xPos, double yPos, double width, double height, double duration) {
        slides = new ArrayList<SingleImage>();

        // Setting position
        slideXPosition = xPos;
        slideYPosition = yPos;
        setX(slideXPosition);
        setY(slideYPosition);

        // Setting dimensions
        slideWidth = width;
        slideHeight = height;
        setFitWidth(slideWidth);
        setFitHeight(slideHeight);
        
        // Setting initial values of the slide show
        slideDuration = duration;
        slideDirection = Direction.FORWARD;
        slideCurrent = 0;
        isPlaying = false;
        hasChanged = false;
    }

    /*
     * Constructor with all parameters specified
     */
    public SlideShow(double xPos, double yPos, double width, double height, double duration, Direction direction) {
        slides = new ArrayList<SingleImage>();
        
        // Setting position
        slideXPosition = xPos;
        slideYPosition = yPos;
        setX(slideXPosition);
        setY(slideYPosition);

        // Setting dimensions
        slideWidth = width;
        slideHeight = height;
        setFitWidth(slideWidth);
        setFitHeight(slideHeight);

        // Setting initial values of the slide show
        slideDuration = duration;
        slideDirection = direction;
        slideCurrent = 0;
        isPlaying = false;
        hasChanged = false;
    }

    /*
     * Method lets you add images to the slideshow using single images
     */
    public void addImage(SingleImage ... images) {
        for (SingleImage image: images) {
            // If we haven't already set dimensions
            if (slideWidth == 0 && slideHeight == 0) {
                slideWidth = image.getImageWidth();
                slideHeight = image.getImageHeight();
                setFitWidth(slideWidth);
                setFitHeight(slideHeight);
            }
            slides.add(image);
        }
        updateSlideShow();
    }

    /*
     * Method lets you add images to the slideshow using strings
     */
    public void addImage(String ... images) throws FileNotFoundException {
        SingleImage newImage;
        for (String image: images) {
            newImage = new SingleImage(image);
            // If we haven't already set dimensions
            if (slideWidth == 0 && slideHeight == 0) {
                slideWidth = newImage.getImageWidth();
                slideHeight = newImage.getImageHeight();
            } 
            slides.add(newImage);
        }
        updateSlideShow();
    }

    /*
     * Method lets you remove images from the slide show by specifiying
     * an index
     */
    public void removeImage(int index) {
        hasChanged = true;
        slides.remove(index);
        slideCurrent = 0;
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

    /*
     * Method is used to run the slide show in a separate thread. Must be called
     * every time the slideshow is updated in order to incorporate these changes
     */
    private void updateSlideShow() {
        hasChanged = true;
        if (isPlaying) {
            new Thread (new Runnable() { public void run() {
                    hasChanged = false;
                    while (hasChanged == false && slides.size() > 0) {
                        setImage(slides.get(slideCurrent).getImage());
                        try {
                            Thread.sleep((int) (slideDuration * 1000));
                        } catch (InterruptedException ie) {}
                        if (slideDirection == Direction.FORWARD && slides.size() != 0) {
                            ++slideCurrent;
                            slideCurrent %= slides.size();
                        } else {
                            --slideCurrent;
                            if (slideCurrent == -1)
                                slideCurrent += slides.size();
                        }
                    }
                    if (slides.size() == 0)
                        setVisible(false);
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
        return slides.size();
    }

    public boolean isPlaying() {
        return isPlaying;
    }
}
