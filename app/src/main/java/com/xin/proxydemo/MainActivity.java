package com.xin.proxydemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String url = "";
        String string = "";


        ProxyHttp.obtain().post(url, string, new IHttpResultCallBack() {
            @Override
            public void onSuccess(String data) {

            }

            @Override
            public void onError(String msg) {

            }
        });
    }
}
