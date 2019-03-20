package com.xin.proxydemo;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

/**
 * Created by admin on 2019/3/20.
 */

public class VolleyUtil implements IHttp{

    private RequestQueue mQueue;

    private JsonObjectRequest mRequest;

    public VolleyUtil(Context context){
        mQueue = Volley.newRequestQueue(context);
    }

    @Override
    public void post(String url, String str, IHttpResultCallBack callBack) {

        mRequest = new JsonObjectRequest(Request.Method.POST,url, str, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        mQueue.add(mRequest);


    }

    @Override
    public void get(String url, String str, IHttpResultCallBack callBack) {

        mRequest = new JsonObjectRequest(Request.Method.GET, url,str, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        mQueue.add(mRequest);

    }
}
