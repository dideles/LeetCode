package com.java.Complication_2_Medium.Task_2554;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> temp = new HashSet<>();

        for(int a: banned){
            temp.add(a);
        }
        long sum = 0;
        int out = 0;

        for(int i=1; i<=n; i++){
            if(!temp.contains(i) && sum+i<=maxSum){
                sum += i;
                out++;
            }
            if(sum+i > maxSum){
                break;
            }
        }
        return out;
    }
}