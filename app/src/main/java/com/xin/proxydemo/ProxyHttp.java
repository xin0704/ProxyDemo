package com.xin.proxydemo;

/**
 * Created by admin on 2019/3/20.
 */

public class ProxyHttp implements IHttp {

    private IHttp iHttp;

    private static ProxyHttp proxyHttp;

    public static ProxyHttp obtain() {
        if (proxyHttp == null) {
            synchronized (ProxyHttp.class) {
                if (proxyHttp == null) {
                    proxyHttp = new ProxyHttp();
                }
            }
        }
        return proxyHttp;
    }

    public void init(IHttp iHttp) {
        this.iHttp = iHttp;
    }

    @Override
    public void post(String url, String str, IHttpResultCallBack callBack) {
        iHttp.post(url, str, callBack);
    }

    @Override
    public void get(String url, String str, IHttpResultCallBack callBack) {
        iHttp.get(url, str, callBack);
    }
}
