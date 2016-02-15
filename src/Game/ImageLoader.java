package Game;

import GlobalClasses.ErrorAlert;
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

    private ArrayList<File> background_photos = new ArrayList<>();
    private ArrayList<File> buttons_photos = new ArrayList<>();


    public ImageLoader() {
        readPhotosFromDirectory("background_photos", background_photos);
        System.out.println("Wczytano zdjęć tła: " + background_photos.size());
        readPhotosFromDirectory("button_photos", buttons_photos);
        System.out.println("Wczytano zdjęć buttonów: " + buttons_photos.size());

        if( background_photos.size() < MIN_BACKGROUND_PHOTOS || buttons_photos.size() < MIN_BUTTONS_PHOTOS) {
            new ErrorAlert().errorOccurs("Za mało zdjęć by móc stworzyć rozgrywkę! Dograj zdjęcia");
            System.err.println("Za mało zdjęć by móc stworzyć rozgrywkę! Dograj zdjęcia");
            System.exit(1);
        }
    }

    private void readPhotosFromDirectory(String dirPath, ArrayList whereToStore) {
        File directory = new File(PHOTOS_LOCALIZATION + dirPath);

        System.out.println("Katalog wczytywanych zdjęć: " + directory.getAbsolutePath());

        if( directory.isDirectory()) {
            try {
                for (File f : directory.listFiles()) {
                    whereToStore.add(f);
                }
            } catch (Exception e) {
                new ErrorAlert().errorOccurs("Nie mogłem wczytać zdjęć z wczytanego już katalogu zdjęć :( (dotyczy to zdjęć buttonów do gry)");
                System.err.println("Nie mogłem wczytać zdjęć z wczytanego już katalogu zdjęć :(");
                System.exit(1);
            }
        }
        else {
            new ErrorAlert().errorOccurs("Nie mogłem wczytać zdjęć do gry, nie widzę katalogu przechowującego te zdjecia (może mają inną nazwę niż trzeba) :(");
            System.err.println("Nie mogłem wczytać zdjęć :(");
            System.exit(1);
        }

    }

    public Image randomButtonPhoto() {
        int randed = rnd.nextInt(buttons_photos.size());
        String photoPath = buttons_photos.get(randed).toURI().toString();
        Image result = new Image(photoPath);
        buttons_photos.remove(randed);


        return result;
    }

    public File randomBackgroundPhoto() {
        int randed = rnd.nextInt(background_photos.size());
        File result = background_photos.get(randed);
        background_photos.remove(randed);

        return result;
    }
}
