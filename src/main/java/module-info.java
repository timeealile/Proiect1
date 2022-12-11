module com.example.proiecttimeea {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.proiecttimeea to javafx.fxml;
    exports com.example.proiecttimeea;
}