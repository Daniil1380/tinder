package com.daniil1380.tinder.service.match.impl;

import com.daniil1380.tinder.entity.User;
import com.daniil1380.tinder.service.database.UsersDatabaseService;
import com.daniil1380.tinder.service.match.MatchService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HighestScoreMatchService implements MatchService {

    private UsersDatabaseService usersDatabaseService;

    public HighestScoreMatchService(UsersDatabaseService usersDatabaseService) {
        this.usersDatabaseService = usersDatabaseService;
    }

    @Override
    public User getNewMatch() {
        List<User> users = usersDatabaseService.getUserList();
        int maxPoint = 0;
        User highestRangUser = null;

        for (User user : users) {
            if (user.getPoints() > maxPoint) {
                maxPoint = user.getPoints();
                highestRangUser = user;
            }
        }

        return highestRangUser;
    }
}
