package GlobalClasses;

import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;

/**
 * Created by drapek on 2/13/16.
 */
public class ErrorAlert {
    public void errorOccurs(String errMessage) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Buuuu! Coś poszło nie tak");
        alert.setHeaderText(null);
        alert.setContentText("Z przyczyn wewnętrznych nie można uruchomić programu :( Przekaż Pawłowi poniższą informacje: \n" +
         errMessage);

        try {
            alert.setGraphic(new ImageView(this.getClass().getResource("./img/sad_cat.jpg").toString()));
        } catch (Exception e) {
            System.err.println("Can't find icon for congrats dialog which appear on wining game");
            e.printStackTrace();
        }

        alert.showAndWait();
    }
}
