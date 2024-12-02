package com.java.Complication_1_Easy.Task_1455_Check_If_a_Word_Occurs_As_a_Prefix_of_Any_Word_in_a_Sentence;

class Solution01 {
    public int isPrefixOfWord(String sentence, String searchWord) {
        // Разбиваем строку sentence на массив строк words:
        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length; i++) {
            // Проверяем, является ли searchWord префиксом текущего слова
            if (words[i].startsWith(searchWord)) {
                // Возвращаем индекс + 1, т.к. индексация начинается с 1
                return i + 1;
            }
        }

        // Если ни одно слово не подходит, возвращаем -1
        return -1;
    }
}