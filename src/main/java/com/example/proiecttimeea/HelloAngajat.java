package com.example.proiecttimeea;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.io.IOException;

public class HelloAngajat {
    public Button angajatMese;
    public Button angajatStock;

    public void goToStock(ActionEvent actionEvent) throws IOException {
        HelloApplication main = new HelloApplication();
        main.changeScene("Stock.fxml");
    }

    public void goToTables(ActionEvent actionEvent) throws IOException {
        HelloApplication main = new HelloApplication();
        main.changeScene("Mese.fxml");
    }

    public void goBack() throws IOException{
        HelloApplication main = new HelloApplication();
        main.changeScene("hello-view.fxml");
    }
}
