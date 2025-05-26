package com.unionpay.gateway.api_gateway.constants;

/**
 * 支付相关常量
 */
public class PaymentConstants {
    
    /**
     * 签名类型
     */
    public static class SignType {
        public static final String SM2 = "SM2";
    }
    
    /**
     * 业务方法
     */
    public static class BizMethod {
        public static final String QRCODE = "aggregate.trade.qrcode";
        public static final String PREPAY = "aggregate.trade.prepay";
    }
    
    /**
     * 响应码
     */
    public static class ResponseCode {
        public static final String SUCCESS = "00";
        public static final String FAIL = "01";
    }
    
    /**
     * 子响应码
     */
    public static class SubCode {
        public static final String SUCCESS = "000000";
    }
}
