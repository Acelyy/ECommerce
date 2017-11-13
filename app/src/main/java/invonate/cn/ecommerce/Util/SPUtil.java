package invonate.cn.ecommerce.Util;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by liyangyang on 2017/11/8.
 */

public class SPUtil {
    public static final String SHARED_USER = "shared_user";
    /**
     * 保存账号密码
     *
     * @param userName
     * @param password
     * @param context
     */
    public static void setSharedUser(String userName, String password, Context context) {
        SharedPreferences sp = context.getSharedPreferences(SHARED_USER, MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("userName", userName);
        editor.putString("password", password);
        editor.commit();
    }

    /**
     * 获取用户名
     *
     * @param context
     * @return
     */
    public static String getUserName(Context context) {
        SharedPreferences sp = context.getSharedPreferences(SHARED_USER, MODE_PRIVATE);
        String userName = sp.getString("userName", "");
        return userName;
    }

    /**
     * 获取密码
     *
     * @param context
     * @return
     */
    public static String getPassword(Context context) {
        SharedPreferences sp = context.getSharedPreferences(SHARED_USER, MODE_PRIVATE);
        String password = sp.getString("password", "");
        return password;
    }
}
