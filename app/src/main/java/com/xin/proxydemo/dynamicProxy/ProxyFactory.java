package com.xin.proxydemo.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by admin on 2019/3/20.
 */

public class ProxyFactory {

    private Object target;

    private static ProxyFactory proxyFactory;

    public static ProxyFactory obtain(){
        if (proxyFactory == null){
            synchronized (ProxyFactory.class){
                if (proxyFactory == null){
                    proxyFactory = new ProxyFactory();
                }
            }
        }
        return proxyFactory;
    }

    public void init(Object target){
        this.target = target;
    }

    public Object getProxyInstance(){

      return   Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        Object o = method.invoke(target,args);

                        return o;
                    }
                });

    }

}
