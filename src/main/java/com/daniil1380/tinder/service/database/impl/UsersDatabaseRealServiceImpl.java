package com.daniil1380.tinder.service.database.impl;

import com.daniil1380.tinder.entity.Sex;
import com.daniil1380.tinder.entity.User;
import com.daniil1380.tinder.repository.UserRepository;
import com.daniil1380.tinder.service.database.UsersDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class UsersDatabaseRealServiceImpl implements UsersDatabaseService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUserList() {
        System.out.println("getUserByName:");
        System.out.println(userRepository.getUserByName("Daniil"));
        System.out.println("getUsersByIdIsIn:");
        System.out.println(userRepository.getUsersByIdIsIn(List.of(1, 2, 3)));
        return userRepository.findAll();
    }
}
