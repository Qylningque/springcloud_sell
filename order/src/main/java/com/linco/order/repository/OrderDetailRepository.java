package com.linco.order.repository;

import com.linco.order.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Classname: OrderDetailRepository
 * @description: OrderDetail DAO
 * @Author: Create by qingyulin(寧缺) qylningque@outlook.com
 * @Date: 2019-09-23 10:18
 * @Version 1.0
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {
}
