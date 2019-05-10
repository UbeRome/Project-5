package server;


import java.io.*;
import java.net.Socket;

public class ClientThread implements Runnable {
    public int id =0;
    private Socket connection;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;
    private Thread thread;
    private boolean isRunning = false;
    private Player player;

    public ClientThread(Socket connection){
        this.connection = connection;
        player = new Player();
    }

    public synchronized void start(){
        if (isRunning) return;
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }
    public synchronized void stop(){
        if (!isRunning) return;
        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void printLog(String message){
        System.out.println("Client Thread"+message);
    }
    @Override
    public void run() {
        player.setName(connection.getInetAddress().getHostName());
        player.setPoints(0);
        player.setSuggesting(false);
        player.setWord("NaN");
        while (isRunning) {
            try {
                printLog(connection.getInetAddress().getHostName());
                objectOutputStream = new ObjectOutputStream(connection.getOutputStream());
                objectOutputStream.flush();
                objectInputStream = new ObjectInputStream(connection.getInputStream());
                printLog("Streams are ready");
                String word = objectInputStream.readUTF();
                if (word.contains("selected,")){
                    printLog("Got word");
                    verifyWord(word.split(",")[1]);
                    Server.wordSelected =true;
                    printLog("Word is good");
                }
                if (word.charAt(0) == 'w'){

                    String check = word.split(",")[1];
                    if (!player.getWord().isEmpty()) {
                        if (player.getWord().contains(check)) {
                            String newWord = player.getWord().replace(check, "");
                            player.setWord(newWord.toUpperCase());

                        }
                    }
                }
                if (player.getWord().isEmpty()){
                    sendMessage("You got the Word right");
                    player.setPoints(player.getPoints()+1);
                    Server.wordSelected = false;
                    Server.selectingPlayer = true;
                    Server.nextGame = true;
                }
                /////////////////////////////////////////
                objectOutputStream.writeChars("I'm here");
                ////////////////////////////////////////
                printLog((String) objectInputStream.readObject());
                ////////////////////////////////////////
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }finally {
                try {
                    objectOutputStream.close();
                    objectInputStream.close();
                    connection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
    public void setSuggesting(boolean isSugesting){
        player.setSuggesting(isSugesting);
        try {
            objectOutputStream.writeUTF("You are suggesting");
            objectOutputStream.writeInt(1);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sendMessage(String message){
        try {
            objectOutputStream.writeUTF(message);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sendCMD(int cmd){
        try {
            objectOutputStream.writeInt(cmd);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public boolean verifyWord(String w){
        String filename = "/Dict/" + w.toUpperCase().charAt(0) + "word.csv";
        printLog(filename);
        BufferedReader br = null;
        String line = "";
        String delim = ",";

        try {
            br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine()) != null){
                if (w.toLowerCase().equals(line.toLowerCase())){
                    Server.word = w;
                    player.setWord(w.toUpperCase());
                    return true;
                }
            }
            return false;
        }
        catch (Exception e){
            System.out.println("Failed to open " + filename + ".\n");
        }
        return false;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
