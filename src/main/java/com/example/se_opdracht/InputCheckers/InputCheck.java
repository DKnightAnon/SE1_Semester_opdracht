package com.example.se_opdracht.InputCheckers;

import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class InputCheck {

    public static Boolean isDatePickerEmpty(DatePicker datePicker) {
        if (datePicker.getValue() != null) {
            return false;
        } else {
            return true;
        }
    }

    public static Boolean isTextFieldEmpty(TextField textfield) {
        if (textfield.getText().isEmpty()) {
            return true;
        }else {
            return false;
        }
    }
}
