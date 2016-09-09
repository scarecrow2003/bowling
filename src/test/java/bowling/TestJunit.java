package bowling;

import org.junit.Test;

import static bowling.Bowling.calculateScore;
import static org.junit.Assert.assertArrayEquals;

/**
 * Created by zhihua on 9/8/16.
 */
public class TestJunit {

    @Test
    public void testCalculateScore() {
        assertArrayEquals(null, calculateScore(null));

        int[][] inData = new int[][]{{1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}};
        assertArrayEquals(null, calculateScore(inData));

        inData = new int[][]{{1, 2}, null, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}};
        assertArrayEquals(null, calculateScore(inData));

        inData = new int[][]{{1, 2}, {1, 2}, {}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}};
        assertArrayEquals(null, calculateScore(inData));

        inData = new int[][]{{1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2, 3, 4}};
        assertArrayEquals(null, calculateScore(inData));

        inData = new int[][]{{1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2, 3}};
        assertArrayEquals(null, calculateScore(inData));

        inData = new int[][]{{1, 2}, {1, 2}, {1, 2}, {1, 2, 3}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {10, 2, 3}};
        assertArrayEquals(null, calculateScore(inData));

        inData = new int[][]{{1, 2}, {1, 2}, {1, 2}, {1, 2}, {0, 11}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {10, 2, 3}};
        assertArrayEquals(null, calculateScore(inData));

        inData = new int[][]{{1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {13, 2}, {1, 2}, {1, 2}, {1, 2}, {10, 2, 3}};
        assertArrayEquals(null, calculateScore(inData));

        inData = new int[][]{{1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {-2, 3}, {1, 2}, {1, 2}, {10, 2, 3}};
        assertArrayEquals(null, calculateScore(inData));

        inData = new int[][]{{1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {7, 8}, {1, 2}, {10, 2, 3}};
        assertArrayEquals(null, calculateScore(inData));

        inData = new int[][]{{1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {3, 8}};
        assertArrayEquals(null, calculateScore(inData));

        inData = new int[][]{{1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {10, 8, 5}};
        assertArrayEquals(null, calculateScore(inData));

        int[] result;

        inData = new int[][]{{1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}};
        result = new int[]{3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
        assertArrayEquals(result, calculateScore(inData));

        inData = new int[][]{{1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {10, 2, 3}};
        result = new int[]{3, 3, 3, 3, 3, 3, 3, 3, 3, 15};
        assertArrayEquals(result, calculateScore(inData));

        inData = new int[][]{{1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {0, 2}, {1, 2}, {1, 2}, {1, 2}};
        result = new int[]{3, 3, 3, 3, 3, 3, 2, 3, 3, 3};
        assertArrayEquals(result, calculateScore(inData));

        inData = new int[][]{{1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 0}, {1, 2}, {1, 2}, {1, 2}};
        result = new int[]{3, 3, 3, 3, 3, 3, 1, 3, 3, 3};
        assertArrayEquals(result, calculateScore(inData));

        inData = new int[][]{{1, 2}, {1, 2}, {10, 0}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}};
        result = new int[]{3, 3, 13, 3, 3, 3, 3, 3, 3, 3};
        assertArrayEquals(result, calculateScore(inData));

        inData = new int[][]{{1, 2}, {1, 2}, {10}, {10}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}};
        result = new int[]{3, 3, 23, 13, 3, 3, 3, 3, 3, 3};
        assertArrayEquals(result, calculateScore(inData));

        inData = new int[][]{{1, 2}, {1, 2}, {10}, {10}, {10}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}};
        result = new int[]{3, 3, 30, 23, 13, 3, 3, 3, 3, 3};
        assertArrayEquals(result, calculateScore(inData));

        inData = new int[][]{{1, 2}, {1, 2}, {10}, {10}, {10}, {10}, {1, 2}, {1, 2}, {1, 2}, {1, 2}};
        result = new int[]{3, 3, 30, 30, 23, 13, 3, 3, 3, 3};
        assertArrayEquals(result, calculateScore(inData));

        inData = new int[][]{{1, 2}, {1, 2}, {10}, {10}, {0, 0}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}};
        result = new int[]{3, 3, 20, 10, 0, 3, 3, 3, 3, 3};
        assertArrayEquals(result, calculateScore(inData));

        inData = new int[][]{{1, 2}, {1, 2}, {10}, {0}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}};
        result = new int[]{3, 3, 10, 0, 3, 3, 3, 3, 3, 3};
        assertArrayEquals(result, calculateScore(inData));

        inData = new int[][]{{1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {10}, {10, 2, 6}};
        result = new int[]{3, 3, 3, 3, 3, 3, 3, 3, 28, 18};
        assertArrayEquals(result, calculateScore(inData));

        inData = new int[][]{{1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {10}, {10}, {10, 2, 6}};
        result = new int[]{3, 3, 3, 3, 3, 3, 3, 38, 28, 18};
        assertArrayEquals(result, calculateScore(inData));

        inData = new int[][]{{1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {10}, {10}, {10}, {10, 2, 6}};
        result = new int[]{3, 3, 3, 3, 3, 3, 30, 38, 28, 18};
        assertArrayEquals(result, calculateScore(inData));

        inData = new int[][]{{10}, {10}, {10}, {10}, {10}, {10}, {10}, {10}, {10}, {10, 10}};
        result = new int[]{30, 30, 30, 30, 30, 30, 30, 40, 30, 20};
        assertArrayEquals(result, calculateScore(inData));
    }
}
