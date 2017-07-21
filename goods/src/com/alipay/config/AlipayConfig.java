package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {

    // ↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016080600178133";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDWOXIgx4V4CG+CfdIAhzhJfwAFH3f7hKAWHfPIvMrgBfQKp2Asmsli1rnZSpnz2bE9t1cGd0FgAOSafaizGgNuxTLV7cmvD9AKdsGFwsrDh1i3dxgZO0gmvZt+bHyct8xLBoH8JSEXseTu/isRFp7hmuLp0enRHnxaDglUUCCXomcnaunPYzyZ0p9gs+O/65qhfeAU7DOkmGXdPICCjBeem+CYQnwBYS4tQQXRj1FjxyM+3KlXmy1sMaJtRRQaCHcx8N6Z+T5n7wKOqGbQi4slJVtgmEVyzqzcfXqsH8calm3EhEhNTODT84ROpzo83M+Bm4Dhh6WDUJykXNjXnzGnAgMBAAECggEBAI2ASnN+dxnPMKDYLROuPa7GVaQMojsf4oJZbILmuXb6V7WF01ADOgywWvg9f62D2MA0TyZ1NViNnnKxl/Idt7C+TxLhy3t4DWosAS4yea5nw2EEKIXaE5GLYp9CV5lJCodwGAIOIGq/VcHLX3UdJPtOTJ43yqMX6PmvFdh8SNr+9FHzBzZtFYyfBqM+zgTVltfd+NltDTI4Pbka23cBTNcL/Oq4COs4pN+sMbyg+YSZACZyuPZFB5fpIK9QZAOPoCTjGqX6dVIWjYFsdcvEgE+Trj/UjqL7jNZV2pvOLrSr2MEqEIZMGn7bGcaaXALIoUW+PL5rYu62a/+ApK84HvECgYEA9CWQ1abd7jixHcK2j9v7E2cJc36qsi8FFDkCqx+dJnBJ46+Ass3a2RbYQTzNnWWvicEriZP0obe+C2LhhICb3QBfybIKfytruOXMor//G7Iau6ql6IGTztiJhOd4FPS/ZbS64X4r1AbW+3lR5ONrD1s27Dv1GH8Ddqzdc3A7gK8CgYEA4J/7uJfW2dVHgCYgkO2ibuoL9ac/JHbNjUeQ4ul47y4XNJ5PJO8Iy32ZBYhjBfEaQBunlTGIq5kaJCDHI/gwK+k/AG0cBVcvP/wfyNFk2q1JN0hoWe3UFOC+jyw0t8dPunwxTtIhK2Sr1qduGLWC+JgtG1uh1fZUvMMCZvK67IkCgYBrBWyPuy3dlwxMt2W/efZ9ctU5w3Sf1uyrCLKawKjqiJ5bKDuKJaKhNtpk/npDXKeuAvdKv4ikux6bbyTcKGQqZFeY2mqvhCEcU994GCGDynbdfNhtKx/XtCPUFoMU7JRZyPeCkQQ1VSo34d58LxRnDtzsgPvXWRXzl6MbTz9GEQKBgCiJVpD6feBz1+JtfwUIjX68qAnd88wt0GyFlMUOYy+uvqtVQm0k4g5vDRVtholE+HrHQtfux35IM+p/K9D28iKKhj8acasZD8LZShcgirXX/dWHMKXCALr/0APgc2cTBfVegjt6OlgtY8FqF7lH0GnydHlycOM/AA3Ml3tipI8ZAoGAen/bIRQZLk5vEfh2+w8DifV11sTWwglWYub0hGjIr7tk9sH/swNaJeGL4JXdLikpi1z3HjlyKvX1sF5azRACkauF5VJD9pasYmrL5BUWtdlbJE8FdWDpwhWJ++TVSgO5eHwUjNoxJ/jataBb5MzFzUtJlvkaws/JPqKYWrxxYGg=";
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm
    // 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsl3EFfp6qXGHQxh9zVt5eyFnSXjct4qfeC4wwKJdUPyUwJXW7afBAfwCYMhI66nIxxcWQe2bTzB73ESFB9sWnIFQa6lljY7IwZ8kZqPjUYFYl+SX/4nbO18Q/amf84Uk5YXZNYRzjnf7A/FN+xK48pdAgAy5QGBPFKzhIMeIjqreTXPgKUkAfDlkQeObm1ME41mOtg6OllYJ6NFC4N9gAz8f9+J4kFnD3kI67DZ+5Ie69cAorsKQZDwwDrdYbz5mWNeJrDQib6D5sojFTTQhP0YmnxfIPACoZkaLJJX4po9gDzha8+HexbeAnrdsYcGDvz9CuSPLWAhSwvl3DbjOLwIDAQAB";
    // 服务器异步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    //public static String notify_url = "http://119.23.45.111/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://119.23.45.111/goods/order/returnurl";
    //public static String return_url = "http://localhost:8080/goods/order/returnurl";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "d:\\";

    // ynkwwj1540@sandbox.com
    // ↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * 
     * @param sWord
     *            要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_"
                    + System.currentTimeMillis() + ".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}