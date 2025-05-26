package com.unionpay.gateway.api_gateway.dto;

import lombok.Data;

/**
 * 预下单查询请求
 */
@Data
public class PreOrderQueryRequest {
    private String tokenNo;  // 预下单返回的token
}
