package cn.edu.uestc.orderservice.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import cn.edu.uestc.orderservice.domain.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author PC
* @description 针对表【tb_order】的数据库操作Mapper
* @createDate 2023-04-12 17:11:37
* @Entity cn.edu.uestc.orderservice.domain.Order
*/
@Mapper
public interface OrderMapper extends BaseMapper<Order> {
    List<Order> queryById(@Param("id") Long id);
}




