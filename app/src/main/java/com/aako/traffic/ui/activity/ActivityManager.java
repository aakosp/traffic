package com.aako.traffic.ui.activity;

import android.app.Activity;
import android.content.Context;

import java.util.Stack;

/**
 * Created by aako on 2015/6/16.
 */
public class ActivityManager {

    private static ActivityManager instance;
    private static Stack<Activity> activityStack = new Stack<>();

    private ActivityManager(){}

    public static ActivityManager getInstance(){
        if(null == instance){
            instance = new ActivityManager();
        }
        return instance;
    }

    public void push(Activity activity){
        activityStack.push(activity);
    }

    public void pop(){
        activityStack.pop();
    }

    public Activity currentActivity(){
        return activityStack.peek();
    }

    public void clear(){
        activityStack.clear();
    }

    public boolean contains(Activity activity){
        return activityStack.contains(activity);
    }

    public void finishActivity(Activity activity) {
        if (activity != null) {
            activityStack.remove(activity);
            activity.finish();
        }
    }

    public void finishActivity(Class<?> cls) {
        for (Activity activity : activityStack) {
            if (activity.getClass().equals(cls)) {
                finishActivity(activity);
            }
        }
    }

    public void finishAllActivity() {
        try {
            if (null == activityStack) {
                return;
            }
            for (int i = 0, size = activityStack.size(); i < size; i++) {
                if (null != activityStack.get(i)) {
                    try {
                        activityStack.get(i).finish();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            activityStack.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void AppExit(Context context) {
        try {
            finishAllActivity();
            android.app.ActivityManager activityMgr = (android.app.ActivityManager) context
                    .getSystemService(Context.ACTIVITY_SERVICE);
            activityMgr.killBackgroundProcesses(context.getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }
    }
}
