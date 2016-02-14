package Game;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by drapek on 2/12/16.
 */
public class ImageButton {
    private Button btn;
    private Image image;
    private ImageView imgView;
    private int nmbOfClicks = 0;
    private boolean active;

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
        this.getBtn().setDisable(!active);
    }

    public int getNmbOfClicks() {
        return nmbOfClicks;
    }

    public void buttonClickedCounter() {
        nmbOfClicks++;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public ImageView getImgView() {
        return imgView;
    }

    public void setImgView(ImageView imgView) {
        this.imgView = imgView;
    }
}
