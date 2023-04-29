package cn.edu.uestc.orderservice.service.impl;

import cn.edu.uestc.feignapi.clients.UserClient;
import cn.edu.uestc.feignapi.domain.User;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.edu.uestc.orderservice.domain.Order;
import cn.edu.uestc.orderservice.service.OrderService;
import cn.edu.uestc.orderservice.mapper.OrderMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import javax.annotation.Resource;
import java.util.List;

/**
* @author PC
* @description 针对表【tb_order】的数据库操作Service实现
* @createDate 2023-04-12 17:11:37
*/
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
    implements OrderService{

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private OrderMapper orderMapper;

    @Override
    public Order queryOrderByRestTemplate(Long orderId) {
        //1、查询订单
        //rder order = this.getById(orderId);
        List<Order> orders = orderMapper.queryById(orderId);
        Order order = orders.get(0);
        // 2.利用RestTemplate发起http请求，查询用户
        //url，不需要管服务的地址，服务名称放上去，就会自动找到，eureka客户端工具会做（用服务提供者的服务名称调用）
        //String url = "http://localhost:8081/user/" + order.getUserId();
        //注意下面这个不是真是的地址，肯定会有处理器把请求拦截下来，处理一下---ribbon
        String url = "http://userservice:8081/user/" + order.getUserId();

        //发送http请求
        User user = restTemplate.getForObject(url, User.class);
        //3.封装
        order.setUser(user);

        return order;
    }
    @Resource
    private UserClient userClient;

    public Order queryOrderByFeign(Long orderId) {
        //1、查询订单
        //Order order = this.getById(orderId);
        List<Order> orders = orderMapper.queryById(orderId);
        Order order = orders.get(0);
        // 2.利用Feign来查询，根据order对应的UserId查询order对应的user
        User user = userClient.findByFeignId(order.getUserId());

        //3.封装
        order.setUser(user);
        return order;
    }
}




