package com.daniil1380.tinder.controller;

import com.daniil1380.tinder.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TinderController {

    @GetMapping(value = "/new-match")
    public User getNewMatch() {

    }

}
