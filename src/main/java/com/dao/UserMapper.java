package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.entry.UserEntry;

@Mapper
public interface UserMapper {

    @Select("select user_id,user_name,user_address from user")
    List<UserEntry> findUserList();

   
    @Insert({"insert into user(user_id,user_name,user_address) values('${user.user_id}','${user.user_name}','${user.user_address}')"})
    int add(@Param("user") UserEntry user);
    
    
    @Delete("delete from user where user_id = #{user_id}")
    int delete(int user_id);

}

