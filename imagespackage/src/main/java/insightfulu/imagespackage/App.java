package insightfulu.imagespackage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import insightfulu.imagespackage.SlideShow.Direction;

/**
 * JavaFX App
 */
public class App extends Application {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException, InterruptedException {
        String filePath = "src/main/resources/images/stockimage.jpg";
        String filePath2 = "src/main/resources/images/stockimage2.jpg";
        String filePath3 = "src/main/resources/images/stockimage3.jpg";

        SingleImage image1 = new SingleImage(filePath);

        SlideShow slideShow = new SlideShow(0, 0, WIDTH, HEIGHT, 2.5, Direction.BACKWARD);

        slideShow.addImage(image1);
        slideShow.addImage(filePath2, filePath3);

        Group root = new Group(slideShow);

        scene = new Scene(root, WIDTH, HEIGHT);

        stage.setTitle("Loading an image");

        stage.setScene(scene);

        stage.show();

        slideShow.play();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
}