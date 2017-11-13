package invonate.cn.ecommerce.Activity;

import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import invonate.cn.ecommerce.BaseActivity;
import invonate.cn.ecommerce.Entry.User;
import invonate.cn.ecommerce.R;
import invonate.cn.ecommerce.YGApplication;

public class PersonnalActivity extends BaseActivity {

    @BindView(R.id.accountnum)
    TextView accountnum;
    @BindView(R.id.consultid)
    TextView consultid;
    @BindView(R.id.customernamecn)
    TextView customernamecn;
    @BindView(R.id.customernameen)
    TextView customernameen;
    @BindView(R.id.customertype)
    TextView customertype;
    @BindView(R.id.dutynum)
    TextView dutynum;
    @BindView(R.id.ownercode)
    TextView ownercode;
    @BindView(R.id.contacts)
    TextView contacts;
    @BindView(R.id.phonenum)
    TextView phonenum;
    @BindView(R.id.registetime)
    TextView registetime;
    @BindView(R.id.office)
    TextView office;
    @BindView(R.id.balanceaccount)
    TextView balanceaccount;

    private YGApplication app;

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personnal);
        ButterKnife.bind(this);
        app = (YGApplication) getApplication();
        user = app.getUser();
        if (user != null) {
            accountnum.setText(user.getAccountnum());
            consultid.setText(user.getConsultid());
            customernamecn.setText(user.getCustomernamecn());
            customernameen.setText(user.getCustomernameen());
            customertype.setText(user.getCustomertype());
            dutynum.setText(user.getDutynum());
            ownercode.setText(user.getOwnercode());
            contacts.setText(user.getContacts());
            phonenum.setText(user.getPhonenum());
            registetime.setText(user.getRegistetime());
            office.setText(user.getOffice());
            balanceaccount.setText(user.getBalanceaccount());
        }

    }

    @OnClick(R.id.img_back)
    public void onViewClicked() {
        finish();
    }
}
