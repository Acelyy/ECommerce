package invonate.cn.ecommerce.Activity;

import android.os.Bundle;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import invonate.cn.ecommerce.BaseActivity;
import invonate.cn.ecommerce.R;
import invonate.cn.ecommerce.View.LYYPullToRefreshListView;

public class AgreementActivity extends BaseActivity {

    @BindView(R.id.list_agree)
    LYYPullToRefreshListView listAgree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agreement);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.img_back)
    public void onViewClicked() {
        finish();
    }
}
