package com.daniil1380.tinder.repository;

import com.daniil1380.tinder.entity.Account;
import com.daniil1380.tinder.entity.Sex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Account, Integer> {

    Account getUserByName(String name);

    Collection<Account> getUsersByIdAfterOrderByNameDesc(int id);
    //найти всех пользователей, id которых "после" int id
    // и отсортировать их по имени в обратном порядке

    Collection<Account> getUsersByIdIsIn(Collection<Integer> ids);

        //SELECT * FROM user where id in (.........)

    Account getTopById(int id);

    void deleteUserByNameEndsWith(String endsWith);

    //DELETE from user where name ilike '%......'

    @Query("SELECT new Account(user.id, user.name, user.sex, user.points) from Account user" +
            " where user.id = :id")
    Account selectByID(@Param("id") Integer id);

    List<Account> findAccountsBySex(Sex sex);

    Account findAccountByName(String name);

}
