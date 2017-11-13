package invonate.cn.ecommerce.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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
    private LayoutInflater inflater;

    public OrderAdapter(List<Order.Rows> data, Context context) {
        this.data = data;
        this.inflater = LayoutInflater.from(context);
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
            convertView = inflater.inflate(R.layout.item_order, null);
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
        holder.freightAmount.setText(data.get(position).getFreightamount() + "");
        holder.storageAmount.setText(data.get(position).getStorageamount() + "");
        holder.yearMonth.setText(data.get(position).getYearmonth());
        holder.period.setText(data.get(position).getPeriod());
        holder.shippingType.setText(data.get(position).getShippingtype());

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

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
