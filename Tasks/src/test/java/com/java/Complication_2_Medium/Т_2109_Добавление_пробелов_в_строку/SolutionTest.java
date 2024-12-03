package com.java.Complication_2_Medium.Т_2109_Добавление_пробелов_в_строку;

import com.java.Complication_2_Medium.Task_2109_Добавление_пробелов_в_строку.Solution;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void testEmptyInput() {
        // Тест для пустой строки

        // Тестовые данные
        String inputStr = "";
        int[] spaces = {};
        String expectedResult = "";

        // Вызываем метод
        String actualResult = solution.addSpaces(inputStr, spaces);

        // Проверяем результат
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testTwoSpaces() {
        String inputStr0 = "EnjoyYourCoffee";
        int[] spaces0 = {5, 9};
        String expectedResult0 = "Enjoy Your Coffee";

        String actualResult0 = solution.addSpaces(inputStr0, spaces0);

        assertEquals(expectedResult0, actualResult0);
    }

    @Test
    void testThreeSpaces() {
        // Тест для трех пробелов
        String inputStr = "LeetcodeHelpsMeLearn";
        int[] spaces = {8, 13, 15};
        String expectedResult = "Leetcode Helps Me Learn";

        String actualResult = solution.addSpaces(inputStr, spaces);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testFourSpaces() {
        // Тест для нескольких пробелов
        String inputStr = "icodeinjava.";
        int[] spaces = {1, 5, 7, 11};
        String expectedResult = "i code in java .";

        String actualResult = solution.addSpaces(inputStr, spaces);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testMultipleSpaces() {
        // Тест для нескольких пробелов
        String inputStr = "spacing";
        int[] spaces = {1, 2, 3, 4, 5, 6};
        String expectedResult = "s p a c i n g";

        String actualResult = solution.addSpaces(inputStr, spaces);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testNoSpacesNeeded() {
        // Тест для случая, когда пробелы не нужны
        String inputStr = "HelloWorld";
        int[] spaces = {};
        String expectedResult = "HelloWorld";

        String actualResult = solution.addSpaces(inputStr, spaces);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testInvalidIndex() {
        // Тест для неправильного индекса (выходит за границы строки)
        String inputStr = "Short";
        int[] spaces = {10}; // Индекс выходит за границу строки

        String actualResult = solution.addSpaces(inputStr, spaces);

        assertEquals("Short", actualResult); // Метод должен игнорировать неверный индекс
    }
}