package invonate.cn.ecommerce.Activity;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.yonggang.liyangyang.ios_dialog.widget.AlertDialog;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import invonate.cn.ecommerce.BaseActivity;
import invonate.cn.ecommerce.Entry.User;
import invonate.cn.ecommerce.Entry.Version;
import invonate.cn.ecommerce.R;
import invonate.cn.ecommerce.Request.Login;
import invonate.cn.ecommerce.Util.DownLoadRunnable;
import invonate.cn.ecommerce.Util.MD5;
import invonate.cn.ecommerce.Util.MyUtils;
import invonate.cn.ecommerce.Util.SPUtil;
import invonate.cn.ecommerce.YGApplication;
import invonate.cn.ecommerce.httpUtil.HttpUtil;
import invonate.cn.ecommerce.httpUtil.ProgressSubscriber;
import invonate.cn.ecommerce.httpUtil.SubscriberOnNextListener;
import rx.Subscriber;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.edit_username)
    EditText editUsername;
    @BindView(R.id.edit_password)
    EditText editPassword;
    private YGApplication app;

    //handler更新ui
    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case DownloadManager.STATUS_SUCCESSFUL:
                    Toast.makeText(LoginActivity.this, "下载完成", Toast.LENGTH_SHORT).show();
                    install(LoginActivity.this);
                    break;
                case DownloadManager.STATUS_RUNNING:
                    break;
                case DownloadManager.STATUS_FAILED:
                    break;
                case DownloadManager.STATUS_PENDING:
                    break;
            }
            return false;
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        app = (YGApplication) getApplication();
        editUsername.setText(SPUtil.getUserName(app));
        editPassword.setText(SPUtil.getPassword(app));
        getVersion();
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
        Log.i("login",JSON.toJSONString(login));
        HttpUtil.getInstance().login(new ProgressSubscriber(onNextListener, this, "登录中"), JSON.toJSONString(login));
    }

    @OnClick(R.id.btn_complete)
    public void onViewClicked() {
        login("android", editUsername.getText().toString().trim(), editPassword.getText().toString().trim(), "1111", "1.0");
    }

    /**
     * 获取版本号
     */
    private void getVersion(){
        Subscriber subscriber=new Subscriber<Version>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.i("error",e.toString());
            }

            @Override
            public void onNext(final Version data) {
                Log.i("version", data.toString());
                String version_new = data.getVersionId();
                String version_local = GetVersion(LoginActivity.this);
                if ("".equals(version_new) || "".equals(version_local)) {
                    return;
                }
                if (Double.parseDouble(version_new) > Double.parseDouble(version_local)) {
                    AlertDialog builder = new AlertDialog(LoginActivity.this).builder();
                    builder.setTitle("有新版本，是否更新")
                            .setPositiveButton("确定", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    String url = HttpUtil.BASE_URL+data.getVersionPath();
                                    new Thread(new DownLoadRunnable(LoginActivity.this, url, "永钢电子销售", 0, handler)).start();
                                }
                            }).setNegativeButton("取消", null)
                            .show();
                }
            }
        };
        HttpUtil.getInstance().getVersion(subscriber);
    }

    // 取得版本号
    public static String GetVersion(Context context) {
        try {
            PackageInfo manager = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), 0);
            return manager.versionName;
        } catch (Exception e) {
            return "";
        }
    }

    public void install(Context context) {
        Log.i("install", "start");
        File file = MyUtils.getCacheFile(MyUtils.APP_NAME, context);
        if (file == null || !file.exists()) {
            return;
        }
        Intent installintent = new Intent();
        installintent.setAction(Intent.ACTION_VIEW);
        // 在Boradcast中启动活动需要添加Intent.FLAG_ACTIVITY_NEW_TASK
        installintent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        installintent.setDataAndType(Uri.fromFile(file),
                "application/vnd.android.package-archive");
        context.startActivity(installintent);
        Log.i("install", "finish");
    }


}
