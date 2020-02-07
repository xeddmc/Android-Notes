package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText itemET;
    private TextView btn;
    private TextView back;

    private ArrayList<String> items;
    private ArrayAdapter<String> adapter;

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemET = findViewById(R.id.item_edit_text);
        btn = findViewById(R.id.sub_btn);
        back = findViewById(R.id.cancel_btn);

        btn.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sub_btn:
                String itemEntered = itemET.getText().toString();
                itemET.setText("");
                Toast.makeText(this, "Note Added", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, ListActivity.class);
                intent.putExtra(EXTRA_MESSAGE, itemEntered);
                startActivity(intent);
                break;
            case R.id.cancel_btn:
                finish();
                break;

        }
    }

}
