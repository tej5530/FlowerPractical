package com.tejaspractical;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton btnGenerateFlower;
    private ImageView ivFirst, ivSecond, ivThird, ivFour;
    ArrayList<String> list;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialization();
        castingControl();
        setListener();
        bindData(list);
    }


    private void initialization() {
        context = this;
        list = new ArrayList<>();
        list.add("https://images.pexels.com/photos/67636/rose-blue-flower-rose-blooms-67636.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260");
        list.add("https://images.pexels.com/photos/60597/dahlia-red-blossom-bloom-60597.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260");
        list.add("https://images.pexels.com/photos/736230/pexels-photo-736230.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260");
        list.add("https://images.pexels.com/photos/36753/flower-purple-lical-blosso.jpg?auto=compress&cs=tinysrgb&h=750&w=1260");
    }

    private void castingControl() {
        btnGenerateFlower = findViewById(R.id.btnGenerateFlower);
        ivFirst = findViewById(R.id.ivFirst);
        ivSecond = findViewById(R.id.ivSecond);
        ivThird = findViewById(R.id.ivThird);
        ivFour = findViewById(R.id.ivFour);
    }

    private void setListener() {
        btnGenerateFlower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Collections.shuffle(list);
                bindData(list);
            }
        });
    }

    private void bindData(ArrayList<String> list) {
        Glide.with(context)
                .load(list.get(0))
                .centerCrop()
                .into(ivFirst);
        Glide.with(context)
                .load(list.get(1))
                .centerCrop()
                .into(ivSecond);
        Glide.with(context)
                .load(list.get(2))
                .centerCrop()
                .into(ivThird);
        Glide.with(context)
                .load(list.get(3))
                .centerCrop()
                .into(ivFour);
    }
}
