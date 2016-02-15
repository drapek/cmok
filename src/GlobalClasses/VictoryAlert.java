package GlobalClasses;

import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;

/**
 * Created by drapek on 2/13/16.
 */
public class VictoryAlert {
    public void gameWin() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Brawo!");
        alert.setHeaderText(null);
        alert.setContentText("Udało Ci się odsłonić wszystkie pola! Ty sprytna bestio :*");

        try {
            alert.setGraphic(new ImageView(this.getClass().getResource("/GlobalClasses/img/congrats.png").toString()));
        } catch (Exception e) {
            System.err.println("Can't find icon for congrats dialog which appear on wining game");
            e.printStackTrace();
        }

        alert.showAndWait();
    }
}
