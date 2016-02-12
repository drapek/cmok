package Game;

import javafx.scene.control.Button;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by drapek on 2/12/16.
 */
public class GameModel {
    private int columns;
    private int rows;
    private ArrayList<ImageButton> buttonsWithoutImage = new ArrayList<>();
    private Random rnd = new Random();

    private ImageButton [][] imageButtons;

    public GameModel(int columns, int rows) {
        this.columns = columns;
        this.rows = rows;

        imageButtons = new ImageButton[columns][rows];
    }

    public void addButton( int column, int row, Button btn) {
        ImageButton tmp = new ImageButton();
        tmp.setBtn(btn);
        tmp.getBtn().setDisable(true); //switch of button because it hasn't image yet...
        tmp.setActive(false);

        buttonsWithoutImage.add(tmp);
        imageButtons[column][row] = tmp;

    }

    public void randImagesForButtons() {
        ImageLoader imgLoader = new ImageLoader();

        //it's rand a photo and assign it to two random buttons
        while ( buttonsWithoutImage.size() > 1) {
            Image randedImage = imgLoader.randomButtonPhoto();

            ImageButton btn1 = getImageButtonWithoutImage();
            ImageButton btn2 = getImageButtonWithoutImage();

            btn1.setImage(randedImage);
            btn2.setImage(randedImage);

            btn1.setActive(true);
            btn2.setActive(true);

        }

    }

    private ImageButton getImageButtonWithoutImage() {
        int randIndex = rnd.nextInt(buttonsWithoutImage.size());

        ImageButton result = buttonsWithoutImage.get(randIndex);
        buttonsWithoutImage.remove(randIndex);

        return result;
    }


}
