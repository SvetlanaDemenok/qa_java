package com.example;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class FelineTest {
    @Test
    public void eatMeat() throws Exception {
        var expected = List.of("Животные", "Птицы", "Рыба");
        var feline = new Feline();
        assertEquals(expected, feline.eatMeat());
    }

    @Test
    public void getFamily() {
        var expected = "Кошачьи";
        var feline = new Feline();
        assertEquals(expected, feline.getFamily());
    }

    @Test
    public void getKittens() {
        var expected = 1;
        var feline = new Feline();
        assertEquals(expected, feline.getKittens());
    }

    @Test
    @Parameters({"5", "50", "100"})
    public void testGetKittens(int kittensCount) {
        var feline = new Feline();
        assertEquals(kittensCount, feline.getKittens(kittensCount));
    }
}