package com.emrebaglayici.lab9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.emrebaglayici.lab9.adapters.Singleton;
import com.emrebaglayici.lab9.databinding.ActivityEditBinding;
import com.emrebaglayici.lab9.model.ProductModel;

public class EditActivity extends AppCompatActivity {

    ActivityEditBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Singleton singleton  = Singleton.getInstance();
        ProductModel productModel= singleton.getProductModel();

        binding.imageView.setImageResource(productModel.getPicID());
        binding.nameDetail.setText(productModel.getName());
        binding.descDetail.setText(productModel.getDescription());
        binding.qtyDetail.setText(productModel.getQuantity());

    }
}