package client;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class ClientGUI  extends Application {
    //private Button a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z;
    private Scene scene;
    private TextArea messages = new TextArea();
    private String word = "PATHOLOGY";

    @Override
    public void start(Stage primaryStage) throws Exception{
        Button A = new Button("A");Button B = new Button("B");Button C = new Button("C");
        Button D = new Button("D");Button E = new Button("E");Button F = new Button("F");
        Button G = new Button("G");Button H = new Button("H");Button I = new Button("I");
        Button J = new Button("J");Button K = new Button("K");Button L = new Button("L");
        Button M = new Button("M");Button N = new Button("N");Button O = new Button("O");
        Button P = new Button("P");Button Q = new Button("Q");Button R = new Button("R");
        Button S = new Button("S");Button T = new Button("T");Button U = new Button("U");
        Button V = new Button("V");Button W = new Button("W");Button X = new Button("X");
        Button Y = new Button("Y");Button Z = new Button("Z");
        messages.setPrefHeight(150);

        VBox Col1 = new VBox();
        VBox Col2 = new VBox();
        HBox Row1 = new HBox();

        Col1.setSpacing(20);
        Col2.setSpacing(20);
        Row1.setSpacing(40);
        Row1.setPadding(new Insets(10,30,10,30));

        //Background image
        // create A image
//        Image image = new Image("land.jpg");
//        // create A background image
//        BackgroundImage backgroundimage = new BackgroundImage(image,
//                BackgroundRepeat.NO_REPEAT,
//                BackgroundRepeat.NO_REPEAT,
//                BackgroundPosition.DEFAULT,
//                BackgroundSize.DEFAULT);
        // create Background
        // Background background = new Background(backgroundimage);
        // Row1.setBackground(background);

        Col1.getChildren().addAll(A,B,C,D,E,F,G,H,I,J,K,L,M);
        Col2.getChildren().addAll(N,O,P,Q,R,S,T,U,V,W,X,Y,Z);
        Row1.getChildren().addAll(Col1,Col2, messages);
        Client client = new Client(messages);
        client.start();
        //******************************************************
        //int length = word.length();
        A.setOnAction(Event->{
            if(word.contains("A")){
                client.sendWord("A");
            }

        });

        B.setOnAction(Event->{
            if(word.contains("B")){
                client.sendWord("B");
            }

        });

        C.setOnAction(Event->{
            if(word.contains("C")){
                client.sendWord("C");
            }

        });

        D.setOnAction(Event->{
            if(word.contains("D")){
                client.sendWord("D");
            }

        });

        E.setOnAction(Event->{
            if(word.contains("E")){
                client.sendWord("E");
            }

        });

        F.setOnAction(Event->{
            if(word.contains("F")){
                client.sendWord("F");
            }

        });

        G.setOnAction(Event->{
            if(word.contains("G")){
                client.sendWord("G");
            }

        });

        H.setOnAction(Event->{
            if(word.contains("H")){
                client.sendWord("H");
            }

        });

        I.setOnAction(Event->{
            if(word.contains("I")){
                client.sendWord("I");
            }

        });

        J.setOnAction(Event->{
            if(word.contains("J")){
                client.sendWord("J");
            }

        });

        K.setOnAction(Event->{
            if(word.contains("K")){
                client.sendWord("K");
            }

        });

        L.setOnAction(Event->{
            if(word.contains("L")){
                client.sendWord("L");
            }

        });

        M.setOnAction(Event->{
            if(word.contains("M")){
                client.sendWord("M");
            }

        });

        N.setOnAction(Event->{
            if(word.contains("N")){
                client.sendWord("N");
            }

        });

        O.setOnAction(Event->{
            if(word.contains("O")){
                client.sendWord("O");
            }

        });

        P.setOnAction(Event->{
            if(word.contains("P")){
                client.sendWord("P");
            }

        });

        Q.setOnAction(Event->{
            if(word.contains("Q")){
                client.sendWord("Q");
            }

        });

        R.setOnAction(Event->{
            if(word.contains("R")){
                client.sendWord("R");
            }

        });

        S.setOnAction(Event->{
            if(word.contains("S")){
                client.sendWord("S");
            }

        });

        T.setOnAction(Event->{
            if(word.contains("T")){
                client.sendWord("T");
            }

        });

        U.setOnAction(Event->{
            if(word.contains("U")){
                client.sendWord("U");
            }

        });

        V.setOnAction(Event->{
            if(word.contains("V")){
                client.sendWord("A");
            }

        });

        W.setOnAction(Event->{
            if(word.contains("W")){
                client.sendWord("W");
            }

        });

        X.setOnAction(Event->{
            if(word.contains("X")){
                client.sendWord("X");
            }

        });

        Y.setOnAction(Event->{
            if(word.contains("Y")){
                client.sendWord("Y");
            }

        });

        Z.setOnAction(Event->{
            if(word.contains("Z")){
                client.sendWord("Z");
            }

        });

        //*******************************************************

        scene = new Scene(Row1, 1000, 600);
        primaryStage.setTitle("Client");
        primaryStage.setScene(scene);
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }

}
