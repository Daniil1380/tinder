package com.daniil1380.tinder.service.database;

import com.daniil1380.tinder.entity.Account;
import com.daniil1380.tinder.entity.Sex;

import java.util.List;

public interface UsersDatabaseService {

    List<Account> getUserList();

    List<Account> getBySex(Sex sex);

    Account getByName(String name);

}
