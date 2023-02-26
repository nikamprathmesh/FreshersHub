package com.example.freshershub;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImageActivity extends AppCompatActivity {
    ImageView image1,image2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        image1 = findViewById(R.id.im1);
        image2 = findViewById(R.id.im2);

        String uri = "https://images.freeimages.com/images/large-previews/ab7/gerber-and-rose-2-1544099.jpg";
        String uri2 = "https://media.istockphoto.com/id/1386535233/photo/flower-arrangement-with-colorful-daisies-in-basket-beautiful-gerbera-flower-basket-beautiful.jpg?s=612x612&w=is&k=20&c=LYvZAkTI3bYf0NKNvsz_VaA3uRwMX9QQylKZoPeepTI=";
        Picasso.get().load(uri2).into(image2);
        Picasso.get().load(uri).into(image1);

    }
}