package com.java.Complication_3_Hard.Task_2290_Minimum_Obstacle_Removal_to_Reach_Corner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    @Test
    void testMinimumObstacles() {
        Solution solution = new Solution();

        // Test case 1
        int[][] grid1 = {
                {0, 1, 2},
                {1, 1, 0},
                {1, 1, 0}
        };
        assertEquals(2, solution.minimumObstacles(grid1));

        // Test case 2
        int[][] grid2 = {
                {0, 1, 0, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0}
        };
        assertEquals(0, solution.minimumObstacles(grid2));
    }
}