
public class TennisGameIonel implements TennisGame {

    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    public String getPlayer1Name() {
        return player1Name;
    }

    public String getPlayer2Name() {
        return player2Name;
    }

    public TennisGameIonel(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            player1Score += 1;
        else
            player2Score += 1;
    }

    public String getScore() {
        String score = "";

        if (isScoreEqual()) {
            score = getEqualScores(player1Score);
        } else if (isEndGame()) {
            score = getAdvantageOrWinScore();
        } else {
            score = getRegularPlayScores(score);
        }

        return score;
    }

    private String getRegularPlayScores(String score) {
        score = appendToScore(score, player1Score);
        score += "-";
        score = appendToScore(score, player2Score);
        return score;
    }

    private boolean isEndGame() {
        return player1Score >= 4 || player2Score >= 4;
    }

    private boolean isScoreEqual() {
        return player1Score == player2Score;
    }

    private String appendToScore(String score, int tempScore) {
        switch (tempScore) {
            case 0:
                score += "Love";
                break;
            case 1:
                score += "Fifteen";
                break;
            case 2:
                score += "Thirty";
                break;
            case 3:
                score += "Forty";
                break;
        }
        return score;
    }

    private String getAdvantageOrWinScore() {
        String score = "";
        String betterPlayer = "player1";
        if (player1Score < player2Score) {
            betterPlayer = "player2";
        }

        int scoreDifference = Math.abs(player1Score - player2Score);

        if (scoreDifference == 1)
            score = "Advantage " + betterPlayer;
        else if (scoreDifference > 1)
            score = "Win for " + betterPlayer;

        return score;
    }

    private String getEqualScores(int temp) {
        String score;
        switch (temp) {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            case 3:
                score = "Forty-All";
                break;
            default:
                score = "Deuce";
                break;

        }
        return score;
    }
}
