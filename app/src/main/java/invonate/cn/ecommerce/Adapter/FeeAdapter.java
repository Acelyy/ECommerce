package invonate.cn.ecommerce.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import invonate.cn.ecommerce.Entry.OrderDetail;
import invonate.cn.ecommerce.R;

/**
 * Created by liyangyang on 2017/11/6.
 */

public class FeeAdapter extends RecyclerView.Adapter<FeeAdapter.ViewHolder> {
    private List<OrderDetail.KkdetailList> data;
    private Context context;

    public FeeAdapter(List<OrderDetail.KkdetailList> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_fee, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.feeeIndex.setText(position + 1 + "");
        holder.feeAmount.setText(data.get(position).getAmount() + "");
        holder.feeOffice.setText(data.get(position).getOffice());
        holder.feeAccountnum.setText(data.get(position).getAccountnum());
        holder.feePurpose.setText(data.get(position).getPurposes());
        holder.feeCreatetime.setText(data.get(position).getCreatetime());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.feee_index)
        TextView feeeIndex;
        @BindView(R.id.fee_amount)
        TextView feeAmount;
        @BindView(R.id.fee_office)
        TextView feeOffice;
        @BindView(R.id.fee_accountnum)
        TextView feeAccountnum;
        @BindView(R.id.fee_purpose)
        TextView feePurpose;
        @BindView(R.id.fee_createtime)
        TextView feeCreatetime;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
