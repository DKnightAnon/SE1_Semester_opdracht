package com.example.se_opdracht;

public class DescriptionChecker {

    private int characterlimit;

    public DescriptionChecker(int characterlimit){
        this.characterlimit = characterlimit;
    }

    public int getCharacterlimit() {
        return characterlimit;
    }

    public void setCharacterlimit(int characterlimit) {
        this.characterlimit = characterlimit;
    }

    public int checkDescription(int descriptionLength){

        int Code = 0;
        //0 voor foutmelding
        //1 voor popup om te vragen of er geen omschrijving bij hoeft
        //2 als omschrijving binnen karakterlimiet valt
        //3 als omschrijving te groot is; gooi een error

        if (descriptionLength <= 0){
            Code = 1;
        }else if (descriptionLength <= characterlimit) {
            Code = 2;
        }else if (descriptionLength > characterlimit ){
            Code = 3;
        }else {
            Code = 0;
        }
        return Code;
    }
}
