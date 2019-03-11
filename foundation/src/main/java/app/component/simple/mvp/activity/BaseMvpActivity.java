package app.component.simple.mvp.activity;

import app.component.simple.mvp.presenter.MvpPresenter;
import app.component.simple.mvp.view.MvpView;
import app.component.simple.mvp.view.delegate.DefaultViewDelegateImp;

public abstract class BaseMvpActivity<Presenter extends MvpPresenter> extends MvpActivity<Presenter> {
    @Override
    protected MvpView applyViewDelegate() {
        return new DefaultViewDelegateImp(this,contentView);
    }
}
