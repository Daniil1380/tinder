package com.daniil1380.tinder.service.impl;

import com.daniil1380.tinder.entity.User;
import com.daniil1380.tinder.repository.UsersRepository;
import com.daniil1380.tinder.service.MatchService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@Primary
public class RandomMatchService implements MatchService {

    private UsersRepository usersRepository;

    public RandomMatchService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public User getNewMatch() {
        List<User> users = usersRepository.getUserList();
        Random random = new Random();
        int i = random.nextInt(users.size());
        return users.get(i);
    }

}
