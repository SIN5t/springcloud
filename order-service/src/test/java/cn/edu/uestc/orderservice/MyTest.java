package cn.edu.uestc.orderservice;


import cn.edu.uestc.orderservice.domain.Order;
import cn.edu.uestc.orderservice.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest()
@RunWith(SpringRunner.class)
public class MyTest {
    @Resource
    OrderService orderService;

    @Test
    public void myTest(){
        Order order = orderService.getById(101);
        System.out.println(order);
    }
}
