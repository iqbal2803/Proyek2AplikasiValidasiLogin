package com.iqbal.proyek2aplikasivalidasilogin;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Activity_Splash_Screen extends AppCompatActivity {

    public static final String FILENAME = "login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isLogin()) {
                    Intent intent = new Intent(Activity_Splash_Screen.this, MainActivity.class);
                    startActivity(intent);

                } else {
                    Intent intent = new Intent(Activity_Splash_Screen.this, Activity_Login.class);
                    startActivity(intent);
                }

                finish();

            }
        }, 3000);
    }

    boolean isLogin() {
        File sdcard = getFilesDir();
        File file = new File(sdcard, FILENAME);
        if (file.exists()) {
            return true;
        } else {
            return false;
        }
    }
}