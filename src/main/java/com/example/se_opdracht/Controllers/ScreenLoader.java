package com.example.se_opdracht.Controllers;

import com.example.se_opdracht.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.FileNotFoundException;
import java.net.URL;

public class ScreenLoader {

    public static AnchorPane getScreen(String Filename){
        AnchorPane Screen;
        try{
            URL fxmlLocation = Main.class.getResource(Filename);
            if (fxmlLocation == null){
                throw new FileNotFoundException("FXML file cannot be found!");
            }
            Screen = new FXMLLoader().load(fxmlLocation);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return Screen;

    }
}
