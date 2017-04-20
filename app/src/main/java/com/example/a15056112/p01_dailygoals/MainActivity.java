package com.example.a15056112.p01_dailygoals;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.security.cert.CertPathChecker;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg;
    RadioGroup rg2;
    RadioGroup rg3;
    EditText etReflection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnOK = (Button)findViewById(R.id.buttonOK);
        rg = (RadioGroup)findViewById(R.id.radio1);
        rg2 = (RadioGroup)findViewById(R.id.radio2);
        rg3 = (RadioGroup)findViewById(R.id.radio3);
        etReflection = (EditText)findViewById(R.id.editText1);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv1 = (TextView) findViewById(R.id.textView1);
                TextView tv2 = (TextView)findViewById(R.id.textView3);
                TextView tv3 = (TextView)findViewById(R.id.textView5);



                int selectedButtonId = rg.getCheckedRadioButtonId();
                int selectedButtonId2 = rg2.getCheckedRadioButtonId();
                int selectedButtonId3 = rg3.getCheckedRadioButtonId();

                RadioButton rb = (RadioButton)findViewById(selectedButtonId);
                RadioButton rb2 = (RadioButton)findViewById(selectedButtonId2);
                RadioButton rb3 = (RadioButton)findViewById(selectedButtonId3);



                String[]info = {tv1.getText().toString(), rb.getText().toString(), tv2.getText().toString(),
                        rb2.getText().toString(), tv3.getText().toString(), rb3.getText().toString(),
                        etReflection.getText().toString()};

                Intent i = new Intent(MainActivity.this, DailyGoals2.class);

                i.putExtra("info", info);
                startActivity(i);

                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                SharedPreferences.Editor prefEdit = preferences.edit();
                prefEdit.putInt("rb", rg.getCheckedRadioButtonId());
                prefEdit.commit();

                SharedPreferences preferences2 = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                SharedPreferences.Editor prefEdit2 = preferences2.edit();
                prefEdit2.putInt("rb2", rg2.getCheckedRadioButtonId());
                prefEdit2.commit();

                SharedPreferences preferences3 = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                SharedPreferences.Editor prefEdit3 = preferences3.edit();
                prefEdit3.putInt("rb3", rg3.getCheckedRadioButtonId());
                prefEdit3.commit();

                SharedPreferences preferences4 = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                SharedPreferences.Editor prefEdit4 = preferences4.edit();
                prefEdit4.putString("etReflection", etReflection.getText().toString());
                prefEdit4.commit();


            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        int radioGroup1 = preferences.getInt("rb", 0);

        SharedPreferences preferences2 = PreferenceManager.getDefaultSharedPreferences(this);
        int radioGroup2 = preferences2.getInt("rb2", 0);

        SharedPreferences preferences3 = PreferenceManager.getDefaultSharedPreferences(this);
        int radioGroup3 = preferences3.getInt("rb3", 0);

        SharedPreferences preferences4 = PreferenceManager.getDefaultSharedPreferences(this);
        String etReflected = preferences4.getString("etReflection", "");


        rg.check(radioGroup1);
        rg2.check(radioGroup2);
        rg3.check(radioGroup3);
        etReflection.setText(etReflected);
    }

}
