package MainMenu;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ProgramLauncher extends Application  {
    private static Stage mainWidnowHndl;
    @Override
    public void start(Stage primaryStage) throws Exception{
        mainWidnowHndl = primaryStage;

        Parent root = FXMLLoader.load(getClass().getResource("VMainMenu.fxml"));
        primaryStage.setTitle("cmok");
        primaryStage.setScene(new Scene(root, 1000, 800));

        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }

    static Stage getMainWindowHndl() { return mainWidnowHndl; }
}
