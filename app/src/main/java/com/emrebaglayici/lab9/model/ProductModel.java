package com.emrebaglayici.lab9.model;


import android.telecom.Call;

import androidx.annotation.Nullable;

import com.emrebaglayici.lab9.fragment.CustomDialogFragment;

public class ProductModel  {

     CharSequence name;
     CharSequence description;
     CharSequence quantity;
     int picID;

    public ProductModel(CharSequence name, @Nullable CharSequence description, @Nullable CharSequence quantity, int picID) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.picID = picID;
    }

    public CharSequence getName() {
        return name;
    }

    public void setName(CharSequence name) {
        this.name = name;
    }

    public CharSequence getDescription() {
        return description;
    }

    public void setDescription(CharSequence description) {
        this.description = description;
    }

    public CharSequence getQuantity() {
        return quantity;
    }

    public void setQuantity(CharSequence quantity) {
        this.quantity = quantity;
    }

    public int getPicID() {
        return picID;
    }

    public void setPicID(int picID) {
        this.picID = picID;
    }
}
