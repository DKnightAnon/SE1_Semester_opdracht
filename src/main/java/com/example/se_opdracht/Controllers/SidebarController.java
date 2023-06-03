package com.example.se_opdracht.Controllers;

import com.example.se_opdracht.Controllers.GenericScreenController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
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
    ArrayList<Button> buttonList = new ArrayList<Button>();
    @FXML
    void MinimizeClicked(MouseEvent event) {
        Stage stage = (Stage) MinimizeIcon.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    void SizeRestoreClicked(MouseEvent event) {

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