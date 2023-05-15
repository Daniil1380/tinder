package com.daniil1380.tinder.controller;

import com.daniil1380.tinder.entity.User;
import com.daniil1380.tinder.repository.UserRepository;
import com.daniil1380.tinder.service.match.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class TinderController {

    private MatchService matchService;
    private UserRepository userRepository;

    @Autowired
    public TinderController(MatchService matchService, UserRepository userRepository) {
        this.matchService = matchService;
        this.userRepository = userRepository;
    }

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



}
