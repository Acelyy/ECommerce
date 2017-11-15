package invonate.cn.ecommerce.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import invonate.cn.ecommerce.Entry.Agn;
import invonate.cn.ecommerce.R;

/**
 * Created by liyangyang on 2017/11/15.
 */

public class AgnAdapter extends BaseAdapter {
    private List<Agn.Rows> data;
    private LayoutInflater inflater;

    public AgnAdapter(List<Agn.Rows> data, Context context) {
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
        ViewHolder holder=null;
        if (convertView==null){
            convertView = inflater.inflate(R.layout.item_agn, parent, false);
            holder=new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        holder.agmonth.setText(data.get(position).getAgmonth());
        holder.wgtuhrb.setText(data.get(position).getWgtuhrb());
        holder.uuhrb.setText(data.get(position).getUuhrb());
        holder.uremainhrb.setText(data.get(position).getUremainhrb());
        holder.wgtdhrb.setText(data.get(position).getWgtdhrb());
        holder.ddhrb.setText(data.get(position).getDdhrb());
        holder.dremainhrb.setText(data.get(position).getDremainhrb());
        holder.wgtxhrb.setText(data.get(position).getWgtxhrb());
        holder.xxhrb.setText(data.get(position).getXxhrb());
        holder.xremainhrb.setText(data.get(position).getXremainhrb());
        holder.wgtuswr.setText(data.get(position).getWgtuswr());
        holder.uuswr.setText(data.get(position).getUuswr());
        holder.uremainswr.setText(data.get(position).getUremainswr());
        holder.wgtdswr.setText(data.get(position).getWgtdswr());
        holder.ddswr.setText(data.get(position).getDdswr());
        holder.dremainswr.setText(data.get(position).getDremainswr());
        holder.wgtxswr.setText(data.get(position).getWgtxswr());
        holder.xxswr.setText(data.get(position).getXxswr());
        holder.xremainswr.setText(data.get(position).getXremainswr());
        AutoUtils.autoSize(convertView);
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.agmonth)
        TextView agmonth;
        @BindView(R.id.wgtuhrb)
        TextView wgtuhrb;
        @BindView(R.id.uuhrb)
        TextView uuhrb;
        @BindView(R.id.uremainhrb)
        TextView uremainhrb;
        @BindView(R.id.wgtdhrb)
        TextView wgtdhrb;
        @BindView(R.id.ddhrb)
        TextView ddhrb;
        @BindView(R.id.dremainhrb)
        TextView dremainhrb;
        @BindView(R.id.wgtxhrb)
        TextView wgtxhrb;
        @BindView(R.id.xxhrb)
        TextView xxhrb;
        @BindView(R.id.xremainhrb)
        TextView xremainhrb;
        @BindView(R.id.wgtuswr)
        TextView wgtuswr;
        @BindView(R.id.uuswr)
        TextView uuswr;
        @BindView(R.id.uremainswr)
        TextView uremainswr;
        @BindView(R.id.wgtdswr)
        TextView wgtdswr;
        @BindView(R.id.ddswr)
        TextView ddswr;
        @BindView(R.id.dremainswr)
        TextView dremainswr;
        @BindView(R.id.wgtxswr)
        TextView wgtxswr;
        @BindView(R.id.xxswr)
        TextView xxswr;
        @BindView(R.id.xremainswr)
        TextView xremainswr;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
