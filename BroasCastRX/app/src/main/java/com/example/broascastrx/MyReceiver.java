package com.example.broascastrx;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;

public class MyReceiver extends BroadcastReceiver {
ImageView imageView;
    public MyReceiver(ImageView img) {
        this.imageView=img;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        switch (intent.getAction()){
            case Intent.ACTION_POWER_CONNECTED:
                imageView.setImageResource(R.drawable.charging);
                break;
            case Intent.ACTION_POWER_DISCONNECTED:
                imageView.setImageResource(R.drawable.discharge);
                break;

        }

    }
}
