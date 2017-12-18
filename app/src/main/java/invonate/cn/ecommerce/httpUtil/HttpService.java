package invonate.cn.ecommerce.httpUtil;


import invonate.cn.ecommerce.Entry.Agn;
import invonate.cn.ecommerce.Entry.Deliver;
import invonate.cn.ecommerce.Entry.DeliverDetail;
import invonate.cn.ecommerce.Entry.Distribution;
import invonate.cn.ecommerce.Entry.Filter;
import invonate.cn.ecommerce.Entry.HttpResult;
import invonate.cn.ecommerce.Entry.Order;
import invonate.cn.ecommerce.Entry.OrderDetail;
import invonate.cn.ecommerce.Entry.OrderSearch;
import invonate.cn.ecommerce.Entry.User;
import invonate.cn.ecommerce.Entry.Version;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by liyangyang on 17/3/14.
 */
public interface HttpService {

    // 登录
    @POST("/esales/jbxx/login/checkUser_app.action")
    @FormUrlEncoded
    Observable<HttpResult<User>> login(
            @Field("request_args") String request_args
    );

    // 获取订单列表
    @POST("/esales/outbus/outresource/doQueryMyOrder_app.action")
    @FormUrlEncoded
    Observable<HttpResult<Order>> getOrder(
            @Field("request_args") String request_args
    );

    // 获取订单详细
    @POST("/esales/outbus/outresource/loadMyOrder_app.action")
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
    @POST("/esales/bus/notice/viewNotice_app.action")
    @FormUrlEncoded
    Observable<HttpResult<DeliverDetail>> getDeliverDetail(
            @Field("request_args") String request_args
    );

    // 获取账户信息
    @POST("/esales/jbxx/login/loadfirstpage_customerrations_app.action")
    @FormUrlEncoded
    Observable<HttpResult<Account>> getAccount(
            @Field("request_args") String request_args
    );

    // 获取协议量
    @POST("/esales/outbus/agreementnum/doQueryAgn_app.action")
    @FormUrlEncoded
    Observable<HttpResult<Agn>> getAgn(
            @Field("request_args") String request_args
    );

    // 获取分配量筛选条件
    @POST("/esales/bus/distrib/doQueryWarehouse_app.action")
    @FormUrlEncoded
    Observable<HttpResult<Filter>> getFilter(
            @Field("request_args") String request_args
    );

    // 查询分配量
    @POST("/esales/bus/distrib/doQueryCustDistrib_app.action")
    @FormUrlEncoded
    Observable<HttpResult<Distribution>> getDistribution(
            @Field("request_args") String request_args
    );


    // 确认订单
    @POST("/esales/bus/qzorder/saveQzorder_app.action")
    @FormUrlEncoded
    Observable<HttpResult<String>> create_order(
            @Field("request_args") String request_args
    );

    // 获取订单详情
    @POST("/esales/outbus/outresource/doQueryResourceDe_app.action")
    @FormUrlEncoded
    Observable<HttpResult<OrderSearch>> search_order(
            @Field("request_args") String request_args
    );

    // 新增发货通知单
    @POST("/esales/bus/notice/saveNotice_app.action")
    @FormUrlEncoded
    Observable<HttpResult<String>> create_deliver(
            @Field("request_args") String request_args
    );

    @POST("/esales/bus/notice/saveNoticeCarShip_app.action")
    @FormUrlEncoded
    Observable<HttpResult<String>> edit_deliver(
            @Field("request_args") String request_args
    );

    // 获取版本号
    @POST("/esales/bus/notice/getVersion_app.action")
    Observable<HttpResult<Version>> getVersion(

    );
}
