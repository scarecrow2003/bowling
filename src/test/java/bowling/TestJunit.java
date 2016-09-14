package bowling;

import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

/**
 * Created by zhihua on 9/8/16.
 */
public class TestJunit {

    @Test
    public void testValidateRawScore() {
        Bowling game = new Bowling();
        game.startGame();
        assertFalse(game.obtainRawScore(null));

        game.restartGame();
        assertFalse(game.obtainRawScore(new int[][]{{1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}}));

        game.restartGame();
        assertFalse(game.obtainRawScore(new int[][]{{1, 2}, null, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}}));

        game.restartGame();
        assertFalse(game.obtainRawScore(new int[][]{{1, 2}, {1, 2}, {}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}}));

        game.restartGame();
        assertFalse(game.obtainRawScore(new int[][]{{1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2, 3, 4}}));

        game.restartGame();
        assertFalse(game.obtainRawScore(new int[][]{{1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2, 3}}));

        game.restartGame();
        assertFalse(game.obtainRawScore(new int[][]{{1, 2}, {1, 2}, {1, 2}, {1, 2, 3}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {10, 2, 3}}));

        game.restartGame();
        assertFalse(game.obtainRawScore(new int[][]{{1, 2}, {1, 2}, {1, 2}, {1, 2}, {0, 11}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {10, 2, 3}}));

        game.restartGame();
        assertFalse(game.obtainRawScore(new int[][]{{1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {13, 2}, {1, 2}, {1, 2}, {1, 2}, {10, 2, 3}}));

        game.restartGame();
        assertFalse(game.obtainRawScore(new int[][]{{1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {-2, 3}, {1, 2}, {1, 2}, {10, 2, 3}}));

        game.restartGame();
        assertFalse(game.obtainRawScore(new int[][]{{1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {7, 8}, {1, 2}, {10, 2, 3}}));

        game.restartGame();
        assertFalse(game.obtainRawScore(new int[][]{{1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {3, 8}}));

        game.restartGame();
        assertFalse(game.obtainRawScore(new int[][]{{1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {10, 8, 5}}));
    }

    @Test
    public void testCalculation() {
        Bowling game = new Bowling();
        game.startGame();
        assertTrue(game.obtainRawScore(new int[][]{{1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}}));
        assertArrayEquals(new int[]{3, 6, 9, 12, 15, 18, 21, 24, 27, 30}, game.getScore());

        game.restartGame();
        assertTrue(game.obtainRawScore(new int[][]{{1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {10, 2, 3}}));
        assertArrayEquals(new int[]{3, 6, 9, 12, 15, 18, 21, 24, 27, 42}, game.getScore());

        game.restartGame();
        assertTrue(game.obtainRawScore(new int[][]{{1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {0, 2}, {1, 2}, {1, 2}, {1, 2}}));
        assertArrayEquals(new int[]{3, 6, 9, 12, 15, 18, 20, 23, 26, 29}, game.getScore());

        game.restartGame();
        assertTrue(game.obtainRawScore(new int[][]{{1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 0}, {1, 2}, {1, 2}, {1, 2}}));
        assertArrayEquals(new int[]{3, 6, 9, 12, 15, 18, 19, 22, 25, 28}, game.getScore());

        game.restartGame();
        assertTrue(game.obtainRawScore(new int[][]{{1, 2}, {1, 2}, {10, 0}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}}));
        assertArrayEquals(new int[]{3, 6, 19, 22, 25, 28, 31, 34, 37, 40}, game.getScore());

        game.restartGame();
        assertTrue(game.obtainRawScore(new int[][]{{1, 2}, {1, 2}, {10}, {10}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}}));
        assertArrayEquals(new int[]{3, 6, 29, 42, 45, 48, 51, 54, 57, 60}, game.getScore());

        game.restartGame();
        assertTrue(game.obtainRawScore(new int[][]{{1, 2}, {1, 2}, {10}, {10}, {10}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}}));
        assertArrayEquals(new int[]{3, 6, 36, 59, 72, 75, 78, 81, 84, 87}, game.getScore());

        game.restartGame();
        assertTrue(game.obtainRawScore(new int[][]{{1, 2}, {1, 2}, {10}, {10}, {10}, {10}, {1, 2}, {1, 2}, {1, 2}, {1, 2}}));
        assertArrayEquals(new int[]{3, 6, 36, 66, 89, 102, 105, 108, 111, 114}, game.getScore());

        game.restartGame();
        assertTrue(game.obtainRawScore(new int[][]{{1, 2}, {1, 2}, {10}, {10}, {0, 0}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}}));
        assertArrayEquals(new int[]{3, 6, 26, 36, 36, 39, 42, 45, 48, 51}, game.getScore());

        game.restartGame();
        assertTrue(game.obtainRawScore(new int[][]{{1, 2}, {1, 2}, {10}, {0}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}}));
        assertArrayEquals(new int[]{3, 6, 16, 16, 19, 22, 25, 28, 31, 34}, game.getScore());

        game.restartGame();
        assertTrue(game.obtainRawScore(new int[][]{{1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {10}, {10, 2, 6}}));
        assertArrayEquals(new int[]{3, 6, 9, 12, 15, 18, 21, 24, 52, 70}, game.getScore());

        game.restartGame();
        assertTrue(game.obtainRawScore(new int[][]{{1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {10}, {10}, {10, 2, 6}}));
        assertArrayEquals(new int[]{3, 6, 9, 12, 15, 18, 21, 59, 87, 105}, game.getScore());

        game.restartGame();
        assertTrue(game.obtainRawScore(new int[][]{{1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {10}, {10}, {10}, {10, 2, 6}}));
        assertArrayEquals(new int[]{3, 6, 9, 12, 15, 18, 48, 86, 114, 132}, game.getScore());

        game.restartGame();
        assertTrue(game.obtainRawScore(new int[][]{{10}, {10}, {10}, {10}, {10}, {10}, {10}, {10}, {10}, {10, 10}}));
        assertArrayEquals(new int[]{30, 60, 90, 120, 150, 180, 210, 250, 280, 300}, game.getScore());

        game.restartGame();
        assertTrue(game.obtainRawScore(new int[][]{{5,2},{8,1},{6,4},{10},{0,5},{2,6},{8,1},{5,3},{6,1},{10,2,6}}));
        assertArrayEquals(new int[]{7,16,26,41,46,54,63,71,78,96}, game.getScore());
    }

    @Test
    public void testValidateFrame() {
        try {
            Object game = Class.forName("Bowling").newInstance();
            Method method = game.getClass().getDeclaredMethod("validateFrame", new Class<?>[0]);
            assertFalse((Boolean) method.invoke(game, null, 0));

            assertFalse((Boolean) method.invoke(game, new int[]{}, 0));

            assertFalse((Boolean) method.invoke(game, new int[]{1, 1, 1, 4}, 9));

            assertFalse((Boolean) method.invoke(game, new int[]{1, 2, 3}, 9));

            assertFalse((Boolean) method.invoke(game, new int[]{1, 2, 3}, 0));

            assertFalse((Boolean) method.invoke(game, new int[]{12, 7}, 0));

            assertFalse((Boolean) method.invoke(game, new int[]{5, -7}, 0));

            assertTrue((Boolean) method.invoke(game, new int[]{5, 3}, 0));

            assertTrue((Boolean) method.invoke(game, new int[]{10, 3}, 9));

            assertTrue((Boolean) method.invoke(game, new int[]{10, 3, 3}, 9));
        } catch (Exception e) {

        }
    }

    @Test
    public void testValidateFrameTotalScore() {
        try {
            Object game = Class.forName("Bowling").newInstance();
            Method method = game.getClass().getDeclaredMethod("validateFrameTotalScore", new Class<?>[0]);
            assertFalse((Boolean) method.invoke(game, new int[]{10, 7, 5}, 9));

            assertFalse((Boolean) method.invoke(game, new int[]{8, 8, 7}, 9));

            assertFalse((Boolean) method.invoke(game, new int[]{5, 7}, 0));

            assertTrue((Boolean) method.invoke(game, new int[]{5, 3}, 0));

            assertTrue((Boolean) method.invoke(game, new int[]{10, 3}, 9));

            assertTrue((Boolean) method.invoke(game, new int[]{10, 3, 3}, 9));
        } catch (Exception e) {

        }
    }
}
