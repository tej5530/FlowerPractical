package com.tejaspractical;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton btnGenerateFlower;
    private ImageView ivFirst, ivSecond, ivThird, ivFour;
    ArrayList<String> list;
    ArrayList<Integer> imageViewList;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialization();
        castingControl();
        setListener();
        generateRandomImage();
    }


    private void initialization() {
        context = this;
        list = new ArrayList<>();
        imageViewList = new ArrayList<>();
        imageViewList.add(R.id.ivFirst);
        imageViewList.add(R.id.ivSecond);
        imageViewList.add(R.id.ivThird);
        imageViewList.add(R.id.ivFour);
        list.add("https://images.pexels.com/photos/67636/rose-blue-flower-rose-blooms-67636.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260");
        list.add("https://images.pexels.com/photos/60597/dahlia-red-blossom-bloom-60597.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260");
        list.add("https://images.pexels.com/photos/736230/pexels-photo-736230.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260");
        list.add("https://images.pexels.com/photos/36753/flower-purple-lical-blosso.jpg?auto=compress&cs=tinysrgb&h=750&w=1260");
        list.add("https://images.unsplash.com/photo-1494617383329-89f8643aa386?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=4500&q=80");
        list.add("https://images.prod.meredith.com/product/afe152ce690de7271173aeeb339a0881/1533383459335/l/girl12queen-1-bouquet-10-heads-sweet-artificial-flower-fake-lily-home-wedding-party-decor");
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
                generateRandomImage();
            }
        });
    }

    private void generateRandomImage() {
        Random random = new Random( System.currentTimeMillis() );
        List<Integer> generated = new ArrayList<Integer>();
        for (int i = 0; i < imageViewList.size(); i++) {

            int v = imageViewList.get(i);
            int next = random.nextInt( list.size() );
            if ( !generated.contains( next ) ) {
                generated.add( next );
                ImageView iv = (ImageView) findViewById( v );
                Glide.with(context)
                        .load(list.get(next))
                        .centerCrop()
                        .into(iv);
            }
            else {
                i--;
            }
        }
    }

}
