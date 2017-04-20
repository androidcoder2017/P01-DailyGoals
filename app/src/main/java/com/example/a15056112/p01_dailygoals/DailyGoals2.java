package com.example.a15056112.p01_dailygoals;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DailyGoals2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_goals2);

        Intent i = getIntent();

        String[]info = i.getStringArrayExtra("info");

        TextView tv1 = (TextView)findViewById(R.id.textViewDisplay);

        tv1.setText(info[0] + ": " + info[1] + "\n" + info[2] + ": " + info[3] + "\n" + info[4] + ": " + info[5] +  "\n" +
                "Reflection: " + info[6]);

        Button btnClose = (Button)findViewById(R.id.buttonClose);

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DailyGoals2.super.onBackPressed();
            }
        });

    }
}
