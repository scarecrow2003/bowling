package bowling;

/**
 * Created by zhihua on 9/8/16.
 */
public class Bowling {
    public static int[] calculateScore(int[][] inData) {
        int len = inData.length;
        int[] scores = new int[len];
        for (int i=len-1; i>=0; i--) {
            int[] frame = inData[i];
            for (int score : frame) {
                scores[i] += score;
            }
            if (i != len-1 && frame[0] == 10) {
                if (scores[i+1] > 20) {
                    scores[i] = 30;
                } else {
                    scores[i] += scores[i + 1];
                }
            }
        }
        return scores;
    }
}
