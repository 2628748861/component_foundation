package app.component.simple.view;

import app.component.simple.mvp.view.MvpView;

public interface MainContractView
{
    interface View extends MvpView
    {
        void refreshView(String data);
    }
    interface Presenter
    {
        void getDataFromNet();
    }
}
