package com.daniil1380.tinder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathsTest {

    @Test
    public void test() {
        Maths maths = new Maths();


        int result = maths.sum(4, 5);


        assertEquals(10, result);
    }

}