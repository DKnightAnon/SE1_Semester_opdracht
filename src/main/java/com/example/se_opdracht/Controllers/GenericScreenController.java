package com.example.se_opdracht.Controllers;

import com.example.se_opdracht.DBHandlers.TransactionDBHandler;
import com.example.se_opdracht.ErrorMessages.ErrorWarnings;
import com.example.se_opdracht.Main;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import org.kordamp.ikonli.javafx.FontIcon;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public abstract class GenericScreenController {
    String darkmodeID = "generalmenubutton-darkmode";
    String darkmodeIDIcons = "#generalicon-darkmode";



    private Parent root;
    private Stage stage;
    private Scene scene;
    @FXML
    private AnchorPane TopBar,ButtonSideBar,Screen,CurrentScreen;
    public static AnchorPane ScreenName;

    @FXML
    private Button ReturnButton,MenuButton,HomeButton;

    @FXML
    private FontIcon MenuIcon,MenuIconClose;
    ErrorWarnings error = new ErrorWarnings();
    private Boolean darkMode;
    TransactionDBHandler tdbh = new TransactionDBHandler();


    public Boolean getDarkMode() {
        return darkMode;
    }

    public void setDarkMode(Boolean darkMode) {
        this.darkMode = darkMode;
    }

    public Boolean isDatePickerEmpty(DatePicker datePicker) {
        if (datePicker.getValue() != null) {
            return false;
        } else {
            return true;
        }
    }

    public Boolean isTextFieldEmpty(TextField textfield) {
        if (textfield.getText().isEmpty()) {
            return true;
        }else {
            return false;
        }
    }

    public void OnReturnButtonClicked(ActionEvent actionEvent) {
            try {
                URL fxmlLocation = getClass().getResource("Controllers/StartMenu.fxml");

                FXMLLoader loader = new FXMLLoader(fxmlLocation);
                root = loader.load();
                stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                scene = new Scene(root);
                scene.getStylesheets().addAll(getClass().getResource("CSS_Files/DarkMode.css").toExternalForm());
                stage.setScene(scene);
                stage.setMinHeight(650);
                stage.setMinWidth(1000);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
                error.unableToSwitchScene();
            }
    }


    @FXML
    void onSettingsButtonClick(ActionEvent event) {

    }
    @FXML
    void onHomeButtonClick(ActionEvent event) {

    }

    @FXML
    void onMenuButtonClick(ActionEvent event) {

    }

    public void onTransactionsButtonClick(ActionEvent actionEvent) throws IOException {
        //Switch scenes
        try {
            URL fxmlLocation = getClass().getResource("TransactionProductsScreen.fxml");

            FXMLLoader loader = new FXMLLoader(fxmlLocation);
            root = loader.load();
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            scene.getStylesheets().addAll(getClass().getResource("CSS_Files/DarkMode.css").toExternalForm());
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

    public void onProductsButtonClick(ActionEvent actionEvent) throws IOException {
        try {
            URL fxmlLocation = getClass().getResource("TimelineProductsScreen.fxml");

            FXMLLoader loader = new FXMLLoader(fxmlLocation);
            root = loader.load();
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            scene.getStylesheets().addAll(getClass().getResource("CSS_Files/DarkMode.css").toExternalForm());
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
            error.logoutConfirm(ScreenName);
        } catch (Exception e) {
            error.unableToCloseApplication();
        }
    }

    public void setScreenTheme () {
            Boolean mode = getDarkMode();
            if (mode = false) {

            } else if (mode = true) {



        }
    }


    public void onCloseImageClick(MouseEvent mouseEvent) {
        javafx.application.Platform.exit();

    }

    public AnchorPane getScreen(String Filename){
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
}
