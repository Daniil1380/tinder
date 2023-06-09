package com.daniil1380.tinder.service.database.impl;

import com.daniil1380.tinder.entity.Account;
import com.daniil1380.tinder.entity.Sex;
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
    public List<Account> getUserList() {
        return userRepository.findAll();
    }

    @Override
    public List<Account> getBySex(Sex sex) {
        return userRepository.findAccountsBySex(sex);
    }

    @Override
    public Account getByName(String name) {
        return userRepository.findAccountByName(name);
    }
}
