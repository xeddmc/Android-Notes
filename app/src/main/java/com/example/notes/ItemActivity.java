package com.example.notes;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ItemActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText itemET;
    private TextView btn;
    private TextView back;
    private String position;

    public static final String NOTE_DELETE = "com.example.myfirstapp.NOTE_DELETE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        Intent intent = getIntent();
        String note = intent.getStringExtra(ListActivity.NOTE_DATA);
        position = intent.getStringExtra(ListActivity.NOTE_POSITION);

        itemET = findViewById(R.id.item_edit_text_detail);
        itemET.setText(note);

        btn = findViewById(R.id.delete_btn);
        btn.setOnClickListener(this);

        back = findViewById(R.id.back_btn);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.delete_btn:
                Intent intent = new Intent(this, ListActivity.class);
                intent.putExtra(NOTE_DELETE, position);
                startActivity(intent);
                break;
            case R.id.back_btn:
                finish();
                break;

        }
    }

}
