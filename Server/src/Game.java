import java.io.BufferedReader;
import java.io.FileReader;
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
        String filename = "/Dict/" + w.toUpperCase().charAt(0) + "word.csv";
        BufferedReader br = null;
        String line = "";
        String delim = ",";

        try {
            br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine()) != null){
                    if (w.toLowerCase().equals(line.toLowerCase())){
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

    public String checkGuess(Player p){
        String tmp = p.getdisplayWord().toString();
        String guess = p.getGuess().toString();
        if (guess.equals(this.word)){  //Player guessed full word
            p.setGuess(this.word);
            setWinner(p);
            return word;
        }

        int i;
        if (guess.length() == 1) {
            for (i = 0; i < word.length(); i++) {
                if (word.charAt(i) == guess.charAt(0)) { // Player guessed a character
                    tmp = tmp.replace(tmp.charAt(i), guess.charAt(0));
                }
            }
        }
        p.setdisplayWord(tmp);
        setWinner(p);
        return tmp;
    }



    private void setWinner(Player player){
        this.winner = player.name;
    }
}
