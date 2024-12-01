package com.java.Complication_1_Easy.Task_1346_Check_If_N_and_Its_Double_Exist;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {

    @Test
    public void testEmptyArray() {
        int[] arr = {};
        assertFalse("An empty collection should return false", new Solution().checkIfExist(arr));
    }

    @Test
    public void testSingleElementArray() {
        int[] arr = {10};
        assertFalse("One element does not form a pair", new Solution().checkIfExist(arr));
    }

    @Test
    public void testTwoEqualElements() {
        int[] arr = {4, 8};
        assertTrue("Two identical elements form a pair", new Solution().checkIfExist(arr));
    }

    @Test
    public void testNoMatchingPairs() {
        int[] arr = {7, 9, 11, 13};
        assertFalse("No matching pairs", new Solution().checkIfExist(arr));
    }

    @Test
    public void testMultipleElementsWithPairs() {
        int[] arr = {10, 2, 5, 3};
        assertTrue("There are suitable pairs", new Solution().checkIfExist(arr));
    }

    @Test
    public void testEdgeCases() {
        int[] arr1 = {0, 0};
        assertTrue("Should return true for zero", new Solution().checkIfExist(arr1));

        int[] arr2 = {Integer.MAX_VALUE, Integer.MIN_VALUE};
        assertFalse("Should handle integer overflow correctly", new Solution().checkIfExist(arr2));
    }

    @Test
    public void testNegativeCases() {
        int[] arr = {3, 1, 7, 11};
        assertFalse("Should return false when no match found", new Solution().checkIfExist(arr));
    }

    /*
    @Test
    public void testCheckIfExist() {

        // Positive tests
        int[] arr1 = {10, 2, 5, 3};
        assertTrue("Should return true when double exists", new Solution().checkIfExist(arr1));

        int[] arr2 = {10, 15, 20};
        assertTrue("Should return true when double exists", new Solution().checkIfExist(arr2));

        int[] arr3 = {-2, 0, 10, -6, 20};
        assertTrue("Should return true when half exists", new Solution().checkIfExist(arr3));

        int[] arr4 = {7, 14};
        assertTrue("Should return true for simple case", new Solution().checkIfExist(arr4));

        // Negative tests
        int[] arr5 = {3, 1, 7, 11};
        assertFalse("Should return false when no match found", new Solution().checkIfExist(arr5));

        int[] arr6 = {7, 8, 9};
       assertFalse("Should return false when no match found", new Solution().checkIfExist(arr6));

        int[] arr7 = {};
        assertFalse("Should return false for empty array", new Solution().checkIfExist(arr7));

        // Edge cases
        int[] arr8 = {0, 0};
        assertTrue("Should return true for zero", new Solution().checkIfExist(arr8));

        int[] arr9 = {Integer.MAX_VALUE, Integer.MIN_VALUE};
        assertFalse("Should handle integer overflow correctly", new Solution().checkIfExist(arr9));
        */
}
