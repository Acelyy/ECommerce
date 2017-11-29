package invonate.cn.ecommerce.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import invonate.cn.ecommerce.BaseActivity;
import invonate.cn.ecommerce.Entry.OrderSearch;
import invonate.cn.ecommerce.R;
import invonate.cn.ecommerce.YGApplication;

public class CreateDeliverActivity extends BaseActivity {

    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.office)
    TextView office;
    @BindView(R.id.order_year_month)
    TextView orderYearMonth;
    @BindView(R.id.order_period)
    TextView orderPeriod;
    @BindView(R.id.deliver_fee)
    TextView deliverFee;
    @BindView(R.id.deliver_way)
    TextView deliverWay;
    @BindView(R.id.car_num)
    TextView carNum;
    @BindView(R.id.deliver_wharf)
    TextView deliverWharf;
    @BindView(R.id.deliver_place)
    TextView deliverPlace;
    @BindView(R.id.layout_ziti)
    LinearLayout layoutZiti;
    @BindView(R.id.contact)
    TextView contact;
    @BindView(R.id.phone)
    TextView phone;
    @BindView(R.id.province)
    TextView province;
    @BindView(R.id.city)
    TextView city;
    @BindView(R.id.area)
    TextView area;
    @BindView(R.id.list_goods)
    RecyclerView listGoods;

    List<OrderSearch.Rows> list_order;

    private YGApplication app;

    private OptionsPickerView freePicker;
    private OptionsPickerView wayPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_deliver);
        ButterKnife.bind(this);
        app= (YGApplication) getApplication();
        list_order= (List<OrderSearch.Rows>) getIntent().getExtras().getSerializable("list_order");
        name.setText(app.getUser().getCustomernamecn());
        office.setText(app.getUser().getOffice());
        orderYearMonth.setText(list_order.get(0).getYearmonth());
        orderPeriod.setText(list_order.get(0).getPeriod());
        initFree();

    }

    @OnClick(R.id.img_back)
    public void onViewClicked() {
        finish();
    }


    private void initFree(){
        final List<String> fees = new ArrayList<>();
        fees.add("自提");
        fees.add("永联代运，代收代付运费");
        fees.add("永联代运，客户负担运费");

        freePicker = new OptionsPickerView.Builder(CreateDeliverActivity.this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {
                deliverFee.setText(fees.get(options1));
                if (options1==0){//选择自提的话，隐藏承运方式及其他信息
                    layoutZiti.setVisibility(View.GONE);
                    deliverWay.setText("请选择");
                }else{
                    layoutZiti.setVisibility(View.VISIBLE);
                }
            }
        }).setCancelText("取消")
                .setSubmitText("确认")
                .setSubCalSize(25)
                .setContentTextSize(25)
                .setSubmitColor(Color.BLUE)//确定按钮文字颜色
                .setCancelColor(Color.BLUE)//取消按钮文字颜色
                .setTextColorCenter(Color.BLACK)//设置选中项的颜色
                .setTitleText("请选择运费担当")
                .build();
        freePicker.setPicker(fees);

        deliverFee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                freePicker.show();
            }
        });
    }


}
