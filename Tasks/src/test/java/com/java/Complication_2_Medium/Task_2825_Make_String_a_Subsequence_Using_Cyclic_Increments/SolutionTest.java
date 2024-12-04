package com.java.Complication_2_Medium.Task_2825_Make_String_a_Subsequence_Using_Cyclic_Increments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    public void testEmptyStrings() {
        assertFalse(solution.canMakeSubsequence("", ""), "Обе строки пусты");
    }

    @Test
    public void testOneStringEmpty() {
        assertFalse(solution.canMakeSubsequence("abc", ""), "Первая строка непустая, вторая пустая");
        assertFalse(solution.canMakeSubsequence("", "def"), "Первая строка пустая, вторая непустая");
    }

    @Test
    public void testLengthMismatch() {
        assertFalse(solution.canMakeSubsequence("ab", "abc"), "Длина целевой подстроки больше длины проверяемой строки");
    }

    @Test
    public void testSimpleMatch() {
        assertTrue(solution.canMakeSubsequence("abc", "ad"), "Простые совпадения");
        assertTrue(solution.canMakeSubsequence("zc", "ad"), "Совпадения с разными символами");
    }

    @Test
    public void testCyclicIncrement() {
        assertTrue(solution.canMakeSubsequence("azbycxdze", "acd"), "Циклический инкремент (z -> a)");
    }

    @Test
    public void testNoMatches() {
        assertFalse(solution.canMakeSubsequence("ab", "d"), "Нет совпадений с целевой подстрокой");
    }

    @Test
    public void testBoundaryCases() {
        assertTrue(solution.canMakeSubsequence("zzzzzzz", "za"), "Все символы одинаковы, переход z -> a");
        assertFalse(solution.canMakeSubsequence("zzzzzzz", "zb"), "Все символы одинаковы, переход z -> b невозможен");
    }
}