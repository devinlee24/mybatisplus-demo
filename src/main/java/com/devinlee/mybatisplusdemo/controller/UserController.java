package com.devinlee.mybatisplusdemo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.devinlee.mybatisplusdemo.entity.User;
import com.devinlee.mybatisplusdemo.mapper.UserMapper;
import com.devinlee.mybatisplusdemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserMapper userMapper;

    @Autowired
    IUserService iUserService;

    @GetMapping("/selectUserList/{name}/{age}")
    public Object selectUserList(@PathVariable(name = "name")String name,@PathVariable(name = "age")Integer age){

        //条件查询构造器
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.eq("name",name);
        queryWrapper.eq("age",age);

        return userMapper.selectList(queryWrapper);
    }

    @GetMapping("/updateUser/{id}/{name}")
    public Object selectUserList(@PathVariable(name = "id")Integer id,@PathVariable(name = "name")String name){

        //条件更新构造器
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<User>();
        updateWrapper.set("name",name);
        updateWrapper.eq("id",id);

        return userMapper.update(null,updateWrapper);
    }

    @GetMapping("/delUser/{id}")
    public Object delUser(@PathVariable(name = "id")Integer id){

        //根据ID删除
        return userMapper.deleteById(id);
    }

    @GetMapping("/pageUserList/{current}/{size}")
    public Object pageUserList(@PathVariable(name = "current")Integer current,@PathVariable(name = "size")Integer size){

        //分页查询
        IPage<User> pageInfo = new Page<User>(current,size);
        //条件查询构造器
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        return iUserService.page(pageInfo,null);
    }

    @GetMapping("/customPageUserList/{name}/{current}/{size}")
    public Object customPageUserList(@PathVariable(name = "name")String name,@PathVariable(name = "current")Integer current,@PathVariable(name = "size")Integer size){

        //分页查询
        Page<User> pageInfo = new Page<User>(current,size);
        //条件查询构造器
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        return iUserService.customPageUserList(pageInfo,name);
    }
}
