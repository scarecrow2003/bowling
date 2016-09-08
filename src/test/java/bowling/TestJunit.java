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
        int[][] inData = {{1, 9}, {0, 10}, {10}, {10}, {10}, {0, 0}, {2, 7}, {10, 0}, {3, 7}, {10, 3, 3}};
        int[] result = {10, 10, 30, 20, 10, 0, 9, 20, 10, 16};
        assertArrayEquals(result, calculateScore(inData));
    }
}
