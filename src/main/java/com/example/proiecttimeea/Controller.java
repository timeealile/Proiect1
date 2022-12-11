package com.example.proiecttimeea;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Controller {

    @FXML
    private Button submitButton;


    @FXML
    private TextField name;

    @FXML
    private PasswordField password;

    @FXML
    private Label wrongLogin;

    public void getData(ActionEvent actionEvent) throws IOException {
        HelloApplication main = new HelloApplication();
        if(name.getText().equals("angajat") || name.getText().equals("admin") && password.getText().equals("parola")){
            main.changeScene("after-login.fxml");
        }
        else if(name.getText().isEmpty() && password.getText().isEmpty()){
            wrongLogin.setText("Please enter data");
        }
        else {
            wrongLogin.setText("Wrong user or password");
        }
        System.out.println(name.getText());
        System.out.println(password.getText());
//        JavaPostgresSql
    }
}
