package com.wanzhon.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wanzhon.model.User;
import com.wanzhon.page.Page;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    public List<User> getUsers(Page page);
    
    public long getAllUserCount();//查询所有的记录数
    
    List<User> queryForList();//查询包含Role的所有的User
    
    User selectUserInfoById(Integer id);//根据UserId查询包含Role的结果集
    
    List<User> selectUserByUsername(@Param("username") String username);  

    public List<User> getAllUser();
}