package com.emrebaglayici.lab9;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.emrebaglayici.lab9.adapters.ListAdapter;
import com.emrebaglayici.lab9.databinding.ActivityMainBinding;
import com.emrebaglayici.lab9.fragment.CustomDialogFragment;
import com.emrebaglayici.lab9.model.ProductModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CustomDialogFragment.CallBack {

    ActivityMainBinding binding;
    List<ProductModel> productModelList = new ArrayList<>();
    ListAdapter myAdapter;

    CharSequence name, des, qua;
    int a = R.drawable.burger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        setSupportActionBar(binding.toolbar);
        if (getSupportActionBar() != null) {
            binding.toolbar.inflateMenu(R.menu.menu_item);
        }


        binding.floatingAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CustomDialogFragment customDialogFragment = new CustomDialogFragment();
                customDialogFragment.show(getSupportFragmentManager(), null);

            }
        });

ProductModel productModel = new ProductModel(name, des, qua, a);
productModelList.add(productModel);

        myAdapter = new ListAdapter(productModelList, this);
        binding.recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView2.setAdapter(myAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.setting) {
            System.out.println("Setting");
            Toast.makeText(getApplicationContext(), "Setting", Toast.LENGTH_LONG).show();

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onActionClick(CharSequence name, CharSequence des, CharSequence qua) {
        this.name = name;
        this.des = des;
        this.qua = qua;
    }
}