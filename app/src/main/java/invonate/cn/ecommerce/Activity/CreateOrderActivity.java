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
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.bigkoo.pickerview.OptionsPickerView;
import com.yonggang.liyangyang.ios_dialog.widget.AlertDialog;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import invonate.cn.ecommerce.Adapter.ShoppingAdapter;
import invonate.cn.ecommerce.BaseActivity;
import invonate.cn.ecommerce.Entry.Distribution;
import invonate.cn.ecommerce.Entry.Xun;
import invonate.cn.ecommerce.R;
import invonate.cn.ecommerce.Request.Request_Shop;
import invonate.cn.ecommerce.View.SwipeItemLayout;
import invonate.cn.ecommerce.YGApplication;
import invonate.cn.ecommerce.httpUtil.HttpUtil;
import invonate.cn.ecommerce.httpUtil.ProgressSubscriber;
import invonate.cn.ecommerce.httpUtil.SubscriberOnNextListener;

import static invonate.cn.ecommerce.Adapter.ShoppingAdapter.TYPE1;

public class CreateOrderActivity extends BaseActivity {

    @BindView(R.id.customername)
    TextView customername;
    @BindView(R.id.office)
    TextView office;
    @BindView(R.id.list_goods)
    RecyclerView listGoods;
    @BindView(R.id.agmonth)
    Button agmonth;
    @BindView(R.id.xun)
    Button xun;
    @BindView(R.id.gsum)
    TextView gsum;
    @BindView(R.id.sum)
    TextView sum;
    @BindView(R.id.b_office)
    TextView bOffice;
    @BindView(R.id.cage)
    TextView cage;

    private ShoppingAdapter adapter;

    ArrayList<Distribution.Rows> list_data = new ArrayList<>();

    private YGApplication app;

    private String g_office;//提货办事处
    private String g_officenum;
    private String g_warehouse;// 仓库
    private String g_warehousenum;

    private OptionsPickerView xunPicker;
    private OptionsPickerView yearPicker;

    private String period = "01";

    private String yearMonth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_order);
        ButterKnife.bind(this);
        app = (YGApplication) getApplication();
        g_office = getIntent().getExtras().getString("office");
        g_officenum = getIntent().getExtras().getString("officenum");
        g_warehouse = getIntent().getExtras().getString("warehouse");
        g_warehousenum = getIntent().getExtras().getString("warehousenum");

        list_data = (ArrayList<Distribution.Rows>) getIntent().getExtras().getSerializable("goods");
        listGoods.setLayoutManager(new LinearLayoutManager(this));
        listGoods.addOnItemTouchListener(new SwipeItemLayout.OnSwipeItemTouchListener(this));
        adapter = new ShoppingAdapter(list_data, this);
        adapter.setOnItemClickLitener(new ShoppingAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                if (adapter.getItemViewType(position) == TYPE1) {//luo'wen螺纹钢
                    pickNum(position);
                } else {
                    inputNum(position);
                }
            }
        });
        adapter.setOnDeleteItemClickListener(new ShoppingAdapter.OnDeleteItemClickListener() {
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

        customername.setText(app.getUser().getCustomernamecn());
        office.setText(app.getUser().getOffice());
        bOffice.setText(g_office);
        cage.setText(g_warehouse);
        xun.setText("上旬");
        initPicker();
        createPicker();

    }

    @Override
    protected void onResume() {
        super.onResume();
        sum(true);
    }

    @OnClick({R.id.img_back, R.id.btn_complete, R.id.btn_cancel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.btn_complete:
                create_order();
                break;
            case R.id.btn_cancel:
                finish();
                break;
        }
    }

    /**
     * 选择螺纹钢件数
     */
    private void pickNum(final int index) {
        final List<Integer> list_num = new ArrayList<>();
        for (int i = 1; i <= list_data.get(index).getMaxPoint(); i++) {
            list_num.add(i);
        }
        OptionsPickerView pvOptions = new OptionsPickerView.Builder(CreateOrderActivity.this, new OptionsPickerView.OnOptionsSelectListener() {
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
        dialog.setTitle("请输入数量，最大为" + list_data.get(index).getSumMax() + "")
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
     * 检查输入复合
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
            if (num > Double.parseDouble(list_data.get(index).getSumMax())) {
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
        if (first) {
            for (int i = 0; i < adapter.getData().size(); i++) {
                if (adapter.getItemViewType(i) == ShoppingAdapter.TYPE1) { // 螺纹钢
                    d_sum = add(d_sum, multiply(multiply(adapter.getData().get(i).getSingleweight(), div(adapter.getData().get(i).getSumMax(), adapter.getData().get(i).getSingleweight(), 0) + "")+"",adapter.getData().get(i).getPrice()));
                } else {
                    d_sum = add(d_sum, multiply(adapter.getData().get(i).getPrice(), min(adapter.getData().get(i).getTotalWgt(), adapter.getData().get(i).getNum()) + ""));
                }
            }
        } else {
            for (Distribution.Rows entry : adapter.getData()) {
                d_sum = add(d_sum, (multiply(entry.getPrice(), entry.getOrderWgt())));
            }
        }
        gsum.setText(String.format("%s", d_sum));
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
    public double add(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        double result = b1.add(b2).setScale(2, BigDecimal.ROUND_DOWN).doubleValue();
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

    /**
     * 下单
     */
    private void create_order() {
        if (adapter.getData().isEmpty()) {
            Toast.makeText(app, "请至少选择一样钢材", Toast.LENGTH_SHORT).show();
            return;
        }
        List<String> producttypes = new ArrayList<>();
        List<String> producttype2s = new ArrayList<>();
        List<String> materials = new ArrayList<>();
        List<String> specs = new ArrayList<>();
        List<String> lengths = new ArrayList<>();
        List<String> plandeliqtys = new ArrayList<>();
        List<String> singleweights = new ArrayList<>();
        List<String> nums = new ArrayList<>();
        List<String> prices = new ArrayList<>();
        List<String> detailcomments = new ArrayList<>();
        List<String> resourcedetailids = new ArrayList<>();

        Request_Shop request = new Request_Shop();
        request.setCustomerid(app.getUser().getCustomerid());
        request.setYearmonth(yearMonth);
        request.setPeriod(period);
        request.setWarehouse(g_warehouse);
        request.setWarehousenum(g_warehousenum);
        request.setKhoffice(app.getUser().getOffice());
        request.setKhofficenum(app.getUser().getOfficenum());
        request.setOffice(g_office);
        request.setOfficenum(g_officenum);
        request.setCreater(app.getUser().getContacts());
        request.setIscustorder("1");

        for (Distribution.Rows entry : adapter.getData()) {
            producttypes.add("A|" + entry.getProducttype());
            String name = entry.getProducttype2();
            if (name.equals("螺纹钢")) {
                producttype2s.add("01|" + entry.getProducttype2());
            } else if (name.equals("线盘")) {
                producttype2s.add("02|" + entry.getProducttype2());
            }
            materials.add(entry.getMaterial());
            specs.add(entry.getSpec());
            lengths.add(entry.getLength());
            plandeliqtys.add(entry.getPoint() == null ? "" : entry.getPoint());
            singleweights.add(entry.getSingleweight());
            nums.add(entry.getOrderWgt());
            prices.add(entry.getPrice());
            detailcomments.add("");
            resourcedetailids.add(entry.getCustdistribId());
        }
        request.setProducttypes(producttypes);
        request.setProducttype2s(producttype2s);
        request.setMaterials(materials);
        request.setSpecs(specs);
        request.setLengths(lengths);
        request.setPlandeliqtys(plandeliqtys);
        request.setSingleweights(singleweights);
        request.setNums(nums);
        request.setPrices(prices);
        request.setDetailcomments(detailcomments);
        request.setResourcedetailids(resourcedetailids);

        Log.i("params", JSON.toJSONString(request));
        SubscriberOnNextListener onNextListener = new SubscriberOnNextListener<String>() {
            @Override
            public void onNext(String data) {
                Log.i("create_order", data);
                Toast.makeText(app, "下单成功", Toast.LENGTH_SHORT).show();
                finish();
            }
        };
        HttpUtil.getInstance().create_order(new ProgressSubscriber(onNextListener, this, "提交中"), JSON.toJSONString(request));
    }

    /**
     *
     */
    private void createPicker() {
        final List<String> list_year = new ArrayList<>();


        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");//定义日期显示格式

        yearMonth = sdf.format(new Date());
        agmonth.setText(yearMonth);
        for (int i = -1; i < 2; i++) {
            Date date = new Date();
            date.setMonth(date.getMonth() + i);
            list_year.add(sdf.format(date));
        }
        yearPicker = new OptionsPickerView.Builder(CreateOrderActivity.this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {
                yearMonth = list_year.get(options1);
                agmonth.setText(yearMonth);
            }
        }).setCancelText("取消")
                .setSubmitText("确认")
                .setSubCalSize(25)
                .setContentTextSize(25)
                .setSubmitColor(Color.BLUE)//确定按钮文字颜色
                .setCancelColor(Color.BLUE)//取消按钮文字颜色
                .setTextColorCenter(Color.BLACK)//设置选中项的颜色
                .setTitleText("")
                .build();
        yearPicker.setPicker(list_year);

        agmonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yearPicker.show();
            }
        });
    }

    /**
     *
     */
    private void initPicker() {
        final List<Xun> xuns = new ArrayList<>();
        xuns.add(new Xun("01", "上旬"));
        xuns.add(new Xun("02", "中旬"));
        xuns.add(new Xun("03", "下旬"));

        xunPicker = new OptionsPickerView.Builder(CreateOrderActivity.this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {
                period = xuns.get(options1).getId();
                xun.setText(xuns.get(options1).getName());
            }
        }).setCancelText("取消")
                .setSubmitText("确认")
                .setSubCalSize(25)
                .setContentTextSize(25)
                .setSubmitColor(Color.BLUE)//确定按钮文字颜色
                .setCancelColor(Color.BLUE)//取消按钮文字颜色
                .setTextColorCenter(Color.BLACK)//设置选中项的颜色
                .setTitleText("")
                .build();
        xunPicker.setPicker(xuns);

        xun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xunPicker.show();
            }
        });
    }

}
