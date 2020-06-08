package com.example.menuspickers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    int c_date,c_month,c_year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.setting:
                Toast.makeText(this, ""+item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.dial:
                Toast.makeText(this, ""+item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.call:
                Toast.makeText(this, ""+item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void alert(View view) {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("This is Alert Dialog");
        alertDialog.setMessage("Are you want close the App?");
        alertDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        alertDialog.setCancelable(false);

        alertDialog.show();

    }

    public void dpd(View view) {

        Calendar c=Calendar.getInstance();
        c_year=c.get(Calendar.YEAR);
        c_date=c.get(Calendar.DATE);
        c_month=c.get(Calendar.MONTH);

        DatePickerDialog datePicker= new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Toast.makeText(MainActivity.this, dayOfMonth+"-"+(month+1)+"-"+year, Toast.LENGTH_SHORT).show();
            }
        },c_year,c_month,c_date);
        datePicker.show();

    }
}






