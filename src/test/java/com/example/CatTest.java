package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    Feline feline;

    @Test
    public void getSound() {
        var expected = "Мяу";

        var cat = new Cat(feline);
        assertEquals(expected, cat.getSound());
    }

    @Test
    public void getFood() throws Exception {
        var expected = List.of("Животные", "Птицы", "Рыба");

        var cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(expected);

        assertEquals(expected, cat.getFood());
    }
}