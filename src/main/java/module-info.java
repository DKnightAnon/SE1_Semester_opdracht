module com.example.se_opdracht {
    requires com.h2database;
    requires javafx.base;
    requires javafx.graphics;
    requires javafx.controls;
    requires org.kordamp.ikonli.core;
    requires org.kordamp.ikonli.javafx;

    // add icon pack modules
    requires org.kordamp.ikonli.fontawesome5;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.se_opdracht to javafx.fxml;
    exports com.example.se_opdracht;
    exports com.example.se_opdracht.Controllers;
    opens com.example.se_opdracht.Controllers to javafx.fxml;
    exports com.example.se_opdracht.DBHandlers;
    opens com.example.se_opdracht.DBHandlers to javafx.fxml;
    exports com.example.se_opdracht.Products;
    opens com.example.se_opdracht.Products to javafx.fxml;
    exports com.example.se_opdracht.Products.Transaction;
    opens com.example.se_opdracht.Products.Transaction to javafx.fxml;
    exports com.example.se_opdracht.Products.Timeline;
    opens com.example.se_opdracht.Products.Timeline to javafx.fxml;

}