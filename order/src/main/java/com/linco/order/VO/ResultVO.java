package com.linco.order.VO;

import lombok.Data;

/**
 * @Classname: ResultVO
 * @description: 返回前端数据封装
 * @Author: Create by qingyulin(寧缺) qylningque@outlook.com
 * @Date: 2019-09-23 11:04
 * @Version 1.0
 */
@Data
public class ResultVO<T> {

    private Integer code;

    private String msg;

    private T data;

}
