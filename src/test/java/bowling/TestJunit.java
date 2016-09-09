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
        result = new int[]{3, 6, 9, 12, 15, 18, 21, 24, 27, 30};
        assertArrayEquals(result, calculateScore(inData));

        inData = new int[][]{{1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {10, 2, 3}};
        result = new int[]{3, 6, 9, 12, 15, 18, 21, 24, 27, 42};
        assertArrayEquals(result, calculateScore(inData));

        inData = new int[][]{{1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {0, 2}, {1, 2}, {1, 2}, {1, 2}};
        result = new int[]{3, 6, 9, 12, 15, 18, 20, 23, 26, 29};
        assertArrayEquals(result, calculateScore(inData));

        inData = new int[][]{{1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 0}, {1, 2}, {1, 2}, {1, 2}};
        result = new int[]{3, 6, 9, 12, 15, 18, 19, 22, 25, 28};
        assertArrayEquals(result, calculateScore(inData));

        inData = new int[][]{{1, 2}, {1, 2}, {10, 0}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}};
        result = new int[]{3, 6, 19, 22, 25, 28, 31, 34, 37, 40};
        assertArrayEquals(result, calculateScore(inData));

        inData = new int[][]{{1, 2}, {1, 2}, {10}, {10}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}};
        result = new int[]{3, 6, 29, 42, 45, 48, 51, 54, 57, 60};
        assertArrayEquals(result, calculateScore(inData));

        inData = new int[][]{{1, 2}, {1, 2}, {10}, {10}, {10}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}};
        result = new int[]{3, 6, 36, 59, 72, 75, 78, 81, 84, 87};
        assertArrayEquals(result, calculateScore(inData));

        inData = new int[][]{{1, 2}, {1, 2}, {10}, {10}, {10}, {10}, {1, 2}, {1, 2}, {1, 2}, {1, 2}};
        result = new int[]{3, 6, 36, 66, 89, 102, 105, 108, 111, 114};
        assertArrayEquals(result, calculateScore(inData));

        inData = new int[][]{{1, 2}, {1, 2}, {10}, {10}, {0, 0}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}};
        result = new int[]{3, 6, 26, 36, 36, 39, 42, 45, 48, 51};
        assertArrayEquals(result, calculateScore(inData));

        inData = new int[][]{{1, 2}, {1, 2}, {10}, {0}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}};
        result = new int[]{3, 6, 16, 16, 19, 22, 25, 28, 31, 34};
        assertArrayEquals(result, calculateScore(inData));

        inData = new int[][]{{1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {10}, {10, 2, 6}};
        result = new int[]{3, 6, 9, 12, 15, 18, 21, 24, 52, 70};
        assertArrayEquals(result, calculateScore(inData));

        inData = new int[][]{{1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {10}, {10}, {10, 2, 6}};
        result = new int[]{3, 6, 9, 12, 15, 18, 21, 59, 87, 105};
        assertArrayEquals(result, calculateScore(inData));

        inData = new int[][]{{1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {10}, {10}, {10}, {10, 2, 6}};
        result = new int[]{3, 6, 9, 12, 15, 18, 48, 86, 114, 132};
        assertArrayEquals(result, calculateScore(inData));

        inData = new int[][]{{10}, {10}, {10}, {10}, {10}, {10}, {10}, {10}, {10}, {10, 10}};
        result = new int[]{30, 60, 90, 120, 150, 180, 210, 250, 280, 300};
        assertArrayEquals(result, calculateScore(inData));

        inData = new int[][]{{5,2},{8,1},{6,4},{10},{0,5},{2,6},{8,1},{5,3},{6,1},{10,2,6}};
        result = new int[]{7,16,26,41,46,54,63,71,78,96};
        assertArrayEquals(result, calculateScore(inData));
    }
}
