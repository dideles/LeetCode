package com.java.Complication_2_Medium.Task_2109_Добавление_пробелов_в_строку;


public class Solution {
    /**
     * Метод добавляет пробелы в строку в соответствии с указанными индексами.
     *
     * @param s      Строка s, которая представляет собой текст без пробелов.
     * @param spaces Массив целых чисел spaces, который содержит индексы тех позиций в строке s, куда нужно вставить пробелы.
     * @return Новая строка с добавленными пробелами.
     */
    public String addSpaces(String s, int[] spaces) {
        StringBuilder result = new StringBuilder();

        // Индекс текущего символа в исходной строке
        int currentIndex = 0;

        // Индекс следующего пробела
        int nextSpaceIndex = 0;

        while (currentIndex < s.length()) {
            if (nextSpaceIndex < spaces.length && currentIndex == spaces[nextSpaceIndex]) {
                // Вставляем пробел
                result.append(' ');

                // Переходим к следующему индексу пробела
                nextSpaceIndex++;
            }

            // Добавляем текущий символ строки
            result.append(s.charAt(currentIndex));

            // Увеличиваем индекс текущего символа
            currentIndex++;
        }

        return result.toString();
    }
}