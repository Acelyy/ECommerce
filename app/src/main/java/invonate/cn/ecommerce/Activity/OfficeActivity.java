package invonate.cn.ecommerce.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.bigkoo.pickerview.OptionsPickerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import invonate.cn.ecommerce.Adapter.CartAdapter;
import invonate.cn.ecommerce.BaseActivity;
import invonate.cn.ecommerce.Entry.Distribution;
import invonate.cn.ecommerce.Entry.Filter;
import invonate.cn.ecommerce.R;
import invonate.cn.ecommerce.Request.Request_Distribution;
import invonate.cn.ecommerce.YGApplication;
import invonate.cn.ecommerce.httpUtil.HttpUtil;
import invonate.cn.ecommerce.httpUtil.ProgressSubscriber;
import invonate.cn.ecommerce.httpUtil.SubscriberOnNextListener;

public class OfficeActivity extends BaseActivity {
    @BindView(R.id.c_office)
    TextView cOffice;
    @BindView(R.id.b_office)
    Button bOffice;
    @BindView(R.id.cage)
    Button cage;
    @BindView(R.id.list_goods)
    RecyclerView listGoods;


    private YGApplication app;

    private List<Filter.Rows> list_filter;

    private List<Filter.Rows.Cage> list_cage;

    private String office;//提货办事处
    private String officenum;
    private String warehouse;// 仓库
    private String warehousenum;


    private CartAdapter adapter;

    private List<Distribution.Rows> list_distribution;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_office);
        ButterKnife.bind(this);
        app = (YGApplication) getApplication();
        listGoods.setLayoutManager(new LinearLayoutManager(this));
        list_filter = (List<Filter.Rows>) getIntent().getExtras().getSerializable("filter");
        cOffice.setText(app.getUser().getOffice());
    }


    @OnClick({R.id.search, R.id.img_back, R.id.b_office, R.id.cage, R.id.btn_complete})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.search:
                if (listGoods == null) {
                    Toast.makeText(app, "请选择提货办事处", Toast.LENGTH_SHORT).show();
                } else if (warehousenum == null) {
                    Toast.makeText(app, "请选择仓库", Toast.LENGTH_SHORT).show();
                } else {
                    getDistribution();
                }
                break;

            case R.id.img_back:
                finish();
                break;

            case R.id.b_office:
                OptionsPickerView pvOptions = new OptionsPickerView.Builder(OfficeActivity.this, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3, View v) {
                        bOffice.setText(list_filter.get(options1).getOffice());
                        list_cage = list_filter.get(options1).getList();
                        cage.setText("请选择");
                        office = list_filter.get(options1).getOffice();
                        officenum = list_filter.get(options1).getOfficenum();
                        warehousenum = null;
                        warehouse = null;
                    }
                }).setCancelText("取消")
                        .setSubmitText("确认")
                        .setSubCalSize(25)
                        .setContentTextSize(25)
                        .setSubmitColor(Color.BLUE)//确定按钮文字颜色
                        .setCancelColor(Color.BLUE)//取消按钮文字颜色
                        .setTextColorCenter(Color.BLACK)//设置选中项的颜色
                        .setTitleText("请选择提货办事处")
                        .build();
                pvOptions.setPicker(list_filter);
                pvOptions.show();
                break;

            case R.id.cage:
                if (list_cage == null) {
                    Toast.makeText(app, "请先选择提货办事处", Toast.LENGTH_SHORT).show();
                } else {
                    OptionsPickerView pvOptions2 = new OptionsPickerView.Builder(OfficeActivity.this, new OptionsPickerView.OnOptionsSelectListener() {
                        @Override
                        public void onOptionsSelect(int options1, int option2, int options3, View v) {
                            cage.setText(list_cage.get(options1).getWarehouse());
                            warehousenum = list_cage.get(options1).getWarehousenum();
                            warehouse = list_cage.get(options1).getWarehouse();
                            getDistribution();
                        }
                    }).setCancelText("取消")
                            .setSubmitText("确认")
                            .setSubCalSize(25)
                            .setContentTextSize(25)
                            .setSubmitColor(Color.BLUE)//确定按钮文字颜色
                            .setCancelColor(Color.BLUE)//取消按钮文字颜色
                            .setTextColorCenter(Color.BLACK)//设置选中项的颜色
                            .setTitleText("请选择提货仓库")
                            .build();
                    pvOptions2.setPicker(list_cage);
                    pvOptions2.show();
                }
                break;

            case R.id.btn_complete:
                ArrayList<Distribution.Rows> list_data = new ArrayList<>();
                for (Distribution.Rows entry : list_distribution) {
                    if (entry.isSelect()) {
                        list_data.add(entry);
                    }
                }
                if (!list_data.isEmpty()) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("goods", list_data);
                    bundle.putString("office", office);
                    bundle.putString("officenum", officenum);
                    bundle.putString("warehouse", warehouse);
                    bundle.putString("warehousenum", warehousenum);
                    stepActivity(bundle, CreateOrderActivity.class);
                } else {
                    Toast.makeText(app, "请至少选择一中商品", Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }

    /**
     * 获取分配量
     */
    private void getDistribution() {
        Request_Distribution request = new Request_Distribution(app.getUser().getAccountnum(), warehousenum);
        SubscriberOnNextListener onNextListener = new SubscriberOnNextListener<Distribution>() {
            @Override
            public void onNext(Distribution data) {
                Log.i("getDistribution", data.toString());
                list_distribution = data.getRows();
                adapter = new CartAdapter(list_distribution, OfficeActivity.this);
                adapter.setOnItemClickLitener(new CartAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        list_distribution.get(position).setSelect(!list_distribution.get(position).isSelect());
                        adapter.notifyDataSetChanged();
                    }
                });
                listGoods.setAdapter(adapter);
            }
        };
        HttpUtil.getInstance().getDistribution(new ProgressSubscriber(onNextListener, this, "查询中"), JSON.toJSONString(request));
    }

}
