package com.xin.proxydemo.common;

/**
 * Created by admin on 2019/3/20.
 */

public interface IHttpResultCallBack {

    void onSuccess(String data);

    void onError(String msg);

}
