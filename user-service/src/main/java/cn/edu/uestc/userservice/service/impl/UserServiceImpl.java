package cn.edu.uestc.userservice.service.impl;

import cn.edu.uestc.userservice.domain.User;
import cn.edu.uestc.userservice.mapper.UserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.edu.uestc.userservice.service.UserService;
import org.springframework.stereotype.Service;

/**
* @author PC
* @description 针对表【tb_user】的数据库操作Service实现
* @createDate 2023-04-13 11:56:58
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




