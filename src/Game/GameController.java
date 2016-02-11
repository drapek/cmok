package Game;

import GlobalClasses.ExitAlert;
import GlobalClasses.GlobalDTO;
import MainMenu.ProgramLauncher;
import com.sun.javafx.geom.Dimension2D;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import sun.security.action.GetLongAction;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by drapek on 2/11/16.
 */
public class GameController implements Initializable {
    @FXML GridPane gridPaneImages;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        generateImageGridPane();
    }

    private void generateImageGridPane() {
        gridPaneImages.setGridLinesVisible(true);

        Dimension2D imgGridPaneDimentions = GlobalDTO.getImageGridPaneDimension();
        int rows = (int) imgGridPaneDimentions.height;
        int columns = (int) imgGridPaneDimentions.width;


        for( int i = 0; i < rows; i++ ) {
            for( int j = 0; j < columns; j++) {
                Button tmp = new Button("tmp1");
                gridPaneImages.add( tmp , j, i);
            }

        }
    }

    @FXML private void exitGameBtnClicled() {
        new ExitAlert().exitGameBtnClicled();
    }

    @FXML private void backToMenuClicked() {
        new ProgramLauncher().drawMainScene();
    }
}
