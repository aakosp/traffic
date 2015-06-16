package com.aako.traffic.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.aako.traffic.log.FLog;

/**
 * Created by aako on 2015/6/16.
 */
public class BaseActionBarActivity extends AppCompatActivity  {

    private static String TAG = "BaseActionBarActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FLog.d(TAG, "onCreat");
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        FLog.d(TAG, "onStart");
        super.onStart();
    }

    @Override
    protected void onRestart() {
        FLog.d(TAG, "onRestart");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        FLog.d(TAG, "onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        FLog.d(TAG, "onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        FLog.d(TAG, "onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        FLog.d(TAG, "onDestroy");
        super.onDestroy();
    }
}
