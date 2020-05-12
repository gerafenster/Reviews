package Reviews;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.TreeMap;

/**
 *
 * @author gjunior2
 */
public class Game_Analysis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       TreeMap<String, Data> map = new TreeMap<String, Data>();
        
        int total = 0;
        
        try {
            BufferedReader br = new BufferedReader(new FileReader("game-reviews.csv"));
            String linha = null;
            String[] linhaSplit = null;
            Data g = null;
            br.readLine();
            while ((linha = br.readLine()) != null) {
                linhaSplit = linha.split(";");
                total++;

                if (!map.containsKey(linhaSplit[4])) { //procura o Genero do jogo na 5º coluna do csv
                    g = new Data();
                    g.setGameGenre(linhaSplit[4]);//seta o genero da lina
                    map.put(g.getGameGenre(), g);                    
                } else { g = map.get(linhaSplit[4]); } //se não for o mesmo genero muda

                g.getScores().add(Double.valueOf(linhaSplit[3])); //coleta o score do jogo

                if (linhaSplit[2].equals("Amazing") || linhaSplit[2].equals("amazing")) {  //coleta os amazing p calcular a %
                    g.setAmazingPercent(g.getAmazingPercent() + 1);
                }

                if (linhaSplit[2].equals("Masterpiece") || linhaSplit[2].equals("masterpiece")) {
                    g.setMasterpiece(g.getMasterpiece() + 1);
                }

                if (linhaSplit[4].equals("Action")) {
                    g.setPlatform(g.getPlatform() + 1);
                    g.getScoresNintendo().add(Double.valueOf(linhaSplit[3]));
                }

                if (g.getBestGame() == null || g.getBestGameEvaluate() < Double.valueOf(linhaSplit[3])) {
                    g.setBestGame(linhaSplit[0]);
                    g.setBestGameEvaluate(Double.valueOf(linhaSplit[3]));
                }

                if (g.getWorstGame() == null || g.getWorstGameEvaluate() > Double.valueOf(linhaSplit[3])) {
                    g.setWorstGame(linhaSplit[0]);
                    g.setWorstGameEvaluate(Double.valueOf(linhaSplit[3]));
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String plataforma = null;
        
     

        // INICIA A IMPRESSÃO DOS DADOS
        double console = 0;
        double median = 0.0;
        for (String k : map.keySet()) {
            System.out.println("------------------------------------------------------------------");
            System.out.println("Gênero: " + k );
            System.out.println("");
            System.out.println("Número de reviews: " + map.get(k).getNReviews());
            System.out.println("Percentual de Reviews do tipo 'Amazing': " + (map.get(k).getAmazingPercent()));
            System.out.println("Média Aritmética: " +  map.get(k).getMedia());
            System.out.println("Desvio Padrão: " + map.get(k).getDesvioPadrao());
            System.out.println("Melhor jogo: " + map.get(k).getBestGame());
            System.out.println("Pior jogo: " + map.get(k).getWorstGame());


            if (plataforma == "null" || console < map.get(k).getPlatform()) {
                if (map.get(k).getAvarageImpression()> console) {
                    plataforma = k;
                    console = map.get(k).getAvarageImpression();
                    
                }
            }

        }
        System.out.println("");
        System.out.println("");
        System.out.println("");
        
        System.out.println("Genero mais comum da Nintendo: " + plataforma);
        System.out.println("");
        System.out.println("");
    }
}
