package com.linco.product.VO;

import lombok.Data;

/**
 * @Classname: ResultVO
 * @description: 最外层返回对象
 * @Author: Create by qingyulin(寧缺) qylningque@outlook.com
 * @Date: 2019-09-22 15:11
 * @Version 1.0
 */
@Data
public class ResultVO<T> {
    /** 错误码 */
    private Integer code;
    /** 提示信息 */
    private String msg;
    /** 具体内容 */
    private T data;

}
