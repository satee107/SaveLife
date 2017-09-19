package com.bloodmanagement.savelife;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends Activity {
    public static final String PREF_USER_FIRST_TIME = "user_first_time";
    final int SPLASH_DISPLAY_LENGTH = 1500;
    boolean isUserFirstTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        isUserFirstTime = Boolean.valueOf(Utils.readSharedSetting(SplashActivity.this, PREF_USER_FIRST_TIME, "true"));
        Intent introIntent = new Intent(SplashActivity.this, OverviewTabsActivity.class);
        introIntent.putExtra(PREF_USER_FIRST_TIME, isUserFirstTime);
        if (isUserFirstTime)
            startActivity(introIntent);
        else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);

                }
            }, SPLASH_DISPLAY_LENGTH);
        }
    }
}
