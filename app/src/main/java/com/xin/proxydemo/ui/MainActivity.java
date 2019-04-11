package com.xin.proxydemo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

import com.google.gson.Gson;
import com.xin.proxydemo.R;
import com.xin.proxydemo.common.IHttp;
import com.xin.proxydemo.common.IHttpResultCallBack;
import com.xin.proxydemo.dynamicProxy.ProxyFactory;
import com.xin.proxydemo.entity.User;

public class MainActivity extends AppCompatActivity implements OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    @Override
    public void onClick(View v) {

        String url = "http://192.168.1.133:8080/JeemaaPortalFrame/frame/android/login";

        User user = new User("123456", "123456");


//        //******************* 静态代理 开始 *****************
//        ProxyHttp.obtain().post(url, new Gson().toJson(user), new IHttpResultCallBack() {
//            @Override
//            public void onSuccess(String data) {
//                Log.d("========", data);
//            }
//
//            @Override
//            public void onError(String msg) {
//                Log.d("========", msg);
//            }
//        });


        //---------------- 动态代理 开始 -------------------

        ((IHttp) ProxyFactory.obtain().getProxyInstance()).post(url, new Gson().toJson(user), new IHttpResultCallBack() {
            @Override
            public void onSuccess(String data) {
                Log.d("========", data);
            }

            @Override
            public void onError(String msg) {
                Log.d("========", msg);
            }
        });


    }
}
