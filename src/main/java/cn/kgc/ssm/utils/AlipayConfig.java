package cn.kgc.ssm.utils;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：  ksfxhw3818@sandbox.com   111111
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016101400687588";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCIo3Nfoh1B2TbkkoGqPcu810iZSDMnXRF/Xt/cyOOrMAPs9erynny6GZ1DjfzIvDp6R0bKd641KVZTs2QMC4K5ZI9MpPcq5hP6Xs/HLicUVQh7hqz9DfspouzsRIqRsnb4TaODykcSLhkHQyBNyLL8tSSkjREEah5IqgH2QFxES/iM2Ncokn6xuGeiQTyBz8YzXAWYPB9oq2beIn8rOnDBxjkA7JQJKtlg+20vWaKPHbDQjnEBpIFuYJw3/6o3ofhaHDfp6eLX8rkHbC40wlhB1QuDEuhvhP2pb0RLi17hFjXRMoFtt5MZLQSiwQPbHORO5EXyP8H5lfEfVOxUbvZDAgMBAAECggEADFHYdDX0t1wzY9aF1Giv9v3eMNveqNzuV/Kg8pI2XNf+cp4Vqfx6OHlYwZ+KvDqkdyP4EQdLcMWiX/ebvK5JAhg8B2gUVQzbnkZwK4BQy7eDBUg2Tra0/6MOA5uGdu6FZYvyg054q/32Cb6Wqgy/fqOCg0eo0iITSu/xL1fMOegRG5rKUKADyefR8ARGE7o1rnRhswXBfBwo+1IfY9dV2fORE6MTsV6oDWjEPmZWMY4hVEskMJyb3Q81KkK5e/CtWpB3oJxeOxfNdNe2oYRZ3K9hdHHX0+Y4LV5YquWKi8PNVXZRn9v3PMMVE3XQIAq7M7EN76EkqY9hZ6GzJ2tVAQKBgQDpIEcPO+cWQDk0ChI21dQBfmNs02r7lQ+QAOq5WE1NSZLj8G1c6rOEDu+LvRKzJ11XjIbnAjFBYAnamx68EQ3yzX/tgo4VL1Q/fQUDBG/gq87h+IkpO6dQ0jf4Fmh19gTeFfD/iBmdNkmEHax9SRoWmX/EBi6H+CMiwblsLPzwgQKBgQCWC5JvLfG0WZlgOZlKjnezLONytosxhdCPch323jPQGit9TanU4n2u/2+VZ/DeVyTzkQnmonx1JFgiB/rOPFHahLCk/YTWegtpAZ9h5YvPtHhbi1krTnbzhQIYNWMjyC1TWCVuDAUGA7bXntG9CNqs2dEXyuvTV1uK9BD15yHEwwKBgFr5fKGGR+TYBTq4n2kEwuoeT2B9lKc/AUa6BN91hR0fFBKdlaAH+ywSxAptK2n8d6GdtltZ8KzJdK75j+HmaeIRrdWa+CVuRdtMx3Lo/VvY0DBA1A3iOKYCk1LeM7+s1TNxro2ZqB1AvSmwhsqRh3vARSrTGr925wc+QETlvYOBAoGAF80mIXTMTquX5Oe+JVGMM2P/gIbsdaKgfuC/WBXPakd8dpgHRLnY7hWfAbhHQT3ZorlzNJ6512s4f818P5LZ+SvrSYDdvZgGj1Wujrz2/K/IF912+6Oqwt5qgqSVYWuzpPDqnxZRBa85JeMPqkjpR1oWDQwndJL69oPY3OkZNjkCgYBWCEAtdAdRVNg/Ux4V2hPT4x0Wh6NL3mZHF8z9S0frZxCiKScdDn3cmPM40u+JHtX5jnrx3EUH5Hy6gaEe0SGQ3S/qn8680FZoaUS9ia8hp5OGnz0cx5TN1h6XNdPjN4ri2r/aI/zq+AG7U0PCO75yeodIMRyzctYLfPqea0kO2g==";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAiKNzX6IdQdk25JKBqj3LvNdImUgzJ10Rf17f3MjjqzAD7PXq8p58uhmdQ438yLw6ekdGyneuNSlWU7NkDAuCuWSPTKT3KuYT+l7Pxy4nFFUIe4as/Q37KaLs7ESKkbJ2+E2jg8pHEi4ZB0MgTciy/LUkpI0RBGoeSKoB9kBcREv4jNjXKJJ+sbhnokE8gc/GM1wFmDwfaKtm3iJ/KzpwwcY5AOyUCSrZYPttL1mijx2w0I5xAaSBbmCcN/+qN6H4Whw36eni1/K5B2wuNMJYQdULgxLob4T9qW9ES4te4RY10TKBbbeTGS0EosED2xzkTuRF8j/B+ZXxH1TsVG72QwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/k9508_hotel-1.0-SNAPSHOT/orders/myOrdersPay";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
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

