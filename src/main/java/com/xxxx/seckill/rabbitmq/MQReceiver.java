package com.xxxx.seckill.rabbitmq;

import com.xxxx.seckill.pojo.SeckillMessage;
import com.xxxx.seckill.pojo.SeckillOrder;
import com.xxxx.seckill.pojo.User;
import com.xxxx.seckill.service.IGoodsService;
import com.xxxx.seckill.service.IOrderService;
import com.xxxx.seckill.utils.JsonUtil;
import com.xxxx.seckill.vo.GoodsVo;
import com.xxxx.seckill.vo.RespBean;
import com.xxxx.seckill.vo.RespBeanEnum;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MQReceiver {

//    @RabbitListener(queues="queue")
//    public void receive(Object msg){
//        log.info("接收消息"+msg);
//    }
//
//    @RabbitListener(queues="queue_fanout01")
//    public void receive01(Object msg){
//        log.info("QUEUE01接收消息"+msg);
//    }
//
//    @RabbitListener(queues="queue_fanout02")
//    public void receive02(Object msg){
//        log.info("QUEUE02接收消息"+msg);
//    }
//
//    @RabbitListener(queues="queue_direct01")
//    public void receive03(Object msg){
//        log.info("QUEUE01接收消息"+msg);
//    }
//
//    @RabbitListener(queues="queue_direct02")
//    public void receive04(Object msg){
//        log.info("QUEUE02接收消息"+msg);
//    }
//
//    @RabbitListener(queues="queue_topic01")
//    public void receive05(Object msg){
//        log.info("QUEUE01接收消息"+msg);
//    }
//
//    @RabbitListener(queues="queue_topic02")
//    public void receive06(Object msg){
//        log.info("QUEUE02接收消息"+msg);
//    }

    @Autowired
    private IGoodsService goodsService;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private IOrderService orderService;

    @RabbitListener(queues="seckillQueue")
    public void receive(String msg){
        log.info("接收消息"+msg);
        SeckillMessage seckillMessage = JsonUtil.jsonStr2Object(msg, SeckillMessage.class);
        Long goodsId=seckillMessage.getGoodsId();
        User user = seckillMessage.getUser();
        //判断库存
        GoodsVo goodsVo = goodsService.findGoodsVoByGoodsId(goodsId);
        if(goodsVo.getStockCount()<1){
            return;
        }
        //判断是否重复抢购
        SeckillOrder seckillOrder =(SeckillOrder) redisTemplate.opsForValue().get("order:"+user.getId()+":"+goodsId);
        if (seckillOrder != null) {
            return;
        }
        orderService.seckill(user,goodsVo);
    }
}
