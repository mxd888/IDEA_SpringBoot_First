package com.ssm.crud.service;

import com.ssm.crud.entity.MXD;
import com.ssm.crud.entity.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface adminService {

    //查询所有用户
    public List<User> selectAll();
    public List<MXD> selectAllmxd();

    //根据ID查指定用户

    public User selectById(Integer id);
    //更新
    public User updateById(User user);
    //插入用户
    public int insertUser(User user);

    //删除用户
    public  int deleteUser(Integer id);

    public void deleteTest(Integer id);
}
