package com.example.proiecttimeea;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.io.IOException;

public class Mese {
    public Button backMese;
    public Button exitMese;

    public void onBack(ActionEvent actionEvent) throws IOException {
        HelloApplication main = new HelloApplication();
        main.changeScene("HelloAngajat.fxml");
    }

    public void onExit(ActionEvent actionEvent) throws IOException {
        HelloApplication main = new HelloApplication();
        main.changeScene("hello-view.fxml");
    }
}
