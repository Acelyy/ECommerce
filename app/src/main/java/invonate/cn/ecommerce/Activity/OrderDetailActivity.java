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
import invonate.cn.ecommerce.Adapter.FeeAdapter;
import invonate.cn.ecommerce.Adapter.GoodsAdapter;
import invonate.cn.ecommerce.BaseActivity;
import invonate.cn.ecommerce.Entry.OrderDetail;
import invonate.cn.ecommerce.R;
import invonate.cn.ecommerce.Request.Request_OrderDetail;
import invonate.cn.ecommerce.httpUtil.HttpUtil;
import rx.Subscriber;

public class OrderDetailActivity extends BaseActivity {

    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;
    @BindView(R.id.order_id)
    TextView orderId;
    @BindView(R.id.order_time)
    TextView orderTime;
    @BindView(R.id.list_goods)
    RecyclerView listGoods;
    @BindView(R.id.list_fee)
    RecyclerView listFee;
    @BindView(R.id.order_count)
    TextView orderCount;
    @BindView(R.id.order_sum)
    TextView orderSum;

    @BindView(R.id.order_customernamecn)
    TextView orderCustomernamecn;
    @BindView(R.id.order_year_month)
    TextView orderYearMonth;
    @BindView(R.id.order_period)
    TextView orderPeriod;
    @BindView(R.id.order_shippingtype)
    TextView orderShippingtype;
    @BindView(R.id.order_freightamount)
    TextView orderFreightamount;
    @BindView(R.id.order_storageamount)
    TextView orderStorageamount;
    @BindView(R.id.order_warehouse)
    TextView orderWarehouse;
    @BindView(R.id.order_office)
    TextView orderOffice;
    @BindView(R.id.order_deliveport)
    TextView orderDeliveport;
    @BindView(R.id.order_carnum)
    TextView orderCarnum;
    @BindView(R.id.order_contacts)
    TextView orderContacts;
    @BindView(R.id.order_phonenum)
    TextView orderPhonenum;
    @BindView(R.id.order_deliveplace)
    TextView orderDeliveplace;
    @BindView(R.id.order_comment)
    TextView orderComment;
    @BindView(R.id.layout_deliver)
    LinearLayout layoutDeliver;
    private String order_id;//订单号


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        ButterKnife.bind(this);
        order_id = getIntent().getExtras().getString("id");
        refresh.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light, android.R.color.holo_orange_light);
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getOrderDetail();
            }
        });
        listGoods.setLayoutManager(new LinearLayoutManager(this));
        listFee.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onResume() {
        super.onResume();
        //进入界面主动刷新一次
        getOrderDetail();

    }

    /**
     * 获取订单详情
     */
    private void getOrderDetail() {
        Request_OrderDetail orderDeatil = new Request_OrderDetail(order_id);
        Subscriber subscriber = new Subscriber<OrderDetail>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                refresh.setRefreshing(false);
                Log.i("error", e.toString());
            }

            @Override
            public void onNext(OrderDetail data) {
                Log.i("getOrderDetail", data.toString());
                setValue(data.getResource());
                listGoods.setAdapter(new GoodsAdapter(data.getOrderdetailList(), OrderDetailActivity.this));
                listFee.setAdapter(new FeeAdapter(data.getKkdetailList(), OrderDetailActivity.this));
                refresh.setRefreshing(false);
            }
        };
        HttpUtil.getInstance().getOrderDetail(subscriber, JSON.toJSONString(orderDeatil));
    }

    /**
     * 设置信息
     *
     * @param resource
     */
    private void setValue(OrderDetail.Resource resource) {
        orderId.setVisibility(View.VISIBLE);
        orderId.setText("订单编号：" + resource.getOrdernum());
        orderTime.setVisibility(View.VISIBLE);
        orderTime.setText("提交时间：" + resource.getCreatetime());
        orderCount.setText(resource.getOrdertotal() + "");
        orderSum.setText(resource.getOrderamount() + "");

        orderCustomernamecn.setText(resource.getCustomernamecn());
        orderYearMonth.setText(resource.getYearmonth());
        orderPeriod.setText(resource.getPeriod());
        orderShippingtype.setText(resource.getShippingtype());
        orderFreightamount.setText(resource.getFreightamount() + "");
        orderStorageamount.setText(resource.getStorageamount() + "");
        orderWarehouse.setText(resource.getWarehouse());
        orderOffice.setText(resource.getOffice());
        orderDeliveport.setText(resource.getDeliveport());
        orderCarnum.setText(resource.getCarnum());
        orderContacts.setText(resource.getContacts());
        orderPhonenum.setText(resource.getPhonenum());
        orderDeliveplace.setText(resource.getDeliveplace());
        orderComment.setText(resource.getComment());
        layoutDeliver.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.img_back)
    public void onViewClicked() {
        finish();
    }
}
