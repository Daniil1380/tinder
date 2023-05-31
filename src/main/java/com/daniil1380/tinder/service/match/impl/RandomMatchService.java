package com.daniil1380.tinder.service.match.impl;

import com.daniil1380.tinder.entity.Account;
import com.daniil1380.tinder.entity.Sex;
import com.daniil1380.tinder.repository.UserRepository;
import com.daniil1380.tinder.service.database.UsersDatabaseService;
import com.daniil1380.tinder.service.match.MatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@Primary
@RequiredArgsConstructor
public class RandomMatchService implements MatchService {

    private final UsersDatabaseService usersDatabaseService;


    @Override
    public Account getNewMatch() {
        String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();
        Account account = usersDatabaseService.getByName(currentUserName.split("_")[0]);
        Sex sex;

        if (account.getSex().equals(Sex.MALE)) {
            sex = Sex.FEMALE;
        }
        else {
            sex = Sex.MALE;
        }
        List<Account> users = usersDatabaseService.getBySex(sex);
        Random random = new Random();
        int i = random.nextInt(users.size());
        return users.get(i);
    }



}
