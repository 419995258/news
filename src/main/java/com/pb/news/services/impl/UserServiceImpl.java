package com.pb.news.services.impl;

import com.pb.news.dao.UserMapper;
import com.pb.news.dao.vo.UserMapperExt;
import com.pb.news.entity.User;
import com.pb.news.entity.UserExample;
import com.pb.news.services.UserService;
import com.pb.news.services.vo.RedisService;
import com.pb.news.util.Basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//import org.springframework.web.multipart.MultipartFile;

/**
 * Created by pb on 2018/5/22.
 */

@Service
public class UserServiceImpl extends Basic implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserMapperExt userMapperExt;

    @Autowired
    private RedisService redisService;


    @Override
    public List<User> getUserList(User user) {
        List<User> userList = new ArrayList<>();
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(user.getUsername())
                .andPasswordEqualTo(user.getPassword());
        userList = userMapper.selectByExample(userExample);

        //test1 = userMapper.test();

        //test1 = userMapper.selectRoleByUserId(1);

        //test1 = userMapper.selectRolePermissionByUserId(1);
        return userList;
    }

    /**
     * @param
     * @return
     * @throws
     * @Description: TODO
     * @author pengbin <pengbin> 2018/10/31 14:15
     */
    @Override
    public User getUser(User user) throws Exception {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(user.getUsername())
                .andPasswordEqualTo(user.getPassword());

        List<User> userList = new ArrayList<>();
        userList = userMapper.selectByExample(userExample);

        if (userList.size() > 0) {
            user = userList.get(0);
        } else {
            user = new User();
        }

        return user;
    }


    /**
     * 获取user通过username
     *
     * @param
     * @return
     * @throws
     * @Description: TODO
     * @author pengbin <pengbin> 2018/10/31 14:26
     */
    @Override
    public User getUserByUserName(String userName) {
        User user = new User();
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(userName);

        List<User> userList = new ArrayList<>();
        userList = userMapper.selectByExample(userExample);

        if (userList.size() > 0) {
            user = userList.get(0);
        } else {
            user = new User();
        }

        return user;
    }
}
