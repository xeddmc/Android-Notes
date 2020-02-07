package com.example.notes;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Welcome extends AppCompatActivity implements View.OnClickListener {

    private Button btn;
    private ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        imgView = findViewById(R.id.logo);
        btn = findViewById(R.id.home_btn);

        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }
}
