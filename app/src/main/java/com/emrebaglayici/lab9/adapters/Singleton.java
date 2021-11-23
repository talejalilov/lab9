package com.emrebaglayici.lab9.adapters;

import com.emrebaglayici.lab9.model.ProductModel;

public class Singleton {

    private ProductModel productModel;
    private static Singleton singleton;

    public Singleton() {

    }

    public ProductModel getProductModel() {
        return productModel;
    }

    public void setProductModel(ProductModel productModel) {
        this.productModel = productModel;
    }

    public static Singleton getInstance(){
        if(singleton==null){
            singleton = new Singleton();
        }
        return singleton;
    }
}

