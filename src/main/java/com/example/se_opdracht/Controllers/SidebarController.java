package com.example.se_opdracht.Controllers;

import com.example.se_opdracht.Controllers.GenericScreenController;
import com.example.se_opdracht.Main;
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
import org.kordamp.ikonli.javafx.FontIcon;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SidebarController extends GenericScreenController implements Initializable {
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

    private boolean maximized = false;
    private boolean fullscreen = false;
    @FXML
    void MinimizeClicked(MouseEvent event) {
        Stage stage = (Stage) MinimizeIcon.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    void SizeRestoreClicked(MouseEvent event) {

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

    /*<---------------------Screensize--------------------->*/

    private void setScreenSmall(Stage stage){
        stage.setWidth(800);
        stage.setHeight(600);
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

    @FXML
    void onHomeButtonClick(ActionEvent event) {
        File directory = new File("./");
        System.out.println(directory.getAbsolutePath());
    }
    @Override
    public void onProductsButtonClick(ActionEvent event) throws IOException {
//        File currentDirFile = new File(".");
//        String helper = currentDirFile.getAbsolutePath();
//        String currentDir = helper.substring(0, helper.length() - currentDirFile.getCanonicalPath().length());//this line may need a try-catch block
//        System.out.println(currentDir);
        FXMLLoader loader = new FXMLLoader();
        CurrentScreen = getScreen("Screens/TimelineProductsScreen.fxml");
        ScreenStage.setCenter(CurrentScreen);
    }

    @FXML
    void onSettingsButtonClick(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        CurrentScreen = getScreen("Screens/SettingsScreen.fxml");
        ScreenStage.setCenter(CurrentScreen);

    }

    @Override
    public void onTransactionsButtonClick(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();

        CurrentScreen = getScreen("Screens/TransactionScreen.fxml");
        ScreenStage.setCenter(CurrentScreen);
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        CurrentScreen.setTranslateX(-100);


        ButtonSideBar.setTranslateX(-200);
        MenuIconClose.setVisible(false);

        ScreenName = MainAnchor;
        System.out.println();
        setDarkMode(true);
        setScreenTheme();

    }
}