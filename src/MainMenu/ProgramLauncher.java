package MainMenu;

import GlobalClasses.ErrorAlert;
import GlobalClasses.GlobalDTO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ProgramLauncher extends Application  {

    @Override
    public void start(Stage primaryStage) throws Exception{
        GlobalDTO.setMainWindowHandler(primaryStage);

        drawMainScene();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public void drawMainScene() {
        Stage primaryStage = GlobalDTO.getMainWindowHandler();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("VMainMenu.fxml"));
            primaryStage.setTitle("cmok");
            primaryStage.setScene(new Scene(root, 1000, 800));
            primaryStage.show();

        } catch (IOException exception) {
            new ErrorAlert().errorOccurs("Nie mogłem załadować pliku VMainMenu.fxml odpowiadającego za wygląd okienek! Problem IO.");
            System.err.println("Nie mogłem załadować pliku VMainMenu.fxml odpowiadającego za wygląd okienek! Problem IO.");
            exception.printStackTrace();
            System.exit(1);
        }
    }
}
