# 聚合支付网关API

## 项目简介

这是一个基于Spring Boot WebFlux的聚合支付网关API项目，支持微信、支付宝、云闪付等多种支付渠道。

## 主要功能

- **预下单接口**：生成动态码，返回tokenNo供前端使用
- **支付接口**：使用tokenNo进行实际支付处理
- **多渠道支持**：微信、支付宝、云闪付
- **幂等性控制**：防止重复支付
- **Token验证**：确保支付安全性
- **异步处理**：基于WebFlux的响应式编程

## 技术栈

- **Java 21**
- **Spring Boot 3.x**
- **Spring WebFlux**（响应式编程）
- **Maven**（依赖管理）
- **MyBatis-Plus**（数据库操作）
- **Redis**（缓存和幂等性控制）
- **Lombok**（简化代码）

## 项目结构

```
src/main/java/com/unionpay/gateway/api_gateway/
├── config/                 # 配置类
├── constants/              # 常量定义
├── controller/             # 控制器层
├── dto/                    # 数据传输对象
├── exception/              # 异常处理
├── filter/                 # 过滤器
├── service/                # 服务层
└── util/                   # 工具类
```

## 接口说明

### 1. 预下单接口
- **路径**：`POST /api/inst/preorder`
- **功能**：生成动态码，返回tokenNo
- **用途**：前端获取tokenNo用于后续支付

### 2. 支付接口
- **路径**：`POST /api/pay/prepay`
- **功能**：使用tokenNo进行实际支付
- **特性**：支持幂等性控制，防止重复支付

### 3. 查询预下单信息
- **路径**：`POST /api/pay/preorder/query`
- **功能**：根据tokenNo查询预下单信息
- **安全性**：POST请求避免敏感信息在URL中暴露

## 渠道支持

### 微信支付
- 支持公众号支付（JSAPI）
- 支持小程序支付
- 支持APP支付

### 支付宝
- 支持网页支付
- 支持APP支付
- 支持扫码支付

### 云闪付
- 支持扫码支付
- 支持APP支付

## 安全特性

1. **Token机制**：每次预下单生成唯一token
2. **幂等性控制**：防止重复支付
3. **签名验证**：使用SM2算法进行签名
4. **敏感信息保护**：日志脱敏处理

## 快速开始

### 环境要求
- JDK 21+
- Maven 3.6+
- Redis 6.0+

### 运行步骤

1. 克隆项目
```bash
git clone https://github.com/a453653211/api-gateway.git
cd api-gateway
```

2. 配置数据库和Redis连接
```yaml
# application.yml
spring:
  redis:
    host: localhost
    port: 6379
```

3. 编译运行
```bash
mvn clean compile
mvn spring-boot:run
```

## 配置说明

详细的配置说明请参考：
- [API业务流程文档](docs/API-BUSINESS-FLOW.md)
- [安全和幂等性文档](docs/API-SECURITY-IDEMPOTENT.md)
- [渠道特有字段说明](docs/channel-specific-fields.md)

## 开发规范

- 使用Java 21特性
- 遵循Spring Boot最佳实践
- 代码注释完整，便于维护
- 严格的错误处理和日志记录
- 避免魔法值，使用常量类管理

## 贡献指南

1. Fork 项目
2. 创建特性分支
3. 提交更改
4. 推送到分支
5. 创建 Pull Request

## 许可证

本项目采用 MIT 许可证。