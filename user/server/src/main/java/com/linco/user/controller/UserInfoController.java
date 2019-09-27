package com.linco.user.controller;

import com.linco.user.VO.ResultVO;
import com.linco.user.constant.CookieConstant;
import com.linco.user.constant.RedisConstant;
import com.linco.user.dataobject.UserInfo;
import com.linco.user.enums.ResultEnum;
import com.linco.user.enums.RoleEnum;
import com.linco.user.service.UserInfoService;
import com.linco.user.utils.CookieUtil;
import com.linco.user.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Classname: UserInfoController
 * @description: UserInfoController
 * @Author: Create by qingyulin(寧缺) qylningque@outlook.com
 * @Date: 2019-09-27 19:06
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 买家登录
     * @param openid
     * @param response
     * @return
     */
    @GetMapping("/buyer")
    public ResultVO buyer(@RequestParam("openid") String openid, HttpServletResponse response){
        //1.openid和数据库里的数据匹配
        UserInfo userInfo = userInfoService.findByOpenid(openid);
        if (userInfo == null){
            return ResultVOUtil.error(ResultEnum.LOGIN_FAIL);
        }
        //2.判断角色
        if (!RoleEnum.BUYER.getCode().equals(userInfo.getRole())){
            return ResultVOUtil.error(ResultEnum.ROLE_ERROR);
        }
        //3cookie里设置openid=abc
        CookieUtil.set(response, CookieConstant.OPENID,openid,CookieConstant.expire);
        return ResultVOUtil.success();
    }

    /**
     * 卖家登录
     * @param openid
     * @param response
     * @return
     */
    @GetMapping("/seller")
    public ResultVO seller(@RequestParam("openid") String openid,
                           HttpServletResponse response,
                           HttpServletRequest request){
        //0.判断是否已登录
        Cookie cookie = CookieUtil.get(request,CookieConstant.TOKEN);
        //cookie不为空且redis存在这个key且时间未过期则登录成功 TODO 判断时间未过期
        if (cookie != null && !StringUtils.isEmpty(redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_TEMPLATE, cookie.getValue())))){
            return ResultVOUtil.success();
        }
        //1.openid和数据库里的数据匹配
        UserInfo userInfo = userInfoService.findByOpenid(openid);
        if (userInfo == null){
            return ResultVOUtil.error(ResultEnum.LOGIN_FAIL);
        }
        //2.判断角色
        if (!RoleEnum.SELLER.getCode().equals(userInfo.getRole())){
            return ResultVOUtil.error(ResultEnum.ROLE_ERROR);
        }
        //3.往redis写 key=UUID,value=xyz(openid)
        //（redis放在前面，cookie放在后面，redis失败后就不往cookie中写）
        String token = UUID.randomUUID().toString();
        Integer expire = CookieConstant.expire;
        redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_TEMPLATE, token),
                openid,
                expire,
                TimeUnit.SECONDS);
        //4.cookie里设置token = UUID
        CookieUtil.set(response, CookieConstant.TOKEN,token,CookieConstant.expire);
        return ResultVOUtil.success();
    }

}
