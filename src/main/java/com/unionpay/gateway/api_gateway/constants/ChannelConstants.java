package com.unionpay.gateway.api_gateway.constants;

/**
 * 渠道相关常量
 */
public class ChannelConstants {
    
    /**
     * 渠道类型
     */
    public static class ChannelType {
        public static final String WECHAT = "wx";      // 微信
        public static final String ALIPAY = "ali";     // 支付宝
        public static final String UNIONPAY = "cup";   // 云闪付
    }
    
    /**
     * 二维码类型
     */
    public static class QrType {
        public static final String UNIFIED_JSAPI = "unifiedjsapi";     // 静态码
        public static final String UNIFIED_NATIVE = "unifiednative";   // 动态码
    }
    
    /**
     * 端程序类型
     */
    public static class AppletsType {
        public static final String SUBAPP = "SUBAPP";      // 公众号
        public static final String APPLETS = "APPLETS";    // 小程序
        public static final String APP = "APP";            // 应用程序
        public static final String WAP = "WAP";            // 浏览器网页
    }
    
    /**
     * 微信相关常量
     */
    public static class Wechat {
        public static final String NEED_RECEIPT_YES = "1";  // 需要电子发票
        public static final String NEED_RECEIPT_NO = "0";   // 不需要电子发票
    }
    
    /**
     * 支付宝相关常量
     */
    public static class Alipay {
        public static final String CERT_TYPE_IDCARD = "IDENTITY_CARD";  // 身份证
    }
}
