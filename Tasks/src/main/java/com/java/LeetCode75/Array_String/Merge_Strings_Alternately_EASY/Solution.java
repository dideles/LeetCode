package com.java.LeetCode75.Array_String.Merge_Strings_Alternately_EASY;

class Solution {
    public String mergeAlternately(String word1, String word2) {

        // Здесь создаются две переменные i и j для отслеживания текущей позиции в каждой строке:
        int i = 0, j = 0;

        // Создается объект StringBuilder для хранения результата:
        StringBuilder result = new StringBuilder();

        // Цикл завершится, когда оба индекса i и j достигнут своих максимальных значений (длины соответствующих строк).
        while (i < word1.length() || j < word2.length()) {
            // Проверяет, находится ли текущий индекс i в пределах длины первой строки. Если да, то:
            if (i < word1.length()) {
                result.append(word1.charAt(i)); // Символ на позиции i из строки word1 добавляется в result.
                i++; // Индекс i увеличивается на единицу, чтобы перейти к следующему символу в следующей итерации.
            }

            //  Если индекс j ещё не вышел за пределы длины строки word2, то:
            if (j < word2.length()) { // Символ на позиции j из строки word2 добавляется в result.
                result.append(word2.charAt(j));
                j++;
            }
        }

        // После того как весь цикл завершен, метод возвращает строку, созданную с помощью StringBuilder.
        return result.toString();
    }
}