package invonate.cn.ecommerce.Activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import invonate.cn.ecommerce.Adapter.GoodsAdapter;
import invonate.cn.ecommerce.BaseActivity;
import invonate.cn.ecommerce.Entry.DeliverDetail;
import invonate.cn.ecommerce.R;
import invonate.cn.ecommerce.Request.Request_DeliverDetail;
import invonate.cn.ecommerce.httpUtil.HttpUtil;
import rx.Subscriber;

public class DeliverDetailActivity extends BaseActivity {

    @BindView(R.id.order_id)
    TextView orderId;
    @BindView(R.id.order_time)
    TextView orderTime;
    @BindView(R.id.list_goods)
    RecyclerView listGoods;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;
    @BindView(R.id.order_year_month)
    TextView orderYearMonth;
    @BindView(R.id.order_period)
    TextView orderPeriod;
    @BindView(R.id.order_transway)
    TextView orderTransway;
    @BindView(R.id.order_customernamecn)
    TextView orderCustomernamecn;
    @BindView(R.id.order_office)
    TextView orderOffice;
    @BindView(R.id.order_warehouse)
    TextView orderWarehouse;
    @BindView(R.id.order_deliveport)
    TextView orderDeliveport;
    @BindView(R.id.order_carnum)
    TextView orderCarnum;
    @BindView(R.id.order_contacts)
    TextView orderContacts;
    @BindView(R.id.order_phonenum)
    TextView orderPhonenum;
    @BindView(R.id.layout_deliver)
    LinearLayout layoutDeliver;
    private String noticeid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deliver_detail);
        ButterKnife.bind(this);
        noticeid = getIntent().getExtras().getString("id");
        getDeliverDetail(noticeid);
        refresh.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light, android.R.color.holo_orange_light);
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getDeliverDetail(noticeid);
            }
        });
        listGoods.setLayoutManager(new LinearLayoutManager(this));
    }

    /**
     * 获取发货通知单详情
     *
     * @param id
     */
    private void getDeliverDetail(String id) {
        Request_DeliverDetail request = new Request_DeliverDetail(id);
        Subscriber subscriber = new Subscriber<DeliverDetail>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.i("error", e.toString());
                refresh.setRefreshing(false);
            }

            @Override
            public void onNext(DeliverDetail data) {
                Log.i("getDeliverDetail", data.toString());
                setValue(data.getNotice());
                listGoods.setAdapter(new GoodsAdapter(data.getNoticeDetailList(), DeliverDetailActivity.this));
                refresh.setRefreshing(false);
            }
        };
        HttpUtil.getInstance().getDeliverDetail(subscriber, JSON.toJSONString(request));
    }

    @OnClick(R.id.img_back)
    public void onViewClicked() {
        finish();
    }

    /**
     * 设置信息
     *
     * @param notice
     */
    private void setValue(DeliverDetail.Notice notice) {
        orderId.setVisibility(View.VISIBLE);
        orderId.setText("订单编号：" + notice.getNoticeno());
        orderTime.setVisibility(View.VISIBLE);
        orderTime.setText("提交时间：" + notice.getCreatetime());
        orderCustomernamecn.setText(notice.getCustomernamecn());
        orderYearMonth.setText(notice.getYearmonth());
        orderPeriod.setText(notice.getPeriod());
        orderWarehouse.setText(notice.getWarehouse());
        orderOffice.setText(notice.getOffice());
        orderDeliveport.setText(notice.getDeliveport());
        orderCarnum.setText(notice.getCarnum());
        orderContacts.setText(notice.getContacts());
        orderPhonenum.setText(notice.getPhonenum());
        orderTransway.setText(notice.getTransway());
        layoutDeliver.setVisibility(View.VISIBLE);
    }

}
