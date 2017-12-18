package invonate.cn.ecommerce.Adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import invonate.cn.ecommerce.Entry.OrderSearch;
import invonate.cn.ecommerce.R;

/**
 * Created by liyangyang on 2017/11/29.
 */

public class ShoppingAdapter2 extends RecyclerView.Adapter<ShoppingAdapter2.ViewHolder> {
    public static int TYPE1 = 0; // 螺纹钢
    public static int TYPE2 = 1; // 线盘

    private List<OrderSearch.Rows> data;
    private Context context;
    private OnItemClickListener onItemClickListener;
    private OnDeleteItemClickListener onDeleteItemClickListener;

    public ShoppingAdapter2(List<OrderSearch.Rows> data, Context context) {
        this.data = data;
        this.context = context;
    }

    public List<OrderSearch.Rows> getData() {
        return data;
    }

    public void setData(List<OrderSearch.Rows> data) {
        this.data = data;
    }

    @Override
    public int getItemViewType(int position) {
        String name = data.get(position).getProducttype2();
        if ("螺纹钢".equals(name)) {
            return TYPE1;
        } else {
            return TYPE2;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = null;
        if (viewType == TYPE1) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_shopping, parent, false);
        } else {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_shopping2, parent, false);
        }
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE1) {//螺纹钢
            data.get(position).setMaxPoint();
            holder.single.setText(data.get(position).getPoint());
            holder.singleweight.setText(data.get(position).getSingleweight());
            holder.num.setText(multiply(data.get(position).getPoint()+"", data.get(position).getSingleweight(), 3));
            data.get(position).setOrderWgt(multiply(data.get(position).getPoint()+"", data.get(position).getSingleweight(), 3));
            holder.sum.setText(multiply(data.get(position).getOrderWgt(),data.get(position).getPrice(),2));
        } else {// 线盘
            if (data.get(position).getOrderWgt()==null){
                data.get(position).setOrderWgt(data.get(position).getNum());
            }
            holder.num.setText(format(data.get(position).getOrderWgt(),3));
            holder.sum.setText(multiply(data.get(position).getPrice(), data.get(position).getOrderWgt(), 2));
        }
        holder.goodsType.setText(data.get(position).getProducttype() + "-" + data.get(position).getProducttype2());
        holder.goodsType2.setText(data.get(position).getMaterial());
        holder.goodsMaterial.setText(data.get(position).getSpec());
        holder.goodsPrice.setText(data.get(position).getPrice());
        if (onItemClickListener != null) {
            holder.item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    onItemClickListener.onItemClick(holder.item, pos);
                }
            });
        }
        if (onDeleteItemClickListener!=null){
            holder.delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    onDeleteItemClickListener.onDeleteItemClick(holder.delete, pos);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item)
        LinearLayout item;
        @BindView(R.id.goods_type)
        TextView goodsType;
        @BindView(R.id.goods_type2)
        TextView goodsType2;
        @BindView(R.id.goods_material)
        TextView goodsMaterial;
        @BindView(R.id.goods_price)
        TextView goodsPrice;
        @BindView(R.id.num)
        TextView num;
        @BindView(R.id.sum)
        TextView sum;
        @Nullable
        @BindView(R.id.single)
        TextView single;
        @Nullable
        @BindView(R.id.singleweight)
        TextView singleweight;
        @BindView(R.id.btn_delete)
        Button delete;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    /**
     * 点击监听
     */
    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    /**
     * 点击监听
     */
    public interface OnDeleteItemClickListener {
        void onDeleteItemClick(View view, int position);
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
     * 设置监听
     *
     * @param onDeleteItemClickListener
     */
    public void setOnDeleteItemClickListener(OnDeleteItemClickListener onDeleteItemClickListener) {
        this.onDeleteItemClickListener = onDeleteItemClickListener;
    }


    /**
     * 相减
     *
     * @param data1
     * @param data2
     * @param scale
     * @return
     */
    private String min(String data1, String data2, int scale) {
        BigDecimal bd1 = new BigDecimal(data1);
        BigDecimal bd2 = new BigDecimal(data2);
        return bd1.subtract(bd2).setScale(scale, BigDecimal.ROUND_DOWN).toString();
    }

    /**
     * 相乘
     *
     * @param data1
     * @param data2
     * @param scale
     * @return
     */
    private String multiply(String data1, String data2, int scale) {
        BigDecimal bd1 = new BigDecimal(data1);
        BigDecimal bd2 = new BigDecimal(data2);
        return bd1.multiply(bd2).setScale(scale, BigDecimal.ROUND_DOWN).toString();
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
     * 格式化价格
     *
     * @param data
     * @param scale
     * @return
     */
    private String format(String data, int scale) {
        BigDecimal bd = new BigDecimal(data);
        return bd.setScale(scale, BigDecimal.ROUND_DOWN).toString();
    }
}
