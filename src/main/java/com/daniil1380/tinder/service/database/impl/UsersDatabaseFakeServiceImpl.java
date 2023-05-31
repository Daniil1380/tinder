package com.daniil1380.tinder.service.database.impl;

import com.daniil1380.tinder.entity.Sex;
import com.daniil1380.tinder.entity.Account;
import com.daniil1380.tinder.service.database.UsersDatabaseService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsersDatabaseFakeServiceImpl implements UsersDatabaseService {

    private List<Account> userList;

    @PostConstruct
    public void init() {
        System.out.println("UsersRepository init method starts");
        Account user = new Account();
        user.setName("Даниил");
        user.setSex(Sex.MALE);
        user.setPoints(10);

        Account user1 = new Account();
        user1.setName("Андрей");
        user1.setSex(Sex.MALE);
        user1.setPoints(5);

        Account user2 = new Account();
        user2.setName("Александр");
        user2.setSex(Sex.MALE);
        user2.setPoints(9);

        userList = new ArrayList<>();
        userList.add(user);
        userList.add(user1);
        userList.add(user2);
    }

    public List<Account> getUserList(String str, boolean a) {
        return userList;
    }


    @Override
    public List<Account> getUserList() {
        return null;
    }

    @Override
    public List<Account> getBySex(Sex sex) {
        return null;
    }

    @Override
    public Account getByName(String name) {
        return null;
    }
}
