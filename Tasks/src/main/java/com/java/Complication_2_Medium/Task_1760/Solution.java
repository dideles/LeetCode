package com.java.Complication_2_Medium.Task_1760;

class Solution {
    // Проверяет, можно ли достичь значения x за maxOperations операций
    private boolean canAchieve(int[] nums, int maxOperations, int x) {
        long opsNeeded = 0;
        for (int num : nums) {
            if (num > x) {
                opsNeeded += (num + x - 1) / x - 1; // округление вверх
            }
        }
        return opsNeeded <= maxOperations;
    }

    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1;
        int right = Integer.MIN_VALUE;

        // Найдем максимальное число в массиве
        for (int num : nums) {
            right = Math.max(right, num);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canAchieve(nums, maxOperations, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}