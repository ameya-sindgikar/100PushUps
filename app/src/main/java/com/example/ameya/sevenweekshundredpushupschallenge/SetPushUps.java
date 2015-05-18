package com.example.ameya.sevenweekshundredpushupschallenge;

import android.graphics.Bitmap;

public class SetPushUps {
    String setNumber;
    String numberPushups;
    Bitmap image;

    public SetPushUps(String setNum, String numPU, Bitmap img) {
        setNumber = setNum;
        numberPushups = numPU;
        image = img;
    }

    public String getSetNumber() {
        return setNumber;
    }

    public String getNumberPushUps(){
        return numberPushups;
    }

    public Bitmap getImage() {
        return image;
    }

}
