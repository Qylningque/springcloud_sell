package com.linco.order.service;

import com.linco.order.dto.OrderDTO;

/**
 * @Classname: OrderService
 * @description: OrderService
 * @Author: Create by qingyulin(寧缺) qylningque@outlook.com
 * @Date: 2019-09-23 11:02
 * @Version 1.0
 */
public interface OrderService {
    OrderDTO create(OrderDTO orderDTO);
}
