package com.example.proiecttimeea;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Angajati implements Initializable {
    public List<Angajat> angajati = new ArrayList<Angajat>();
    @FXML
    public Label numeAngajat;
    @FXML
    public Label prenumeAngajat;
    @FXML
    public Label cnpAngajat;
    @FXML
    public Label emailAngajat;
    @FXML
    public Label dataNasteriiAngajat;
    @FXML
    public Label dataAngajariiAngajat;
    @FXML
    public Label salariuAngajat;
    private Database db = new Database();

    @FXML
    private ListView<String> listViewAngajati = new ListView<String>();

    @FXML
    private Button backAngajati;

    private ObservableList<String> items = FXCollections.observableArrayList (
            );

    public Angajati(){}

    public void getEmplooyes() {
        String sql = "SELECT * FROM angajat";
        Statement stmt;
        ResultSet res;
        try{
            Connection connection = db.connection();
            stmt = connection.createStatement();
            res = stmt.executeQuery(sql);

            while(res.next()) {
                System.out.println("HELLO33");
                Angajat angajat = new Angajat();
                angajat.setCnp(res.getBigDecimal("cnp"));
                angajat.setFirstname(res.getString("nume"));
                angajat.setLastname(res.getString("premune"));
                angajat.setEmail(res.getString("E-mail"));
                angajat.setHire_date(res.getDate("data_angajarii"));
                angajat.setSalary(res.getBigDecimal("salariu"));
                angajati.add(angajat);

                listViewAngajati.setPrefWidth(100);
                listViewAngajati.setPrefHeight(70);

                System.out.println("here");

                ObservableList<String> items = FXCollections.observableArrayList (
                        "Single", "Double", "Suite", "Family App");

                listViewAngajati.getItems().addAll(items);



            }
        }catch (Exception e) {

        }
    }

    public void printEmployees() {
        System.out.println(angajati.size());
        for(Angajat angajat : angajati) {
            System.out.println(angajat.getEmail());
        }
    }

    public void back() throws IOException {
        HelloApplication main = new HelloApplication();
            main.changeScene("DateUtilizator.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String sql = "SELECT * FROM angajat";
        Statement stmt;
        ResultSet res;
        int index = 0;
        try{
            Connection connection = db.connection();
            stmt = connection.createStatement();
            res = stmt.executeQuery(sql);

            while(res.next()) {
                System.out.println("HELLO33");
                Angajat angajat = new Angajat();
                angajat.setCnp(res.getBigDecimal("cnp"));
                angajat.setFirstname(res.getString("nume"));
                angajat.setLastname(res.getString("premune"));
                angajat.setEmail(res.getString("E-mail"));
                angajat.setHire_date(res.getDate("data_angajarii"));
                angajat.setSalary(res.getBigDecimal("salariu"));
                angajati.add(angajat);

                items.add(res.getString("nume") + " "+res.getString("premune"));

            }
            System.out.println("TEST");
            System.out.println(items);
            listViewAngajati.getItems().addAll(items);
            numeAngajat.setText(angajati.get(index).getFirstname());
            prenumeAngajat.setText(angajati.get(index).getLastname());
            cnpAngajat.setText(angajati.get(index).getCnp().toString());
            emailAngajat.setText(angajati.get(index).getEmail());
            dataAngajariiAngajat.setText(angajati.get(index).getHire_date().toString());
            salariuAngajat.setText(angajati.get(index).getSalary().toString());


            listViewAngajati.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                    System.out.println(listViewAngajati.getSelectionModel().getSelectedIndex());
                    Angajat angajat = angajati.get(listViewAngajati.getSelectionModel().getSelectedIndex());
                    numeAngajat.setText(angajat.getFirstname());
                    prenumeAngajat.setText(angajat.getLastname());
                    cnpAngajat.setText(angajat.getCnp().toString());
                    emailAngajat.setText(angajat.getEmail());
                    dataAngajariiAngajat.setText(angajat.getHire_date().toString());
                    salariuAngajat.setText(angajat.getSalary().toString());
                }
            });
        }catch (Exception e) {
            System.out.println("catch");
            System.out.println(e);
        }
    }
}
