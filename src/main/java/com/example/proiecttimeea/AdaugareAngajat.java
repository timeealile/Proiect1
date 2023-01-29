package com.example.proiecttimeea;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

public class AdaugareAngajat {
    public TextField textfieldNume;
    public TextField textfieldPrenume;
    public TextField textfieldEmail;
    public TextField textfieldCNP;
    public TextField textfieldSalar;
    public DatePicker datepicker;
    public Button confirm;
    public Button cancel;

    private Database db = new Database();


    public void confirm(ActionEvent actionEvent) throws IOException {
        String sql = "INSERT INTO `angajat`(`CNP`, `nume`, `premune`, `E-mail`, `data_angajarii`, `Salariu`) " +
                "VALUES ('"+textfieldCNP.getText()+"','"+textfieldNume.getText()+"','"+textfieldPrenume.getText()+"'," +
                "'"+textfieldEmail.getText()+"','"+datepicker.getValue()+"','"+textfieldSalar.getText()+"')";
        System.out.println(sql);
        Statement stmt;
        int res;
        try{
//            System.out.println(this.id);
            Connection connection = db.connection();
            stmt = connection.createStatement();
            res = stmt.executeUpdate(sql);
            backToAngajati();


        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public void backToAngajati() throws IOException {
        HelloApplication main = new HelloApplication();
        main.changeScene("Angajati.fxml");
    }
}
