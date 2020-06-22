package com.example.myworkmanager;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class Mywork extends Worker {
    public Mywork(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        worknotification();
        return Result.success();
    }

    private void worknotification() {
        NotificationManager manager=(NotificationManager) getApplicationContext()
                .getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >=Build.VERSION_CODES.O){
            NotificationChannel channel=new NotificationChannel("1","apssdc",
                    NotificationManager.IMPORTANCE_DEFAULT);
            manager.createNotificationChannel(channel);
        }
        NotificationCompat.Builder builder=new
                NotificationCompat.Builder(getApplicationContext(),"1")
                .setContentTitle("WorkmanagerTitle")
                .setContentText("This is the text for workmanager")
                .setSmallIcon(R.mipmap.ic_launcher);
        manager.notify(1,builder.build());


    }
}
