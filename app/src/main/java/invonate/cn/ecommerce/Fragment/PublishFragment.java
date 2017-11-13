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
import invonate.cn.ecommerce.Activity.DeliverDetailActivity;
import invonate.cn.ecommerce.Adapter.DeliverAdapter;
import invonate.cn.ecommerce.Entry.Deliver;
import invonate.cn.ecommerce.R;
import invonate.cn.ecommerce.Request.Request_Deliver;
import invonate.cn.ecommerce.View.LYYPullToRefreshListView;
import invonate.cn.ecommerce.YGApplication;
import invonate.cn.ecommerce.httpUtil.HttpUtil;
import rx.Subscriber;

/**
 * Created by liyangyang on 2017/11/3.
 */

public class PublishFragment extends Fragment {
    public final static int PAGE_SIZE = 5;

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.list_deliver)
    LYYPullToRefreshListView listDeliver;
    Unbinder unbinder;

    private YGApplication app;

    private DeliverAdapter adapter;

    private List<Deliver.Rows> list_deliver;

    private int total;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_publish_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        app = (YGApplication) getActivity().getApplication();
        getDeliver(1);
        listDeliver.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                getDeliver(1);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                getDeliver(adapter.getCount() / PAGE_SIZE + 1);
            }
        });
        listDeliver.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), DeliverDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("id", list_deliver.get(position - 1).getNoticeid());
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
     * 获取
     *
     * @param page
     */
    private void getDeliver(final int page) {
        Request_Deliver request = new Request_Deliver(app.getUser().getCustomerid(), page, PAGE_SIZE);
        Subscriber subscriber = new Subscriber<Deliver>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.i("error", e.toString());
                listDeliver.onRefreshComplete();
                Toast.makeText(getActivity(), "网络中断，请检查您的网络状态", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNext(Deliver data) {
                Log.i("getDeliver", data.toString());
                total = data.getTotal();
                title.setText("发货通知单-" + total + "条记录");
                if (page == 1) {
                    list_deliver = data.getRows();
                    adapter = new DeliverAdapter(list_deliver, getActivity());
                    listDeliver.setAdapter(adapter);
                } else {
                    list_deliver.addAll(data.getRows());
                    adapter.notifyDataSetChanged();
                }
                listDeliver.onRefreshComplete();
                if (adapter.getCount() < total) {
                    listDeliver.setMode(PullToRefreshBase.Mode.BOTH);
                } else {
                    listDeliver.setMode(PullToRefreshBase.Mode.PULL_FROM_START);
                }

            }
        };
        HttpUtil.getInstance().getDeliver(subscriber, JSON.toJSONString(request));
    }
}
