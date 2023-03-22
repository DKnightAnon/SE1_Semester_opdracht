module com.example.se_opdracht {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.se_opdracht to javafx.fxml;
    exports com.example.se_opdracht;
    exports com.example.se_opdracht.graphs;
    opens com.example.se_opdracht.graphs to javafx.fxml;
}