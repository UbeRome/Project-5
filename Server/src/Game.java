import java.io.Serializable;
import java.util.ArrayList;

public class Game {
    public String winner = null;
    public ArrayList<Player> players = new ArrayList<Player>();
    public int numClients = players.size();
    public String word;

    public String getStatus(){
        String status = "Clients Connected to Sever: " + this.numClients + "\n";
        return status;
    }


    public void setWinner(String w){
        this.winner = w;
    }

    public boolean isReady(){return this.ready;}

    public int getNumClients() {
        return numClients;
    }

    public void setNumClients() {
        this.numClients = this.players.size();
    }

    public void addPlayer(Player p){
        players.add(p);
    }

    public void removePlayer(Player p){
        players.remove(p);
    }

    public String getWinner(){
        return this.winner;
    }

    public boolean isReady(){
        if (this.players.size() >= 4){
            for (int i = 0; i < this.players.size(); i++){
                if (!players.get(i).isReady()){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public boolean verifyWord(String w){
        String filename = "/Dict/" + w.charAt(0).toUpperCase() + "word.csv";
        BufferedReader br = null;
        line = "";
        delim = ",";

        try {
            br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine()) != null){
                    if (w.toLowerCase().equals(line.toString().toLowerCase())){
                        this.word = w;
                        return true;
                    }
            }
            return false;
        }
        catch (Exception e){
           System.out.println("Failed to open " + filename + ".\n");
        }
    }

    public Serializable checkGuess(Player p){
        Serializable tmp = p.getGameWord();
        Serializabe guess = p.getGuess;
        if (guess.toString().equals(this.word)){
            p.setPlay(this.word);
            return word;
        }

        int i;
        for (i = 0; i < word.length(); i++){
               if (word.charAt(i).equals(guess)){
                   tmp.charAt(i) = guess;
               }
        }
        p.setGameWord()
        return tmp;
    }



    private void setWinner(){
        this.winner =
    }
}
