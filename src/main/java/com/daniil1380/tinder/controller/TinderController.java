package com.daniil1380.tinder.controller;

import com.daniil1380.tinder.entity.User;
import com.daniil1380.tinder.repository.UserRepository;
import com.daniil1380.tinder.service.match.MatchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.Random;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TinderController {

    private final MatchService matchService;
    private final UserRepository userRepository;


    @GetMapping(value = "/new-match")
    public User getNewMatch() {
        return matchService.getNewMatch();
    }

    @GetMapping(value = "/user/{id}")
    @Cacheable(value = "USERS", key = "#id")
    public User getUser(@PathVariable(name = "id") Integer id) throws InterruptedException {
        System.out.println("Method started");
        Thread.sleep(5000);
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            return userOptional.get();
        }
        else {
            return null;
        }
    }

    @GetMapping("/update-users/{id}")
    @CachePut(value = "USERS", key = "#id")
    public User updateUsers(@PathVariable(name = "id") Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setPoints(user.getPoints() + 1);
            userRepository.save(user);
            return user;
        }
        return null;
    }

    @GetMapping("/update-user/{id}")
    @CacheEvict(value = "USERS", key = "#id")
    public void updateUser(@PathVariable(name = "id") Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setPoints(user.getPoints() + 1);
            userRepository.save(user);
        }
    }

    @GetMapping("/gift/{first}/{second}")
    @Transactional
    public void gift(@PathVariable Integer first, @PathVariable Integer second) {
        User firstUser = userRepository.selectByID(first);
        User secondUser = userRepository.selectByID(second);
        Random random = new Random();

        firstUser.setPoints(firstUser.getPoints() - 100);
        userRepository.save(firstUser);

        if (random.nextInt(10) < 9) {
            throw new RuntimeException();
        }

        secondUser.setPoints(secondUser.getPoints() + 100);
        userRepository.save(secondUser);
    }

}
