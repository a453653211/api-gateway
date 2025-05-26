package com.unionpay.gateway.api_gateway.util;

import com.unionpay.gateway.api_gateway.constants.ChannelConstants;
import com.unionpay.gateway.api_gateway.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * PrepayRequest构建工具类
 * 根据不同渠道设置特有字段
 */
public class PrepayRequestBuilder {
    
    private static final Logger logger = LoggerFactory.getLogger(PrepayRequestBuilder.class);
    
    /**
     * 为微信渠道设置特有字段
     */
    public static void setWxSpecificFields(PrepayRequest.PrepayRequestBuilder builder, PreOrderRequest preOrder) {
        logger.debug("设置微信渠道特有字段: outTradeNo={}", preOrder.getOutTradeNo());
        
        builder.qrType(ChannelConstants.QrType.UNIFIED_JSAPI)  // 微信默认使用JSAPI
               .qrId(preOrder.getOutTradeNo())
               .needReceipt(ChannelConstants.Wechat.NEED_RECEIPT_NO)  // 默认不需要电子发票
               .timeStart(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")));
        
        // 设置场景信息
        WxSceneInfo sceneInfo = new WxSceneInfo();
        sceneInfo.setPayer_client_ip(preOrder.getTermIp());
        builder.wxSceneInfo(sceneInfo);
        
        // TODO: 以下字段需要从前端传入或配置中获取
        // builder.openid(preOrder.getOpenid());
        // builder.subAppid(preOrder.getSubAppid());
        // builder.subOpenid(preOrder.getSubOpenid());
    }
    
    /**
     * 为支付宝渠道设置特有字段
     */
    public static void setAliSpecificFields(PrepayRequest.PrepayRequestBuilder builder, PreOrderRequest preOrder) {
        logger.debug("设置支付宝渠道特有字段: outTradeNo={}", preOrder.getOutTradeNo());
        
        builder.qrType(ChannelConstants.QrType.UNIFIED_JSAPI)  // 支付宝默认使用JSAPI
               .qrId(preOrder.getOutTradeNo())
               .offsetAmt(preOrder.getTxnAmt());  // 可打折金额默认等于交易金额
        
        // TODO: 以下字段需要从前端传入
        // builder.buyerId(preOrder.getBuyerId());  // 支付宝渠道必送
        
        // 设置商品详情（示例）
        AliGoodsDetail goodsDetail = new AliGoodsDetail();
        goodsDetail.setGoods_id("001");
        goodsDetail.setGoods_name(preOrder.getBody());
        goodsDetail.setQuantity("1");
        goodsDetail.setPrice(String.valueOf(Double.parseDouble(preOrder.getTxnAmt()) / 100.0)); // 转换为元
        builder.aliGoodsDetail(new AliGoodsDetail[]{goodsDetail});
    }
    
    /**
     * 为云闪付渠道设置特有字段
     */
    public static void setCupSpecificFields(PrepayRequest.PrepayRequestBuilder builder, PreOrderRequest preOrder) {
        logger.debug("设置云闪付渠道特有字段: outTradeNo={}", preOrder.getOutTradeNo());
        
        // 云闪付的qrType和qrId是必送的
        builder.qrType(ChannelConstants.QrType.UNIFIED_NATIVE)  // 云闪付默认使用动态码
               .qrId(preOrder.getOutTradeNo());
        
        // 设置收款方附加数据（示例）
        AcqAddnData acqAddnData = new AcqAddnData();
        acqAddnData.setMerName("测试商户");
        acqAddnData.setMerAbbr("测试");
        builder.acqAddnData(acqAddnData);
    }
}
