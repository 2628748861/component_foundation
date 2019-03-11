package app.component.simple.mvp.fragment;


import app.component.simple.mvp.presenter.MvpPresenter;
import app.component.simple.mvp.view.MvpView;
import app.component.simple.mvp.view.delegate.DefaultViewDelegateImp;

public abstract class BaseMvpFragment<Presenter extends MvpPresenter> extends MvpFragment<Presenter> {
    @Override
    protected MvpView applyViewDelegate() {
        return new DefaultViewDelegateImp(this,getContentView());
    }
}
