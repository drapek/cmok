package Game;

import GlobalClasses.ExitAlert;
import GlobalClasses.GlobalDTO;
import MainMenu.ProgramLauncher;
import javafx.geometry.Dimension2D;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by drapek on 2/11/16.
 */
public class GameController implements Initializable {
    @FXML GridPane gridPaneImages;
    private GameModel gameModel; //TODO initize it

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        generateImageGridPane();
    }

    private void generateImageGridPane() {
        gridPaneImages.setGridLinesVisible(true);

        Dimension2D imageGridPaneDimension = GlobalDTO.getImageGridPaneDimension();
        int rows = (int) imageGridPaneDimension.getHeight();
        int columns = (int) imageGridPaneDimension.getWidth();
        gameModel = new GameModel(columns, rows);

        Dimension2D buttonSize = computeImageButtonSize(rows, columns);

        for( int i = 0; i < rows; i++ ) {
            for( int j = 0; j < columns; j++) {
                Button tmp = new Button("image HERE");
                tmp.setMinSize(buttonSize.getWidth(), buttonSize.getHeight());
                tmp.setStyle("-fx-background-image: url('/Game/img/card_front.jpg');");
                gridPaneImages.add( tmp , j, i);
                gameModel.addButton(j, i, tmp);
            }

        }

        gameModel.randImagesForButtons();

    }

    private Dimension2D computeImageButtonSize(int rows, int columns) {
        double btnHeight = gridPaneImages.getMinHeight() / rows ;
        double btnWidth = gridPaneImages.getMinWidth() / columns ;

        System.out.println("Obliczona wielkośc obrazaka to: " + btnWidth + ", " + btnHeight);
        return new Dimension2D(btnWidth, btnHeight);
    }

    @FXML private void exitGameBtnClicled() {
        new ExitAlert().exitGameBtnClicled();
    }

    @FXML private void backToMenuClicked() {
        new ProgramLauncher().drawMainScene();
    }
}
