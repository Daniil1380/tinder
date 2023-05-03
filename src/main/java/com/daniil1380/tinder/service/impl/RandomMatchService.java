package com.daniil1380.tinder.service.impl;

import com.daniil1380.tinder.entity.User;
import com.daniil1380.tinder.service.MatchService;
import org.springframework.stereotype.Service;

@Service
public class RandomMatchService implements MatchService {

    @Override
    public User getNewMatch() {
        System.out.println("Нашелся случайный человек");
        return null;
    }

}
