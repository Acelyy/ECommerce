package invonate.cn.ecommerce.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import invonate.cn.ecommerce.Entry.Distribution;
import invonate.cn.ecommerce.R;

/**
 * Created by liyangyang on 2017/11/16.
 */

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

    private List<Distribution.Rows> data;
    private Context context;
    private OnItemClickListener onItemClickListener;

    public CartAdapter(List<Distribution.Rows> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_cart, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.goodsType.setText(data.get(position).getProducttype() + "-" + data.get(position).getProducttype2());
        holder.goodsType2.setText(data.get(position).getMaterial());
        holder.goodsMaterial.setText(data.get(position).getSpec());
        holder.goodsPrice.setText(data.get(position).getPrice());
        holder.numSum.setText(format(data.get(position).getTotalWgt(),3));
        holder.moneySum.setText(multiply(data.get(position).getTotalWgt(),data.get(position).getPrice(),2));
        holder.numDone.setText(format(data.get(position).getNum(),3));
        holder.moneyDone.setText(multiply(data.get(position).getNum(),data.get(position).getPrice(),2));
        holder.goodsNum.setText(min(data.get(position).getTotalWgt(),data.get(position).getNum(),3));
        boolean select = data.get(position).isSelect();
        if (select) {
            holder.goodsSelect.setImageResource(R.mipmap.pic_fselect);
        } else {
            holder.goodsSelect.setImageResource(R.mipmap.pic_fnoselect);
        }
        if (onItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    onItemClickListener.onItemClick(holder.itemView, pos);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.goods_type)
        TextView goodsType;
        @BindView(R.id.goods_type2)
        TextView goodsType2;
        @BindView(R.id.goods_material)
        TextView goodsMaterial;
        @BindView(R.id.goods_price)
        TextView goodsPrice;
        @BindView(R.id.num_sum)
        TextView numSum;
        @BindView(R.id.money_sum)
        TextView moneySum;
        @BindView(R.id.num_done)
        TextView numDone;
        @BindView(R.id.money_done)
        TextView moneyDone;
        @BindView(R.id.goods_select)
        ImageView goodsSelect;
        @BindView(R.id.goods_num)
        TextView goodsNum;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    /**
     * 点击监听
     */
    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    /**
     * 设置监听
     *
     * @param mOnItemClickLitener
     */
    public void setOnItemClickLitener(OnItemClickListener mOnItemClickLitener) {
        this.onItemClickListener = mOnItemClickLitener;
    }

    /**
     *  格式化价格
     *
     * @param data
     * @param scale
     * @return
     */
    private String format(String data, int scale) {
        BigDecimal bd = new BigDecimal(data);
        return bd.setScale(scale,BigDecimal.ROUND_DOWN).toString();
    }

    /**
     * 相减
     *
     * @param data1
     * @param data2
     * @param scale
     * @return
     */
    private String min(String data1,String data2,int scale){
        BigDecimal bd1=new BigDecimal(data1);
        BigDecimal bd2=new BigDecimal(data2);
        return bd1.subtract(bd2).setScale(scale,BigDecimal.ROUND_DOWN).toString();
    }

    /**
     * 相乘
     *
     * @param data1
     * @param data2
     * @param scale
     * @return
     */
    private String multiply(String data1,String data2,int scale){
        BigDecimal bd1=new BigDecimal(data1);
        BigDecimal bd2=new BigDecimal(data2);
        return bd1.multiply(bd2).setScale(scale,BigDecimal.ROUND_DOWN).toString();
    }

}
