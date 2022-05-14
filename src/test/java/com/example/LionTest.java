package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Feline feline;

    @Test
    public void incorrectSex() throws Exception {
        var expected = "Используйте допустимые значения пола животного - самец или самка";

        Exception exc = assertThrows(Exception.class, () -> { new Lion(feline,"Оно"); });

        assertEquals(expected, exc.getMessage());
    }

    @Test
    public void getKittens() throws Exception {
        var expected = 10000;

        var lion = new Lion(feline,"Самец");
        Mockito.when(feline.getKittens()).thenReturn(expected);

        assertEquals(expected, lion.getKittens());
    }

    @Test
    public void doesHaveMane() throws Exception {
        var expected = true;

        var lion = new Lion(feline, "Самец");

        assertEquals(expected, lion.doesHaveMane());
    }

    @Test
    public void doesNotHaveMane() throws Exception {
        var expected = false;

        var lion = new Lion(feline, "Самка");

        assertEquals(expected, lion.doesHaveMane());
    }

    @Test
    public void getFood() throws Exception {
        var expected = List.of("Животные", "Птицы", "Рыба");

        var lion = new Lion(feline,"Самец");
        Mockito.when(feline.eatMeat()).thenReturn(expected);

        assertEquals(expected, lion.getFood());
    }
}