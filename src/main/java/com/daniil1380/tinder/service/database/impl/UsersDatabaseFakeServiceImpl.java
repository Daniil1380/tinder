package com.daniil1380.tinder.service.database.impl;

import com.daniil1380.tinder.entity.Sex;
import com.daniil1380.tinder.entity.User;
import com.daniil1380.tinder.service.database.UsersDatabaseService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsersDatabaseFakeServiceImpl implements UsersDatabaseService {

    private List<User> userList;

    @PostConstruct
    public void init() {
        System.out.println("UsersRepository init method starts");
        User user = new User();
        user.setName("Даниил");
        user.setSex(Sex.MALE);
        user.setPoints(10);

        User user1 = new User();
        user1.setName("Андрей");
        user1.setSex(Sex.MALE);
        user1.setPoints(5);

        User user2 = new User();
        user2.setName("Александр");
        user2.setSex(Sex.MALE);
        user2.setPoints(9);

        userList = new ArrayList<>();
        userList.add(user);
        userList.add(user1);
        userList.add(user2);
    }

    public List<User> getUserList(String str, boolean a) {
        return userList;
    }


}
