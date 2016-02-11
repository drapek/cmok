package GlobalClasses;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;

/**
 * Created by drapek on 2/11/16.
 */
public class ExitAlert {

    public void exitGameBtnClicled() {

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
}
