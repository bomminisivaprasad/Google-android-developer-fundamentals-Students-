package com.example.notifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    NotificationManager manager;


    String text = "We feel excited to welcome you to the \"Android Application Development Workshop\". The Program is going to happen from 01-06-2020 to 20-06-2020. \n" +
            "\n" +
            "You will be provisionally selected based on the following conditions(Important Instructions).\n" +
            "\n" +
            "1. There will be a 2:00 hours session every day, and attendance is mandatory for all the sessions (Attendance will be taken directly from the GoToMeeting App).\n" +
            "2. An exam will be conducted at the end of the course.\n" +
            "3. Desktop or Laptop with Good Internet connectivity is a must to participate.\n" +
            "4. Please make sure that please install Android Studio Software.  ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    public void notification(View view) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel =
                    new NotificationChannel("sai","Sai Sankar",NotificationManager.IMPORTANCE_HIGH);
            channel.enableLights(true);
            channel.enableVibration(true);
            manager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,"sai");
        builder.setContentTitle("App Notification");
        builder.setContentText("Hi!, How Are You?");
        builder.setSmallIcon(R.mipmap.ic_launcher_round);
        Intent i =new Intent(this,MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this,
                45,i,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pi);
        builder.setAutoCancel(true);
        builder.addAction(R.drawable.ic_delete_black_24dp,"Delete",pi);

        builder.setStyle(new NotificationCompat.BigTextStyle().bigText(text));


        Notification notification = builder.build();
        manager.notify(45,notification);



    }
}
