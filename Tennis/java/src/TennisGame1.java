public class TennisGame1 implements TennisGame {
    private String player1Name;
    private String player2Name;

    private int player1Score = 0;
    private int player2Score = 0;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    @Override
    public String getPlayer1Name() {
        return player1Name;
    }

    @Override
    public String getPlayer2Name() {
        return player2Name;
    }

    @Override
    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name)) {
            player1Score++;
        } else if (playerName.equals(player2Name)) {
            player2Score++;
        }
    }

    @Override
    public String getScore() {
        String score;

        if (isEqualScore()) {
            score = getScoreStringWhenEquals();
        } else if (isEligibleForWin()) {
            score = getScoreRepresentationEligibleForWin();
        } else {
            score = getIntermediateScore();
        }

        return score;
    }

    private boolean isEligibleForWin() {
        return player1Score >= 4 || player2Score >= 4;
    }

    private boolean isEqualScore() {
        return player1Score == player2Score;
    }

    private String getIntermediateScore() {
        return getScoreName(player1Score) + "-" + getScoreName(player2Score);
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


    private String getScoreRepresentationEligibleForWin() {
        int deltaScore = player1Score - player2Score;

        String scoreRepresentation = getScoreType(deltaScore) + " " + getLeadingPlayer(deltaScore);

        return scoreRepresentation;
    }

    private String getScoreStringWhenEquals() {
        String score;

        if (player1Score == 4) {
            score = "Deuce";
        } else {
            score = getScoreName(player1Score) + "-All";
        }

        return score;
    }

    private String getScoreType(int deltaScore) {
        String scoreType;

        if (Math.abs(deltaScore) == 1) {
            scoreType = "Advantage";
        } else {
            scoreType = "Win for";
        }

        return scoreType;
    }

    private String getLeadingPlayer(int deltaScore) {
        String player;

        if (deltaScore > 0) {
            player = "player1";
        } else {
            player = "player2";
        }

        return player;
    }


}