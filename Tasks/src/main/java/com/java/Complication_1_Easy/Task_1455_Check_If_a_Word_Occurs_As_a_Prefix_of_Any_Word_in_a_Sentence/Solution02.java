package com.java.Complication_1_Easy.Task_1455_Check_If_a_Word_Occurs_As_a_Prefix_of_Any_Word_in_a_Sentence;

import java.util.Arrays;

public class Solution02 {
    public static void main(String[] args) {
        System.out.println(isPrefixOfWord("i love eating burger", "burg"));
        System.out.println(isPrefixOfWord("this problem is an easy problem", "pro"));
        System.out.println(isPrefixOfWord("i am tired", "you"));
    }

    public static int isPrefixOfWord(String sentence, String searchWord) {
        // Разделяем строку на массив слов
        String[] words = sentence.split(" ");

        // Используем потоковую обработку для нахождения первого подходящего слова
        return Arrays.stream(words) // создает поток элементов из массива words
                .filter(word -> word.startsWith(searchWord)) // фильтрует элементы потока, оставляя только те слова, которые начинаются с searchWord
                .findFirst() // возвращает первый элемент, удовлетворяющий условию фильтра
                .map(word -> Arrays.asList(words).indexOf(word) + 1) // индексация начинается с 1
                .orElse(-1); // В случае отсутствия подходящих слов используется orElse(-1), чтобы вернуть значение -1
    }
}
