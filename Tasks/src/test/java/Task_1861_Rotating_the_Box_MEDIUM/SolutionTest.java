package Task_1861_Rotating_the_Box_MEDIUM;

import com.java.Task_1861_Rotating_the_Box_MEDIUM.Solution;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {

    /**
     * Тестирует поворот коробки с одним камнем.
     */
    @Test
    public void testCase1() {
        char[][] expected = {
                {'.'},
                {'#'},
                {'#'}
        };
        char[][] actual = new Solution().rotateTheBox(new char[][]{
                {'#', '.', '#'}
        });
        assertArrayEquals(expected, actual);
    }

    /**
     * Тестирует поворот коробки с несколькими камнями и препятствиями.
     */
    @Test
    public void testCase2() {
        char[][] expected = {
                {'#', '.'},
                {'#', '#'},
                {'*', '*'},
                {'.', '.'}
        };
        char[][] actual = new Solution().rotateTheBox(new char[][]{
                {'#', '.', '*', '.'},
                {'#', '#', '*', '.'}
        });
        assertArrayEquals(expected, actual);
    }

    /**
     * Тестирует поворот сложной коробки с множеством камней и препятствий.
     */
    @Test
    public void testCase3() {
        char[][] expected = {
                {'.', '#', '#'},
                {'.', '#', '#'},
                {'#', '#', '*'},
                {'#', '*', '.'},
                {'#', '.', '*'},
                {'#', '.', '.'}
        };
        char[][] actual = new Solution().rotateTheBox(new char[][]{
                {'#', '#', '*', '.', '*', '.'},
                {'#', '#', '#', '*', '.', '.'},
                {'#', '#', '#', '.', '#', '.'}
        });
        assertArrayEquals(expected, actual);
    }

}