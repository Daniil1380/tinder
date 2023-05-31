package com.daniil1380.tinder.service.match.impl;

import com.daniil1380.tinder.entity.Account;
import com.daniil1380.tinder.service.database.UsersDatabaseService;
import com.daniil1380.tinder.service.match.MatchService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HighestScoreMatchService implements MatchService {

    private UsersDatabaseService usersDatabaseService;

    public HighestScoreMatchService(UsersDatabaseService usersDatabaseService) {
        this.usersDatabaseService = usersDatabaseService;
    }

    @Override
    @Transactional
    public Account getNewMatch() {
        List<Account> users = usersDatabaseService.getUserList(); //LinkedList из 0 элементов


        if (users == null) {
            return null;
        }

        int maxPoint = 0;
        Account highestRangUser = null;

        for (Account user : users) {
            Integer points = user.getPoints();
            if (points != null && points > maxPoint) {
                maxPoint = user.getPoints();
                highestRangUser = user;
            }
        }

        return highestRangUser;
    }
}
