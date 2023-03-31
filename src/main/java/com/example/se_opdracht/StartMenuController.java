package com.example.se_opdracht;

import com.example.se_opdracht.ErrorMessages.ErrorWarnings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class StartMenuController extends GenericScreenController {
    TransactionScreenController Transaction = new TransactionScreenController();
    ErrorWarnings error = new ErrorWarnings();
    //Image Hamburger1 = new Image("Hamburger_Menu_Icon.png");


    @FXML
       private AnchorPane BlackScreen;

        @FXML
        private AnchorPane ButtonBar;

        @FXML
        private Button Close;

        @FXML
        private ImageView ExitIcon;

        @FXML
        private Button GraphsButton;

        @FXML
        private Button HomeButton;

        @FXML
        private ImageView HomeIcon;

        @FXML
        private AnchorPane MainScreen;

        @FXML
        private Button MenuButton;

        @FXML
        private ImageView MenuIcon;

        @FXML
        private ImageView MenuIconMaster ;



        @FXML
        private Button ProductsButton;

        @FXML
        private Button SettingsButton;

        @FXML
        private ImageView SettingsIcon;

        @FXML
        private AnchorPane SideBar;

        @FXML
        private AnchorPane StartMenu;

        @FXML
        private ImageView TimelineProductIcon;

        @FXML
        private AnchorPane TopBar;

        @FXML
        private ImageView TransactionIcon;

        @FXML
        private Button TransactionsButton;

        @FXML
        private Label WelcomeGuideMessage;

    @FXML
    private Label WelcomeMessage;


    private Stage stage;
    private Scene scene;
    private Parent root;






    public void onTransactionsButtonClick(ActionEvent actionEvent) throws IOException {
        //Switch scenes
        try {
            URL fxmlLocation = getClass().getResource("TransactionScreen.fxml");

            FXMLLoader loader = new FXMLLoader(fxmlLocation);
            root = loader.load();
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setMinHeight(650);
            stage.setMinWidth(1000);
            stage.show();
        } catch (Exception e) {
            //Removing the e.printStackTrace(); causes the sceneswitching to work for some reason? Needs looking into on a different date.
            //Sceneswtiching works if both controllers are in source package.
            error.unableToSwitchScene();
            e.printStackTrace();
        }

    }

    public void onGraphsButtonClick(ActionEvent actionEvent) {
    }

    public void onProductsButtonClick(ActionEvent actionEvent) {
        try {
            URL fxmlLocation = getClass().getResource("ProductsScreen.fxml");

            FXMLLoader loader = new FXMLLoader(fxmlLocation);
            root = loader.load();
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setMinHeight(650);
            stage.setMinWidth(1000);
            stage.show();
        } catch (Exception e) {
            //Removing the e.printStackTrace(); causes the sceneswitching to work for some reason? Needs looking into on a different date.
            //Sceneswtiching works if both controllers are in source package.
            error.unableToSwitchScene();
            e.printStackTrace();
        }
    }

    public void onCloseButtonClick(ActionEvent actionEvent) {
    try {
        error.logoutConfirm(StartMenu);
    } catch (Exception e) {
        error.unableToCloseApplication();
    }
    }

}