package com.example.se_opdracht;

import com.example.se_opdracht.ErrorMessages.ErrorWarnings;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.kordamp.ikonli.javafx.FontIcon;

import java.io.*;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class StartMenuController extends GenericScreenController implements Initializable{
    TransactionScreenController Transaction = new TransactionScreenController();
    @FXML
       private AnchorPane BlackScreen;

        @FXML
        private AnchorPane ButtonSideBar;

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
        private ImageView MenuIconClose;

        @FXML
        private ImageView AppIconView;



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
        AnchorPane ScreenName = StartMenu;

        @FXML
        private ImageView TimelineProductIcon;

        @FXML
        private ImageView TransactionIcon;

        @FXML
        private Button TransactionsButton;
        @FXML
        private ImageView Crossmark;

        @FXML
        private Label WelcomeGuideMessage;

    @FXML
    private Label WelcomeMessage;


    @FXML
    private Label testlabelIcon;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public StartMenuController() throws FileNotFoundException {
    }


    public void onTransactionsButtonClick(ActionEvent actionEvent) throws IOException {
        //Switch scenes
        try {
            URL fxmlLocation = getClass().getResource("TransactionProductsScreen.fxml");

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
            URL fxmlLocation = getClass().getResource("TimelineProductsScreen.fxml");

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

    public void setImageViewIcons(){
        AppIconView.setImage(AppIcon);
        MenuIcon.setImage(BurgerMenuIcon);
        MenuIconClose.setImage(BurgerMenuIcon);
        SettingsIcon.setImage(Settings);
        ExitIcon.setImage(exitIcon);
        Crossmark.setImage(CrossmarkSmall);
        //HomeIcon.setImage(Home);
        TransactionIcon.setImage(BudgetTransactionProductIcon);
        TimelineProductIcon.setImage(Timeline);
        ImageView MenuIconView = new ImageView(String.valueOf(getClass().getResource("images/HamburgerMenuIcon.png")));
        //MenuIconView.setFitHeight(35); MenuIconView.setFitWidth(35);
        MenuIconView.fitWidthProperty().bind(MenuButton.widthProperty().divide(10)); MenuIconView.setPreserveRatio(true);

        MenuButton.setGraphic(MenuIconView);

    }

    public void loadButtonStyle(){
       loadButtonStyleDarkMode();
    }

    private void loadButtonStyleDarkMode(){
        MenuButton.setId(darkmodeID);
            MenuButton.setMaxWidth(200);
        GraphsButton.setId(darkmodeID);
            GraphsButton.setMaxWidth(200);
        HomeButton.setId(darkmodeID);
            HomeButton.setMaxWidth(200);
        ProductsButton.setId(darkmodeID);
            ProductsButton.setMaxWidth(200);
        TransactionsButton.setId(darkmodeID);
            TransactionsButton.setMaxWidth(200);
        SettingsButton.setId(darkmodeID);
            SettingsButton.setMaxWidth(200);
        Close.setId(darkmodeID);
            Close.setMaxWidth(200);
    }





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setImageViewIcons();
        loadButtonStyle();
        ButtonSideBar.setTranslateX(-200);
        MenuIconClose.setVisible(false);



    }

    public void onMenuClicked(MouseEvent mouseEvent) {
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

    public void onMenuCloseClicked(MouseEvent mouseEvent) {
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

    @FXML
    private FontIcon testIcon;

    @FXML
    private Button testButton1;
    public void Test1Click(ActionEvent event) {
        testIcon.setIconColor(Color.YELLOW);

    }

    @FXML
    private Button testButton2;
    public void Test2Click(ActionEvent event) {
        testIcon.setIconColor(Color.STEELBLUE);

    }
}