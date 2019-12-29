package com.ssm.crud;

import com.ssm.crud.dao.userDao;
import com.ssm.crud.entity.User;
import com.ssm.crud.service.adminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


@SpringBootTest
class CrudApplicationTests {
    @Autowired
    adminService adminService;
    @Autowired
    userDao userdao;
    @Autowired
    DataSource dataSource;
    @Autowired
    StringRedisTemplate stringRedisTemplate;    //针对k-v都是字符串操作
    @Autowired
    RedisTemplate redisTemplate;                //k-v都是对象
    @Autowired
    RedisTemplate<Object, User> UserredisTemplate;

    /**
     *          stringRedisTemplate.opsForValue(); 操作字符创
     *         stringRedisTemplate.opsForList();    操作list
     *         stringRedisTemplate.opsForHash();    操作哈希
     *         stringRedisTemplate.opsForSet();     操作set
     *         stringRedisTemplate.opsForZSet();       操作zset
     *         --------> 与redisTemplate相似
     */
    @Test
    public void servicetest(){
        adminService.selectById(1);
    }

    @Test
    public void redistest(){
        //stringRedisTemplate.opsForValue().append("msg","hello");      //存数据
        //String msg = stringRedisTemplate.opsForValue().get("msg");    //取数据
        User user = userdao.selectById(1);
        //redisTemplate.opsForValue().set("user-01",user);
        UserredisTemplate.opsForValue().set("user-01",user);
        User user1 = UserredisTemplate.opsForValue().get("user-01");
        System.out.println(user1);
    }

    //测试连接阿里巴巴数据连接池是否成功
    @Test
    void contextLoads() throws SQLException {
        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

}
