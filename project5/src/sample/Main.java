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
    private Button a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z;
    private Scene client;
    private TextArea messages = new TextArea();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Button a = new Button("A");Button b = new Button("B");Button c = new Button("C");
        Button d = new Button("D");Button e = new Button("E");Button f = new Button("F");
        Button g = new Button("G");Button h = new Button("H");Button i = new Button("I");
        Button j = new Button("J");Button k = new Button("K");Button l = new Button("L");
        Button m = new Button("M");Button n = new Button("N");Button o = new Button("O");
        Button p = new Button("P");Button q = new Button("Q");Button r = new Button("R");
        Button s = new Button("S");Button t = new Button("T");Button u = new Button("U");
        Button v = new Button("V");Button w = new Button("W");Button x = new Button("X");
        Button y = new Button("Y");Button z = new Button("Z");
        messages.setPrefHeight(150);

        VBox Col1 = new VBox();
        VBox Col2 = new VBox();
        HBox Row1 = new HBox();

        Col1.setSpacing(20);
        Col2.setSpacing(20);
        Row1.setSpacing(40);
        Row1.setPadding(new Insets(10,30,10,30));

        //Background image
        // create a image
        Image image = new Image("land.jpg");
        // create a background image
        BackgroundImage backgroundimage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        // create Background
        Background background = new Background(backgroundimage);
        Row1.setBackground(background);

        Col1.getChildren().addAll(a,b,c,d,e,f,g,h,i,j,k,l,m);
        Col2.getChildren().addAll(n,o,p,q,r,s,t,u,v,w,x,y,z);
        Row1.getChildren().addAll(Col1,Col2, messages);


        client = new Scene(Row1, 1000, 600);
        primaryStage.setTitle("Client");
        primaryStage.setScene(client);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
