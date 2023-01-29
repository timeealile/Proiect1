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
import java.util.Objects;

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
        String sql = "SELECT * FROM `users` WHERE user='"+name.getText()+"' AND parola='"+password.getText()+"'";
        System.out.println(sql);
        Statement stmt;
        ResultSet res;
        try{
            stmt = connection.createStatement();
            res = stmt.executeQuery(sql);
            System.out.println(res);
            while (res.next()){
                if(Objects.equals(res.getString("rol"), "admin")){
                    main.changeScene("DateUtilizator.fxml");
                }
                else if(Objects.equals(res.getString("rol"), "angajat")){
                    main.changeScene("DateUtilizator.fxml");
                }
                else if(name.getText().isEmpty() && password.getText().isEmpty()){
            wrongLogin.setText("Please enter data");
        }
        else {
            wrongLogin.setText("Wrong user or password");
        }

            }
        }
        catch (Exception e){
            System.out.println(e);}


    }
}
