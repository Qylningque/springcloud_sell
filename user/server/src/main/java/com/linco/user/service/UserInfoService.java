package com.linco.user.service;

import com.linco.user.dataobject.UserInfo;

/**
 * @Classname: UserInfoService
 * @description: UserInfoService
 * @Author: Create by qingyulin(寧缺) qylningque@outlook.com
 * @Date: 2019-09-27 18:58
 * @Version 1.0
 */
public interface UserInfoService {

    /**
     * 通过openid查询用户信息
     * @param openid
     * @return
     */
    UserInfo findByOpenid(String openid);

}
