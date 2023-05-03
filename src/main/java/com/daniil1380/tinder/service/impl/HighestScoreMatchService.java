package com.daniil1380.tinder.service.impl;

import com.daniil1380.tinder.entity.User;
import com.daniil1380.tinder.repository.UsersRepository;
import com.daniil1380.tinder.service.MatchService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class HighestScoreMatchService implements MatchService {

    private UsersRepository usersRepository;

    @Override
    public User getNewMatch() {
        System.out.println("HighestScoreMatchService");
        return null;
    }
}
