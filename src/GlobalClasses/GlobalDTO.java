package GlobalClasses;

import com.sun.javafx.css.Size;
import javafx.geometry.Dimension2D;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Created by drapek on 2/11/16.
 */
public class GlobalDTO {
    public final static boolean DEBUG_MODE = true;
    static private Stage mainWindowHandler;
    static private Dimension2D imageGridPaneDimension;
    public static final String imageBtnCardBackground = "";// "-fx-background-image: url('/Game/img/card_front.jpg');";

    static public Stage getMainWindowHandler() {
        return mainWindowHandler;
    }

    static public void setMainWindowHandler(Stage mainWindowHandler) {
        GlobalDTO.mainWindowHandler = mainWindowHandler;
    }


    public static Dimension2D getImageGridPaneDimension() {
        return imageGridPaneDimension;
    }

    public static void setImageGridPaneDimension(int width, int height) {
        GlobalDTO.imageGridPaneDimension = new Dimension2D(width, height);
    }

}
