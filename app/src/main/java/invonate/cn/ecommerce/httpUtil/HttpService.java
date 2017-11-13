package invonate.cn.ecommerce.httpUtil;


import invonate.cn.ecommerce.Entry.Deliver;
import invonate.cn.ecommerce.Entry.DeliverDetail;
import invonate.cn.ecommerce.Entry.HttpResult;
import invonate.cn.ecommerce.Entry.Order;
import invonate.cn.ecommerce.Entry.OrderDetail;
import invonate.cn.ecommerce.Entry.User;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by liyangyang on 17/3/14.
 */
public interface HttpService {

    // 登录
    @POST("esales/jbxx/login/checkUser_app.action")
    @FormUrlEncoded
    Observable<HttpResult<User>> login(
            @Field("request_args") String request_args
    );

    // 获取订单列表
    @POST("esales/outbus/outresource/doQueryMyOrder_app.action")
    @FormUrlEncoded
    Observable<HttpResult<Order>> getOrder(
            @Field("request_args") String request_args
    );

    // 获取订单详细
    @POST("esales/outbus/outresource/loadMyOrder_app.action")
    @FormUrlEncoded
    Observable<HttpResult<OrderDetail>> getOrderDetail(
            @Field("request_args") String request_args
    );

    // 获取发货通知单列表
    @POST("esales/bus/notice/doQueryNotice_app.action")
    @FormUrlEncoded
    Observable<HttpResult<Deliver>> getDeliver(
            @Field("request_args") String request_args
    );

    // 获取发货通知单详细
    @POST("esales/bus/notice/viewNotice_app.action")
    @FormUrlEncoded
    Observable<HttpResult<DeliverDetail>> getDeliverDetail(
            @Field("request_args") String request_args
    );

    // 获取账户信息
    @POST("esales/jbxx/login/loadfirstpage_customerrations_app.action")
    @FormUrlEncoded
    Observable<HttpResult<Account>> getAccount(
            @Field("request_args") String request_args
    );

}
