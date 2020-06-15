package com.example.rectrofitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {
TextView tv;
ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.text_view);
        progressBar=findViewById(R.id.progress);
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.covid19api.com/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        Covid19Interface service=retrofit.create(Covid19Interface.class);
        Call<String> data=service.getData();
        data.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                //Toast.makeText(MainActivity.this, response.body(), Toast.LENGTH_SHORT).show();
                try {
                    JSONArray root=new JSONArray(response.body());
                    for (int i=0;i<root.length();i++){
                        JSONObject data=root.getJSONObject(i);
                        String date=data.getString("Date");
                        int active=data.getInt("Active");
                        int conf=data.getInt("Confirmed");
                        int deaths=data.getInt("Deaths");
                        int recover=data.getInt("Recovered");
                        tv.append(parseDateToddMMyyyy(date.substring(0,10))+" : "
                                +conf+" : "+active+" : "+recover+" : "
                                   +deaths+"\n");

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Somethin Fail", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);

            }
        });


    }
    public String parseDateToddMMyyyy(String time) {
        String inputPattern = "yyyy-MM-dd";
        String outputPattern = "dd-MM-yyyy";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

        Date date = null;
        String str = null;

        try {
            date = inputFormat.parse(time);
            str = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }
}