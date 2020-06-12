package com.example.asyntask;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    String myurl = "https://pixabay.com/api/?key=8907574-f2ba82f0d1e5cef1d06a114e6&q=";

    EditText et;
    TextView tv;
    ImageView iv;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et= findViewById(R.id.nameofimage);
        tv= findViewById(R.id.likes);
        iv= findViewById(R.id.imageView);
        progressBar=findViewById(R.id.progress);

    }

    public void submit(View view) {
        new DataTask().execute();
    }

    class DataTask extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {

            try {
                /*To get data Url*/
                @SuppressLint("WrongThread") URL url = new URL(myurl+et.getText().toString());
                /*To Check Internet permission avaliable or not*/
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                /*Getting input from the url*/
                InputStream is = urlConnection.getInputStream();
                /*to read Data*/
                Scanner sc =new Scanner(is);

                /*for reading from open object to close object*/
                sc.useDelimiter("\\A");
                if (sc.hasNext()){
                    return sc.next();
                }


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            progressBar.setVisibility(View.GONE);
            //Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
            try {
                JSONObject jsonObject =new JSONObject(s);
                JSONArray hitsArray = jsonObject.getJSONArray("hits");
                JSONObject mydata = hitsArray.getJSONObject(6);
                String image = mydata.getString("largeImageURL");
                String likes = mydata.getString("likes");
                tv.setText("Likes : "+likes);
                Picasso.get().load(image).into(iv);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }



}
