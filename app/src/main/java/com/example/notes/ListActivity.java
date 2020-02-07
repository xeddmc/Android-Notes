package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


import java.util.ArrayList;

public class ListActivity extends AppCompatActivity implements View.OnClickListener, ListView.OnItemClickListener{

    private ListView itemsList;
    private FloatingActionButton btn;

    private ArrayList<String> items;
    private ArrayAdapter<String> adapter;

    public static final String NOTE_DATA = "com.example.myfirstapp.NOTE_DATA";
    public static final String NOTE_POSITION = "com.example.myfirstapp.NOTE_POSITION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Intent intent = getIntent();
        String newNote = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        itemsList = findViewById(R.id.items_list);
        items = FileHelper.readData(this);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        if(newNote!= null){
            if(!newNote.isEmpty()){
                adapter.add(newNote);
                FileHelper.writeData(items, this);
            }
        }

        itemsList.setAdapter(adapter);
        itemsList.setOnItemClickListener(this);

        btn = findViewById(R.id.add_btn);
        btn.setOnClickListener(this);

        String positionDelete = intent.getStringExtra(ItemActivity.NOTE_DELETE);
        if(positionDelete!=null) {
            removeItem(Integer.parseInt(positionDelete));
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, ItemActivity.class);
        intent.putExtra(NOTE_DATA, items.get(position));
        intent.putExtra(NOTE_POSITION, String.valueOf(position));

        startActivity(intent);
    }

    public void removeItem(int position) {
        items.remove(position);
        FileHelper.writeData(items, this);
        adapter.notifyDataSetChanged();
        Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show();
    }
}
