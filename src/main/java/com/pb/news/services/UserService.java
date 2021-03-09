package com.pb.news.services;

import com.pb.news.entity.User;

import java.util.List;

/**
 * Created by pb on 2018/5/22.
 */
public interface UserService {

    List<User> getUserList(User user);

    User getUser(User user) throws Exception;

    User getUserByUserName(String userName);

}
