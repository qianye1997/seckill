package com.xxxx.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.seckill.pojo.User;
import com.xxxx.seckill.vo.LoginVo;
import com.xxxx.seckill.vo.RespBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhoubin
 * @since 2021-06-18
 */
public interface IUserService extends IService<User> {

    RespBean doLogin(HttpServletRequest request, HttpServletResponse response, LoginVo loginVo);
    User getByUserCookie(String ticket,HttpServletRequest request, HttpServletResponse response);
}
