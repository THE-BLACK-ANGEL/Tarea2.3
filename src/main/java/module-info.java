module com.example.terea2_3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;


    opens com.example.terea2_3 to javafx.fxml;
    exports com.example.terea2_3;
}