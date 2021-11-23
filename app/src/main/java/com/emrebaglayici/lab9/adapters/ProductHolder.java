package com.emrebaglayici.lab9.adapters;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.emrebaglayici.lab9.databinding.RecyclerItemBinding;
import com.emrebaglayici.lab9.inteface.ItemClickListener;
import com.emrebaglayici.lab9.R;

public class ProductHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


     RecyclerItemBinding binding;

    ItemClickListener itemClickListener;


    public ProductHolder(RecyclerItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;



    }

    @Override
    public void onClick(View view) {
        this.itemClickListener.onItemClick(view,getLayoutPosition());
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {

        this.itemClickListener = itemClickListener;
    }

}
