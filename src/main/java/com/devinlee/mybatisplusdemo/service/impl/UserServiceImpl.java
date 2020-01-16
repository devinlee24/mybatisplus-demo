package com.devinlee.mybatisplusdemo.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.devinlee.mybatisplusdemo.entity.User;
import com.devinlee.mybatisplusdemo.mapper.UserMapper;
import com.devinlee.mybatisplusdemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public Page<User> customPageUserList(Page<User> page,String name) {

        userMapper.customPageUserList(page,name);
        return page;
    }
}
