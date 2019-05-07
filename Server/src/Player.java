import java.io.Serializable;

public class Player {
    public Thread thread;
    public String name;
    public Serializable guess;
    public Serializable gameWord;
    public int wins;
    public int numGuesses;
    public int numWrongGuesses;
    public int ID;
    public boolean ready;

    Player(Thread t, String n){
        this.thread = t;
        this.name = n;
    }

    public Serializable getGuess(){
        return guess;
    }


    public void setGuess(Serializable val){
        this.play = val;
        System.out.println(this.play);
    }



    public int getPoints(){
        return points;
    }

    public void setPoints(int val){
        this.points = val;
    }

    public Serializable getGameWord() { return gameWord; }

    public void setGameWord(Serializable val) {this.gameWord = val}

    public boolean getPlayAgain(){
        return getPlayAgain();
    }

    public void setPlayAgain(boolean val){
        this.playAgain = val;
    }

    public boolean isReady(){ return ready; }
}

