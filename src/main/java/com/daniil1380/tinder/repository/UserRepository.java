package com.daniil1380.tinder.repository;

import com.daniil1380.tinder.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User getUserByName(String name);

    Collection<User> getUsersByIdAfterOrderByNameDesc(int id);
    //найти всех пользователей, id которых "после" int id
    // и отсортировать их по имени в обратном порядке

    Collection<User> getUsersByIdIsIn(Collection<Integer> ids);

        //SELECT * FROM user where id in (.........)

    User getTopById(int id);

    void deleteUserByNameEndsWith(String endsWith);

    //DELETE from user where name ilike '%......'

    @Query("SELECT new User(user.id, user.name, user.sex, user.points) from User user" +
            " where user.id = :id")
    User selectByID(@Param("id") Integer id);

}
