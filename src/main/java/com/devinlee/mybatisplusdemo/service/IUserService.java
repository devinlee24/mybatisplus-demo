package com.devinlee.mybatisplusdemo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.devinlee.mybatisplusdemo.entity.User;

public interface IUserService extends IService<User> {

    Page<User> customPageUserList(Page<User> pageInfo,String name);
}