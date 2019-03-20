# ProxyDemo


## 代理
代理，是一种设计模式，提供了对目标对象的另外一种访问方式。即通过代理对象去访问目标对象</br>
举个例子：女生 通过 某位代购 去购买某国际知名品牌化妆品</br></br>

## 优点

可以在目标对象实现的基础上，增加额外的功能操作，即扩展目标对象功能</br></br>

## 描述
本demo通过代理模式，实现了volley和okhttp网络请求库的无缝切换。只需将Application中的ProxyHttp.obtain().init(new VolleyUtil())和 ProxyHttp.obtain().init(new OkHttpUtil())相互切换就行了，就不需要去强行改动VolleyUtil或者OkHttpUtil中的大量代码
