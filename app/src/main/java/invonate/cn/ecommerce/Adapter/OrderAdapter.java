package invonate.cn.ecommerce.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import invonate.cn.ecommerce.Entry.Order;
import invonate.cn.ecommerce.R;

/**
 * Created by liyangyang on 2017/11/6.
 */

public class OrderAdapter extends BaseAdapter {
    private List<Order.Rows> data;
    private Context context;

    public int getSelect_index() {
        return select_index;
    }

    public void setSelect_index(int select_index) {
        this.select_index = select_index;
    }

    private int select_index = -1;

    public boolean isSelect_mode() {
        return select_mode;
    }

    public void setSelect_mode(boolean select_mode) {
        this.select_mode = select_mode;
    }

    private boolean select_mode;

    public OrderAdapter(List<Order.Rows> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_order, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.orderNum.setText(data.get(position).getOrdernum());
        holder.status.setText(data.get(position).getStatus());
        holder.createTime.setText(data.get(position).getCreatetime());
        holder.orderTotal.setText(data.get(position).getOrdertotal() + "");
        holder.orderAmount.setText(data.get(position).getOrderamount() + "");
        holder.salesAmount.setText(data.get(position).getSalesamount() + "");
        holder.warehouse.setText(data.get(position).getWarehouse());
        holder.freightAmount.setText(data.get(position).getFreightamount() + "");
        holder.storageAmount.setText(data.get(position).getStorageamount() + "");
        holder.yearMonth.setText(data.get(position).getYearmonth());
        holder.period.setText(data.get(position).getPeriod());
        holder.shippingType.setText(data.get(position).getShippingtype());
        if (isSelect_mode()) { // 选择模式
            if (select_index != -1) { // 非第一次选择
                holder.same.setVisibility(View.VISIBLE);
                if (position == select_index) {
                    holder.same.setText("当前订单");
                    holder.same.setTextColor(Color.parseColor("#000000"));
                } else {
                    if (is_same(data.get(position))) {
                        holder.same.setText("可合并");
                        holder.same.setTextColor(Color.parseColor("#16ADFC"));
                    } else {
                        holder.same.setText("不可合并");
                        holder.same.setTextColor(Color.parseColor("#FF0000"));
                    }
                }
            }else{
                holder.same.setVisibility(View.GONE);
            }
            if (data.get(position).is_select()){
                holder.goods_select.setImageResource(R.mipmap.pic_fselect);
            }else{
                holder.goods_select.setImageResource(R.mipmap.pic_fnoselect);
            }
        } else {
            holder.same.setVisibility(View.GONE);
        }
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.order_num)
        TextView orderNum;
        @BindView(R.id.status)
        TextView status;
        @BindView(R.id.create_time)
        TextView createTime;
        @BindView(R.id.order_total)
        TextView orderTotal;
        @BindView(R.id.order_amount)
        TextView orderAmount;
        @BindView(R.id.sales_amount)
        TextView salesAmount;
        @BindView(R.id.warehouse)
        TextView warehouse;
        @BindView(R.id.freight_amount)
        TextView freightAmount;
        @BindView(R.id.storage_amount)
        TextView storageAmount;
        @BindView(R.id.year_month)
        TextView yearMonth;
        @BindView(R.id.period)
        TextView period;
        @BindView(R.id.shipping_type)
        TextView shippingType;
        @BindView(R.id.same)
        TextView same;
        @BindView(R.id.goods_select)
        ImageView goods_select;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    /**
     * @return
     */
    public boolean is_same(Order.Rows order) {
        //if (order.getStatus()==2)
        return order.getWarehousenum().equals(data.get(select_index).getWarehousenum())
                && order.getYearmonth().equals(data.get(select_index).getYearmonth())
                && order.getPeriod().equals(data.get(select_index).getPeriod());
    }
}
