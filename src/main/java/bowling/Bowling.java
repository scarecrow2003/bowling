package bowling;

/**
 * Created by zhihua on 9/8/16.
 */
public class Bowling {
    /**
     * Calculate the score of the bowling session
     * Null will be returned if the input is invalid
     */
    public static int[] calculateScore(int[][] inData) {
        if (inData == null) {
            return null;
        }
        int len = inData.length;
        if (len != 10) {
            return null;
        }
        int[] scores = new int[len];
        for (int i=len-1; i>=0; i--) {
            int[] frame = inData[i];
            //Check for valid array
            if (frame == null || frame.length == 0) {
                return null;
            }
            //Last frame
            if (i==len-1) {
                if (frame.length > 3) {
                    return null;
                }
                if (frame[0] != 10 && frame.length > 2) {
                    return null;
                }
            } else {
                if (frame.length > 2) {
                    return null;
                }
            }
            //End check for valid array
            for (int score : frame) {
                if (score > 10 || score < 0) {
                    //Invalid individual score
                    return null;
                }
                scores[i] += score;
            }
            //Check for invalid score for every frame
            if (i==len-1 && frame[0]==10) {
                if (scores[i] > 20) {
                    return null;
                }
            } else {
                if (scores[i] > 10) {
                    return null;
                }
            }
            //End check for invalid score for every frame

            //Main calculation
            if (i != len-1 && frame[0] == 10) {
                if (i <= len-4 && scores[i + 1] > 20) {
                    //More than two continuous strikes
                    //And before the 8th frame
                    scores[i] = 30;
                } else {
                    scores[i] += scores[i + 1];
                }
            }
        }
        return scores;
    }
}
