package com.example.proiecttimeea;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Stock implements Initializable {
    public List<Produs> stock = new ArrayList<Produs>();
    private ObservableList<String> items = FXCollections.observableArrayList (
    );
    @FXML
    public ListView<String> listViewProduse = new ListView<String>();
    private Database db = new Database();

    @FXML
    public Button backProduse;
    @FXML
    public Text idNumeProdus;
    @FXML
    public Text idPret;
    @FXML
    public Text idCantitate;

    public void back() throws IOException {
        HelloApplication main = new HelloApplication();
        main.changeScene("DateUtilizator.fxml");
    }


    public void initialize(URL url, ResourceBundle resourceBundle) {
        String sql = "SELECT * FROM produse";
        Statement stmt;
        ResultSet res;
        int index = 0;
        try{
            Connection connection = db.connection();
            stmt = connection.createStatement();
            res = stmt.executeQuery(sql);

            while(res.next()) {
                Produs produs = new Produs();
                produs.setName(res.getString("produs"));
                produs.setPrice(res.getInt("pret"));
                produs.setCantitate(res.getInt("cantitate"));
                stock.add(produs);
                items.add(res.getString("produs"));

            }
            System.out.println("TEST");
            System.out.println(items);
            listViewProduse.getItems().addAll(items);
            idNumeProdus.setText(stock.get(index).getName());
            idCantitate.setText(String.valueOf(stock.get(index).getCantitate()));
            idPret.setText(String.valueOf(stock.get(index).getPrice()));



            listViewProduse.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                    Produs produs = stock.get(listViewProduse.getSelectionModel().getSelectedIndex());
                    idNumeProdus.setText(produs.getName());
                    idCantitate.setText(String.valueOf(produs.getCantitate()));
                    idPret.setText(String.valueOf(produs.getPrice()));
                }
            });
        }catch (Exception e) {
            System.out.println("catch");
            System.out.println(e);
        }
    }
}
