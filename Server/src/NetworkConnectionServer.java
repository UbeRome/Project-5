import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.function.Consumer;

public abstract class NetworkConnectionServer {

    private ConnThread connthread = new ConnThread();
    private Consumer<Serializable> callback;
    ArrayList<ClientThread> ct;
    // ArrayList<String> players;
    Boolean c1, c2;
    int player1Points = 0, player2Points = 0;
    String client1Data, client2Data;
    private Game game = new Game();

    public NetworkConnectionServer(Consumer<Serializable> callback) {
        this.callback = callback;
        connthread.setDaemon(true);
        ct = new ArrayList<>();
        c1 = false;
        c2 = false;
    }

    public void startConn() throws Exception{
        connthread.start();
    }

    public void sendAll(Serializable data) throws Exception{
            for (int clientNum = 0; clientNum < game.getNumClients(); clientNum++){
                    ct.get(clientNum).tout.writeObject(data);
                    ct.get(clientNum).tout.flush();
            }
    }

    public void send(Serializable data, int index) throws Exception{
        ct.get(index).tout.writeObject(data);
        ct.get(index).tout.flush();
    }

    public void closeConn() throws Exception{
        connthread.socket.close();
    }

    abstract protected boolean isServer();
    abstract protected String getIP();
    abstract protected int getPort();


    class ConnThread extends Thread{
        private Socket socket;
        private ObjectOutputStream out;
        ClientThread t1;
        Player p;
        @SuppressWarnings("resource")
        public void run() {

            if(isServer()) {
                try{
                    ServerSocket server = new ServerSocket(5555);
                    while(true) {
                        t1 = new ClientThread(server.accept(), game.getNumClients(), getName());
                        ct.add(t1);
                        t1.start();
                        p = new Player(t1, "Player " + (game.getNumClients() + 1));
                        game.addPlayer(p);
                        game.setNumClients();
                        Thread.sleep(250);
                        send("youare: " + (game.getNumClients()), game.getNumClients() - 1);
                        if (ct != null && !ct.isEmpty()) {
                            sendAll("RESET");       // RESET clears the clients dropdown list
                            for (int i = 0; i < ct.size(); i++) {
                                sendAll("cl: " + game.players.get(i).name);
                            }
                        }
                        //players.add("Player");//
                    }
                }
                catch(Exception e) {
                    System.out.println(e);
                    callback.accept("Connection Closed\n");
                }
                finally {            // Handles closed connection

                    ct.remove(t1);
                    t1.interrupt();
                }
            }
        }
    }

    class ClientThread extends Thread{
        Socket s;
        int number;
        String name;
        ObjectOutputStream tout;
        ObjectInputStream tin;
        int p1, p2;

        public ClientThread(Socket socket, int num, String player) {
            this.s = socket;
            this.number = num;
            this.name = "Player " + num;
        }

        public void run() {
            try(ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(s.getInputStream())){
                s.setTcpNoDelay(true);
                this.tout = out;
                this.tin = in;

                while(true) {
                    Serializable data = (Serializable) in.readObject();
                    Thread.sleep(1000);
                    if(data.toString().startsWith("players: ")){            // Gets the four players for the game
                        p1 = Integer.parseInt(data.toString().substring(9, data.toString().length() - 2));  // game will fail attempting to connect to players greater than 10
                        p2 = Integer.parseInt(data.toString().substring(11));
                        sendAll("lockConnection");          // Locks clients dropdown lists
                        send("ready", p1 - 1);        // Unlocks clients gameplay options
                        send("ready", p2 - 1);        //
                    }

                    if(game.getNumClients() >= 4) {
                        try {
                            game.players.get(number).setPlay(data.toString());
                        }
                        catch (Exception e){System.out.println(e);}
                        if (game.players.get(p1).play != null && game.players.get(p2).play != null){

                            game.players.get(p1).setPlay(null);         // Set players last play to null
                            game.players.get(p2).setPlay(null);         //
                            game.players.get(p3).setPlay(null);         //
                            game.players.get(p4).setPlay(null);         //
                            sendAll("unlockConnection");        //Unlocks clients dropdown lists
                        }
                    }
                    else {
                        tout.writeObject("Waiting for another player to join");
                    }
                }
            }
            catch(Exception e) {
                callback.accept("Connection Closed");
            }
            finally {           // Handles closed connection
                game.players.remove(game.players.get(number));
                game.setNumClients();

                try {
                    Thread.sleep(5000);
                    if (ct != null && !ct.isEmpty()) {
                        sendAll("RESET");
                        for (int i = 0; i < game.getNumClients(); i++) {
                            sendAll("cl: " + game.players.get(i).name);
                        }
                    }
                }
                catch (Exception e2){
                    System.out.println(e2);
                }
            }
        }
    }
}