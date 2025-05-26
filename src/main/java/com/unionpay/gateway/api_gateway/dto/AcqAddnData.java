package com.unionpay.gateway.api_gateway.dto;

import lombok.Data;

/**
 * 云闪付收款方附加数据
 */
@Data
public class AcqAddnData {
    private String merCatCode;        // 商户类别码
    private String merName;           // 商户名称
    private String merAbbr;           // 商户简称
    private String subMerId;          // 子商户号
    private String subMerName;        // 子商户名称
    private String subMerAbbr;        // 子商户简称
}
