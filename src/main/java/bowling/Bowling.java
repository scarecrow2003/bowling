package bowling;

/**
 * Created by zhihua on 9/8/16.
 */
public class Bowling {

	private static int FRAMES_PER_GAME = 10;

	private int[][] rawScore = null;

	private int[] finalScore = null;

	public void startGame() {
		rawScore = new int[10][];
		finalScore = new int[10];
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
		}
		return dataValid;
	}

	private boolean validateData(int[][] inData) {
		if (inData == null) {
			return false;
		}
		int len = inData.length;
		if (len != FRAMES_PER_GAME) {
			return false;
		}
		for (int i=0; i<len; i++) {
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
			if (frame[0] != 10 && frame.length > 2) {
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
		if (i==len-1 && frame[0]==10) {
                	if (frame[0] + frame[1]==null?0:frame[1] + frame[2]==null?0:frame[2] > 20) {
                    		return false;
                	}
            	} else {
                	if (frame[0] + frame[1]==null?0:frame[1] > 10) {
                    		return false;
                	}
            	}
		return true;
	}

	public void calculateScore() {

	}

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

            //Get the score for every frame
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
        //Get the final result
        for (int i=1; i<len; i++) {
            scores[i] += scores[i-1];
        }
        return scores;
    }
}
