package com.daniil1380.tinder;

import com.daniil1380.tinder.entity.User;
import com.daniil1380.tinder.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.springframework.scheduling.annotation.Scheduled.CRON_DISABLED;

@Slf4j
@RequiredArgsConstructor
@Component
public class ScheduleTask {

    private final UserRepository userRepository;


    @Scheduled(cron = "* * * * *")
    public void doSomething() {
        if (1 == 0) {
            return;
        }

        log.info("Operation started");

        List<User> users = userRepository.findAll();
        for (User user : users) {
            user.setPoints(user.getPoints() / 2);
            userRepository.save(user);
        }

        log.info("Operation finished");
    }


}
