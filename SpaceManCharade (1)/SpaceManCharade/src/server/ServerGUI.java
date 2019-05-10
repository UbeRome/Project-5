package server;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class ServerGUI extends Application {
    private TextArea serverLogs;
    private BorderPane root;
    private Button start;

    private Server server;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Server");
        serverLogs = new TextArea();
        start = new Button("Start Server");
        root = new BorderPane();
        root.setCenter(serverLogs);
        root.setTop(start);
        primaryStage.setScene(new Scene(root,400,600));
        primaryStage.show();
        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               server =  new Server(serverLogs);
               server.start();
            }
        });
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                if (server !=null) {
                    System.exit(0);
                    server.stop();

                }
            }
        });
    }
    public static void main(String args[]){
        launch(args);
    }
}
