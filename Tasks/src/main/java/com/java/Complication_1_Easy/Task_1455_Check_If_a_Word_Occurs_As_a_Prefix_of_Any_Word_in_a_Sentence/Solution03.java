package com.java.Complication_1_Easy.Task_1455_Check_If_a_Word_Occurs_As_a_Prefix_of_Any_Word_in_a_Sentence;

public class Solution03 {
    public int isPrefixOfWord(String sentence, String searchWord) {
        // Разбиваем предложение на отдельные слова
        String[] words = sentence.split(" ");

        // Индексируем слова начиная с 1
        int index = 1;

        // Проходим по всем словам
        for (String word : words) {
            // Проверяем, является ли searchWord префиксом текущего слова
            if (word.startsWith(searchWord)) {
                // Возвращаем текущий индекс
                return index;
            }

            // Увеличиваем индекс
            index++;
        }

        // Если ни одно слово не подходит, возвращаем -1
        return -1;
    }
}
