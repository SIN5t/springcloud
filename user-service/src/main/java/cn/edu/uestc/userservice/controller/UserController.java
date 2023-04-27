package cn.edu.uestc.userservice.controller;

import cn.edu.uestc.userservice.domain.User;
import cn.edu.uestc.userservice.service.UserService;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@RestController
@RequestMapping("/user")
@RefreshScope
public class UserController {

    @Resource
    UserService userService;

    @GetMapping("/{userId}")
    public User userController(@PathVariable("userId") String userId){
        User user = userService.getById(userId);
        return user;
    }


    @GetMapping("/test")
    public User userController1(String id){
        User user = userService.getById(id);
        return user;
    }

    @Value("${pattern.dateform}")
    private String dateForm;
    @GetMapping("time")
    public String nowController(){
        DateTimeFormatter time = DateTimeFormatter.ofPattern(dateForm, Locale.CHINA);
        String res = LocalDateTime.now().format(time);
        return res;
    }

}
