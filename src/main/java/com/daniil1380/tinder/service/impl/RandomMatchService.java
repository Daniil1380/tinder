package com.daniil1380.tinder.service.impl;

import com.daniil1380.tinder.entity.User;
import com.daniil1380.tinder.repository.UsersRepository;
import com.daniil1380.tinder.service.MatchService;
import org.springframework.stereotype.Service;

@Service
public class RandomMatchService implements MatchService {

    private UsersRepository usersRepository;

    @Override
    public User getNewMatch() {
        System.out.println("RandomMatchService");
        return null;
    }

}
