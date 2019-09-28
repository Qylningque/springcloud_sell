package com.linco.order.service;

import com.linco.order.dto.OrderDTO;
import org.aspectj.weaver.ast.Or;

/**
 * @Classname: OrderService
 * @description: OrderService
 * @Author: Create by qingyulin(寧缺) qylningque@outlook.com
 * @Date: 2019-09-23 11:02
 * @Version 1.0
 */
public interface OrderService {
    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    OrderDTO create(OrderDTO orderDTO);

    /**
     * 完结订单（只能卖家来操作）
     * @param orderId
     * @return
     */
    OrderDTO finish(String orderId);
}
