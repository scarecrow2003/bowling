package bowling;

/**
 * Created by zhihua on 9/8/16.
 */
public class Bowling {

	private static final int FRAMES_PER_GAME = 10;

    private static final int MAX_SCORE_PER_HIT = 10;

	private int[][] rawScore = null;

	private int[] finalScore = null;

    private boolean gameCompleted = false;

    private boolean validateData(int[][] inData) {
        if (inData == null) {
            return false;
        }
        if (inData.length != FRAMES_PER_GAME) {
            return false;
        }
        for (int i=0; i<FRAMES_PER_GAME; i++) {
            int[] frame = inData[i];
            boolean frameValid = validateFrame(frame, i);
            if (!frameValid) {
                return false;
            }
        }
        return true;
    }

    private boolean validateFrame(int[] frame, int i) {
        if (frame == null || frame.length == 0) {
            return false;
        }
        if (i == FRAMES_PER_GAME-1) {
            if (frame.length > 3) {
                return false;
            }
            if (frame[0] != FRAMES_PER_GAME && frame.length > 2) {
                return false;
            }
        } else if (frame.length > 2) {
            return false;
        }
        for (int score: frame) {
            if (score > 10 || score < 0) {
                return false;
            }
        }
        return validateFrameTotalScore(frame, i);
    }

    private boolean validateFrameTotalScore(int[] frame, int i) {
        int total = 0;
        for (int score: frame) {
            total += score;
        }
        if (i==FRAMES_PER_GAME-1 && frame[0]==MAX_SCORE_PER_HIT) {
            if (total > 20) {
                return false;
            }
        } else {
            if (total > 10) {
                return false;
            }
        }
        return true;
    }

    /**
     * Calculate the score of the bowling session
     */
    private void calculateScore() {
        for (int i=FRAMES_PER_GAME-1; i>=0; i--) {
            int[] frame = rawScore[i];
            for (int score: frame) {
                finalScore[i] += score;
            }
            if (i != FRAMES_PER_GAME-1 && frame[0] == MAX_SCORE_PER_HIT) {
                if (i > FRAMES_PER_GAME-4) {
                    finalScore[i] += finalScore[i+1];
                } else {
                    if (finalScore[i+1] > 20) {
                        finalScore[i] = 30;
                    } else {
                        finalScore[i] += finalScore[i+1];
                    }
                }
            }
        }
        for (int i=1; i<FRAMES_PER_GAME; i++) {
            finalScore[i] += finalScore[i-1];
        }
    }

	public void startGame() {
		rawScore = new int[FRAMES_PER_GAME][];
        gameCompleted = false;
	}

	public void restartGame() {
		startGame();
	}

	/**
	 * Obtain the raw score data
	 * Return false if the supplied raw data is invalid
	 */
	public boolean obtainRawScore(int[][] inData) {
		boolean dataValid = validateData(inData);
		if (dataValid) {
			rawScore = inData;
            gameCompleted = true;
		}
		return dataValid;
	}

    public int[] getScore() {
        finalScore = new int[FRAMES_PER_GAME];
        calculateScore();
        return finalScore;
    }

	public boolean isGameCompleted() {
        return gameCompleted;
    }
}
