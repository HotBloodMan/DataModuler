package com.ljt.datamoduler;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class OneActivity extends AppCompatActivity {

    public static final String PREF_NAME="myPreferences";
    private SharedPreferences mPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        mPreferences=getSharedPreferences(PREF_NAME, Activity.MODE_PRIVATE);
    }
}
