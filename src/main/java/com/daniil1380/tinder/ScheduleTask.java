package com.daniil1380.tinder;

import com.daniil1380.tinder.entity.Account;
import com.daniil1380.tinder.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component
public class ScheduleTask {

    private final UserRepository userRepository;


    @Scheduled(cron = "5 * * * * *")
    public void doSomething() {
        if (1 == 0) {
            return;
        }

        log.info("Operation started");

        List<Account> users = userRepository.findAll();
        for (Account user : users) {
            user.setPoints(user.getPoints() / 2);
            userRepository.save(user);
        }

        log.info("Operation finished");
    }


}
