package com.example.se_opdracht.Controllers;

import com.example.se_opdracht.ErrorMessages.ErrorWarnings;
import com.example.se_opdracht.Main;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.kordamp.ikonli.javafx.FontIcon;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static com.example.se_opdracht.Controllers.ScreenLoader.getScreen;

public class SidebarController implements Initializable {
    @FXML
    private AnchorPane ButtonSideBar,TopBar,MainAnchor;
    @FXML
    private AnchorPane CurrentScreen = new AnchorPane();
    @FXML
    private BorderPane ScreenStage;
    @FXML
    private FontIcon MenuIcon,MenuIconClose,Crossmark,HomeIconFont,MinimizeIcon,PriceTrackingIcon,SizeRestore,TransactionIcon,CloseApplicationIcon;

    @FXML
    private Button Close,HomeButton,ProductsButton,SettingsButton,TransactionsButton;
    /*<---------------------Screensize--------------------->*/
    private boolean maximized = false;
    private boolean fullscreen = false;
    @FXML
    void MinimizeClicked(MouseEvent event) {
        Stage stage = (Stage) MinimizeIcon.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    void SizeRestoreClicked(MouseEvent event) {
        if (maximized){
            setScreenSmall(Main.genericstage);
            maximized = false;
        }else {
            setScreenLarge(Main.genericstage);
            maximized = true;
        }
    }
    @FXML
    public void fullScreen(KeyEvent event){
        if (event.getCode().equals(KeyCode.F11)){
            if (fullscreen){
                fullscreen = false;
                if (maximized){
                    Main.genericstage.setMaximized(false);
                    setScreenLarge(Main.genericstage);
                }else{
                    Main.genericstage.setMaximized(false);
                    setScreenSmall(Main.genericstage);
                }
            }else{
                Main.genericstage.setMaximized(true);
                fullscreen = true;

            }


        }
    }



    private void setScreenSmall(Stage stage){
        stage.setWidth(1000);
        stage.setHeight(650);
        stage.centerOnScreen();
        maximized = false;
    }

    private void setScreenLarge(Stage stage){
        Rectangle2D primaryScreenBounds = javafx.stage.Screen.getPrimary().getVisualBounds();
        stage.setX(primaryScreenBounds.getMinX());
        stage.setY(primaryScreenBounds.getMinY());
        stage.setWidth(primaryScreenBounds.getWidth());
        stage.setHeight(primaryScreenBounds.getHeight());
        maximized = true;
    }

    /*<---------------------Screenloading--------------------->*/

    @FXML
    void onHomeButtonClick(ActionEvent event) {
        File directory = new File("./");
        System.out.println(directory.getAbsolutePath());
        slideSidebarIn();

    }
    public void onProductsButtonClick(ActionEvent event) throws IOException {
        loadScreen(CurrentScreen = getScreen("Screens/TimelineProductsScreen.fxml"));
    }

    @FXML
    void onSettingsButtonClick(ActionEvent event) {
     loadScreen(CurrentScreen = getScreen("Screens/SettingsScreen.fxml"));
    }

    public void onTransactionsButtonClick(ActionEvent event) {
        loadScreen(CurrentScreen = getScreen("Screens/TransactionScreen.fxml"));
    }

    public void onCloseButtonClick(ActionEvent actionEvent) {
        try {
            ErrorWarnings.logoutConfirm();
        } catch (Exception e) {
            ErrorWarnings.unableToCloseApplication();
        }
    }

    public void onCloseImageClick(MouseEvent mouseEvent) {
        javafx.application.Platform.exit();
    }

    private void loadScreen(AnchorPane screen){
        ScreenStage.setCenter(screen);
        slideSidebarIn();
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        CurrentScreen.setTranslateX(-100);
        ButtonSideBar.setTranslateX(-200);
        MenuIconClose.setVisible(false);

        System.out.println();


    }

    double x = 0;
    double y = 0;
    public void TopBar_pressed(MouseEvent mouseEvent) {
        x = mouseEvent.getSceneX();
        y = mouseEvent.getSceneY();

    }

    public void TopBar_dragged(MouseEvent mouseEvent) {
        Stage stage = (Stage) TopBar.getScene().getWindow();
        stage.setY(mouseEvent.getScreenY()-y);
        stage.setX(mouseEvent.getScreenX()-x);
    }

    public void onMenuClicked(MouseEvent mouseEvent) {
    slideSidebarOut();
    }

    public void onMenuCloseClicked(MouseEvent mouseEvent) {
        slideSidebarIn();
    }

    private void slideSidebarOut(){
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.4));
        slide.setNode(ButtonSideBar);
        slide.setToX(0);
        slide.play();
        ButtonSideBar.setTranslateX(-200);
        slide.setOnFinished(event -> {
            System.out.println("The sidebar should have opened now!");
            MenuIcon.setVisible(false);
            MenuIconClose.setVisible(true);
        });
    }

    private void slideSidebarIn(){
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.4));
        slide.setNode(ButtonSideBar);
        slide.setToX(-200);
        slide.play();
        ButtonSideBar.setTranslateX(0);
        slide.setOnFinished(event -> {
            System.out.println("The sidebar should have closed now!");
            MenuIcon.setVisible(true);
            MenuIconClose.setVisible(false);
        });
    }

}