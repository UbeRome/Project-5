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
            for(int count= 0; count< length; count++){
                if('A' == word.indexOf(count) || 'A' != word.indexOf(count)){
                    A.setDisable(true);
                }
            }
        });

        B.setOnAction(Event->{
            for(int count= 0; count< length; count++){
                if('B' == word.indexOf(count) || 'B' != word.indexOf(count)){
                    B.setDisable(true);
                }
            }
        });

        C.setOnAction(Event->{
            for(int count= 0; count< length; count++){
                if('C' == word.indexOf(count) || 'C' != word.indexOf(count)){
                    C.setDisable(true);
                }
            }
        });

        D.setOnAction(Event->{
            for(int count= 0; count< length; count++){
                if('D' == word.indexOf(count) || 'D' != word.indexOf(count)){
                    D.setDisable(true);
                }
            }
        });

        E.setOnAction(Event->{
            for(int count= 0; count< length; count++){
                if('E' == word.indexOf(count) || 'E' != word.indexOf(count)){
                    E.setDisable(true);
                }
            }
        });

        F.setOnAction(Event->{
            for(int count= 0; count< length; count++){
                if('F' == word.indexOf(count) || 'F' != word.indexOf(count)){
                    F.setDisable(true);
                }
            }
        });

        G.setOnAction(Event->{
            for(int count= 0; count< length; count++){
                if('G' == word.indexOf(count) || 'G' != word.indexOf(count)){
                    G.setDisable(true);
                }
            }
        });

        H.setOnAction(Event->{
            for(int count= 0; count< length; count++){
                if('H' == word.indexOf(count) || 'H' != word.indexOf(count)){
                    H.setDisable(true);
                }
            }
        });

        I.setOnAction(Event->{
            for(int count= 0; count< length; count++){
                if('I' == word.indexOf(count) || 'I' != word.indexOf(count)){
                    I.setDisable(true);
                }
            }
        });

        J.setOnAction(Event->{
            for(int count= 0; count< length; count++){
                if('J' == word.indexOf(count) || 'J' != word.indexOf(count)){
                    J.setDisable(true);
                }
            }
        });

        K.setOnAction(Event->{
            for(int count= 0; count< length; count++){
                if('K' == word.indexOf(count) || 'K' != word.indexOf(count)){
                    K.setDisable(true);
                }
            }
        });

        L.setOnAction(Event->{
            for(int count= 0; count< length; count++){
                if('L' == word.indexOf(count) || 'L' != word.indexOf(count)){
                    L.setDisable(true);
                }
            }
        });

        M.setOnAction(Event->{
            for(int count= 0; count< length; count++){
                if('M' == word.indexOf(count) || 'M' != word.indexOf(count)){
                    M.setDisable(true);
                }
            }
        });

        N.setOnAction(Event->{
            for(int count= 0; count< length; count++){
                if('N' == word.indexOf(count) || 'N' != word.indexOf(count)){
                    N.setDisable(true);
                }
            }
        });

        O.setOnAction(Event->{
            for(int count= 0; count< length; count++){
                if('O' == word.indexOf(count) || 'O' != word.indexOf(count)){
                    O.setDisable(true);
                }
            }
        });

        P.setOnAction(Event->{
            for(int count= 0; count< length; count++){
                if('P' == word.indexOf(count) || 'P' != word.indexOf(count)){
                    P.setDisable(true);
                }
            }
        });

        Q.setOnAction(Event->{
            for(int count= 0; count< length; count++){
                if('Q' == word.indexOf(count) || 'Q' != word.indexOf(count)){
                    Q.setDisable(true);
                }
            }
        });

        R.setOnAction(Event->{
            for(int count= 0; count< length; count++){
                if('R' == word.indexOf(count) || 'R' != word.indexOf(count)){
                    R.setDisable(true);
                }
            }
        });

        S.setOnAction(Event->{
            for(int count= 0; count< length; count++){
                if('S' == word.indexOf(count) || 'S' != word.indexOf(count)){
                    S.setDisable(true);
                }
            }
        });

        T.setOnAction(Event->{
            for(int count= 0; count< length; count++){
                if('T' == word.indexOf(count) || 'T' != word.indexOf(count)){
                    T.setDisable(true);
                }
            }
        });

        U.setOnAction(Event->{
            for(int count= 0; count< length; count++){
                if('U' == word.indexOf(count) || 'U' != word.indexOf(count)){
                    U.setDisable(true);
                }
            }
        });

        V.setOnAction(Event->{
            for(int count= 0; count< length; count++){
                if('V' == word.indexOf(count) || 'V' != word.indexOf(count)){
                    V.setDisable(true);
                }
            }
        });

        W.setOnAction(Event->{
            for(int count= 0; count< length; count++){
                if('W' == word.indexOf(count) || 'W' != word.indexOf(count)){
                    W.setDisable(true);
                }
            }
        });

        X.setOnAction(Event->{
            for(int count= 0; count< length; count++){
                if('X' == word.indexOf(count) || 'X' != word.indexOf(count)){
                    X.setDisable(true);
                }
            }
        });

        Y.setOnAction(Event->{
            for(int count= 0; count< length; count++){
                if('Y' == word.indexOf(count) || 'Y' != word.indexOf(count)){
                    Y.setDisable(true);
                }
            }
        });

        Z.setOnAction(Event->{
            for(int count= 0; count< length; count++){
                if('Z' == word.indexOf(count) || 'Z' != word.indexOf(count)){
                    Z.setDisable(true);
                }
            }
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