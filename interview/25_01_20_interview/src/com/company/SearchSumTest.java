package com.company;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SearchSumTest {


    @Test
    public void isSum_6ElementsNotSortSum3and4_true() {
        int n = 11;
        List<Integer> list = Arrays.asList(1, 20, 5, 6, -10, 5);
        SearchSum task = new SearchSum(list, n);
        assertTrue(task.isSum());
    }

    @Test
    public void isSum_2Elements_true() {
        int n = 45;
        List<Integer> list = Arrays.asList(50, -5);
        SearchSum task = new SearchSum(list, n);
        assertTrue(task.isSum());
    }

    @Test
    public void isSum_3ElementsNotSortSum1And2_true() {
        int n = 60;
        List<Integer> list = Arrays.asList(10, 50, -5);
        SearchSum task = new SearchSum(list, n);
        assertTrue(task.isSum());
    }

    @Test
    public void isSum_9ElementsNotSortSum2And9_true() {
        int n = 53;
        List<Integer> list = Arrays.asList(18, 1, 20, 5, -6, -10, 50, -5, 52);
        SearchSum task = new SearchSum(list, n);
        assertTrue(task.isSum());
    }

    @Test
    public void isSum_8Elements_false() {
        int n = 53;
        List<Integer> list = Arrays.asList(18, 1, 20, 5, -6, -10, 50, -5);
        SearchSum task = new SearchSum(list, n);
        assertFalse(task.isSum());
    }

    @Test
    public void isSum_2Elements_false() {
        int n = 10;
        List<Integer> list = Arrays.asList(50, -5);
        SearchSum task = new SearchSum(list, n);
        assertFalse(task.isSum());
    }

    @Test
    public void isSum_SizeLower2_false() {
        int n = 10;
        List<Integer> list = Arrays.asList(50);
        SearchSum task = new SearchSum(list, n);
        assertFalse(task.isSum());
    }
}