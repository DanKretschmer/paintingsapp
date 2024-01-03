package com.kaishamarketing.paintingsapp;

import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private int currentPaintingIndex = 4;
    private int[] paintings = {
            R.drawable.p1, // Replace with your resource IDs
            R.drawable.p2,
            // ... other paintings
            R.drawable.p3,
            R.drawable.p4, // Replace with your resource IDs
            R.drawable.p5,
            // ... other paintings
            R.drawable.p6,
            R.drawable.p7, // Replace with your resource IDs
            R.drawable.p8,
            // ... other paintings
            R.drawable.p9,
            R.drawable.p10 // Replace with your resource IDs
    };

    private String[] paintingTitles = {
            "Supper at Emmaus",
            "The Fortune Teller",
            "Saint Jerome Writing",
            "Martha and Mary Magdalene",
            "The Cardsharps",
            "Sacrifice of Isaac",
            "Basket of Fruit",
            "Saint John the Baptist",
            "Boy With a Basket of Fruit",
            "Saint John the Baptist"

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // Hide the status bar and navigation bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        Log.d("MainActivity", "onCreate executed");

        imageView = findViewById(R.id.imageView);
        showToastWithTitle(currentPaintingIndex);
        ImageButton leftButton = findViewById(R.id.leftButton);
        ImageButton rightButton = findViewById(R.id.rightButton);

        leftButton.setOnClickListener(v -> changePainting(false));
        rightButton.setOnClickListener(v -> changePainting(true));
    }

    private void changePainting(boolean increment) {
        if (increment) {
            currentPaintingIndex++;
            if (currentPaintingIndex >= paintings.length) {
                currentPaintingIndex = 0;
            }
        } else {
            currentPaintingIndex--;
            if (currentPaintingIndex < 0) {
                currentPaintingIndex = paintings.length - 1;
            }
        }
        imageView.setImageResource(paintings[currentPaintingIndex]);
        showToastWithTitle(currentPaintingIndex);
    }


    private void showToastWithTitle(int index) {
        if (index >= 0 && index < paintingTitles.length) {
            Toast.makeText(this, paintingTitles[index], Toast.LENGTH_SHORT).show();
        }
    }
}
