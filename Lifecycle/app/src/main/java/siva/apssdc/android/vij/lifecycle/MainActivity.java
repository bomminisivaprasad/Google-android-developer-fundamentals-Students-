package siva.apssdc.android.vij.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText et1,et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=findViewById(R.id.et_name);
        et2=findViewById(R.id.et_lastname);
        Toast.makeText(this, "On Create", Toast.LENGTH_SHORT).show();
        Log.i("apssdc","onCreate");
    }

    public void nextScreen(View view) {
        String s=et1.getText().toString();
        String s1=et2.getText().toString();
        Intent i=new Intent(this,MainActivity2.class);
        i.putExtra("key1",s);
        i.putExtra("key2",s1);
        startActivity(i);


    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "OnStart", Toast.LENGTH_SHORT).show();
        Log.i("lifecycle","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "OnResume", Toast.LENGTH_SHORT).show();
        Log.i("apssdc","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "OnPause", Toast.LENGTH_SHORT).show();
        Log.i("apssdc","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "OnStop", Toast.LENGTH_SHORT).show();
        Log.i("apssdc","onstop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "OnRestart", Toast.LENGTH_SHORT).show();
        Log.i("apssdc","onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "OnDestroy", Toast.LENGTH_SHORT).show();
        Log.i("apssdc","onDestroy");
    }
}