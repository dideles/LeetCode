package com.java.Complication_2_Medium.Task_2054;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, Comparator.comparingInt((int[] a) -> a[1]));
        int res = events[0][2];
        for(int i = 0; i < events.length;i++)
            System.out.println(Arrays.toString(events[i]));
        int[][] maxByTime = new int[events.length][2];
        maxByTime[0][0] = events[0][2];
        maxByTime[0][1] = events[0][1];
        for(int i = 1; i < events.length; i++) {
            maxByTime[i][0] = Math.max(maxByTime[i - 1][0], events[i][2]);
            maxByTime[i][1] = events[i][1];
        }
        for(int i = 0; i < events.length;i++) {
            int cur = events[i][2];
            int maxPrev = 0;

            int l = 0;
            int r = maxByTime.length - 1;
            int mid;


            while(l <=r) {
                mid = l + (r - l) / 2;
                if(maxByTime[mid][1] < events[i][0  ]) {
                    maxPrev = maxByTime[mid][0];
                    l = mid + 1;
                }else {
                    r = mid - 1;
                }

            }
            res = Math.max(res, cur + maxPrev);
        }
        return res;
    }
}
