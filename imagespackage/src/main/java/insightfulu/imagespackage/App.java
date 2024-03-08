package insightfulu.imagespackage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        SingleImage singleImage = new SingleImage("src/main/resources/images/stockimage.jpg");

        singleImage.setFitWidth(300);
        singleImage.setFitHeight(200);

        singleImage.setX(WIDTH / 2 - singleImage.getFitWidth() / 2);
        singleImage.setY(HEIGHT / 2 - singleImage.getFitHeight() / 2);

        Group root = new Group(singleImage);

        scene = new Scene(root, WIDTH, HEIGHT);

        stage.setTitle("Loading an image");

        stage.setScene(scene);

        stage.show();
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