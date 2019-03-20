package com.xin.proxydemo;

import android.app.Application;

/**
 * Created by admin on 2019/3/20.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        ProxyHttp.obtain().init(new VolleyUtil(this));
//        ProxyHttp.obtain().init(new OkHttpUtil());

    }
}
