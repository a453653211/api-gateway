package com.unionpay.gateway.api_gateway.dto;

import lombok.Data;

/**
 * 支付宝商品详情信息
 */
@Data
public class AliGoodsDetail {
    private String goods_id;          // 商品的编号
    private String goods_name;        // 商品名称
    private String quantity;          // 商品数量
    private String price;             // 商品单价，单位为元
    private String goods_category;    // 商品类目
    private String categories_tree;   // 商品类目树
    private String body;              // 商品描述信息
    private String show_url;          // 商品的展示地址
}
