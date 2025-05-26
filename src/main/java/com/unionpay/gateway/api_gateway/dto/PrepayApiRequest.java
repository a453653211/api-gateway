package com.unionpay.gateway.api_gateway.dto;

import lombok.Data;

/**
 * 前端支付API请求
 */
@Data
public class PrepayApiRequest {
    private String tokenNo;  // 预下单返回的token
}
