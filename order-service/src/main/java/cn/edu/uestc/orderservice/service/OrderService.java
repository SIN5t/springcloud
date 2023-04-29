package cn.edu.uestc.orderservice.service;

import cn.edu.uestc.orderservice.domain.Order;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author PC
* @description 针对表【tb_order】的数据库操作Service
* @createDate 2023-04-12 17:11:37
*/
public interface OrderService extends IService<Order> {
    Order queryOrderByRestTemplate(Long orderId);
    Order queryOrderByFeign(Long orderId);

}
