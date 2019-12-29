package com.ssm.crud.service.serviceImpl;

import com.ssm.crud.dao.MXDDao;
import com.ssm.crud.dao.userDao;
import com.ssm.crud.entity.MXD;
import com.ssm.crud.entity.User;
import com.ssm.crud.service.adminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * value==CacheNames  表示要往哪个cacheNames中存，类似于数据库表
 * key==keyGenerator    表示存放该内容的key。因为缓存器均是以key-value来村内容的。
 * condition 当条件成立时加入缓存，unless 为true是不加入缓存 sync 是否异步
 * 如果需要返回结果中的值 用 #result.userId     #result.表示返回对象  userId为对象中的属性
 * 如果需要方法参数中的值 用#id     id表示方法中参数名
 *    定义复杂缓存
 *     @Caching(
 *             cacheable = {
 *                     @Cacheable(value = "users",key = "#id")
 *             },
 *             put = {
 *                     @CachePut(value = "users",key = "#id"),
 *                     @CachePut(value = "users",key = "#id")
 *             }
 *     )
 *
 * 一下注解表示该类通用value也表示通用CacheNames。两者一样。再此处写了该类下的所有方法均不用再次书写
@CacheConfig(cacheNames = {"","",""})
@CacheConfig(cacheNames = "")
 */
@Service
public class adminServiceImpl implements adminService {


    @Autowired
    userDao userdao;

    @Autowired
    MXDDao mxdDao;

    @Override
    public List<MXD> selectAllmxd() {
        return mxdDao.selectAllmxd();
    }

    @Override
    public List<User> selectAll() {
        return userdao.selectAll();
    }

    @Override           //condition 当条件成立时加入缓存，unless 为true是不加入缓存 sync 是否异步
    @Cacheable(cacheNames = {"users"})
    public User selectById(Integer id) {
        System.out.println(id);
        return userdao.selectById(id);
    }

    @Override
    @CachePut(value = "users",key = "#result.userId")
    public User updateById(User user) {
        System.out.println("service");
        Integer i=1;
        System.out.println(userdao.updateById(user)==i);
        return user;
    }

    @Override
    @CacheEvict(value = "users", key = "#id")
    public void deleteTest(Integer id) {
        System.out.println(id);
    }

    @Override
    public int insertUser(User user) {
        System.out.println(user);
        return userdao.insertUser(user);
    }

    //定义复杂缓存
    @Caching(
            cacheable = {
                    @Cacheable(value = "users",key = "#id")
            },
            put = {
                    @CachePut(value = "users",key = "#id"),
                    @CachePut(value = "users",key = "#id")
            }
    )
    @Override
    public int deleteUser(Integer id) {
        return userdao.deleteUser(id);
    }
}
