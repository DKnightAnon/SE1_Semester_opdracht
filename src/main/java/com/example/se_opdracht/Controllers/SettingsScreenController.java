package com.example.se_opdracht.Controllers;

import com.example.se_opdracht.Main;
import com.example.se_opdracht.User.UserProfile;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.controlsfx.control.ToggleSwitch;

import java.net.URL;
import java.util.ResourceBundle;


public class SettingsScreenController implements Initializable {


    @FXML
    private ToggleSwitch DarkmodeToggle;

    @FXML
    private Label Darkmodelabel,EMAILLabel,Email,TBA,TBALabel,Username,UsernameLabel;

    @FXML
    private Button EditProfileImageButton,EditUsernameButton,Editemail,TBAButton;

    private boolean mode;


    @FXML
    private ImageView ProfileImage;

    @FXML
    public void modeToggle(MouseEvent event){
        if (DarkmodeToggle.isSelected()){
            mode = true;
        }else {
            mode = false;
        }
        switchTheme();
    }
    private void switchTheme(){
        if (mode){
            loadDark();
            UserProfile.getInstance().setDarkMode(true);
        }else{
            loadLight();
            UserProfile.getInstance().setDarkMode(false);
        }
    }

    private void loadLight(){
        String path = String.valueOf(Main.class.getResource("CSS_Files/LightMode.css"));
        Main.genericstage.getScene().getStylesheets().clear();
        Main.genericstage.getScene().getStylesheets().add(path);
    }

    private void loadDark(){
        String path = String.valueOf(Main.class.getResource("CSS_Files/DarkMode.css"));
        Main.genericstage.getScene().getStylesheets().clear();
        Main.genericstage.getScene().getStylesheets().add(path);
    }

    @FXML
    void onEditEmailButtonClicked(ActionEvent event) {
        UserProfile.getInstance().setEmail(getSubject());
    }

    @FXML
    void onEditProfileImageButtonClicked(ActionEvent event) {

    }

    @FXML
    void onEditUsernameButtonClicked(ActionEvent event) {
        UserProfile.getInstance().setUsername(getSubject());
    }

    @FXML
    void onTBAButtonClicked(ActionEvent event) {

    }

    private String getSubject(){
        String subject;
        TextInputDialog td = new TextInputDialog();
        td.setHeaderText("Voer onderwerp in");
        td.showAndWait();
        subject = td.getEditor().getText();
        return subject;
    }

    private void loadUserDetails(){
        Email.setText(UserProfile.getInstance().getEmail());
        Username.setText(UserProfile.getInstance().getUsername());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DarkmodeToggle.setSelected(UserProfile.getInstance().getDarkMode());
        switchTheme();
        UserProfile.getInstance().setEmail("testEmail");
        UserProfile.getInstance().setUsername("TestUserName");
        loadUserDetails();

    }
}
