package com.daniil1380.tinder.controller;

import com.daniil1380.tinder.entity.Sex;
import com.daniil1380.tinder.entity.User;
import com.daniil1380.tinder.service.match.MatchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequiredArgsConstructor
public class TinderController {

    private final MatchService matchService;

    @GetMapping(value = "/new-match")
    public ResponseEntity<User> getNewMatch() throws Exception {
            User user = matchService.getNewMatch();

            return user != null ? ResponseEntity.ok(user) : ResponseEntity.badRequest().build();
    }

}
