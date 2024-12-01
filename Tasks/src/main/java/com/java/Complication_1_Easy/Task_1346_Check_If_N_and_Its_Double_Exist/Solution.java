package com.java.Complication_1_Easy.Task_1346_Check_If_N_and_Its_Double_Exist;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();

        for (int num : arr) {
            if (set.contains(num / 2) && num % 2 == 0 || set.contains(num * 2)) {
                return true;
            }

            set.add(num);
        }

        return false;
    }
}
