package com.example.proiecttimeea;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class AfterLogin {
    @FXML
    public Button navStock;
    @FXML
    public Button navProduse;
    @FXML
    public Button navPreturi;
    @FXML
    private Button navAngajati;

    public void clickAngajat(ActionEvent e) throws IOException {
        Button button = (Button) e.getSource();
        String buttonText = button.getText();
        System.out.println(e.getSource());
        System.out.println("test");
        HelloApplication main = new HelloApplication();
        main.changeScene(buttonText+".fxml");
    }

    public void back() throws IOException{
        HelloApplication main = new HelloApplication();
        main.changeScene("hello-view"+".fxml");
    }
}
