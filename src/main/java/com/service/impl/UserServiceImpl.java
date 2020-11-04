package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.dao.UserMapper;
import com.entry.UserEntry;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    protected UserMapper userMapper;

    @Override
    public List<UserEntry> findUserList() {
        return userMapper.findUserList();
    }

    
    @Override
    public int addUser(int user_id,String user_name,String user_address) {
    	UserEntry user=new UserEntry();
        user.setUser_id(user_id);
        user.setUser_name(user_name);
        user.setUser_address(user_address);
        return userMapper.add(user);
    }

    @Override
    public int deleteUser(int user_id) {
        return userMapper.delete(user_id);
    }
}

