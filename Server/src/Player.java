import java.io.Serializable;

public class Player {
    public Thread thread;
    public String name;
    public Serializable guess;
    public Serializable displayWord;
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

    public Serializable getdisplayWord() { return displayWord; }

    public void setdisplayWord(Serializable val) {this.displayWord = val}

    public boolean getPlayAgain(){
        return getPlayAgain();
    }

    public void setPlayAgain(boolean val){
        this.playAgain = val;
    }

    public boolean isReady(){ return ready; }
}

