package com.xin.proxydemo.common;

import com.google.gson.Gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by admin on 2019/3/20.
 */

public class OkHttpUtil implements IHttp {

    private OkHttpClient client;

    private final MediaType JSON = MediaType.parse("application/json;charset=utf-8");

    private final long TIME_OUT = 60 * 1000;

    public OkHttpUtil() {
        client = new OkHttpClient();
        client.newBuilder()
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                .build();
    }


    @Override
    public void post(String url, String str, final IHttpResultCallBack callBack) {

        RequestBody body = RequestBody.create(JSON, str);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .addHeader("token", "token")
                .build();
        client.newCall(request)
                .enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        if (callBack != null) {
                            callBack.onError(e.toString());
                        }
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {

                        if (callBack != null) {
                            callBack.onSuccess(response.body().string());
                        }

                    }
                });

    }

    @Override
    public void get(String url, String str, final IHttpResultCallBack callBack) {

        Request.Builder builder = new Request.Builder();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(url).newBuilder();

        JsonObject object = new Gson().fromJson(str, JsonObject.class);

        Set<Map.Entry<String, JsonElement>> keys = object.entrySet();

        for (Map.Entry<String, JsonElement> entry : keys) {
            urlBuilder.addQueryParameter(entry.getKey(), entry.getValue().toString());
        }

        builder.url(urlBuilder.build());

        Request request = builder
                .addHeader("token", "token")
                .build();

        client.newCall(request)
                .enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        if (callBack != null) {
                            callBack.onError(e.toString());
                        }
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        if (callBack != null) {
                            callBack.onSuccess(response.body().string());
                        }
                    }
                });


    }
}
