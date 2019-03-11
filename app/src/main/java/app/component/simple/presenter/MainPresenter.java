package app.component.simple.presenter;

import android.util.Log;

import app.component.simple.IUserService;
import app.component.simple.http.HttpApiProxy;
import app.component.simple.http.entity.BaseResponseEntity;
import app.component.simple.http.response.AppResultObservable;
import app.component.simple.mvp.presenter.MvpPresenter;
import app.component.simple.util.RxUtils;
import app.component.simple.view.MainContractView;
import me.jessyan.retrofiturlmanager.RetrofitUrlManager;

public class MainPresenter extends MvpPresenter<MainContractView.View> implements MainContractView.Presenter
{
    public MainPresenter(MainContractView.View view) {
        super(view);
    }

    @Override
    public void getDataFromNet() {
        RetrofitUrlManager.getInstance().putDomain("domain", "http://192.168.1.52");
        HttpApiProxy.getInstance()
                .create(IUserService.class)
                .getArticleCategory()
                .compose(RxUtils.<BaseResponseEntity<String>>schedulerWithPanel(compositeDisposable,v))
                .subscribe(new AppResultObservable<BaseResponseEntity<String>>() {

                               @Override
                               public void onSuccess(BaseResponseEntity<String> stringBaseResponseEntity) {
                                   Log.e("TAG",stringBaseResponseEntity.getMsg());
                                   v.refreshView(stringBaseResponseEntity.getData());
                               }

                               @Override
                               public void onErrors(String msg) {
                                   Log.e("TAG",msg);
                                   v.showTip(msg);
                                   v.showError();
                               }
                           }
                );
    }
}
