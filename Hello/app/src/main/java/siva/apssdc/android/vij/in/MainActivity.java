package siva.apssdc.android.vij.in;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    Button count;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.text_view);
        count=findViewById(R.id.bt_count);
        count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                tv.setText(""+i);



            }
        });

    }


    public void hello_toast(View view) {

        Toast.makeText(MainActivity.this,"Value of textview"+i
        ,Toast.LENGTH_SHORT).show();
    }

}