package com.example.atividade03;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button btnPosts = (Button) findViewById(R.id.btnPosts);
        Button btnComments = (Button) findViewById(R.id.btnComments);
        Button btnAlbums = (Button) findViewById(R.id.btnAlbums);


        btnPosts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), PostsActivity.class);
                startActivity(intent1);
            }
        });

        btnComments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), ActivityComments.class);
                startActivity(intent1);
            }
        });

        btnAlbums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), PrimeiraActivity.class);
                startActivity(intent1);
            }
        });


    }
}