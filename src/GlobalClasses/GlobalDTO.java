package GlobalClasses;

import com.sun.javafx.css.Size;
import com.sun.javafx.geom.Dimension2D;
import javafx.stage.Stage;

/**
 * Created by drapek on 2/11/16.
 */
public class GlobalDTO {
    static private Stage mainWindowHandler;
    static private Dimension2D imageGridPaneDimension;

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
