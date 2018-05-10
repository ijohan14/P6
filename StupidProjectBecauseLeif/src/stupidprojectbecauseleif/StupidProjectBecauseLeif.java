/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stupidprojectbecauseleif;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author nathalie
 */
public class StupidProjectBecauseLeif extends Application {
    /*Button btnscene1, btnscene2;
    Label lblscene1, lblscene2;
    FlowPane pane1, pane2;
    Scene scene1, scene2;
    Stage theStage;*/
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        /*theStage = primaryStage;
        
        btnscene1 = new Button("Click to go to other scene");
        btnscene2 = new Button ("Click to go back to first scene");
        btnscene1.setOnAction(e -> handleButtonAction(e));
        btnscene2.setOnAction(e -> handleButtonAction(e));
        lblscene1 = new Label("Scene 1");
        lblscene2 = new Label("Scene 2");
        pane1 = new FlowPane();
        pane2 = new FlowPane();
        pane1.setVgap(10);
        pane2.setVgap(10);
        pane1.setStyle("-fx-background-color: tan;-fx-padding: 10px;");
        pane2.setStyle("-fx-background-color: red;-fx-padding: 10px;");
        
        pane1.getChildren().addAll(lblscene1,btnscene1);
        pane2.getChildren().addAll(lblscene2,btnscene2);
        
        scene1 = new Scene(pane1, 200, 100);
        scene2 = new Scene(pane2, 200, 100);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene1);
        primaryStage.show();*/
        
        Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    /*
    public void ButtonClicked(ActionEvent e) 
        {
            if (e.getSource() == btnscene1)
                theStage.setScene(scene2);
                
            else 
                theStage.setScene(scene1);
            }*/
        }
    

