module com.example.se_opdracht {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.h2database;


    opens com.example.se_opdracht to javafx.fxml;
    exports com.example.se_opdracht;
    //exports com.example.se_opdracht.graphs;
    //opens com.example.se_opdracht.graphs to javafx.fxml;
    exports com.example.se_opdracht.Controllers;
    opens com.example.se_opdracht.Controllers to javafx.fxml;
    exports com.example.se_opdracht.DBHandlers;
    opens com.example.se_opdracht.DBHandlers to javafx.fxml;
    exports com.example.se_opdracht.Products;
    opens com.example.se_opdracht.Products to javafx.fxml;
}