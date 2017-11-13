package invonate.cn.ecommerce.Activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import invonate.cn.ecommerce.BaseActivity;
import invonate.cn.ecommerce.Entry.User;
import invonate.cn.ecommerce.R;
import invonate.cn.ecommerce.Request.Login;
import invonate.cn.ecommerce.Util.MD5;
import invonate.cn.ecommerce.Util.SPUtil;
import invonate.cn.ecommerce.YGApplication;
import invonate.cn.ecommerce.httpUtil.HttpUtil;
import invonate.cn.ecommerce.httpUtil.ProgressSubscriber;
import invonate.cn.ecommerce.httpUtil.SubscriberOnNextListener;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.edit_username)
    EditText editUsername;
    @BindView(R.id.edit_password)
    EditText editPassword;
    private YGApplication app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        app = (YGApplication) getApplication();
        editUsername.setText(SPUtil.getUserName(app));
        editPassword.setText(SPUtil.getPassword(app));
    }

    /**
     * 登录
     *
     * @param veryCode
     * @param ownerCode
     * @param password
     * @param clientid
     * @param appversion
     */
    private void login(String veryCode, final String ownerCode, final String password, String clientid, String appversion) {
        if ("".equals(ownerCode)) {
            Toast.makeText(app, "请输入用户名", Toast.LENGTH_SHORT).show();
            return;
        }
        if ("".equals(password)) {
            Toast.makeText(app, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }
        Login login = new Login(veryCode, ownerCode, MD5.GetMD5Code(ownerCode + password), clientid, appversion);
        SubscriberOnNextListener onNextListener = new SubscriberOnNextListener<User>() {
            @Override
            public void onNext(User data) {
                Log.i("login", data.toString());
                app.setUser(data);
                SPUtil.setSharedUser(ownerCode, password, app);
                goActivity(MainActivity.class);
            }
        };
        HttpUtil.getInstance().login(new ProgressSubscriber(onNextListener, this, "登录中"), JSON.toJSONString(login));
    }

    @OnClick(R.id.btn_complete)
    public void onViewClicked() {
        login("android", editUsername.getText().toString().trim(), editPassword.getText().toString().trim(), "1111", "1.0");
    }


}
