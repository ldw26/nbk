package com.sbm.demo.mapper;

import com.sbm.demo.bean.Person;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * @author 不若为止
 * @version 1.0
 * @class PersonMapper
 * @package com.wzhi.tableserver.dao
 * @desc 个人信息Mapper，此处的Mapper注解会被启动类的@MapperScan扫描到
 * @copyright weizhi
 * @date 2018/09/04
 */
@Mapper
public interface PersonMapper {
    /**
     * @desc 查询所有的用户
     * @return
     */
    List<Person> findAll();
}