package com.hfad.online_shop.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.hfad.online_shop.Activity.DetailActivity;
import com.hfad.online_shop.Domain.PopularDomain;
import com.hfad.online_shop.Helper.ChangeNumberItemsListener;
import com.hfad.online_shop.Helper.ManagmentCart;
import com.hfad.online_shop.databinding.ViewholderCartBinding;
import com.hfad.online_shop.databinding.ViewholderPopBinding;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.Viewholder> {
    ArrayList<PopularDomain> items;
    Context context;
    ViewholderCartBinding binding;
    ChangeNumberItemsListener changeNumberItemsListener;

    ManagmentCart managmentCart;

    public CartAdapter(ArrayList<PopularDomain> items, ChangeNumberItemsListener changeNumberItemsListener) {
        this.items = items;

        this.changeNumberItemsListener = changeNumberItemsListener;
    }

    @NonNull
    @Override
    public CartAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding=ViewholderCartBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        context = parent.getContext();
        managmentCart = new ManagmentCart(context);
        return new Viewholder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.Viewholder holder, int position) {
        binding.titleTxt.setText(items.get(position).getTitle());
       binding.feeEachItem.setText("$"+items.get(position).getPrice());
       binding.totalEachItem.setText("$"+Math.round(items.get(position).getNumberInCart()+items.get(position).getPrice()));
       binding.numberItemTxt.setText(String.valueOf(items.get(position).getNumberInCart()));


        int drawableResourced=holder.itemView.getResources().getIdentifier(items.get(position).getPicUrl()
                ,"drawable",holder.itemView.getContext().getPackageName());


        Glide.with(context)
                .load(drawableResourced)
                .transform(new GranularRoundedCorners(30,30,0,0))
                .into(binding.pic);


     binding.plusCartBtn.setOnClickListener(v -> managmentCart.plusNumberItem(items, position, () -> {
         notifyDataSetChanged();
         changeNumberItemsListener.change();
     }));
     binding.minusCartItem.setOnClickListener(v -> managmentCart.minusNumberItem(items, position, () -> {
         notifyDataSetChanged();
         changeNumberItemsListener.change();
     }));

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class Viewholder  extends RecyclerView.ViewHolder {
        public Viewholder(ViewholderCartBinding binding) {
            super(binding.getRoot());
        }
    }
}
