package com.java.Complication_1_Easy.Task_1455_Check_If_a_Word_Occurs_As_a_Prefix_of_Any_Word_in_a_Sentence;

import org.junit.Test;
import static org.junit.Assert.*;

public class Solution02Test {

    @Test
    public void testIsPrefixOfWord_Example1() {
        String sentence = "i love eating burger";
        String searchWord = "burg";
        int expectedIndex = 4;

        int actualIndex = Solution02.isPrefixOfWord(sentence, searchWord);

        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void testIsPrefixOfWord_Example2() {
        String sentence = "this problem is an easy problem";
        String searchWord = "pro";
        int expectedIndex = 2;

        int actualIndex = Solution02.isPrefixOfWord(sentence, searchWord);

        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void testIsPrefixOfWord_NotFound() {
        String sentence = "i am tired";
        String searchWord = "you";
        int expectedIndex = -1;

        int actualIndex = Solution02.isPrefixOfWord(sentence, searchWord);

        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void testIsPrefixOfWord_EmptySearchWord() {
        String sentence = "abc def ghi";
        String searchWord = "";
        int expectedIndex = 1;

        int actualIndex = Solution02.isPrefixOfWord(sentence, searchWord);

        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void testIsPrefixOfWord_WholeWordMatch() {
        String sentence = "a aaa aaaaa";
        String searchWord = "a";
        int expectedIndex = 1;

        int actualIndex = Solution02.isPrefixOfWord(sentence, searchWord);

        assertEquals(expectedIndex, actualIndex);
    }
}
