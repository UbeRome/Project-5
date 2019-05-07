import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.HashMap;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class ClientGUI extends Application {
	String player2Points;
	String player1Points;
    private TextArea messages = new TextArea();
    private Text scoreBoard = new Text();
    Button connect, rockButton, paperButton, scissorButton, lizardButton, spockButton, quit, quit1;
    Text welcome, clientNo, playerMove, selectMove, gameWin, playAgain;
    Stage myStage;
    Scene scene, gameplay;
    HashMap < String, Scene > sceneMap;
    Image rockImage, paperImage, scissorImage, lizardImage, spockImage;
    ChoiceBox<String> clientList = new ChoiceBox<String>();
    HBox moveBox;

    int id;
    private NetworkConnectionClient conn;

    private ClientLogic createClient() {
        return new ClientLogic(data -> {
            Platform.runLater(() -> {
                int inbound;
                moveBox.setDisable(true);
                if (data.toString().startsWith("youare: ")){
                    this.id = Integer.parseInt(data.toString().substring(8));
                    System.out.println("Changing ID: " + id);
                }
                else if (data.toString().equals("RESET")){
                    clientList.getItems().clear();
                }
                else if (data.toString().equals("lockConnection")){
                    clientList.setDisable(true);
                }
                else if (data.toString().equals("unlockConnection")){
                    clientList.setDisable(false);
                }
                else if (data.toString().startsWith("cl: ")) {
                    inbound = Integer.parseInt(data.toString().substring(11));
                    if (id != inbound) {
                        clientList.getItems().add(data.toString().substring(4));
                    }
                }
                else if (data.toString().equals("ready")){
                    moveBox.setDisable(false);
                }
                else {
                    messages.appendText(data.toString());
                }
            });
        });
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub
        primaryStage.setTitle("Rock Paper Scissor Lizard Spock Client");
        myStage = primaryStage;
        welcome = new Text("Welcome to Rock Paper Scissors Lizard Spock! ");
        selectMove = new Text("Make your choice: ");
        connect = new Button("Connect");
        quit1 = new Button("Quit");
        quit = new Button("Quit");
        scoreBoard.setTextAlignment(TextAlignment.LEFT);;
        messages.setPrefHeight(550);

        //clientList.getItems().add("Testing");
        //clientList.getItems().add("1");
        //clientList.getItems().add("2");
        //clientList.getItems().add("3");

        clientList.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
            	String playerSelect = clientList.getItems().get((Integer) number2).substring(7);
            	String players = "players: " + id + " " + playerSelect;
            	try {conn.send(players);} catch (Exception e){}
            	clientList.getSelectionModel().clearSelection();
            }
        });
        
        String rockFile = "Rock.png";
        try {
            rockImage = new Image(rockFile);

        } catch (Exception ex) {
            System.out.println(String.format("Error loading image from: (%s)", rockFile));
            rockImage = null;
        }

        String paperFile = "Paper.png";
        try {
            paperImage = new Image(paperFile);

        } catch (Exception ex) {
            System.out.println(String.format("Error loading image from: (%s)", paperFile));
            paperImage = null;
        }

        String scissorFile = "Scissor.png";
        try {
            scissorImage = new Image(scissorFile);

        } catch (Exception ex) {
            System.out.println(String.format("Error loading image from: (%s)", scissorFile));
            scissorImage = null;
        }

        String lizardFile = "Lizard.png";
        try {
            lizardImage = new Image(lizardFile);

        } catch (Exception ex) {
            System.out.println(String.format("Error loading image from: (%s)", lizardFile));
            lizardImage = null;
        }

        String spockFile = "Spock.png";
        try {
            spockImage = new Image(spockFile);

        } catch (Exception ex) {
            System.out.println(String.format("Error loading image from: (%s)", spockFile));
            spockImage = null;
        }

        rockButton = new Button();
        paperButton = new Button();
        scissorButton = new Button();
        lizardButton = new Button();
        spockButton = new Button();
        moveBox = new HBox(10, rockButton, paperButton, scissorButton, lizardButton, spockButton);

        ImageView rock = new ImageView(rockImage);
        ImageView paper = new ImageView(paperImage);
        ImageView scissor = new ImageView(scissorImage);
        ImageView lizard = new ImageView(lizardImage);
        ImageView spock = new ImageView(spockImage);
        rock.setFitHeight(100);
        rock.setFitWidth(100);
        rock.setPreserveRatio(true);
        rockButton.setGraphic(rock);
        rockButton.setPadding(Insets.EMPTY);

        paper.setFitHeight(100);
        paper.setFitWidth(100);
        paper.setPreserveRatio(true);
        paperButton.setGraphic(paper);
        paperButton.setPadding(Insets.EMPTY);

        scissor.setFitHeight(100);
        scissor.setFitWidth(100);
        scissor.setPreserveRatio(true);
        scissorButton.setGraphic(scissor);
        scissorButton.setPadding(Insets.EMPTY);

        lizard.setFitHeight(100);
        lizard.setFitWidth(100);
        lizard.setPreserveRatio(true);
        lizardButton.setGraphic(lizard);
        lizardButton.setPadding(Insets.EMPTY);

        spock.setFitHeight(100);
        spock.setFitWidth(100);
        spock.setPreserveRatio(true);
        spockButton.setGraphic(spock);
        spockButton.setPadding(Insets.EMPTY);

        sceneMap = new HashMap < String, Scene > ();
      
        connect.setOnAction(new EventHandler <ActionEvent> () {
            public void handle(ActionEvent event) {
                try {
                    conn = createClient();
                    try {
                        conn.startConn();
                    } catch (Exception e) {
                        System.out.println("Connection not established");
                    }
                    myStage.setScene(sceneMap.get("gamePlay"));
                } catch (NumberFormatException e) {
                    
                }
            }
        });

        quit.setOnAction(new EventHandler < ActionEvent > () {
            public void handle(ActionEvent event) {
                Stage stage = (Stage) quit.getScene().getWindow();
                stage.close();
            }
        });

        quit1.setOnAction(new EventHandler < ActionEvent > () {
            public void handle(ActionEvent event) {
                Stage stage = (Stage) quit.getScene().getWindow();
                stage.close();
            }
        });


        rockButton.setOnAction(new EventHandler < ActionEvent > () {
            public void handle(ActionEvent event) {
                String message = "rock";
                try {
                    conn.send(message);
                    moveBox.setDisable(true);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    System.out.println("Connection unavailable");
                }
            }
        });

        paperButton.setOnAction(new EventHandler < ActionEvent > () {
            public void handle(ActionEvent event) {
                String message = "paper";
                try {
                    conn.send(message);
                    moveBox.setDisable(true);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    System.out.println("Connection unavailable");
                }
            }
        });

        scissorButton.setOnAction(new EventHandler < ActionEvent > () {
            public void handle(ActionEvent event) {
                String message = "scissor";
                try {
                    conn.send(message);
                    moveBox.setDisable(true);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    System.out.println("Connection unavailable");
                }
            }
        });

        lizardButton.setOnAction(new EventHandler < ActionEvent > () {
            public void handle(ActionEvent event) {
                String message = "lizard";
                try {
                    conn.send(message);
                    moveBox.setDisable(true);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    System.out.println("Connection unavailable");
                }
            }
        });

        spockButton.setOnAction(new EventHandler < ActionEvent > () {
            public void handle(ActionEvent event) {
                String message = "spock";
                try {
                    conn.send(message);
                    moveBox.setDisable(true);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    System.out.println("Connection unavailable");
                }
            }
        });
        
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(70));
        VBox paneCenter = new VBox(10, welcome, connect, quit);
        pane.setCenter(paneCenter);


        VBox box = new VBox(5, scoreBoard, messages, selectMove, moveBox, quit1);
        HBox newBox = new HBox(5, box, clientList);
        BorderPane pane2 = new BorderPane();
        pane2.setPadding(new Insets(70));
        pane2.setCenter(newBox);

        scene = new Scene(pane, 400, 500);
        gameplay = new Scene(pane2, 800, 700);
        sceneMap.put("welcome", scene);
        sceneMap.put("gamePlay", gameplay);
        primaryStage.setScene(sceneMap.get("welcome"));
        primaryStage.show();
    }
}