package com.daniil1380.tinder.service.impl;

import com.daniil1380.tinder.entity.User;
import com.daniil1380.tinder.repository.UserRepository;
import com.daniil1380.tinder.service.UsersDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersDatabaseRealServiceImpl implements UsersDatabaseService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUserList() {
        return null;
    }
}