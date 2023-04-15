package com.example.se_opdracht;

import com.example.se_opdracht.DBHandlers.TransactionDBHandler;
import com.example.se_opdracht.ErrorMessages.ErrorWarnings;
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

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public abstract class GenericScreenController {
    String darkmodeID = "generalmenubutton-darkmode";
    String darkmodeIDIcons = "#generalicon-darkmode";



    private AnchorPane ScreenName;
    private Parent root;
    private Stage stage;
    private Scene scene;
    @FXML
    private AnchorPane TopBar;
    @FXML
    private Button ReturnButton;
    @FXML
    private Button MenuButton;
    @FXML
    private Button HomeButton;
    ErrorWarnings error = new ErrorWarnings();
    private Boolean darkMode;
    TransactionDBHandler tdbh = new TransactionDBHandler();

    Image AppIcon = new Image((Objects.requireNonNull(getClass().getResourceAsStream("images/AppIcon.png"))));
    Image BurgerMenuIcon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/HamburgerMenuIcon.png")));
    Image BudgetTransactionProductIcon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/BudgetTransactionProductIcon.png")));
    Image CrossmarkSmall = new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/CrossmarkSmall.png")));
    Image exitIcon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/ExitIcon.png")));
    Image Home = new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/HomeMenuIcon.png")));
    Image Settings = new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/SettingsIcon.png")));
    Image Timeline = new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/TimelineProductIcon.png")));



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

    public void onProductsButtonClick(ActionEvent actionEvent) {
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
        while (true) {
            Boolean mode = getDarkMode();
            if (mode = false) {

            } else if (mode = true) {


            }
        }
    }


    public void onCloseImageClick(MouseEvent mouseEvent) {
        stage = (Stage) Main.genericstage.getScene().getWindow();
        stage.close();

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
}
