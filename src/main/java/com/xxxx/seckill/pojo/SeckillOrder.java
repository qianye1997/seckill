package com.xxxx.seckill.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhoubin
 * @since 2021-06-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_seckill_order")
public class SeckillOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private Long userId;

    private String orderId;

    private Long goodsId;


}
