package com.java.Complication_2_Medium.Task_3242_Shortest_Distance_After_Road_Addition_Quaries_I;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {

    @Test
    public void testShortestDistanceAfterQueries() {
        Solution solution = new Solution();

        int n1 = 5;
        int[][] queries1 = {{2, 4}, {0, 2}, {0, 4}};
        int[] expectedResult1 = {3, 2, 1};
        assertArrayEquals(expectedResult1, solution.shortestDistanceAfterQueries(n1, queries1));

        int n2 = 4;
        int[][] queries2 = {{0, 3}, {0, 2}};
        int[] expectedResult2 = {1, 1};
        assertArrayEquals(expectedResult2, solution.shortestDistanceAfterQueries(n2, queries2));

    }
}