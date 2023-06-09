package cn.edu.uestc.orderservice.controller;

import cn.edu.uestc.orderservice.domain.Order;
import cn.edu.uestc.orderservice.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("order")
public class OrderController {

    @Resource
    OrderService orderService;

    //一杠一值，一杠一括号都忘了！在SpringMVC中可以使用占位符进行参数绑定，地址/list/1/3可以写成/list/{page}/{limit}，占位符{page}和{limit}对应的值就是1和3。在业务方法中我们可以使用@PathVariable注解进行占位符的匹配获取工作。
    @GetMapping("/{orderId}")
    @ResponseBody
    public Order queryOrderById(@PathVariable("orderId") Long orderId){
        Order order = orderService.getById(orderId);
        return order;
    }

    @GetMapping("/rest/{orderId}")
    @ResponseBody
    public Order queryOrderByRestTemplate(@PathVariable("orderId") Long orderId){
        Order order = orderService.queryOrderByRestTemplate(orderId);
        return order;
    }

    @GetMapping("/feign/{orderId}")
    @ResponseBody
    public Order queryOrderByFeignController(@PathVariable("orderId") Long orderId,
                                             @RequestHeader(value ="Msg",required = false) String msg){
        Order order = orderService.queryOrderByFeign(orderId);
        log.info("msg = {}",msg);
        return order;
    }

}
