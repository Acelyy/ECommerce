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

public class GoodsAdapter extends RecyclerView.Adapter<GoodsAdapter.ViewHolder> {
    private List<OrderDetail.OrderdetailList> data;
    private Context context;

    public GoodsAdapter(List<OrderDetail.OrderdetailList> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_goods, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.goodsIndex.setText(position + 1 + "");
        holder.goodsType.setText(data.get(position).getProducttype()+"-"+data.get(position).getProducttype2());
        holder.goodsType2.setText(data.get(position).getMaterial());
        holder.goodsMaterial.setText(data.get(position).getSpec());
        holder.goodsPrice.setText(data.get(position).getPrice() + "");
        holder.goodsNum.setText(data.get(position).getNum() + "");
        holder.goodsAmount.setText(data.get(position).getAmount() + "");
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.goods_index)
        TextView goodsIndex;
        @BindView(R.id.goods_type)
        TextView goodsType;
        @BindView(R.id.goods_type2)
        TextView goodsType2;
        @BindView(R.id.goods_material)
        TextView goodsMaterial;
        @BindView(R.id.goods_price)
        TextView goodsPrice;
        @BindView(R.id.goods_num)
        TextView goodsNum;
        @BindView(R.id.goods_amount)
        TextView goodsAmount;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
