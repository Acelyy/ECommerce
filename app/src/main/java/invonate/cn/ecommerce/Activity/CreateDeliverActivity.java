package invonate.cn.ecommerce.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.bigkoo.pickerview.OptionsPickerView;
import com.yonggang.liyangyang.ios_dialog.widget.AlertDialog;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import invonate.cn.ecommerce.Adapter.ShoppingAdapter;
import invonate.cn.ecommerce.Adapter.ShoppingAdapter2;
import invonate.cn.ecommerce.BaseActivity;
import invonate.cn.ecommerce.Entry.Deliver_fee;
import invonate.cn.ecommerce.Entry.Deliver_way;
import invonate.cn.ecommerce.Entry.OrderSearch;
import invonate.cn.ecommerce.R;
import invonate.cn.ecommerce.Request.Request_sDeliver;
import invonate.cn.ecommerce.View.SwipeItemLayout;
import invonate.cn.ecommerce.YGApplication;
import invonate.cn.ecommerce.httpUtil.HttpUtil;
import invonate.cn.ecommerce.httpUtil.ProgressSubscriber;
import invonate.cn.ecommerce.httpUtil.SubscriberOnNextListener;

import static invonate.cn.ecommerce.Adapter.ShoppingAdapter.TYPE1;

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
    Button deliverFee;
    @BindView(R.id.deliver_way)
    Button deliverWay;
    @BindView(R.id.car_num)
    EditText carNum;
    @BindView(R.id.deliver_wharf)
    Button deliverWharf;
    @BindView(R.id.deliver_place)
    Button deliverPlace;
    @BindView(R.id.layout_ziti)
    LinearLayout layoutZiti;
    @BindView(R.id.contact)
    EditText contact;
    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.province)
    Button province;
    @BindView(R.id.city)
    Button city;
    @BindView(R.id.area)
    Button area;
    @BindView(R.id.list_goods)
    RecyclerView listGoods;

    @BindView(R.id.layout_water)
    LinearLayout layoutWater;
    @BindView(R.id.layout_place)
    LinearLayout layoutPlace;
    @BindView(R.id.gsum)
    TextView gsum;
    @BindView(R.id.sum)
    TextView sum;

    List<OrderSearch.Rows> list_order;
    private ArrayList<OrderSearch.Trans> lrows;
    private ArrayList<OrderSearch.Trans> trows;
    private ArrayList<OrderSearch.Trans> wrows;

    private YGApplication app;

    private OptionsPickerView freePicker;
    private OptionsPickerView wayPicker;

    private ShoppingAdapter2 adapter;

    private String transway = "";// 运费担当
    private String shippingtype = ""; // 承运方式

    private String deliveplace = "";// 交货地点
    private String deliveplacecode = ""; // 交货地点编号

    private String deliveport = ""; // 到港码头
    private String deliveportnum = ""; // 到港码头编号


    private String receiveno = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_deliver);
        ButterKnife.bind(this);
        app = (YGApplication) getApplication();
        list_order = (List<OrderSearch.Rows>) getIntent().getExtras().getSerializable("list_order");
        lrows = (ArrayList<OrderSearch.Trans>) getIntent().getExtras().getSerializable("lrows");
        trows = (ArrayList<OrderSearch.Trans>) getIntent().getExtras().getSerializable("lrows");
        wrows = (ArrayList<OrderSearch.Trans>) getIntent().getExtras().getSerializable("lrows");
        name.setText(app.getUser().getCustomernamecn());
        office.setText(app.getUser().getOffice());
        orderYearMonth.setText(list_order.get(0).getYearmonth());
        orderPeriod.setText(list_order.get(0).getPeriod());
        initFree();
        initWay();
        listGoods.setLayoutManager(new LinearLayoutManager(this));
        listGoods.addOnItemTouchListener(new SwipeItemLayout.OnSwipeItemTouchListener(this));
        adapter = new ShoppingAdapter2(list_order, this);
        adapter.setOnItemClickLitener(new ShoppingAdapter2.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                if (adapter.getItemViewType(position) == TYPE1) {//luo'wen螺纹钢
                    pickNum(position);
                } else {
                    inputNum(position);
                }
            }
        });
        adapter.setOnDeleteItemClickListener(new ShoppingAdapter2.OnDeleteItemClickListener() {

            @Override
            public void onDeleteItemClick(View view, int position) {
                adapter.getData().remove(position);
                adapter.notifyDataSetChanged();
                sum(false);
                if (adapter.getData().isEmpty()) {
                    finish();
                }
            }
        });
        listGoods.setAdapter(adapter);
        sum(true);
    }


    private void initFree() {
        final List<Deliver_fee> fees = new ArrayList<>();
        fees.add(new Deliver_fee("A", "自提"));
        fees.add(new Deliver_fee("B", "永联代运，代收代付运费"));
        fees.add(new Deliver_fee("C", "永联代运，客户负担运费"));

        freePicker = new OptionsPickerView.Builder(CreateDeliverActivity.this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {
                deliverFee.setText(fees.get(options1).getName());
                transway = fees.get(options1).getId();
                if (options1 == 0) {//选择自提的话，隐藏承运方式及其他信息
                    layoutZiti.setVisibility(View.GONE);
                    deliverWay.setText("请选择");

                    shippingtype = ""; // 承运方式

                    deliveplace = "";// 交货地点
                    deliveplacecode = ""; // 交货地点编号

                    deliveport = ""; // 到港码头
                    deliveportnum = ""; // 到港码头编号

                    receiveno = "";
                } else {
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

    private void initWay() {
        final List<Deliver_way> ways = new ArrayList<>();
        ways.add(new Deliver_way("T", "汽运"));
        ways.add(new Deliver_way("W", "水运"));
        ways.add(new Deliver_way("L", "联运"));

        wayPicker = new OptionsPickerView.Builder(CreateDeliverActivity.this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {
                deliverWay.setText(ways.get(options1).getName());
                if (options1 == 1) { // 水运
                    layoutWater.setVisibility(View.VISIBLE);
                    layoutPlace.setVisibility(View.GONE);

                    final OptionsPickerView pickerView = initPlace(wrows, new OptionsPickerView.OnOptionsSelectListener() {
                        @Override
                        public void onOptionsSelect(int options1, int options2, int options3, View v) {
                            deliveportnum = wrows.get(options1).getLocationno();
                            deliveport = wrows.get(options1).getRecshortname();
                            receiveno = wrows.get(options1).getRecorderno();
                        }
                    });
                    deliverWharf.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            pickerView.show();
                        }
                    });
                    deliverPlace.setOnClickListener(null);
                    deliveplace = "";
                    deliveplacecode = "";

                } else { // 非水运
                    List<OrderSearch.Trans> list = null;
                    if (options1 == 0) {
                        list = trows;
                    } else {
                        list = lrows;
                    }
                    layoutWater.setVisibility(View.GONE);
                    layoutPlace.setVisibility(View.VISIBLE);

                    final OptionsPickerView pickerView = initPlace(list, new OptionsPickerView.OnOptionsSelectListener() {
                        @Override
                        public void onOptionsSelect(int options1, int options2, int options3, View v) {
                            deliveplacecode = wrows.get(options1).getLocationno();
                            deliveplace = wrows.get(options1).getRecshortname();
                            receiveno = wrows.get(options1).getRecorderno();
                        }
                    });
                    deliverPlace.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            pickerView.show();
                        }
                    });
                    deliverWharf.setOnClickListener(null);
                    deliveport = "";
                    deliveportnum = "";
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
        wayPicker.setPicker(ways);

        deliverWay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wayPicker.show();
            }
        });
    }

    private OptionsPickerView initPlace(final List<OrderSearch.Trans> data, OptionsPickerView.OnOptionsSelectListener listener) {
        OptionsPickerView pickerView = new OptionsPickerView.Builder(CreateDeliverActivity.this, listener)
                .setCancelText("取消")
                .setSubmitText("确认")
                .setSubCalSize(25)
                .setContentTextSize(25)
                .setSubmitColor(Color.BLUE)//确定按钮文字颜色
                .setCancelColor(Color.BLUE)//取消按钮文字颜色
                .setTextColorCenter(Color.BLACK)//设置选中项的颜色
                .setTitleText("请选择运费担当")
                .build();
        pickerView.setPicker(data);
        return pickerView;
    }


    /**
     * 选择螺纹钢件数
     */
    private void pickNum(final int index) {
        final List<Integer> list_num = new ArrayList<>();
        for (int i = 1; i <= list_order.get(index).getMaxPoint(); i++) {
            list_num.add(i);
        }
        OptionsPickerView pvOptions = new OptionsPickerView.Builder(CreateDeliverActivity.this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {
                adapter.getData().get(index).setPoint(list_num.get(options1) + "");
                adapter.getData().get(index).setOrderWgt(multiply(adapter.getData().get(index).getPoint(), adapter.getData().get(index).getSingleweight()) + "");
                adapter.notifyDataSetChanged();
                sum(false);
            }
        }).setCancelText("取消")
                .setSelectOptions(Integer.parseInt(adapter.getData().get(index).getPoint()) - 1)
                .setSubmitText("确认")
                .setSubCalSize(25)
                .setContentTextSize(25)
                .setSubmitColor(Color.BLUE)//确定按钮文字颜色
                .setCancelColor(Color.BLUE)//取消按钮文字颜色
                .setTextColorCenter(Color.BLACK)//设置选中项的颜色
                .setTitleText("请选择" + adapter.getData().get(index).getProducttype2() + "件数")
                .build();
        pvOptions.setPicker(list_num);
        pvOptions.show();
    }

    /**
     * 输入数量
     *
     * @param index
     */
    private void inputNum(final int index) {
        View view = LayoutInflater.from(this).inflate(R.layout.item_input, null);
        final EditText input = view.findViewById(R.id.input);
        AlertDialog dialog = new AlertDialog(this).builder();
        dialog.setTitle("请输入数量，最大为" + list_order.get(index).getNum() + "")
                .setView(view)
                .setNegativeButton("取消", null)
                .setPositiveButton("确定", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        check(index, input.getText().toString().trim());
                    }
                }).show();
    }

    /**
     * 检查输入符合
     */

    private void check(final int index, String s) {
        if ("".equals(s)) {
            return;
        }
        try {
            double num = Double.parseDouble(s);
            if (num == 0) {
                AlertDialog dialog = new AlertDialog(this).builder();
                dialog.setTitle("数量为0，将会删除该钢材，是否确定？")
                        .setNegativeButton("取消", null)
                        .setPositiveButton("确定", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                adapter.getData().remove(index);
                                adapter.notifyDataSetChanged();
                                sum(false);
                                if (adapter.getData().isEmpty()) {
                                    finish();
                                }
                            }
                        }).show();
            }
            if (num > Double.parseDouble(list_order.get(index).getNum())) {
                Toast.makeText(app, "下单量不能大于最大量", Toast.LENGTH_SHORT).show();
                return;
            }
            adapter.getData().get(index).setOrderWgt(num + "");
            adapter.notifyDataSetChanged();
            sum(false);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    /**
     * 计算总价
     */
    private void sum(boolean first) {
        double d_sum = 0;
        double w_sum = 0;
        if (first) {
            for (int i = 0; i < adapter.getData().size(); i++) {
                if (adapter.getItemViewType(i) == ShoppingAdapter.TYPE1) { // 螺纹钢
                    d_sum = add(d_sum, multiply(multiply(adapter.getData().get(i).getSingleweight(), div(adapter.getData().get(i).getNum(), adapter.getData().get(i).getSingleweight(), 0) + "")+"",adapter.getData().get(i).getPrice()),3);
                    w_sum = add(w_sum,multiply(adapter.getData().get(i).getSingleweight(), div(adapter.getData().get(i).getNum(), adapter.getData().get(i).getSingleweight(), 0) + ""),2);
                } else {
                    d_sum = add(d_sum, multiply(adapter.getData().get(i).getPrice(), adapter.getData().get(i).getNum()),3);
                    w_sum = add(w_sum,Double.parseDouble(adapter.getData().get(i).getNum()),2);
                }
            }
        } else {
            for (OrderSearch.Rows entry : adapter.getData()) {
                d_sum = add(d_sum, (multiply(entry.getPrice(), entry.getOrderWgt())),3);
                w_sum = add(w_sum, Double.parseDouble(entry.getOrderWgt()),2);
            }
        }
        gsum.setText(String.format("%s", w_sum));
        sum.setText(String.format("%s", d_sum));
    }

    /**
     * 相乘
     *
     * @param data1
     * @param data2
     * @return
     */
    private double multiply(String data1, String data2) {
        BigDecimal bd1 = new BigDecimal(data1);
        BigDecimal bd2 = new BigDecimal(data2);
        double result = bd1.multiply(bd2).setScale(3, BigDecimal.ROUND_DOWN).doubleValue();
        Log.i("multiply", bd1 + "X" + bd2 + "=" + result);
        return result;
    }

    /**
     * 相加
     *
     * @param v1
     * @param v2
     * @return
     */
    public double add(double v1, double v2, int scale) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        double result = b1.add(b2).setScale(scale, BigDecimal.ROUND_DOWN).doubleValue();
        Log.i("add", v1 + "+" + v2 + "=" + result);
        return result;
    }

    /**
     * 相减
     *
     * @param v1
     * @param v2
     * @return
     */
    public double min(String v1, String v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        double result = b1.subtract(b2).setScale(2, BigDecimal.ROUND_DOWN).doubleValue();
        Log.i("min", v1 + "-" + v2 + "=" + result);
        return result;
    }

    /**
     * 相除
     *
     * @param data1
     * @param data2
     * @param scale
     * @return
     */
    private int div(String data1, String data2, int scale) {
        BigDecimal bd1 = new BigDecimal(data1);
        BigDecimal bd2 = new BigDecimal(data2);
        return bd1.divide(bd2, 0).setScale(scale, BigDecimal.ROUND_DOWN).intValue();
    }


    @OnClick({R.id.img_back, R.id.btn_complete, R.id.btn_cancel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.btn_complete:
                create_deliver(contact.getText().toString().trim(), phone.getText().toString().trim(), carNum.getText().toString().trim());
                break;
            case R.id.btn_cancel:
                finish();
                break;
        }
    }

    /**
     * 开发货通知单
     *
     * @param contact
     * @param phone
     * @param car
     */
    private void create_deliver(String contact, String phone, String car) {
        if ("".equals(transway)) {
            Toast.makeText(this, "请选择运费担当", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!"A".equals(transway)) {
            if ("".equals(shippingtype)) {
                Toast.makeText(this, "请选择承运方式", Toast.LENGTH_SHORT).show();
                return;
            } else {
                if ("W".equals(transway)) {
                    if ("".equals(deliveport)) {
                        Toast.makeText(this, "请选择到港码头", Toast.LENGTH_SHORT).show();
                        return;
                    }
                } else {
                    if ("".equals(deliveplace)) {
                        Toast.makeText(this, "请选择交货地点", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
            }
            if ("".equals(car)) {
                Toast.makeText(this, "请填写车船号", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        if ("".equals(contact)) {
            Toast.makeText(this, "联系人不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if ("".equals(phone)) {
            Toast.makeText(this, "联系电话不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (Double.parseDouble(gsum.getText().toString().trim())>61.5){
            Toast.makeText(this, "吨数不能超过61.5吨", Toast.LENGTH_SHORT).show();
            return;
        }
        Request_sDeliver request = new Request_sDeliver();
        if ("W".equals(transway)) {
            request.setCarnum("");
            request.setShipnum(car);//
        } else {
            request.setCarnum(car);
            request.setShipnum("");
        }
        request.setContacts(contact);
        request.setCreater(app.getUser().getContacts());
        request.setModifer(app.getUser().getContacts());
        request.setCustomerno(app.getUser().getAccountnum());
        request.setCustomerid(app.getUser().getCustomerid());
        request.setCustomernamecn(app.getUser().getCustomernamecn());
        request.setDeliveplacecode(deliveplacecode);
        request.setDeliveplace(deliveplace);
        request.setDeliveportnum(deliveportnum);//
        request.setDeliveport(deliveport);//
        request.setOffice(list_order.get(0).getOffice());
        request.setOfficenum(list_order.get(0).getOfficenum());
        request.setKhoffice(list_order.get(0).getKhoffice());
        request.setKhofficenum(list_order.get(0).getKhofficenum());
        request.setWarehouse(list_order.get(0).getWarehouse());
        request.setWarehousenum(list_order.get(0).getWarehousenum());
        request.setPhonenum(phone);
        request.setTransway(transway);
        request.setShippingtype(shippingtype);
        request.setPeriod(list_order.get(0).getPeriod());
        request.setYearmonth(list_order.get(0).getYearmonth());
        request.setReceiveno(receiveno);

        List<String> noticedetailids = new ArrayList<>();
        List<String> orderids = new ArrayList<>();
        List<String> ordernums = new ArrayList<>();
        List<String> orderdetailids = new ArrayList<>();
        List<String> producttypecodes = new ArrayList<>();
        List<String> producttypes = new ArrayList<>();
        List<String> producttype2codes = new ArrayList<>();
        List<String> producttype2s = new ArrayList<>();
        List<String> materials = new ArrayList<>();
        List<String> specs = new ArrayList<>();
        List<String> lengths = new ArrayList<>();
        List<String> plandeliqtys = new ArrayList<>();
        List<String> singleweights = new ArrayList<>();
        List<String> nums = new ArrayList<>();
        List<String> prices = new ArrayList<>();
        List<String> detailcomments = new ArrayList<>();

        for (OrderSearch.Rows entry : adapter.getData()) {
            noticedetailids.add("");
            orderids.add(entry.getOrderid());
            ordernums.add(entry.getNum());
            orderdetailids.add(entry.getOrderdetailid());
            producttypecodes.add(entry.getProducttypecode());
            producttypes.add(entry.getProducttype());
            producttype2codes.add(entry.getProducttype2code());
            producttype2s.add(entry.getProducttype2());
            materials.add(entry.getMaterial());
            specs.add(entry.getSpec());
            lengths.add(entry.getLength());
            plandeliqtys.add(entry.getPoint() == null ? "" : entry.getPoint());
            singleweights.add(entry.getSingleweight());
            nums.add(entry.getOrderWgt());
            prices.add(entry.getPrice());
            detailcomments.add("");
        }

        request.setNoticedetailids(noticedetailids);
        request.setOrderids(orderids);
        request.setOrdernums(ordernums);
        request.setOrderdetailids(orderdetailids);
        request.setProducttypes(producttypes);
        request.setProducttypecodes(producttypecodes);
        request.setProducttype2s(producttype2s);
        request.setProducttype2codes(producttype2codes);
        request.setMaterials(materials);
        request.setSpecs(specs);
        request.setLengths(lengths);
        request.setPlandeliqtys(plandeliqtys);
        request.setSingleweights(singleweights);
        request.setNums(nums);
        request.setPrices(prices);
        request.setDetailcomments(detailcomments);

        SubscriberOnNextListener onNextListener = new SubscriberOnNextListener<String>() {
            @Override
            public void onNext(String data) {
                //Log.i("create_deliver", data);
                Toast.makeText(CreateDeliverActivity.this, "开发货通知单成功", Toast.LENGTH_SHORT).show();
                finish();
            }
        };
        //System.out.println(JSON.toJSON(request));
        HttpUtil.getInstance().create_deliver(new ProgressSubscriber(onNextListener, this, "保存中"), JSON.toJSONString(request));
    }

}
