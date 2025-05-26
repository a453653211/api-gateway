package com.unionpay.gateway.api_gateway.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PrepayRequest {
    // === 基础字段 ===
    private String version;      // 版本号，默认1.0
    private String sign;         // 签名串
    private String signType;     // 签名方式：SM2
    private String certId;       // 证书ID
    private String bizMethod;    // 交易类型：aggregate.trade.prepay
    private String insCode;      // 服务商机构号
    private String timestamp;    // 时间戳：yyyy-MM-dd HH:mm:ss
    private String merId;        // 商户编号
    private String qrType;       // 二维码类型：unifiedjsapi/unifiednative（云闪付必送）
    private String qrId;         // 商户二维码编号（云闪付必送）
    private String outTradeNo;   // 订单号
    private String body;         // 商品描述
    private String subject;      // 订单标题
    private String attach;       // 备注
    private String txnAmt;       // 交易金额（分）
    private String termIp;       // 终端IP
    private Object termInfo;     // 终端信息
    private String termId;       // 平台终端号
    private String appletsType;  // 端程序类型：SUBAPP/APPLETS/APP/WAP
    private String payNotifyUrl; // 支付结果通知地址
    private String channelType;  // 渠道类型：wx/ali/cup
    
    // === 微信特有字段 ===
    private String needReceipt;     // 电子发票：1-需要 0-不需要
    private String goodsTag;        // 商品标记
    private Object detail;          // 商品详情
    private WxSceneInfo wxSceneInfo; // 场景信息
    private String timeStart;       // 订单生成时间：yyyymmddhhmmss
    private String openid;          // 微信买家用户标识（平台公众号下单必送）
    private String subAppid;        // 微信子商户公众号或小程序ID
    private String subOpenid;       // 微信买家用户子标识
    
    // === 支付宝特有字段 ===
    private ExtUserInfo extUserInfo;    // 外部指定买家
    private String offsetAmt;           // 可打折金额（分）
    private String buyerId;             // 买家支付宝用户id（支付宝渠道必送）
    private AliGoodsDetail[] aliGoodsDetail; // 商品信息列表
    private String operatorId;          // 商户操作员编号
    private String storeId;             // 商户门店编号
    private String alipayStoreId;       // 支付宝店铺编号
    private Object extendParams;        // 业务扩展参数
    
    // === 云闪付特有字段 ===
    private AcqAddnData acqAddnData;    // 收款方附加数据
}

