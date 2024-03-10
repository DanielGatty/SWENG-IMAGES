package insightfulu.imagespackage;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * SingleImage class represents a single image. This class contains the 
 * information necessary to display a single image and manipulate it
 */
public class SingleImage extends ImageView {
    // Constants related to the image, these can be manipulated
    private double sourceWidth; // Based on source image
    private double sourceHeight; // Based on source image
    private double viewWidth;
    private double viewHeight;
    private double xPosition;
    private double yPosition;
    private double scale; // Scale can go above 1.0 to enlarge images
    private double angle;

    private Image image;

    /*
     * Constructor requires just the image source. The size will be 
     * the original dimensions of the image and will be displayed at 
     * 0,0
     */
    public SingleImage(String source) throws FileNotFoundException {
        // Loading image file
        File imageFile = new File(source);
        image = new Image(new FileInputStream(imageFile));
        setImage(image);

        // Image position is based on top left corner of image
        sourceWidth = image.getWidth();
        sourceHeight = image.getHeight();
        
        // Default behaviour is to preserve aspect ratio
        setPreserveRatio(true);
    }

    /*
     * Constructor requires the image source and x/y coordinates.
     * The size will be the original dimensions of the image and will
     * be displayed at x,y
     */
    public SingleImage(String source, double xPos, double yPos) throws FileNotFoundException {
        // Loading image file
        File imageFile = new File(source);
        image = new Image(new FileInputStream(imageFile));
        setImage(image);

        // Dimensions are based on original image size
        sourceWidth = image.getWidth();
        sourceHeight = image.getHeight();

        // Image position is based on top left corner of image
        xPosition = xPos;
        yPosition = yPos;
        setX(xPos);
        setY(yPos);

        // Default behaviour is to preserve aspect ratio
        setPreserveRatio(true);
    }

    /*
     * Constructor requires the image source, x/y coordinates and
     * scale. The size will be the original dimensions multiplied by 
     * the scale, and will be displayed at x,y
     */
    public SingleImage(String source, double xPos, double yPos, double scale) throws FileNotFoundException {
        // Loading image file
        File imageFile = new File(source);
        image = new Image(new FileInputStream(imageFile));
        setImage(image);

        // Dimensions are based on original image size
        sourceWidth = image.getWidth();
        sourceHeight = image.getHeight();
        
        // Image position is based on top left corner of image
        xPosition = xPos;
        yPosition = yPos;
        setX(xPos);
        setY(yPos);

        // Setting image size according to scale
        viewWidth = sourceWidth * scale;
        viewHeight = sourceHeight * scale;
        setFitWidth(sourceWidth * scale);
        setFitHeight(sourceHeight * scale);

        // Default behaviour is to preserve aspect ratio
        setPreserveRatio(true);
    }

    /*
     * Constructor requires the image source, x/y coordinates, scale
     * and angle. The size will be the original dimensions multiplied 
     * by the scale, and will be displayed at x,y. The image will be 
     * rotated at a specified number of degrees rotated clockwise 
     * about the center of the image
     */
    public SingleImage(String source, double xPos, double yPos, double scale, double angle) throws FileNotFoundException {
        // Loading image file
        File imageFile = new File(source);
        image = new Image(new FileInputStream(imageFile));
        setImage(image);

        // Dimensions are based on original image size
        sourceWidth = image.getWidth();
        sourceHeight = image.getHeight();

        // Image position is based on top left corner of image
        xPosition = xPos;
        yPosition = yPos;
        setX(xPos);
        setY(yPos);

        // Setting image size according to scale
        viewWidth = sourceWidth * scale;
        viewHeight = sourceHeight * scale;
        setFitWidth(sourceWidth * scale);
        setFitHeight(sourceHeight * scale);

        // Setting angle of rotation
        setRotate(angle);

        // Default behaviour is to preserve aspect ratio
        setPreserveRatio(true);
    }

    /*
     * Constructor requires the image source, x/y coordinates, scale, angle
     * and a delay until showing. The size will be the original dimensions 
     * multiplied by the scale, and will be displayed at x,y. The image 
     * will be rotated at a specified number of degrees rotated clockwise 
     * about the center of the image. The image will be shown after the delay
     * in seconds, with millisecond resolution
     */
    public SingleImage(String source, double xPos, double yPos, double scale, double angle, double delay) throws FileNotFoundException {
        // Loading image file
        File imageFile = new File(source);
        image = new Image(new FileInputStream(imageFile));
        setImage(image);

        // Dimensions are based on original image size
        sourceWidth = image.getWidth();
        sourceHeight = image.getHeight();

        // Image position is based on top left corner of image
        xPosition = xPos;
        yPosition = yPos;
        setX(xPos);
        setY(yPos);

        // Setting image size according to scale
        viewWidth = sourceWidth * scale;
        viewHeight = sourceHeight * scale;
        setFitWidth(sourceWidth * scale);
        setFitHeight(sourceHeight * scale);

        // Setting angle of rotation
        setRotate(angle);

        // Default behaviour is to preserve aspect ratio
        setPreserveRatio(true);

        setVisible(false);
        new Thread ( new Runnable() {
            public void run() {
                try {
                    Thread.sleep((int) (delay * 1000));
                } catch (InterruptedException ie) {}
                setVisible(true);
            }
        }).start();
    }

    /*
     * Constructor requires the full set of parameters for the image. The size
     * will be the original dimensions multiplied by the scale, and will be 
     * displayed at x,y. The image will be rotated at a specified number of 
     * degrees rotated clockwise about the center of the image. The image will
     * be shown after the delay, and will be hidden after the duration, both
     * with millisecond resolution.
     */
    public SingleImage(String source, double xPos, double yPos, double scale, double angle, double delay, double duration) throws FileNotFoundException {
        // Loading image file
        File imageFile = new File(source);
        image = new Image(new FileInputStream(imageFile));
        setImage(image);

        // Dimensions are based on original image size
        sourceWidth = image.getWidth();
        sourceHeight = image.getHeight();

        // Image position is based on top left corner of image
        xPosition = xPos;
        yPosition = yPos;
        setX(xPos);
        setY(yPos);

        // Setting image size according to scale
        viewWidth = sourceWidth * scale;
        viewHeight = sourceHeight * scale;
        setFitWidth(sourceWidth * scale);
        setFitHeight(sourceHeight * scale);

        // Setting angle of rotation
        setRotate(angle);

        // Default behaviour is to preserve aspect ratio
        setPreserveRatio(true);

        setVisible(false);
        new Thread ( new Runnable() {
            public void run() {
                try {
                    Thread.sleep((int) (delay * 1000));
                } catch (InterruptedException ie) {}
                setVisible(true);
                try {
                    Thread.sleep((int) (duration * 1000));
                } catch (InterruptedException ie) {}
                setVisible(false);
            }
        }).start();
    }

    /*
     * Method allows you to change the image file by specifying a new
     * source for the image. The other 
     */
    public void changeSource(String source) {

    }

    /*
     * Method allows you to change the x position of the image. All
     * other properties will remain the same
     */
    public void changeX(double xPos) {

    }

    /*
     * Method allows you to change the y position of the image. All
     * other properties will remain the same
     */
    public void changeY(double yPos) {

    }

    /*
     * Method allows you to change the scale of the image. This will
     * change the view width and height of the image to be a multiple
     * of their original dimensions (maintaining aspect ratio). If you
     * have manually set a height and width, both of these properties
     * will be changed by calling this method
     */
    public void changeScale(double scale) {

    }

    /*
     * Method allows you to change the width of the image. This won't
     * change the height, so the aspect ratio will no longer be 
     * preserved (unless the height is changed in kind)
     */
    public void changeWidth(double width) {

    }

    /*
     * Method allows you to change the height of the image. This 
     * won't change the width, so the aspect ratio will no longer be
     * preserved (unless the width is changed in kind)
     */
    public void changeHeight(double height) {

    }

    /*
     * Method allows you to change the angle of the image. This
     * will set the angle of rotation clockwise, not rotate the 
     * image by a further amount
     */
    public void changeAngle(double angle) {

    }

    /*
     * Method allows you to hide the image
     */
    public void hide() {
        setVisible(false);
    }

    /*
     * Method allows you to show the image
     */
    public void show() {
        setVisible(true);
    }

    /*
     * GETTER METHODS DECLARED BELOW
     */

    public double getSourceWidth() {
        return sourceWidth;
    }

    public double getSourceHeight() {
        return sourceHeight;
    }

    public double getImageWidth() {
        return viewWidth;
    }

    public double getImageHeight() {
        return viewHeight;
    }

    public double getImageX() {
        return xPosition;
    }

    public double getImageY() {
        return yPosition;
    }

    public double getImageScale() {
        return scale;
    }

    public double getImageAngle() {
        return angle;
    }
}