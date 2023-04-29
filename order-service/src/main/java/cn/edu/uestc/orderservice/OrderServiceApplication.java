package cn.edu.uestc.orderservice;

import cn.edu.uestc.feignapi.clients.UserClient;
import cn.edu.uestc.feignapi.config.DefaultFeignConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;

@SpringBootApplication
@Slf4j
//下面这个clients = UserClient.class是要加的，因为包扫描的时候，只扫描到最上面的那个包名：cn.edu.uestc.orderservice,
// 没扫描到fein，因此在依赖注入@Resource的时候，就没有把对应的实例注入。所以就经常出我们遇到的那个错误
@EnableFeignClients(clients = UserClient.class, defaultConfiguration = DefaultFeignConfiguration.class)
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
        log.info("order-service项目启动成功");
    }

    /**
     * 创建RestTemplate并注入Spring容器
     */
    @Bean
    @LoadBalanced //负载均衡
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
