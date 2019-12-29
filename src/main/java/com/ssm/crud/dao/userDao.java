package com.ssm.crud.dao;

import com.ssm.crud.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface userDao {

    //查询所有用户
    public List<User> selectAll();

    //根据ID查指定用户
    public User selectById(Integer id);
    //更新
    public int updateById(User user);
    //插入用户
    public int insertUser(User user);

    //删除用户
    public  int deleteUser(Integer id);

}
