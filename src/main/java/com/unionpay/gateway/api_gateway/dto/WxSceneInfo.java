package com.unionpay.gateway.api_gateway.dto;

import lombok.Data;

/**
 * 微信场景信息
 */
@Data
public class WxSceneInfo {
    private String payer_client_ip;  // 用户终端IP
    private String device_id;        // 设备号
    private StoreInfo store_info;    // 商户门店信息
    
    @Data
    public static class StoreInfo {
        private String id;           // 门店编号
        private String name;         // 门店名称
        private String area_code;    // 地区编码
        private String address;      // 详细地址
    }
}
