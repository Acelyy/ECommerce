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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.handmark.pulltorefresh.library.PullToRefreshBase;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import invonate.cn.ecommerce.Activity.OrderDetailActivity;
import invonate.cn.ecommerce.Adapter.OrderAdapter;
import invonate.cn.ecommerce.Entry.Order;
import invonate.cn.ecommerce.R;
import invonate.cn.ecommerce.Request.Request_Order;
import invonate.cn.ecommerce.View.LYYPullToRefreshListView;
import invonate.cn.ecommerce.YGApplication;
import invonate.cn.ecommerce.httpUtil.HttpUtil;
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

    private YGApplication app;

    private int total;

    private OrderAdapter adapter;

    private List<Order.Rows> list_order;

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
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                getOrder(adapter.getCount() / PAGE_SIZE + 1);
            }
        });
        listOrder.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), OrderDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("id", list_order.get(position - 1).getOrderid());
                intent.putExtras(bundle);
                startActivity(intent);
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
}
