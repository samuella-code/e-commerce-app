package com.hfad.online_shop.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.hfad.online_shop.Adapter.PopularAdapter;
import com.hfad.online_shop.Domain.PopularDomain;
import com.hfad.online_shop.R;
import com.hfad.online_shop.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivitys extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        statusBarColor();
        initRecyclerView();
        bottomNavigation();
    }

    private void bottomNavigation() {
        binding.cartBtn.setOnClickListener(v -> startActivity(new Intent(MainActivitys.this,CartActivity.class)));
    }

    private void statusBarColor() {
        Window window=MainActivitys.this.getWindow();
        window.setStatusBarColor(ContextCompat.getColor(MainActivitys.this, R.color.purple_Dark));
    }

    private void initRecyclerView() {
        ArrayList<PopularDomain> items=new ArrayList<>();
        items.add(new PopularDomain("T-shirt black","item_1",15,4,500,"Immerse yourself in a world of vibrant visuals\n" +
                "immersive sound with the monitor.\n" +
                "Its cutting-edge monitor technology brings every\n"+
                "scene to life with striking clarity and rich colors.\n"+
                "With seamless integration and s sleek, modern\n"+
                "design, the monitor Pro is not just a monitor, but\n"+
                "centerpiece for your entertainment space.\n"+
                "With its sleek, modern design, the monitor is\n"+
                "not just a TV, but a centerpiece for your \n"+
                "entertainment space. The ultra-slim bezel and\n"+
                "premium finish blend seamlessly with any decor"));
        items.add(new PopularDomain("Smart Watch","item_2",10,4.5,450,"Immerse yourself in a world of vibrant visuals\n"+
                "immersive sound with the monitor.\n" +
                "Its cutting-edge monitor technology brings every\n"+
                "scene to life with striking clarity and rich colors.\n"+
                "With seamless integration and s sleek, modern\n"+
                "design, the monitor Pro is not just a monitor, but\n"+
                "centerpiece for your entertainment space.\n"+
                "With its sleek, modern design, the monitor is\n"+
                "not just a TV, but a centerpiece for your \n"+
                "entertainment space. The ultra-slim bezel and\n"+
                "premium finish blend seamlessly with any decor"));
        items.add(new PopularDomain("Phone","item_3",3,4.9,800,"Immerse yourself in a world of vibrant visuals\n" +
                "immersive sound with the monitor.\n" +
                "Its cutting-edge monitor technology brings every\n"+
                "scene to life with striking clarity and rich colors.\n"+
                "With seamless integration and s sleek, modern\n"+
                "design, the monitor Pro is not just a monitor, but\n"+
                "centerpiece for your entertainment space.\n"+
                "With its sleek, modern design, the monitor is\n"+
                "not just a TV, but a centerpiece for your \n"+
                "entertainment space. The ultra-slim bezel and\n"+
                "premium finish blend seamlessly with any decor"));

        binding.PopularView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        binding.PopularView.setAdapter(new PopularAdapter(items));
    }
}
