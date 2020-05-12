package Reviews;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gjunior2
 */
public class Data {
    private String genre;
    private List<Double> scores;
    private double bestPercent;
    private int best;
    private int platform;
    private List<Double> scoresPlatform;
    private String bestGame;
    private double BestGameEvaluate;
    private String worstGame;
    private String genreMoreCommon;
    private double worstGameEvaluate;
    public Data() {
        scores = new ArrayList<Double>();
        scoresPlatform = new ArrayList<>();
    }
     public String getGameGenre() {
        return genre;
    }

    public void setGameGenre(String genre) {
        this.genre = genre;
    }

    public int getMasterpiece() {
        return best;
    }

    public void setMasterpiece(int masterpiece) {
        this.best = masterpiece;
    }

    public double getAmazingPercent() {
        return bestPercent;
    }

    public void setAmazingPercent(double amazingPercent) {
        this.bestPercent = amazingPercent;
    }

    public double getBestGameEvaluate() {
        return BestGameEvaluate;
    }

    public void setBestGameEvaluate(double bestGameScore) {
        this.BestGameEvaluate = bestGameScore;
    }

    public String getBestGame() {
        return bestGame;
    }

    public void setBestGame(String bestGame) {
        this.bestGame = bestGame;
    }

    public double getWorstGameEvaluate() {
        return worstGameEvaluate;
    }

    public void setWorstGameEvaluate(double worstGameScore) {
        this.worstGameEvaluate = worstGameScore;
    }

    public String getWorstGame() {
        return worstGame;
    }

    public void setWorstGame(String worstGame) {
        this.worstGame = worstGame;
    }

    public String getMostCommonGenre() {
        return genreMoreCommon;
    }

    public void setMostCommonGenre(String mostCommonGenre) {
        this.genreMoreCommon = mostCommonGenre;
    }

    public int getPlatform() {
        return platform;
    }

    public void setPlatform(int getPlatform) {
        this.platform = getPlatform;
    }

    public List<Double> getScores() {
        return scores;
    }

    public void setScores(List<Double> scores) {
        this.scores = scores;
    }

    public List<Double> getScoresNintendo() {
        return scoresPlatform;
    }

    public void setScoresNintendo(List<Double> scoresNintendo) {
        this.scoresPlatform = scoresNintendo;
    }
    public int getNReviews() {
        return getScores().size(); // retorna o tamanho
    }
    public double getMedia() {
        double totalScore = 0.0;
        for (Double score : getScores()) {
            totalScore = totalScore + score;
        }
        return totalScore / getNReviews(); // total dividido pelo tamanho para obter a média
    }
    public double getAvarageImpression() {
        double totalScore = 0.0;
        for (Double score : scoresPlatform) {
            totalScore = totalScore + score;
        }
        return totalScore / platform;
    }
    
    
    public double getDesvioPadrao() { ///calculo do desvio padrao
        double media = getMedia(); //coleta a média na função já pronta
        double var = 0.0;
        for (Double score : getScores()) {
            var = var + Math.pow(score - media, 2.0); // base elevada pelo expoente
        }
        var = var / getNReviews();
        return Math.sqrt(var); //efetua calculo de raiz quadrada para obter o resultado do desvio padrao
    }
}
