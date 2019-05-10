package client;

import javafx.scene.control.TextArea;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Client implements Runnable{

    private Socket connection;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;
    private TextArea serverLogs;
    private Thread thread;

    private boolean isRunning = false;
    private boolean isSelecting = false;

    public Client(TextArea serverLogs){
        this.serverLogs = serverLogs;
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
        while (isRunning) {
            try {
                connection = new Socket("192.168.0.115",7801);
                printLog(connection.getInetAddress().getHostName());
                objectOutputStream = new ObjectOutputStream(connection.getOutputStream());
                objectInputStream = new ObjectInputStream(connection.getInputStream());
                printLog("Streams are ready");
                /////////////////////////////////////////
                objectOutputStream.writeUTF("I'm here");
                objectOutputStream.flush();
                printLog(objectInputStream.readUTF());
                if (objectInputStream.readInt() == 1){
                    isSelecting = true;
                }
                if (isSelecting){
                    String word = JOptionPane.showInputDialog(null,"Enter a Word");
                    objectOutputStream.writeUTF("selected,"+word);
                    objectOutputStream.flush();
                }
                if (objectInputStream.readInt() == 2){
                    printLog("Start Guessing");
                }
                ////////////////////////////////////////
//                printLog( objectInputStream.readUTF());
                ////////////////////////////////////////
            } catch (IOException e) {
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
    private void printLog(String message){
        System.out.println(message);
        serverLogs.appendText("\n "+message);
    }
    public void sendWord(String word){
        try {
            printLog("Writing word");
            objectOutputStream.writeUTF("w,"+word);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
