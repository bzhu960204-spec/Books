package CRSPredictor.pojo;

import java.util.Date;
import java.util.Map;

/**
 * Entity for record a history draw
 */
public class CRSHistoryDraw {
    // date of the draw
    private Date drawDate;
    // number of candidates that got ITA
    private int numberOfCandidatesDraw;
    // the number of candidates distributed among different ranges of scores
    private Map<String, Integer> candidatesDistributions;
    // the score of cut off
    private int cutOffScore;
    // total number of candidates
    private int totalCandidateNumber;
    // round of draw
    private String roundOfDraw;


    public CRSHistoryDraw(Date drawDate, int numberOfCandidatesDraw, Map<String, Integer> candidatesDistributions, int cutOffScore) {
        this.drawDate = drawDate;
        this.numberOfCandidatesDraw = numberOfCandidatesDraw;
        this.candidatesDistributions = candidatesDistributions;
        this.cutOffScore = cutOffScore;
        totalCandidateNumber = 0;
        for (String key : candidatesDistributions.keySet()) {
            totalCandidateNumber += candidatesDistributions.get(key);
        }
    }

    public CRSHistoryDraw() {
    }

    public CRSHistoryDraw(Date drawDate, int numberOfCandidatesDraw, Map<String, Integer> candidatesDistributions, int cutOffScore, String roundOfDraw) {
        this.drawDate = drawDate;
        this.numberOfCandidatesDraw = numberOfCandidatesDraw;
        this.candidatesDistributions = candidatesDistributions;
        this.cutOffScore = cutOffScore;
        this.roundOfDraw = roundOfDraw;
        totalCandidateNumber = 0;
        for (String key : candidatesDistributions.keySet()) {
            totalCandidateNumber += candidatesDistributions.get(key);
        }
    }

    public Date getDrawDate() {
        return drawDate;
    }

    public void setDrawDate(Date drawDate) {
        this.drawDate = drawDate;
    }

    public int getNumberOfCandidatesDraw() {
        return numberOfCandidatesDraw;
    }

    public void setNumberOfCandidatesDraw(int numberOfCandidatesDraw) {
        this.numberOfCandidatesDraw = numberOfCandidatesDraw;
    }

    public Map<String, Integer> getCandidatesDistributions() {
        return candidatesDistributions;
    }

    public void setCandidatesDistributions(Map<String, Integer> candidatesDistributions) {
        this.candidatesDistributions = candidatesDistributions;
        totalCandidateNumber = 0;
        for (String key : candidatesDistributions.keySet()) {
            totalCandidateNumber += candidatesDistributions.get(key);
        }
    }

    public int getCutOffScore() {
        return cutOffScore;
    }

    public void setCutOffScore(int cutOffScore) {
        this.cutOffScore = cutOffScore;
    }

    public int getTotalCandidateNumber() {
        return totalCandidateNumber;
    }

    public void setTotalCandidateNumber(int totalCandidateNumber) {
        this.totalCandidateNumber = totalCandidateNumber;
    }

    public String getRoundOfDraw() {
        return roundOfDraw;
    }

    public void setRoundOfDraw(String roundOfDraw) {
        this.roundOfDraw = roundOfDraw;
    }


    @Override
    public String toString() {
        return "CRSHistoryDraw{" +
                "drawDate=" + drawDate +
                ", numberOfCandidatesDraw=" + numberOfCandidatesDraw +
                ", candidatesDistributions=" + candidatesDistributions +
                ", cutOffScore=" + cutOffScore +
                ", totalCandidateNumber=" + totalCandidateNumber +
                ", roundOfDraw='" + roundOfDraw + '\'' +
                '}';
    }
}
