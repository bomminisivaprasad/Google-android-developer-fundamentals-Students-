package siva.apssdc.android.vij.impintents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=findViewById(R.id.et_text);
    }

    public void dail(View view) {
        String s=text.getText().toString();
        Intent i=new Intent(Intent.ACTION_DIAL);
        i.setData(Uri.parse("tel:"+s));
        startActivity(i);
    }

    public void share(View view) {
        String s=text.getText().toString();
        ShareCompat.IntentBuilder.from(this)// place
                .setType("text/plain")// type of data
                .setChooserTitle("select one app")
                .setText(s)// share data
                .startChooser();// open a chooser


    }

    public void whatsapp(View view) {
        Intent i=getPackageManager().getLaunchIntentForPackage("com.whatsapp");
        startActivity(i);
    }
}