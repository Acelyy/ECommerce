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
import invonate.cn.ecommerce.Entry.Deliver;
import invonate.cn.ecommerce.R;

/**
 * Created by liyangyang on 2017/11/7.
 */

public class DeliverAdapter extends BaseAdapter {
    private List<Deliver.Rows> data;
    private LayoutInflater inflater;

    public DeliverAdapter(List<Deliver.Rows> data, Context context) {
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
            convertView = inflater.inflate(R.layout.item_deliver, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.deliverCustomernamecn.setText(data.get(position).getCustomernamecn());
        holder.deliverDate.setText(data.get(position).getNoticedate());
        holder.deliverNum.setText(data.get(position).getNoticeno());
        holder.deliverStatus.setText(data.get(position).getStatus());
        return convertView;
    }


    static class ViewHolder {
        @BindView(R.id.deliver_num)
        TextView deliverNum;
        @BindView(R.id.deliver_date)
        TextView deliverDate;
        @BindView(R.id.deliver_customernamecn)
        TextView deliverCustomernamecn;
        @BindView(R.id.deliver_status)
        TextView deliverStatus;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
