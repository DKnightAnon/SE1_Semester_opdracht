package com.example.se_opdracht.Controllers;

import com.example.se_opdracht.User.UserProfile;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import org.controlsfx.control.ToggleSwitch;

import java.net.URL;
import java.util.ResourceBundle;


public class SettingsScreenController implements Initializable {
    UserProfile user = new UserProfile();

    @FXML
    private ToggleSwitch DarkmodeToggle;

    @FXML
    private Label Darkmodelabel,EMAILLabel,Email,TBA,TBALabel,Username,UsernameLabel;

    @FXML
    private Button EditProfileImageButton,EditUsernameButton,Editemail,TBAButton;


    @FXML
    private ImageView ProfileImage;


    @FXML
    void onEditEmailButtonClicked(ActionEvent event) {

    }

    @FXML
    void onEditProfileImageButtonClicked(ActionEvent event) {

    }

    @FXML
    void onEditUsernameButtonClicked(ActionEvent event) {

    }

    @FXML
    void onTBAButtonClicked(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
