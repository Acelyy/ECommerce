package invonate.cn.ecommerce.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.yonggang.liyangyang.ios_dialog.widget.AlertDialog;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import invonate.cn.ecommerce.Activity.LoginActivity;
import invonate.cn.ecommerce.Activity.PersonnalActivity;
import invonate.cn.ecommerce.Adapter.AccountAdapter;
import invonate.cn.ecommerce.R;
import invonate.cn.ecommerce.Request.Request_Account;
import invonate.cn.ecommerce.Util.SPUtil;
import invonate.cn.ecommerce.View.RiseNumberTextView;
import invonate.cn.ecommerce.YGApplication;
import invonate.cn.ecommerce.httpUtil.Account;
import invonate.cn.ecommerce.httpUtil.HttpUtil;
import rx.Subscriber;

/**
 * Created by liyangyang on 2017/11/3.
 */

public class MineFragment extends Fragment {

    @BindView(R.id.txt_name)
    TextView txtName;
    @BindView(R.id.txt_com)
    TextView txtCom;
    @BindView(R.id.txt_time)
    TextView txtTime;
    @BindView(R.id.customerrationsnum)
    RiseNumberTextView customerrationsnum;
    @BindView(R.id.customerrationsnum2)
    RiseNumberTextView customerrationsnum2;
    @BindView(R.id.customerrationsnum3)
    RiseNumberTextView customerrationsnum3;
    @BindView(R.id.list_account)
    RecyclerView listAccount;
    Unbinder unbinder;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;
    private YGApplication app;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_mine_fragment, container, false);
        app = (YGApplication) getActivity().getApplication();
        unbinder = ButterKnife.bind(this, view);
        listAccount.setLayoutManager(new LinearLayoutManager(getActivity()));
        getAccount();
        txtName.setText(app.getUser().getCustomernamecn());
        txtCom.setText("所属办事处：" + app.getUser().getOffice());
        //设置卷内的颜色
        refresh.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light, android.R.color.holo_orange_light);
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getAccount();
            }
        });
        return view;
    }


    /**
     * 获取账号信息
     */
    private void getAccount() {
        Request_Account account = new Request_Account(app.getUser().getCustomerid());
        Subscriber subscriber = new Subscriber<Account>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.i("error", e.toString());
                refresh.setRefreshing(false);
            }

            @Override
            public void onNext(Account data) {
                Log.i("getAccount", data.toString());
                customerrationsnum.withNumber(data.getCustinfo().getCustomerrationsnum()).start();
                customerrationsnum2.withNumber(data.getCustinfo().getCustomerrationsnum2()).start();
                customerrationsnum3.withNumber(data.getCustinfo().getCustomerrationsnum3()).start();
                listAccount.setAdapter(new AccountAdapter(data.getNoticeDetailList(), getActivity()));
                setDate();
                refresh.setRefreshing(false);
            }
        };
        HttpUtil.getInstance().getAccount(subscriber, JSON.toJSONString(account));
    }

    /**
     * 设置当前日期
     */
    private void setDate() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 EEEE", Locale.CHINA);
        txtTime.setText(sdf.format(date));
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.layout_account, R.id.layout_xyl, R.id.btn_exit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.layout_account:
                Intent intent = new Intent(getActivity(), PersonnalActivity.class);
                startActivity(intent);
                break;
            case R.id.layout_xyl:
                break;
            case R.id.btn_exit:
                AlertDialog dialog = new AlertDialog(getActivity()).builder();
                dialog.setTitle("确认退出当前账号？")
                        .setPositiveButton("确认", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                exit();
                            }
                        }).setNegativeButton("取消", null)
                        .show();
                break;
        }
    }

    /**
     * 退出当前账号
     */
    private void exit() {
        app.setUser(null);
        SPUtil.setSharedUser("", "", getActivity());
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
        getActivity().finish();
    }
}
