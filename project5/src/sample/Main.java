package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.image.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BackgroundPosition;

import javafx.scene.control.Button;


public class Main extends Application {
    //private Button a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z;
    private Scene client;
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
        Image image = new Image("land.jpg");
        // create A background image
        BackgroundImage backgroundimage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        // create Background
        Background background = new Background(backgroundimage);
        Row1.setBackground(background);

        Col1.getChildren().addAll(A,B,C,D,E,F,G,H,I,J,K,L,M);
        Col2.getChildren().addAll(N,O,P,Q,R,S,T,U,V,W,X,Y,Z);
        Row1.getChildren().addAll(Col1,Col2, messages);
        //******************************************************
        int length = word.length();
        A.setOnAction(Event->{
            if(word.contains("A")){
                A.setDisable(false);
            }
            else A.setDisable(true);
        });

        B.setOnAction(Event->{
            if(word.contains("B")){
                B.setDisable(false);
            }
            else B.setDisable(true);
        });

        C.setOnAction(Event->{
            if(word.contains("C")){
                C.setDisable(false);
            }
            else C.setDisable(true);
        });

        D.setOnAction(Event->{
            if(word.contains("D")){
                D.setDisable(false);
            }
            else D.setDisable(true);
        });

        E.setOnAction(Event->{
            if(word.contains("E")){
                E.setDisable(false);
            }
            else E.setDisable(true);
        });

        F.setOnAction(Event->{
            if(word.contains("F")){
                F.setDisable(false);
            }
            else F.setDisable(true);
        });

        G.setOnAction(Event->{
            if(word.contains("G")){
                G.setDisable(false);
            }
            else G.setDisable(true);
        });

        H.setOnAction(Event->{
            if(word.contains("H")){
                H.setDisable(false);
            }
            else H.setDisable(true);
        });

        I.setOnAction(Event->{
            if(word.contains("I")){
                I.setDisable(false);
            }
            else I.setDisable(true);
        });

        J.setOnAction(Event->{
            if(word.contains("J")){
                J.setDisable(false);
            }
            else J.setDisable(true);
        });

        K.setOnAction(Event->{
            if(word.contains("K")){
                K.setDisable(false);
            }
            else K.setDisable(true);
        });

        L.setOnAction(Event->{
            if(word.contains("L")){
                L.setDisable(false);
            }
            else L.setDisable(true);
        });

        M.setOnAction(Event->{
            if(word.contains("M")){
                M.setDisable(false);
            }
            else M.setDisable(true);
        });

        N.setOnAction(Event->{
            if(word.contains("N")){
                N.setDisable(false);
            }
            else N.setDisable(true);
        });

        O.setOnAction(Event->{
            if(word.contains("O")){
                O.setDisable(false);
            }
            else O.setDisable(true);
        });

        P.setOnAction(Event->{
            if(word.contains("P")){
                P.setDisable(false);
            }
            else P.setDisable(true);
        });

        Q.setOnAction(Event->{
            if(word.contains("Q")){
                Q.setDisable(false);
            }
            else Q.setDisable(true);
        });

        R.setOnAction(Event->{
            if(word.contains("R")){
                R.setDisable(false);
            }
            else R.setDisable(true);
        });

        S.setOnAction(Event->{
            if(word.contains("S")){
                S.setDisable(false);
            }
            else S.setDisable(true);
        });

        T.setOnAction(Event->{
            if(word.contains("T")){
                T.setDisable(false);
            }
            else T.setDisable(true);
        });

        U.setOnAction(Event->{
            if(word.contains("U")){
                U.setDisable(false);
            }
            else U.setDisable(true);
        });

        V.setOnAction(Event->{
            if(word.contains("V")){
                V.setDisable(false);
            }
            else V.setDisable(true);
        });

        W.setOnAction(Event->{
            if(word.contains("W")){
                W.setDisable(false);
            }
            else W.setDisable(true);
        });

        X.setOnAction(Event->{
            if(word.contains("X")){
                X.setDisable(false);
            }
            else X.setDisable(true);
        });

        Y.setOnAction(Event->{
            if(word.contains("Y")){
                Y.setDisable(false);
            }
            else Y.setDisable(true);
        });

        Z.setOnAction(Event->{
            if(word.contains("Z")){
                Z.setDisable(false);
            }
            else Z.setDisable(true);
        });

        //*******************************************************

        client = new Scene(Row1, 1000, 600);
        primaryStage.setTitle("Client");
        primaryStage.setScene(client);
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }


}