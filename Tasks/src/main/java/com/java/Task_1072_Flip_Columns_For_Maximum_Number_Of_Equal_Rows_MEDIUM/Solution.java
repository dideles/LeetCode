package com.java.Task_1072_Flip_Columns_For_Maximum_Number_Of_Equal_Rows_MEDIUM;

import java.util.HashMap;
import java.util.Map;

/**
 * Используя хэширование для учета уникальных строк и их инверсий
 */
class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        // Получаем размеры бинарной матрицы
        int m = matrix.length; // Т.к. matrix — это двумерный массив, matrix.length дает КОЛИЧЕСТВО СТРОК.
        if (m == 0) // Если количество строк равно нулю (матрица пуста),
            return 0; // то функция немедленно завершает выполнение и возвращает 0.
        // Это логично, т.к. в пустой матрице нельзя получить ни одной строки, удовлетворяющей условиям задачи.
        int n = matrix[0].length; // Это КОЛИЧЕСТВО СТОЛБЦОВ в матрице.
        // Здесь берется длина первого подмассива матрицы (первая строка) и сохраняется в переменную n.
        // Предполагается, что все строки имеют одинаковую длину,
        // поэтому используется первая строка для определения общего количества столбцов.

        // Создаем коллекцию типа Map, реализованную через класс HashMap, для хранения уникальных строк:
        Map<String, Integer> countMap = new HashMap<>();

        // Цикл по строкам матрицы:
        for (int[] row : matrix) {
            // Формирование строки и её инверсии:
            // Внутри цикла по строкам создается два StringBuilder
            StringBuilder sb = new StringBuilder(); // один для оригинальной строки
            StringBuilder invertedSb = new StringBuilder(); // другой для её инверсии

            // Формируем строку и её инверсию
            for (int j = 0; j < n; ++j) {
                sb.append(row[j]);
                invertedSb.append(1 - row[j]); // Инвертируем элемент
            }

            // Выбор минимальной (лексикографически) строки для сохранения в карту:
            String key = sb.toString().compareTo(invertedSb.toString()) < 0 ? sb.toString() : invertedSb.toString();
            countMap.put(key, countMap.getOrDefault(key, 0) + 1); // Метод getOrDefault() проверяет наличие ключа в карте
        }

        // Находим максимальную частоту встречаемости строки
        int maxCount = 0;
        for (Integer freq : countMap.values()) {
            maxCount = Math.max(maxCount, freq);
        }
        // Проходя по всем значениям карты, находится максимальная частота встречаемости строки.

        return maxCount;
        // Возвращается максимальное количество строк, которые могут стать одинаковыми после переворота столбцов.
    }
}