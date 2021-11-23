package com.emrebaglayici.lab9.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.emrebaglayici.lab9.EditActivity;
import com.emrebaglayici.lab9.MainActivity;
import com.emrebaglayici.lab9.databinding.RecyclerItemBinding;
import com.emrebaglayici.lab9.fragment.CustomDialogFragment;
import com.emrebaglayici.lab9.model.ProductModel;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ProductHolder> {


    List<ProductModel> products;
    Context context;


    public ListAdapter(List<ProductModel> products, Context context) {
        this.products = products;
        this.context = context;
    }

    @NonNull
    @Override
    public ProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerItemBinding binding = RecyclerItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ProductHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.binding.quantity.setText(products.get(position).getQuantity());
        holder.binding.description.setText(products.get(position).getDescription());
        holder.binding.productImage.setImageResource(products.get(position).getPicID());
        holder.binding.productName.setText(products.get(position).getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckBox checkBox = (CheckBox) view;
                if (checkBox.isChecked()) {
                    holder.binding.description.setPaintFlags(holder.binding.description.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                } else if (!checkBox.isChecked()) {
                    holder.binding.description.setPaintFlags(holder.binding.description.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                }
                Intent intent = new Intent(context, MainActivity.class);
                Singleton singleton = Singleton.getInstance();
                singleton.setProductModel(products.get(position));
                holder.itemView.getContext().startActivity(intent);

            }
        });

    }
        @Override
        public int getItemCount () {
            return products.size();
        }


}
