package com.java.Complication_2_Medium.Task_2337_Move_Pieces_to_Obtain_a_String;

import org.junit.Test;
import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void testCanChange() {
        Solution solution = new Solution();

        // Тестовые случаи
        assertTrue(solution.canChange("_L__R__R_", "L______RR"));
        assertFalse(solution.canChange("R_L_", "__LR"));
        assertFalse(solution.canChange("_R", "R_"));

        assertFalse(solution.canChange("___", "L__"));
        assertTrue(solution.canChange("____", "____"));
        assertFalse(solution.canChange("L_R_", "_LR_"));
    }
}