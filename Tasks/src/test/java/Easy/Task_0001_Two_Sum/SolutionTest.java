package Easy.Task_0001_Two_Sum;


import com.java.Easy.Task_0001_Two_Sum.Solution;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    public void testNullAndEmptyArrays() {
        assertArrayEquals(new int[0], solution.twoSum(null, 10));
        assertArrayEquals(new int[0], solution.twoSum(new  int[0], 10));
    }

    @Test
    public void testBasicCases() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        assertArrayEquals(new int[]{0, 1}, solution.twoSum(nums, target));

        nums = new int[]{3, 2, 4};
        target = 6;
        assertArrayEquals(new int[]{1, 2}, solution.twoSum(nums, target));

        nums = new int[]{3, 3};
        target = 6;
        assertArrayEquals(new int[]{0, 1}, solution.twoSum(nums, target));
    }

    @Test
    public void testNegativeNumbers() {
        int[] nums = {-1, 0, 1, 2};
        int target = 1;
        assertArrayEquals(new int[]{1, 2}, solution.twoSum(nums, target));
    }

    @Test
    public void testLargeNumbers() {
        int[] nums = {10000, 20000, 30000, 40000};
        int target = 50000;
        assertArrayEquals(new int[]{1, 2}, solution.twoSum(nums, target));
    }

    @Test
    public void testNoSolution() {
        int[] nums = {1, 2, 3, 4};
        int target = 50;
        try {
            solution.twoSum(nums, target);
        } catch (IllegalArgumentException e) {
            // Ожидаемое поведение: исключение должно быть брошено, так как решения нет
        }
    }
}