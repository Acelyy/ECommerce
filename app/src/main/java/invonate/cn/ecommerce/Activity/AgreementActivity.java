package invonate.cn.ecommerce.Activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.handmark.pulltorefresh.library.PullToRefreshBase;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import invonate.cn.ecommerce.Adapter.AgnAdapter;
import invonate.cn.ecommerce.BaseActivity;
import invonate.cn.ecommerce.Entry.Agn;
import invonate.cn.ecommerce.R;
import invonate.cn.ecommerce.Request.Request_Agn;
import invonate.cn.ecommerce.View.LYYPullToRefreshListView;
import invonate.cn.ecommerce.YGApplication;
import invonate.cn.ecommerce.httpUtil.HttpUtil;
import rx.Subscriber;

public class AgreementActivity extends BaseActivity {
    private static final int PAGE_SIZE = 6;// 一页条数

    @BindView(R.id.list_agree)
    LYYPullToRefreshListView listAgree;

    private YGApplication app;

    private List<Agn.Rows> list_sgn;

    private AgnAdapter adapter;

    private int total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agreement);
        ButterKnife.bind(this);
        app = (YGApplication) getApplication();

        listAgree.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                get_Agn(1);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                get_Agn(adapter.getCount() / PAGE_SIZE + 1);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        get_Agn(1);
    }

    @OnClick(R.id.img_back)
    public void onViewClicked() {
        finish();
    }

    private void get_Agn(final int page) {
        Request_Agn request = new Request_Agn(app.getUser().getCustomerid(), page, PAGE_SIZE);
        Subscriber subscriber = new Subscriber<Agn>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.i("get_Agn", e.toString());
                listAgree.onRefreshComplete();
            }

            @Override
            public void onNext(Agn data) {
                Log.i("get_Agn", data.toString());
                total = data.getTotal();
                if (page == 1) {
                    list_sgn = data.getRows();
                    adapter = new AgnAdapter(list_sgn, AgreementActivity.this);
                    listAgree.setAdapter(adapter);
                } else {
                    list_sgn.addAll(data.getRows());
                    adapter.notifyDataSetChanged();
                }
                listAgree.onRefreshComplete();
                if (adapter.getCount() < total) {
                    listAgree.setMode(PullToRefreshBase.Mode.BOTH);
                } else {
                    listAgree.setMode(PullToRefreshBase.Mode.PULL_FROM_START);
                }
            }
        };
        HttpUtil.getInstance().getAgn(subscriber, JSON.toJSONString(request));
    }
}
