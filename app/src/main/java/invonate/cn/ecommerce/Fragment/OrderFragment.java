package invonate.cn.ecommerce.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.handmark.pulltorefresh.library.PullToRefreshBase;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import invonate.cn.ecommerce.Activity.CreateDeliverActivity;
import invonate.cn.ecommerce.Activity.OrderDetailActivity;
import invonate.cn.ecommerce.Adapter.OrderAdapter;
import invonate.cn.ecommerce.Entry.Order;
import invonate.cn.ecommerce.Entry.OrderSearch;
import invonate.cn.ecommerce.R;
import invonate.cn.ecommerce.Request.Request_Order;
import invonate.cn.ecommerce.View.LYYPullToRefreshListView;
import invonate.cn.ecommerce.YGApplication;
import invonate.cn.ecommerce.httpUtil.HttpUtil;
import invonate.cn.ecommerce.httpUtil.ProgressSubscriber;
import invonate.cn.ecommerce.httpUtil.SubscriberOnNextListener;
import rx.Subscriber;

/**
 * Created by liyangyang on 2017/11/3.
 */

public class OrderFragment extends Fragment {
    private static final int PAGE_SIZE = 5;

    Unbinder unbinder;
    @BindView(R.id.list_order)
    LYYPullToRefreshListView listOrder;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.btn_deliver)
    TextView btnDeliver;
    @BindView(R.id.btn_complete)
    Button btnComplete;

    private YGApplication app;

    private int total;

    private OrderAdapter adapter;

    private List<Order.Rows> list_order;

    private List<Order.Rows> list_select = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_order_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        app = (YGApplication) getActivity().getApplication();
        getOrder(1);
        listOrder.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {

            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                getOrder(1);// 获取
                btnDeliver.setText("开发货通知单");
                btnComplete.setVisibility(View.GONE);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                getOrder(adapter.getCount() / PAGE_SIZE + 1);
            }
        });
        listOrder.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (adapter.isSelect_mode()) {
                    if (adapter.getSelect_index() == -1) {
                        adapter.setSelect_index(position - 1);
                        list_order.get(position - 1).setIs_select(true);
                        list_select.add(list_order.get(position - 1));
                        adapter.notifyDataSetChanged();
                    } else {
                        if (adapter.getSelect_index() != position - 1) {
                            if (adapter.is_same(list_order.get(position - 1))) {
                                if (list_order.get(position - 1).is_select()) {
                                    list_order.get(position - 1).setIs_select(false);
                                    list_select.remove(list_order.get(position - 1));
                                } else {
                                    list_order.get(position - 1).setIs_select(true);
                                    list_select.add(list_order.get(position - 1));
                                }
                                adapter.notifyDataSetChanged();
                            } else {
                                Toast.makeText(getActivity(), "当前订单不能合并", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                } else {
                    Intent intent = new Intent(getActivity(), OrderDetailActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("id", list_order.get(position - 1).getOrderid());
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    /**
     * @param page
     */
    private void getOrder(final int page) {
        Request_Order order = new Request_Order("", "", "", "", "", app.getUser().getCustomerid(), page, PAGE_SIZE);
        Subscriber subscriber = new Subscriber<Order>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.i("getOrder", e.toString());
                listOrder.onRefreshComplete();
                Toast.makeText(getActivity(), "网络中断，请检查您的网络状态", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNext(Order data) {
                Log.i("getOrder", data.toString());
                total = data.getTotal();
                title.setText("订单-" + total + "条记录");
                if (page == 1) {
                    list_order = data.getRows();
                    adapter = new OrderAdapter(list_order, getActivity());
                    listOrder.setAdapter(adapter);
                } else {
                    list_order.addAll(data.getRows());
                    adapter.notifyDataSetChanged();
                }
                listOrder.onRefreshComplete();
                if (adapter.getCount() < total) {
                    listOrder.setMode(PullToRefreshBase.Mode.BOTH);
                } else {
                    listOrder.setMode(PullToRefreshBase.Mode.PULL_FROM_START);
                }
            }
        };
        HttpUtil.getInstance().getOrder(subscriber, JSON.toJSONString(order));
    }

    @OnClick({R.id.btn_deliver, R.id.btn_complete})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_deliver:
                if (adapter.isSelect_mode()) {
                    adapter.setSelect_mode(false);
                    btnDeliver.setText("开发货通知单");
                    btnComplete.setVisibility(View.GONE);
                    for (Order.Rows order : list_order) {
                        order.setIs_select(false);
                    }
                    adapter.setSelect_index(-1);
                } else {
                    list_select.clear();
                    adapter.setSelect_mode(true);
                    btnDeliver.setText("取消");
                    btnComplete.setVisibility(View.VISIBLE);
                }
                adapter.notifyDataSetChanged();
                break;
            case R.id.btn_complete:
                //Log.i("list",list_select.toString());
                search_order();
                break;
        }
    }


    /**
     * 获取订单信息
     */
    private void search_order() {
        List<String> list_ordernum = new ArrayList<>();
        for (Order.Rows order : list_select) {
            list_ordernum.add(order.getOrdernum());
        }

        SubscriberOnNextListener onNextListener = new SubscriberOnNextListener<OrderSearch>() {
            @Override
            public void onNext(OrderSearch data) {
                Log.i("create_order", data.toString());
                ArrayList<OrderSearch.Rows> list_order=data.getRows();
                Intent intent=new Intent(getActivity(), CreateDeliverActivity.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("list_order",list_order);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        };

        Log.i("list_num", JSON.toJSONString(list_ordernum));
        HttpUtil.getInstance().search_order(new ProgressSubscriber(onNextListener, getActivity(), "获取订单信息"), JSON.toJSONString(list_ordernum));
    }
}
