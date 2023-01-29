package com.example.proiecttimeea;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class Mese implements Initializable {
    @FXML
    public Button backMese;
    @FXML
    public Button exitMese;
    @FXML
    public ImageView imageViewMese;

    public void onBack(ActionEvent actionEvent) throws IOException {
        HelloApplication main = new HelloApplication();
        main.changeScene("HelloAngajat.fxml");
    }

    public void onExit(ActionEvent actionEvent) throws IOException {
        HelloApplication main = new HelloApplication();
        main.changeScene("hello-view.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            InputStream input = new FileInputStream("src/main/resources/assets/WhatsApp Image 2023-01-29 at 19.08.53.jpeg");
            Image image = new Image(input);
            imageViewMese.setImage(image);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
