module com.example.se_opdracht {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.se_opdracht to javafx.fxml;
    exports com.example.se_opdracht;
}