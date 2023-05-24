package com.daniil1380.tinder.service.match.impl;

import com.daniil1380.tinder.entity.Sex;
import com.daniil1380.tinder.entity.User;
import com.daniil1380.tinder.service.database.UsersDatabaseService;
import com.daniil1380.tinder.service.database.impl.UsersDatabaseRealServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class HighestScoreMatchServiceTest {

    @Mock
    private UsersDatabaseService usersDatabaseService;

    @InjectMocks
    private HighestScoreMatchService highestScoreMatchService;


    @Test
    public void getNewMatch_twoUsersWithDifferentPoints_success() {
        //создание различных обьектов, моков, и тд
        User expected = new User(2, "Kirill", Sex.MALE, 101);

        List<User> list = new ArrayList<>();
        list.add(new User(1, "Daniil", Sex.MALE, 100));
        list.add(expected);


        when(usersDatabaseService.getUserList(any(), anyBoolean())).thenReturn(list);
        //doThrow(NullPointerException.class).when(usersDatabaseService).getUserList(any(), anyBoolean());


        //вызов метода, который ткстируем
        //assertThrows(NullPointerException.class, () -> highestScoreMatchService.getNewMatch());
        User actual = highestScoreMatchService.getNewMatch();


        //проверка результатов
        assertNotNull(actual);
        assertEquals(expected, actual);
        verify(usersDatabaseService, times(1)).getUserList(any(), anyBoolean());
    }


}