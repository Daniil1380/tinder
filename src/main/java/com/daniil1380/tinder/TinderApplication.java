package com.daniil1380.tinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableCaching
@EnableScheduling
public class TinderApplication {

    public static void main(String[] args) {

        SpringApplication.run(TinderApplication.class, args);
    }

}
