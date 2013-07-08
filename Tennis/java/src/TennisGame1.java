public class TennisGame1 implements TennisGame {

    private int player1Score = 0;
    private int player2Score = 0;

    @Override
    public String getPlayer1Name() {
        return player1Name;
    }

    @Override
    public String getPlayer2Name() {
        return player2Name;
    }

    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name))
            player1Score += 1;
        else if (playerName.equals(player2Name))
            player2Score += 1;
    }

    public String getScore() {
        String score = "";
        if (isEqualScore()) {
            score = getScoreStringWhenEquals();
        } else if (isEligibleForWin()) {
            score = getScoreEligibleForWin();
        } else {
            score = getScoreOtherwise(score);
        }
        return score;
    }

    private boolean isEligibleForWin() {
        return player1Score >= 4 || player2Score >= 4;
    }

    private boolean isEqualScore() {
        return player1Score == player2Score;
    }

    private String getScoreOtherwise(String score) {
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = player1Score;
            else {
                score += "-";
                tempScore = player2Score;
            }
            score += getScoreName(tempScore);
        }
        return score;
    }

    private String getScoreName(int score) {
        String scoreName = "";
        switch (score) {
            case 0:
                scoreName = "Love";
                break;
            case 1:
                scoreName = "Fifteen";
                break;
            case 2:
                scoreName = "Thirty";
                break;
            case 3:
                scoreName = "Forty";
                break;
        }
        return scoreName;
    }

    private String getScoreEligibleForWin() {
        String score;
        int deltaScore = player1Score - player2Score;
        if (deltaScore == 1) score = "Advantage player1";
        else if (deltaScore == -1) score = "Advantage player2";
        else if (deltaScore >= 2) score = "Win for player1";
        else score = "Win for player2";
        return score;
    }

    private String getScoreStringWhenEquals() {
        String score;
        if(player1Score == 4) {
            score = "Deuce";
        } else {
            score = getScoreName(player1Score) + "-All";
        }
        return score;
    }


}