package com.daniil1380.tinder.service.impl;

import com.daniil1380.tinder.entity.User;
import com.daniil1380.tinder.repository.UsersRepository;
import com.daniil1380.tinder.service.MatchService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HighestScoreMatchService implements MatchService {

    private UsersRepository usersRepository;

    public HighestScoreMatchService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public User getNewMatch() {
        List<User> users = usersRepository.getUserList();
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
