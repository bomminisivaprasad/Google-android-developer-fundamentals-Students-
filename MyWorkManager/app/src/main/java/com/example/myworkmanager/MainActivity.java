package com.example.myworkmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Button button;
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.work_button);
        tv=findViewById(R.id.text_view);
        final OneTimeWorkRequest request=new OneTimeWorkRequest
                .Builder(Mywork.class).build();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                WorkManager.getInstance().enqueue(request);
            }
        });
        WorkManager.getInstance().getWorkInfoByIdLiveData(request.getId())
                .observe(this, new Observer<WorkInfo>() {
                    @Override
                    public void onChanged(WorkInfo workInfo) {
                        String status=workInfo.getState().name();
                        tv.append(status+"\n");

                    }
                });

    }
}