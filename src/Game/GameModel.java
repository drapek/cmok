package Game;

import GlobalClasses.GlobalDTO;
import javafx.event.Event;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
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
    private ImageView btnImageBackground;

    private boolean haveRemembBtn = false; //says if user already click another button witch whom we must compare new one
    private int prev_col = -1;
    private int prv_row = -1;

    private static ImageButton [][] imageButtons;

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
        tmp.getBtn().setGraphic(btnImageBackground);
        imageButtons[column][row] = tmp;

    }

    public void randImagesForButtons() {
        ImageLoader imgLoader = new ImageLoader();

        initBtnImageBackground();

        //it's rand a photo and assign it to two random buttons
        while ( buttonsWithoutImage.size() > 1) {
            Image randedImage = imgLoader.randomButtonPhoto();

            ImageButton btn1 = getImageButtonWithoutImage();
            ImageButton btn2 = getImageButtonWithoutImage();

            ImageView btn1ImgView = fitImageToButton(btn1.getBtn(), randedImage);
            ImageView btn2ImgView = fitImageToButton(btn2.getBtn(), randedImage);

            btn1.setImgView(btn1ImgView);
            btn2.setImgView(btn2ImgView);

            btn1.setImage(randedImage);
            btn2.setImage(randedImage);

            btn1.setActive(true);
            btn2.setActive(true);

            btn1.getBtn().setGraphic(btnImageBackground);
            btn2.getBtn().setGraphic(btnImageBackground);

        }


    }

    private void initBtnImageBackground() {
        try {
            File imageBckFile = new File("Game/img/card_front.jpg");
            Image bckgImg = new Image(imageBckFile.toURI().toString());
            btnImageBackground = new ImageView(bckgImg);
            btnImageBackground.setFitWidth(imageButtons[0][0].getBtn().getMinWidth() - 20);
            btnImageBackground.setFitHeight(imageButtons[0][0].getBtn().getMinHeight() - 10);

            if(GlobalDTO.DEBUG_MODE) {
                System.out.println("Scieżka zdjęcia tła buttonów: " + imageBckFile.getAbsoluteFile());
            }
        } catch (Exception e) {
            //TODO add alert here
            System.err.println("Nie mogłem wczytać obrazka odpowiedzialnego za tło kart!");
            System.exit(1);
        }

    }

    private ImageView fitImageToButton(Button btn, Image img) {
        ImageView imgView = new ImageView(img);
        imgView.setFitWidth(btn.getMinWidth() - 20);
        imgView.setFitHeight(btn.getMinHeight() - 10);

        if(GlobalDTO.DEBUG_MODE)
            System.out.println("Rozmiar zdjęcia w buttonie: " + imgView.getFitWidth() + ", " + imgView.getFitHeight());

        return imgView;
    }

    private ImageButton getImageButtonWithoutImage() {
        int randIndex = rnd.nextInt(buttonsWithoutImage.size());

        ImageButton result = buttonsWithoutImage.get(randIndex);
        buttonsWithoutImage.remove(randIndex);

        return result;
    }

    public void catchButtons(int btn_col, int btn_row) {
        ImageButton btn = imageButtons[btn_col][btn_row];
        showImageOfImageButton(btn_col, btn_row);

        if(haveRemembBtn) {
            haveRemembBtn = false;

            //TODO compare this buttons
            //TODO don't forget to wait and unflip buttons
            pause(1000);

            setDefaultBtnBackgr(imageButtons[prev_col][prv_row].getBtn());
            setDefaultBtnBackgr(btn.getBtn());

        }
        else {
            haveRemembBtn = true;
            prev_col = btn_col;
            prv_row = btn_row;
        }
    }

    private void setDefaultBtnBackgr(Button btn) {
        btn.setGraphic(null);
    }

    private void pause(long sleeptime) {
        try {
            Thread.sleep(sleeptime);
        } catch (InterruptedException ex) {
            //ToCatchOrNot
        }
    }

    public void showImageOfImageButton(int btn_col, int btn_row) {
        ImageButton btn = imageButtons[btn_col][btn_row];
        btn.getBtn().setGraphic(btn.getImgView());
    }

}
