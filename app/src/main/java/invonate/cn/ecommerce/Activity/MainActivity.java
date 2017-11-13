package invonate.cn.ecommerce.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindColor;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import invonate.cn.ecommerce.BaseActivity;
import invonate.cn.ecommerce.Fragment.MineFragment;
import invonate.cn.ecommerce.Fragment.OrderFragment;
import invonate.cn.ecommerce.Fragment.PublishFragment;
import invonate.cn.ecommerce.R;

public class MainActivity extends BaseActivity {

    @BindViews({R.id.img_order, R.id.img_publish, R.id.img_mine})
    List<ImageView> list_imgs;

    @BindViews({R.id.txt_order, R.id.txt_publish, R.id.txt_mine})
    List<TextView> list_txt;

    //点击的字体颜色
    @BindColor(R.color.colorPrimary)
    public int colorMainClick;

    //未点击的字体颜色
    @BindColor(R.color.fragemnt_text)
    public int colorMainUnClick;

    private Fragment[] fragments;

    private int currentItem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        fragments = new Fragment[]{new OrderFragment(), new PublishFragment(),new MineFragment()};
        getSupportFragmentManager().beginTransaction()
                .add(R.id.content, fragments[0])
                .add(R.id.content, fragments[1])
                .add(R.id.content, fragments[2])
                .hide(fragments[1]).hide(fragments[2])
                .show(fragments[0])
                .commit();
        list_imgs.get(0).setSelected(true);
        list_txt.get(0).setTextColor(colorMainClick);
    }

    /**
     * 切换Fragment
     *
     * @param index 页码
     */
    private void changeFragment(int index) {
        if (currentItem != index) {
            FragmentTransaction trx = getSupportFragmentManager().beginTransaction();
            trx.hide(fragments[currentItem]);
            if (!fragments[index].isAdded()) {
                trx.add(R.id.content, fragments[index]);
            }
            trx.show(fragments[index]).commit();
        }
        list_imgs.get(currentItem).setSelected(false);
        list_imgs.get(index).setSelected(true);

        list_txt.get(currentItem).setTextColor(colorMainUnClick);
        list_txt.get(index).setTextColor(colorMainClick);
        currentItem = index;
    }

    @OnClick({R.id.layout_order, R.id.layout_publish, R.id.layout_mine})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.layout_order:
                changeFragment(0);
                break;
            case R.id.layout_publish:
                changeFragment(1);
                break;
            case R.id.layout_mine:
                changeFragment(2);
                break;
        }
    }


}
