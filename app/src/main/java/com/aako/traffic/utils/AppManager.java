package com.aako.traffic.utils;

import android.app.Application;

import com.aako.traffic.fresco.ImagePipelineConfigFactory;
import com.aako.traffic.log.FLog;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.backends.okhttp.OkHttpImagePipelineConfigFactory;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.squareup.okhttp.OkHttpClient;

/**
 * Created by aako on 2015/6/19.
 */
public class AppManager extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FLog.d("AppManager", "onCreate==================");
        Fresco.initialize(this, ImagePipelineConfigFactory.getOkHttpImagePipelineConfig(this));
    }
}
