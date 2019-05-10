package server;


import javafx.scene.control.TextArea;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Server implements Runnable{
    public static String word = "";
    private ServerSocket serverSocket;
    private Socket connection;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;
    private TextArea serverLogs;
    private Thread thread;
    public static boolean selectingPlayer = true;
    public static boolean wordSelected = false;
    public static boolean weGotWinner = false;
    public static boolean nextGame = false;

    private List<ClientThread> clients;

    private boolean isRunning = false;

    public Server(TextArea serverLogs){
        this.serverLogs = serverLogs;
        clients = new ArrayList<>();
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

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(7801);
        } catch (IOException e) {
            e.printStackTrace();
        }
        printLog("Waiting for Connections");
        while (isRunning) {
            try {
                connection = serverSocket.accept();
                ClientThread thread = new ClientThread(connection);
                thread.start();
                thread.id = clients.size();
                clients.add(thread);
                printLog("Added "+connection.getInetAddress().getHostName());
                printLog(clients.size()+"");
                // Select
                if (clients.size() >=3) {
                    printLog("Selecting");
                    if (selectingPlayer) {
                        if (!clients.isEmpty()) {
                            Random r = new Random();
                            int selected = r.nextInt(clients.size());
                            clients.get(selected).setSuggesting(true);
                            selectingPlayer = false;
                            for (ClientThread c:clients) {
                                if (c.id !=0) {
                                    c.sendMessage("Waiting for Player to select a word");
                                }
                            }
                        }
                    }
                }
                if (wordSelected){
                    printLog("Word Selected");
                    for (ClientThread c:clients) {
                        if (c.id !=0) {
                            c.sendMessage("Word Selected\n Game Begins now");
                            if (!c.getPlayer().isSuggesting()) {
                                c.sendCMD(2);
                            }
                        }
                    }
                }
                for (ClientThread c:clients) {
                    if (c.getPlayer().getPoints() >=8){
                        weGotWinner = true;
                    }
                }
                if (weGotWinner){
                    for (ClientThread c:clients) {
                        if (c.id !=0) {
                            c.sendMessage("Next game starts now");
                        }
                    }
                }
                if (nextGame){
                    printLog("Next game Now");
                    for (ClientThread c:clients) {
                        if (c.id !=0) {
                            c.getPlayer().setSuggesting(false);
                            c.getPlayer().setWord("");
                        }
                    }
                    nextGame = false;
                }
            } catch (IOException e) {
                e.printStackTrace();
           }
        }
    }
    private void printLog(String message){
        System.out.println(message);
        serverLogs.appendText("\n "+message);
    }


}
