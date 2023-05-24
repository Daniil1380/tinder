package com.daniil1380.tinder.service.match.impl;

import com.daniil1380.tinder.entity.User;
import com.daniil1380.tinder.service.database.UsersDatabaseService;
import com.daniil1380.tinder.service.match.MatchService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@Primary
public class RandomMatchService implements MatchService {

    private UsersDatabaseService usersDatabaseService;

    public RandomMatchService(UsersDatabaseService usersDatabaseService) {
        this.usersDatabaseService = usersDatabaseService;
    }

    @Override
    public User getNewMatch() {
        List<User> users = usersDatabaseService.getUserList("", true);
        Random random = new Random();
        int i = random.nextInt(users.size());
        return users.get(i);
    }



}
