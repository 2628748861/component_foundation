package app.component.simple;

import android.app.Application;

import java.util.List;

import okhttp3.Interceptor;

/**
 * module初始化相关行为抽取
 */
public interface IModuleConfiguration {
    /**
     * 向向主工程中添加Application生命周期管理.
     * 考虑到Application初始化可能涉及很多代码,阅读性会很差.这里我们可以创建多个实现：比如推送,分享,Bugly...
     * 那么我们可以分别创建对应的实现类(PushApplicationLifeCycle:做push相关初始化及逻辑, ShareApplicationLifeCycle:做share相关初始化及逻辑...最后都一一添加到集合中去)
     */
    void injectApplifeCycle(List<IApplifeCycle> applifeCycles);

    /**向主工程中添加Activity生命周期管理
     * @param lifecycles
     */
    void injectActivityLifecycle(List<Application.ActivityLifecycleCallbacks> lifecycles);


    /**添加http拦截器
     * @param interceptors
     */
    void injectHttpInterceptor(List<Interceptor> interceptors);

}
