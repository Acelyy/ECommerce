package invonate.cn.ecommerce;

import android.app.Application;

import invonate.cn.ecommerce.Entry.User;

/**
 * Created by liyangyang on 2017/10/20.
 */

public class YGApplication extends Application {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
