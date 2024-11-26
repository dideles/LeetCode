package com.java.Easy.Task_0001_Two_Sum;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс для нахождения двух чисел в массиве, сумма которых равна заданному числу.
 */
public class Solution {
    /**
     * Найти два числа в массиве, сумма которых равна заданному числу.
     *
     * @param nums   Массив целых чисел.
     * @param target Целевая сумма.
     * @return Индексы двух чисел, сумма которых равна целевой сумме.
     */
    public int[] twoSum(int[] nums, int target) {

        // Эта проверка необходима для того, чтобы избежать возможных ошибок при работе с массивом:
        if (nums == null || nums.length == 0) { // Если массив nums равен null или если длина массива равна нулю,
            // то у нас нет элементов для работы, то дальнейшая работа с ним невозможна
            return new int[0]; // поэтому мы возвращаем пустой массив.
        }
        // if (nums == null || nums.length == 0) return new int[0];

        // Создаем хэш-карту для хранения значений и их индексов:
        Map<Integer, Integer> map = new HashMap<>();

        // Цикл прохода по массиву (перебираем каждый элемент массива):
        for (int i = 0; i < nums.length; i++) {
            // Вычисляем разницу между целевой суммой и текущим элементом:
            int difference = target - nums[i];

            // Проверяем, есть ли эта разница в хэш-мапе.
            if (map.containsKey(difference)) {
                // Если да, то возвращаем текущий индекс и индекс найденного элемента из карты.
                return new int[]{map.get(difference), i};
            }
            // В противном случае добавляем текущий элемент в карту с соответствующим индексом.
            map.put(nums[i], i);
        }

        /*
        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
         */

        // Этот код никогда не выполнится, т.к. гарантируется наличие одного решения
        throw new IllegalArgumentException("No two sum solution");
    }
}