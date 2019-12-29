package com.ssm.crud.dao;

import com.ssm.crud.entity.MXD;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MXDDao {
    //查询所有用户
    public List<MXD> selectAllmxd();

    //根据ID查指定用户
    public MXD selectById(Integer id);

    //插入用户
    public int insertUser(MXD mxd);

    //删除用户
    public  int deleteUser(Integer id);
}
