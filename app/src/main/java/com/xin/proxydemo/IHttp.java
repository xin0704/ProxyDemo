package com.xin.proxydemo;

/**
 * Created by admin on 2019/3/20.
 */

public interface IHttp {

    /**
     *
     * @param url 请求地址
     * @param str 参数
     * @param callBack 请求回调
     */
    void post(String url,String str,IHttpResultCallBack callBack);

    /**
     *
     * @param url 请求地址
     * @param str 参数
     * @param callBack 请求回调
     */
    void get(String url,String str,IHttpResultCallBack callBack);

}
