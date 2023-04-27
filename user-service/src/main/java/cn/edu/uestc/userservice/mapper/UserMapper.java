package cn.edu.uestc.userservice.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import cn.edu.uestc.userservice.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author PC
* @description 针对表【tb_user】的数据库操作Mapper
* @createDate 2023-04-13 11:56:58
* @Entity cn.edu.uestc.orderservice.domain.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {
    List<User> queryById(@Param("id") Long id);

}




