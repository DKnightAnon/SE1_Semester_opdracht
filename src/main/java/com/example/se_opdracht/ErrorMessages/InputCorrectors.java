package com.example.se_opdracht.ErrorMessages;

import javafx.scene.control.TextInputDialog;

import java.math.BigDecimal;

public class InputCorrectors {

    public static BigDecimal CorrectPrice(){
        String subject;
        TextInputDialog td = new TextInputDialog();
        td.setHeaderText("Prijs kan niet negatief zijn.");
        td.setContentText("Voer een geldig bedrag in.");
        td.showAndWait();
        subject = td.getEditor().getText();
        BigDecimal correctPrice = BigDecimal.valueOf(Double.valueOf(subject));
        return correctPrice;
    }
}
