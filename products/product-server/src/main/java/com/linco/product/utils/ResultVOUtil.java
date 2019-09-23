package com.linco.product.utils;

import com.linco.product.vo.ResultVO;

/**
 * @Classname: ResultVOUtil
 * @description: ResultVOUtil工具类
 * @Author: Create by qingyulin(寧缺) qylningque@outlook.com
 * @Date: 2019-09-22 15:47
 * @Version 1.0
 */
public class ResultVOUtil {

    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(object);
        return resultVO;
    }

}
