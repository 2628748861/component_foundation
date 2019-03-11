package app.component.simple.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import app.component.simple.R;
import app.component.simple.mvp.activity.BaseMvpActivity;
import app.component.simple.presenter.MainPresenter;
import app.component.simple.view.MainContractView;
import butterknife.BindView;
import ezy.ui.layout.LoadingLayout;

public class MainActivity extends BaseMvpActivity<MainPresenter> implements MainContractView.View
{
    @BindView(R.id.loadingLayout)
    LoadingLayout loadingLayout;
    @BindView(R.id.contentTextView)
    TextView contentTextView;

    @Override
    public int applyContent() {
        return R.layout.simple_activity_main;
    }

    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadingLayout.setRetryListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.getDataFromNet();
            }
        });
        p.getDataFromNet();
    }

    @Override
    public void refreshView(String data) {
        showContent();
        contentTextView.setText(data);
    }
}
