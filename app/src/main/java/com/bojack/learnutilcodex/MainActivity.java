package com.bojack.learnutilcodex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Lifecycle;

import android.app.Activity;
import android.os.Bundle;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.Utils;
import com.bojack.learnutilcodex.databinding.ActivityMainBinding;
import com.bojack.learnutilcodex.util.LogUtil;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private ActivityMainBinding binding;

    public MainActivity(){
        // on object constructor method
        Thread subThread = new Thread(){
            @Override
            public void run() {
                super.run();
                addActivityLifecycleCallbacks();
            }
        };subThread.start();
        try {
            Thread.sleep(2 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LogUtil.e(TAG, "MainActivity Constructor");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.buttonInvoke.setOnClickListener(v -> addActivityLifecycleCallbacks());
        LogUtil.e(TAG, "onCreate() finished");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtil.e(TAG, "onDestroy() finished");
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtil.e(TAG, "onStart() finished");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtil.e(TAG, "onResume() finished");
    }

    private void addActivityLifecycleCallbacks() {
        ActivityUtils.addActivityLifecycleCallbacks(MainActivity.this,
                new Utils.ActivityLifecycleCallbacks(){
                    @Override
                    public void onActivityCreated(@NonNull Activity activity) {
                        super.onActivityCreated(activity);
                        LogUtil.e(TAG, "onActivityCreated()");
                    }

                    @Override
                    public void onActivityDestroyed(@NonNull Activity activity) {
                        super.onActivityDestroyed(activity);
                        LogUtil.e(TAG, "onActivityDestroyed()");
                    }

                    @Override
                    public void onActivityPaused(@NonNull Activity activity) {
                        super.onActivityPaused(activity);
                        LogUtil.e(TAG, "onActivityPaused()");
                    }

                    @Override
                    public void onActivityResumed(@NonNull Activity activity) {
                        super.onActivityResumed(activity);
                        LogUtil.e(TAG, "onActivityResumed()");
                    }

                    @Override
                    public void onActivityStarted(@NonNull Activity activity) {
                        super.onActivityStarted(activity);
                        LogUtil.e(TAG, "onActivityStarted()");
                    }

                    @Override
                    public void onActivityStopped(@NonNull Activity activity) {
                        super.onActivityStopped(activity);
                        LogUtil.e(TAG, "onActivityStopped()");
                    }

                    @Override
                    public void onLifecycleChanged(@NonNull Activity activity, Lifecycle.Event event) {
                        super.onLifecycleChanged(activity, event);
                        LogUtil.e(TAG, "onLifecycleChanged() activity: " + activity + " event: " + event);
                    }
                });
    }

    private void func2(){
        ActivityUtils.addActivityLifecycleCallbacks(new Utils.ActivityLifecycleCallbacks(){
            @Override
            public void onActivityCreated(@NonNull Activity activity) {
                super.onActivityCreated(activity);
                LogUtil.e(TAG, "no activity param call back: " + "onActivityCreated()");
            }
        });
    }
}