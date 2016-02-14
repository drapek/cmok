package Game;

import GlobalClasses.ExitAlert;
import GlobalClasses.GlobalDTO;
import MainMenu.ProgramLauncher;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Dimension2D;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by drapek on 2/11/16.
 */
public class GameController implements Initializable {
    @FXML GridPane gridPaneImages;
    private GameModel gameModel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        generateImageGridPane();
    }

    private void generateImageGridPane() {
        gridPaneImages.setGridLinesVisible(false);

        Dimension2D imageGridPaneDimension = GlobalDTO.getImageGridPaneDimension();
        int rows = (int) imageGridPaneDimension.getHeight();
        int columns = (int) imageGridPaneDimension.getWidth();
        gameModel = new GameModel(columns, rows);

        Dimension2D buttonSize = computeImageButtonSize(rows, columns);

        for( int i = 0; i < rows; i++ ) {
            for( int j = 0; j < columns; j++) {
                Button tmp = new Button();
                tmp.setMinSize(buttonSize.getWidth(), buttonSize.getHeight());
                tmp.setStyle(GlobalDTO.imageBtnCardBackground);
                tmp.setOnAction(new ButtonHandler(j, i));
                tmp.getStyleClass().addAll("button-img");
                gridPaneImages.add( tmp , j, i);
                gameModel.addButton(j, i, tmp);
            }

        }

        gameModel.randImagesForButtons();
        gameModel.randGridPaneBackground(gridPaneImages);

    }

    private Dimension2D computeImageButtonSize(int rows, int columns) {
        double btnHeight = gridPaneImages.getMinHeight() / rows ;
        double btnWidth = gridPaneImages.getMinWidth() / columns ;
        if( GlobalDTO.DEBUG_MODE)
            System.out.println("Obliczona wielkośc obrazaka to: " + btnWidth + ", " + btnHeight);
        return new Dimension2D(btnWidth, btnHeight);
    }


    @FXML private void exitGameBtnClicled() {
        new ExitAlert().exitGameBtnClicked();
    }

    @FXML private void backToMenuClicked() {
        new ProgramLauncher().drawMainScene();
    }

    private class ButtonHandler implements EventHandler{
        int row_pos;
        int col_pos;

        public ButtonHandler(int col_pos, int row_pos) {
            this.row_pos = row_pos;
            this.col_pos = col_pos;
        }

        @Override
        public void handle(Event event) {
            if(GlobalDTO.DEBUG_MODE)
                System.out.println("Kliknięto przycisk " + col_pos + ", " + row_pos);
            gameModel.catchButtons(col_pos, row_pos);


        }
    }



}
