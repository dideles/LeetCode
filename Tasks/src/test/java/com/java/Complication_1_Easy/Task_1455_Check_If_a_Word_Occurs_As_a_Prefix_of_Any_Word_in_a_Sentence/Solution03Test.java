package com.java.Complication_1_Easy.Task_1455_Check_If_a_Word_Occurs_As_a_Prefix_of_Any_Word_in_a_Sentence;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Solution03Test {

    private final Solution03 solution = new Solution03();

    @Test
    public void testExample1() {
        String sentence = "i love eating burger";
        String searchWord = "burg";
        int expectedResult = 4;

        assertEquals(expectedResult, solution.isPrefixOfWord(sentence, searchWord));
    }

    @Test
    public void testExample2() {
        String sentence = "this problem is an easy problem";
        String searchWord = "pro";
        int expectedResult = 2;

        assertEquals(expectedResult, solution.isPrefixOfWord(sentence, searchWord));
    }

    @Test
    public void testNotFound() {
        String sentence = "hello world";
        String searchWord = "foo";
        int expectedResult = -1;

        assertEquals(expectedResult, solution.isPrefixOfWord(sentence, searchWord));
    }

    @Test
    public void testEmptySearchWord() {
        String sentence = "abc def ghi";
        String searchWord = "";
        int expectedResult = 1;

        assertEquals(expectedResult, solution.isPrefixOfWord(sentence, searchWord));
    }

    @Test
    public void testWholeWordMatch() {
        String sentence = "a aaa aaaaa";
        String searchWord = "a";
        int expectedResult = 1;

        assertEquals(expectedResult, solution.isPrefixOfWord(sentence, searchWord));
    }
}