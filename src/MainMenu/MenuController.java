package MainMenu;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {
    @FXML ImageView imgLogo;

    @FXML private void clickedGame4x4() {
        prepareGameScene("cmok - 4x4");
    }

    @FXML private void clickedGame4x6() {
        prepareGameScene("cmok - 4x6");
    }

    @FXML private void clickedGame6x6() {
        prepareGameScene("cmok - 6x6");
    }

    private void prepareGameScene(String windowTitle) {
        Stage mainWindow = ProgramLauncher.getMainWindowHndl();
        mainWindow.setTitle(windowTitle);

        try {
            Parent root = FXMLLoader.load(getClass().getResource("../Game/game.fxml"));
            mainWindow.setScene(new Scene(root, 1000, 800));
            mainWindow.show();
        } catch (IOException exception) {
            System.err.println("Nie mogłem załadować pliku game.fxml odpowiadającego za wygląd okienek! Problem IO.");
            exception.printStackTrace();
            System.exit(1);
        }

    }

    @FXML private void exitGameBtnClicled() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Pożegnanie :(");
        alert.setHeaderText(null);
        alert.setContentText("Dziękuje za granie kochanie :*");

        try {
            alert.setGraphic(new ImageView(this.getClass().getResource("./img/farewell_logo_on_exit.png").toString()));
        } catch (Exception e) {
            System.err.println("Can't find icon for farewell dialog which appear on exiting game");
            e.printStackTrace();
        }

        alert.showAndWait();

        System.exit(0);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        imgLogo.setImage(new Image("MainMenu/img/usta_logo.png"));
    }
}
