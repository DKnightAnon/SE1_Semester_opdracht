module com.example.se_opdracht {
    requires javafx.base;
    requires javafx.graphics;
    requires javafx.controls;
    requires org.kordamp.ikonli.core;
    requires org.kordamp.ikonli.javafx;

    // add icon pack modules
    requires org.kordamp.ikonli.fontawesome5;
    requires javafx.fxml;
    requires java.sql;
    requires org.controlsfx.controls;

    requires com.h2database;

    opens com.example.se_opdracht to javafx.fxml;
    exports com.example.se_opdracht;
    exports com.example.se_opdracht.Controllers;
    opens com.example.se_opdracht.Controllers to javafx.fxml;
    exports com.example.se_opdracht.DBHandlers;
    opens com.example.se_opdracht.DBHandlers to javafx.fxml;
    exports com.example.se_opdracht.ProductMaker.Products;
    opens com.example.se_opdracht.ProductMaker.Products to javafx.fxml;
    exports com.example.se_opdracht.InputCheckers;
    opens com.example.se_opdracht.InputCheckers to javafx.fxml;

}