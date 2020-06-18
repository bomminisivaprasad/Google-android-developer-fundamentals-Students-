package com.example.roomdatabasewithlivedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab;
    RecyclerView rv;

    static StudentDatabase database;
    List<Student> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fab=findViewById(R.id.fab);
        rv =findViewById(R.id.recycler);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,InsertActivity.class);
                startActivity(i);
            }
        });

        database = Room.databaseBuilder(MainActivity.this,
                StudentDatabase.class,"MyDb")
                .allowMainThreadQueries().build();

        studentList = database.myDao().readData();

        rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        rv.setAdapter(new MyDataAdapter(MainActivity.this,studentList));

    }
}
