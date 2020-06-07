package siva.apssdc.android.vij.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
TextView tv1,tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv1=findViewById(R.id.text1);
        tv2=findViewById(R.id.text2);
        String s=getIntent().getStringExtra("key1");
        String s1=getIntent().getStringExtra("key2");
        tv1.setText(s);
        tv2.setText(s1);

    }
}