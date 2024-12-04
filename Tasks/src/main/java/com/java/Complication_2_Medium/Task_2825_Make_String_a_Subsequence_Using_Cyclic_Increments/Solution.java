package com.java.Complication_2_Medium.Task_2825_Make_String_a_Subsequence_Using_Cyclic_Increments;

public class Solution {

    /**
     * Проверяет возможность создания подстроки из заданной строки.
     *
     * @param toCheckForTargetSubsequence строка, которую проверяем на наличие целевого шаблона
     * @param targetSubsequence           целевая подстрока, которую нужно найти
     * @return true, если возможно создать подстроку, иначе false
     */
    public boolean canMakeSubsequence(String toCheckForTargetSubsequence, String targetSubsequence) {

        // Проверка на пустоту одну из строк:
        if (toCheckForTargetSubsequence.isEmpty() || targetSubsequence.isEmpty()) {
            return false;
        }

        // Проверка длины строк:
        if (targetSubsequence.length() > toCheckForTargetSubsequence.length()) {
            return false; // т.к. невозможно сформировать нужную подстроку.
        }

        int indexTarget = 0; // Переменная indexTarget отслеживает текущую позицию в целевой строке targetSubsequence

        // Условие выхода из цикла: либо конец строки, либо достижение конца целевой подстроки:
        for (int i = 0; i < toCheckForTargetSubsequence.length() && indexTarget < targetSubsequence.length(); ++i) {

            // Сравнение символов:
            // Для каждого символа строки toCheckForTargetSubsequence проверяются два условия:
            if (toCheckForTargetSubsequence.charAt(i) == targetSubsequence.charAt(indexTarget) // Текущий символ совпадает с символом целевой подстроки.
                    || nextLetter(toCheckForTargetSubsequence.charAt(i)) == targetSubsequence.charAt(indexTarget)) {
                // Следующий символ после текущего также совпадает с символом целевой подстроки.
                ++indexTarget; // Если одно из условий выполняется, увеличиваем индекс текущей позиции в целевой строке
            }
        }

        // Завершение метода (проверка достижения конца целевой подстроки):
        return indexTarget == targetSubsequence.length();
        // Если да, значит, удалось найти подстроку, соответствующую условиям задачи, и возвращается true.
        // Иначе возвращается false.
    }

    /**
     * Возвращает следующую букву латинского алфавита после переданной.
     *
     * @param currentLetter текущий символ, для которого нужно получить следующий
     * @return следующая буква после переданной, циклически переходящая от 'z' к 'a'
     */
    private char nextLetter(char currentLetter) {
        /*
        // Используем модульную арифметику ((currentLetter + 1 - 'a') % ALPHABET_SIZE)
        // Используем оператор % (остаток от деления), чтобы обеспечить цикличность.
        // Т.к. ALPHABET_SIZE равно 26, остаток всегда будет находиться в пределах от 0 до 25.
        // Когда текущая буква равна 'z', выражение (currentLetter + 1 - 'a') даст нам 27,
        // но после применения операции % 26 получится 1, что соответствует букве 'b' в нашем алфавите.
        return (char) ('a' + (currentLetter + 1 - 'a') % ALPHABET_SIZE); // private static final int ALPHABET_SIZE = 26;
        // После получения правильного индекса в диапазоне от 0 до 25, добавляем его к 'a', чтобы снова получить букву.
        // Поскольку операция сложения и взятия остатка дает целое число (int), приводим результат обратно к типу char,
        // чтобы вернуть символ.
        */
        return currentLetter == 'z' ? 'a' : (char) (currentLetter + 1);
    }
}