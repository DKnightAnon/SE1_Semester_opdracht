package com.example.se_opdracht;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import org.kordamp.ikonli.javafx.FontIcon;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

public class SidebarController extends GenericScreenController implements Initializable {
    @FXML
    private AnchorPane ButtonSideBar,Screen,TopBar;
    @FXML
    private AnchorPane CurrentScreen = new AnchorPane();
    @FXML
    private BorderPane ScreenStage;
    @FXML
    private FontIcon MenuIcon,MenuIconClose,Crossmark,HomeIconFont,MinimizeIcon,PriceTrackingIcon,SizeRestore,TransactionIcon,CloseApplicationIcon;

    @FXML
    private Button Close,HomeButton,ProductsButton,SettingsButton,TransactionsButton;
    @FXML
    void MinimizeClicked(MouseEvent event) {

    }

    @FXML
    void SizeRestoreClicked(MouseEvent event) {

    }


    @FXML
    void onHomeButtonClick(ActionEvent event) {

    }
    @Override
    public void onProductsButtonClick(ActionEvent event) {

    }

    @FXML
    void onSettingsButtonClick(ActionEvent event) {

    }

    @Override
    public void onTransactionsButtonClick(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        CurrentScreen = getScreen("Screens/TransactionScreen.fxml");
        ScreenStage.setCenter(CurrentScreen);
    }

    private AnchorPane getScreen(String Filename){
        try{
            URL fxmlLocation = getClass().getResource(Filename);
            if (fxmlLocation == null){
                throw new FileNotFoundException("FXML file cannot be found!");
            }
            Screen = new FXMLLoader().load(fxmlLocation);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return Screen;

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        CurrentScreen.setTranslateX(-100);


        ButtonSideBar.setTranslateX(-200);
        MenuIconClose.setVisible(false);
    }
}