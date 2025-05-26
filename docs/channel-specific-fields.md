# 渠道特有字段说明

## 概述
根据第三方支付接口文档，不同渠道（微信、支付宝、云闪付）有各自的特有字段要求。本文档详细说明各渠道的必送字段和可选字段。

## 基础字段（所有渠道通用）
- `version`: 版本号，默认1.0
- `sign`: 签名串
- `signType`: 签名方式，固定为SM2
- `certId`: 证书ID
- `bizMethod`: 交易类型，固定为aggregate.trade.prepay
- `insCode`: 服务商机构号
- `timestamp`: 时间戳，格式：yyyy-MM-dd HH:mm:ss
- `merId`: 商户编号
- `outTradeNo`: 订单号
- `body`: 商品描述
- `subject`: 订单标题
- `txnAmt`: 交易金额（分）
- `termIp`: 终端IP
- `channelType`: 渠道类型（wx/ali/cup）

## 微信渠道特有字段

### 必送字段
- `qrType`: 二维码类型，默认使用 `unifiedjsapi`
- `qrId`: 商户二维码编号，使用订单号

### 可选字段
- `needReceipt`: 电子发票（1-需要，0-不需要），默认0
- `goodsTag`: 商品标记
- `detail`: 商品详情
- `wxSceneInfo`: 场景信息
- `timeStart`: 订单生成时间，格式：yyyymmddhhmmss
- `openid`: 微信买家用户标识（平台公众号下单必送）
- `subAppid`: 微信子商户公众号或小程序ID
- `subOpenid`: 微信买家用户子标识

### 注意事项
- 如果是平台公众号下单，`openid` 字段必送
- 如果是特约子商户公众号或小程序下单，`subAppid` 和 `subOpenid` 必送

## 支付宝渠道特有字段

### 必送字段
- `qrType`: 二维码类型，默认使用 `unifiedjsapi`
- `qrId`: 商户二维码编号，使用订单号
- `buyerId`: 买家支付宝用户id（支付宝渠道必送）

### 可选字段
- `extUserInfo`: 外部指定买家信息
- `offsetAmt`: 可打折金额（分），默认等于交易金额
- `aliGoodsDetail`: 商品信息列表
- `operatorId`: 商户操作员编号
- `storeId`: 商户门店编号
- `alipayStoreId`: 支付宝店铺编号
- `extendParams`: 业务扩展参数

### 注意事项
- `buyerId` 字段在支付宝渠道是必送的，需要从前端获取

## 云闪付渠道特有字段

### 必送字段
- `qrType`: 二维码类型，云闪付必送，默认使用 `unifiednative`
- `qrId`: 商户二维码编号，云闪付必送，使用订单号

### 可选字段
- `acqAddnData`: 收款方附加数据

### 注意事项
- 云闪付渠道的 `qrType` 和 `qrId` 是必送字段

## 实现说明

### 代码结构
1. `PrepayRequest`: 包含所有渠道字段的请求DTO
2. `PrepayRequestBuilder`: 工具类，根据渠道设置特有字段
3. `ChannelConstants`: 渠道相关常量定义
4. 各渠道特有字段的DTO类：
   - `WxSceneInfo`: 微信场景信息
   - `ExtUserInfo`: 支付宝外部用户信息
   - `AliGoodsDetail`: 支付宝商品详情
   - `AcqAddnData`: 云闪付收款方附加数据

### 使用方式
```java
// 在PrepayController中
String channelType = preOrder.getChannelType();
if (ChannelConstants.ChannelType.WECHAT.equals(channelType)) {
    PrepayRequestBuilder.setWxSpecificFields(builder, preOrder);
} else if (ChannelConstants.ChannelType.ALIPAY.equals(channelType)) {
    PrepayRequestBuilder.setAliSpecificFields(builder, preOrder);
} else if (ChannelConstants.ChannelType.UNIONPAY.equals(channelType)) {
    PrepayRequestBuilder.setCupSpecificFields(builder, preOrder);
}
```

## TODO 待完善
1. 微信的 `openid`、`subAppid`、`subOpenid` 需要从前端传入或配置中获取
2. 支付宝的 `buyerId` 需要从前端传入
3. 各渠道的商户配置信息需要从配置文件或数据库中获取
4. 签名逻辑需要根据各渠道要求实现
