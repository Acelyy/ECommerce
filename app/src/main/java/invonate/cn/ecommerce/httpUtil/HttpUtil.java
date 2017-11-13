package invonate.cn.ecommerce.httpUtil;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import invonate.cn.ecommerce.Entry.Deliver;
import invonate.cn.ecommerce.Entry.DeliverDetail;
import invonate.cn.ecommerce.Entry.HttpResult;
import invonate.cn.ecommerce.Entry.Order;
import invonate.cn.ecommerce.Entry.OrderDetail;
import invonate.cn.ecommerce.Entry.User;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.fastjson.FastJsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by liyangyang on 2017/3/22.
 */

public class HttpUtil {

    //public static final String BASE_URL = "http://esale.yong-gang.com/";
    //public static final String BASE_URL = "http://192.168.202.180:8000/";
    public static final String BASE_URL = "http://172.30.198.30:8000/";

    public static int DEFAULT_TIMEOUT = 5;

    private Retrofit retrofit;

    private HttpService httpService;

    private static HttpUtil INSTANCE = new HttpUtil();

    private HttpUtil() {
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder()
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);//设置超时时间
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(clientBuilder.build())
                .addConverterFactory(FastJsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        httpService = retrofit.create(HttpService.class);
    }

    public static HttpUtil getInstance() {
        return INSTANCE;
    }

    /**
     * 用来统一处理Http的flag,并将HttpResult的Data部分剥离出来返回给subscriber
     *
     * @param <T> Subscriber真正需要的数据类型，也就是Data部分的数据类型
     */
    public static class HttpResultFunc<T> implements Func1<HttpResult<T>, T> {

        @Override
        public T call(HttpResult<T> httpResult) {
            Log.i("result", httpResult.toString());
            if (httpResult.getResultCode() == 1) {
                String msg = httpResult.getResultMsg();
                if (msg == null) {
                    msg = "msg为空";
                }
                throw new RuntimeException(msg);
            }
            return httpResult.getData();
        }
    }

    /**
     * 统一配置观察者
     *
     * @param o
     * @param <T>
     */
    private <T> void toSubscribe(Observable<T> o, Subscriber<T> s) {
        o.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s);
    }

    /**
     * 登录
     *
     * @param subscriber
     * @param request_args
     */
    public void login(Subscriber subscriber, String request_args) {
        Observable observable = httpService.login(request_args)
                .map(new HttpResultFunc<User>());
        toSubscribe(observable, subscriber);
    }

    /**
     * 获取订单列表
     *
     * @param subscriber
     * @param request_args
     */
    public void getOrder(Subscriber subscriber, String request_args) {
        Observable observable = httpService.getOrder(request_args)
                .map(new HttpResultFunc<Order>());
        toSubscribe(observable, subscriber);
    }

    /**
     * 获取订单详情
     *
     * @param subscriber
     * @param request_args
     */
    public void getOrderDetail(Subscriber subscriber, String request_args) {
        Observable observable = httpService.getOrderDetail(request_args)
                .map(new HttpResultFunc<OrderDetail>());
        toSubscribe(observable, subscriber);
    }

    /**
     * 获取发货通知单列表
     *
     * @param subscriber
     * @param request_args
     */
    public void getDeliver(Subscriber subscriber, String request_args) {
        Observable observable = httpService.getDeliver(request_args)
                .map(new HttpResultFunc<Deliver>());
        toSubscribe(observable, subscriber);
    }

    /**
     * 获取发货通知单详情
     *
     * @param subscriber
     * @param request_args
     */
    public void getDeliverDetail(Subscriber subscriber, String request_args) {
        Observable observable = httpService.getDeliverDetail(request_args)
                .map(new HttpResultFunc<DeliverDetail>());
        toSubscribe(observable, subscriber);
    }

    /**
     * 获取账户信息
     *
     * @param subscriber
     * @param request_args
     */
    public void getAccount(Subscriber subscriber, String request_args) {
        Observable observable = httpService.getAccount(request_args)
                .map(new HttpResultFunc<Account>());
        toSubscribe(observable, subscriber);
    }
}