package com.unionpay.gateway.api_gateway.dto;

import lombok.Data;

/**
 * 支付宝外部指定买家信息
 */
@Data
public class ExtUserInfo {
    private String name;              // 姓名
    private String mobile;            // 手机号
    private String cert_type;         // 证件类型
    private String cert_no;           // 证件号码
    private String min_age;           // 最小年龄
    private String fix_buyer;         // 是否强制校验付款人身份信息
    private String need_check_info;   // 是否强制校验身份信息
}
