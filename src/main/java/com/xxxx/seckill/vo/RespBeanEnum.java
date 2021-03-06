package com.xxxx.seckill.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
/**
 * 返回状态枚举
 *
 * @author zhoubin
 * @since 1.0.0
 */
@ToString
@Getter
@AllArgsConstructor
public enum RespBeanEnum {
    //通用状态码
    SUCCESS(200,"success"),
    ERROR(500,"服务端异常"),
    //登录模块5002xx
    LOGINVO_ERROR(500210,"用户名或者密码错误"),
    MOBILE_ERROR(500211,"手机号码格式错误"),
    BIND_ERROR(500212,"手机号码格式错误"),
    MOBILE_NOT_EXIST(500213,"手机号码不存在"),
    PASSWORD_UPDATE_FAIL(500214,"更新号码失败"),
    SESSION_ERROR(500215,"session不存在或者已经失效"),
    //秒杀模块5005xx
    EMPTY_STOCK(500500,"库存为空"),
    REPEATE_ERROR(500501,"每人限购一件"),
    //订单模块
    ORDER_NOT_EXIST(500400,"订单不存在");
    private final Integer code;
    private final String message;
}
