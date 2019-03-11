package app.component.simple.mvp.presenter;

import android.content.Context;


import app.component.simple.mvp.view.MvpView;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by cample on 2018/5/12.
 */
public abstract class MvpPresenter<V extends MvpView>{
    protected V v;
    protected Context mContext;
    protected CompositeDisposable compositeDisposable=new CompositeDisposable();
    public MvpPresenter(V v) {
        this.v = v;
    }
    public void onDetach()
    {
        this.compositeDisposable.clear();
        this.compositeDisposable=null;
        this.v=null;
        this.mContext=null;
    }
}
