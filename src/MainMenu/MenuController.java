package MainMenu;

import GlobalClasses.ExitAlert;
import GlobalClasses.GlobalDTO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {
    @FXML ImageView imgLogo;

    @FXML private void clickedGame4x4() {
        GlobalDTO.setImageGridPaneDimension(4, 4);
        prepareGameScene("cmok - 4x4");
    }

    @FXML private void clickedGame4x6() {
        GlobalDTO.setImageGridPaneDimension(4, 6);
        prepareGameScene("cmok - 4x6");

    }

    @FXML private void clickedGame6x6() {
        GlobalDTO.setImageGridPaneDimension(6, 6);
        prepareGameScene("cmok - 6x6");

    }

    private void prepareGameScene(String windowTitle) {
        Stage mainWindow = GlobalDTO.getMainWindowHandler();
        mainWindow.setTitle(windowTitle);

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/Game/game.fxml"));
            mainWindow.setScene(new Scene(root, 1000, 800));
            mainWindow.show();
        } catch (IOException exception) {
            System.err.println("Nie mogłem załadować pliku game.fxml odpowiadającego za wygląd okienek! Problem IO.");
            exception.printStackTrace();
            System.exit(1);
        }

    }

    @FXML private void exitGameBtnClicled() {

        new ExitAlert().exitGameBtnClicked();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        imgLogo.setImage(new Image("MainMenu/img/usta_logo_v2.png"));
    }
}
