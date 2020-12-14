package com.example.projetandroidtsp.Models;

import android.graphics.drawable.Drawable;

public class Categories {
    public String appelation;
    public int img;
    public Integer nb_succes;

    public Categories(String appelation, int img, Integer nb_succes){
        this.appelation=appelation;
        this.img=img;
        this.nb_succes=nb_succes;
    }

    public Integer getNb_succes() {
        return nb_succes;
    }

    public String getAppelation() {
        return appelation;
    }

    public void setAppelation(String appelation) {
        this.appelation = appelation;
    }


    public void setNb_succes(Integer nb_succes) {
        this.nb_succes = nb_succes;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
