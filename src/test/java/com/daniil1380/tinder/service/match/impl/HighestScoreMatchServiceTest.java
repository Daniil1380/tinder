package com.daniil1380.tinder.service.match.impl;

import com.daniil1380.tinder.entity.Sex;
import com.daniil1380.tinder.entity.Account;
import com.daniil1380.tinder.service.database.UsersDatabaseService;
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
        Account expected = new Account(2, "Kirill", Sex.MALE, 101);

        List<Account> list = new ArrayList<>();
        list.add(new Account(1, "Daniil", Sex.MALE, 100));
        list.add(expected);


        when(usersDatabaseService.getUserList()).thenReturn(list);
        //doThrow(NullPointerException.class).when(usersDatabaseService).getUserList(any(), anyBoolean());


        //вызов метода, который ткстируем
        //assertThrows(NullPointerException.class, () -> highestScoreMatchService.getNewMatch());
        Account actual = highestScoreMatchService.getNewMatch();


        //проверка результатов
        assertNotNull(actual);
        assertEquals(expected, actual);
        verify(usersDatabaseService, times(1)).getUserList();
    }


}