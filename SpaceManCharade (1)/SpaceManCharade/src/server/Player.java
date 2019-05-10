package server;

public class Player {

    private String name;
    private int points;
    private boolean isSuggesting;
    private String word = "";

    public Player(String name, int points, boolean isSuggesting) {
        this.name = name;
        this.points = points;
        this.isSuggesting = isSuggesting;
    }

    public Player(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public boolean isSuggesting() {
        return isSuggesting;
    }

    public void setSuggesting(boolean suggesting) {
        isSuggesting = suggesting;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
