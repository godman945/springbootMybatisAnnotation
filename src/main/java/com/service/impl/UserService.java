package com.service.impl;

import java.util.List;

import com.entry.UserEntry;

public interface UserService {

    List<UserEntry> findUserList();

    
    int addUser(int user_id,String user_name,String user_address);
    
    int deleteUser(int user_id);
}

