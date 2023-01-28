package com.example.proiecttimeea;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Controller {
    Database database = new Database();

    @FXML
    private Button submitButton;


    @FXML
    private TextField name;

    @FXML
    private PasswordField password;

    @FXML
    private Label wrongLogin;

    public void getData(ActionEvent actionEvent) throws IOException, SQLException {
        Connection connection = database.connection();
        HelloApplication main = new HelloApplication();
        if(name.getText().equals("angajat") || name.getText().equals("admin") && password.getText().equals("parola")){
            main.changeScene("DateUtilizator.fxml");
        }
        else if (name.getText().equals("angajat") || name.getText().equals("user") && password.getText().equals("parola")) {
            main.changeScene("DateUtilizator.fxml");
        }
        else if(name.getText().isEmpty() && password.getText().isEmpty()){
            wrongLogin.setText("Please enter data");
        }
        else {
            wrongLogin.setText("Wrong user or password");
        }

        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery("SELECT NOW()");
        System.out.println(name.getText());
        System.out.println(password.getText());
//        JavaPostgresSql
    }
}
