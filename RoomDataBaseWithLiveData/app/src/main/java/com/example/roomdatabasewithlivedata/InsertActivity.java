package com.example.roomdatabasewithlivedata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class InsertActivity extends AppCompatActivity {

    EditText sname,sroll,smobile,smail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        sname =findViewById(R.id.studentname);
        sroll = findViewById(R.id.studentrollnumber);
        smail = findViewById(R.id.studentmailid);
        smobile = findViewById(R.id.studentmobileNumber);

    }

    public void save(View view) {
        String name = sname.getText().toString();
        String mailid = smail.getText().toString();
        String phone = smobile.getText().toString();
        String roll = sroll.getText().toString();

        Student student=new Student();
        student.setName(name);
        student.setMailID(mailid);
        student.setMobileNUmber(phone);
        student.setRollNumber(roll);

        MainActivity.database.myDao().insert(student);

        finish();
    }
}
