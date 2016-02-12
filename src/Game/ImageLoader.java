package Game;

import javafx.scene.image.Image;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by drapek on 2/12/16.
 */
public class ImageLoader {
    private static final String PHOTOS_LOCALIZATION = "external_images/";
    Random rnd = new Random();
    private static final int MIN_BACKGROUND_PHOTOS = 3;
    private static final int MIN_BUTTONS_PHOTOS = 36;

    private ArrayList<Image> background_photos = new ArrayList<>();
    private ArrayList<Image> buttons_photos = new ArrayList<>();


    public ImageLoader() {
        readPhotosFromDirectory("background_photos", background_photos);
        readPhotosFromDirectory("button_photos", buttons_photos);

        if( background_photos.size() < MIN_BACKGROUND_PHOTOS || buttons_photos.size() < MIN_BUTTONS_PHOTOS) {
            //TODO alert about not enought pohots!
            System.err.println("Za mało zdjęć by móc stworzyć rozgrywkę! Dograj zdjęcia");
            System.exit(1);
        }
    }

    private void readPhotosFromDirectory(String dirPath, ArrayList<Image> whereToStore) {
        File directory = new File(PHOTOS_LOCALIZATION + dirPath);

        System.out.println("Katalog wczytywanych zdjęć: " + directory.getAbsolutePath());

        if( directory.isDirectory()) {
            try {
                for (File f : directory.listFiles()) {
                    String imagePath = f.toURI().toString();
                    Image tmp = new Image(imagePath);

                    whereToStore.add(tmp);
                    System.out.println("Wczytano zdjęcie: " + imagePath);

                }
            } catch (Exception e) {
                System.err.println("Nie mogłem wczytać zdjęć z wczytanego już katalogu zdjęć :(");
                //TODO add alert
            }
        }
        else {
            //TODO alert about problem with reading images!
            System.err.println("Nie mogłem wczytać zdjęć :(");
        }

    }

    public Image randomButtonPhoto() {
        int randed = rnd.nextInt(buttons_photos.size());
        Image result = buttons_photos.get(randed);
        buttons_photos.remove(randed);

        return result;
    }

    public Image randomBackgroundPhoto() {
        int randed = rnd.nextInt(background_photos.size());
        Image result = background_photos.get(randed);
        background_photos.remove(randed);

        return result;
    }
}
