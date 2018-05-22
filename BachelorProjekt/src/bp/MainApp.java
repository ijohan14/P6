/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bp;

import bp.controller.Database;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import bp.controller.DatabaseController;
import bp.model.KontoModel;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author nathalie
 */
public class MainApp extends Application {
    
//    java.sql.Connection con;
//    Database database = new Database();
    DatabaseController dc;
    
//    private ObservableList<KontoModel> familieData = FXCollections.observableArrayList();
//    public ObservableList<KontoModel> getFamilieData(){
//        return familieData;
//    }

    public MainApp(){
        this.dc = new DatabaseController();
    }
    
    
    @Override
    public void start(Stage primaryStage) throws IOException, SQLException {
        
        dc.hentDB();
        
        Parent root = FXMLLoader.load(getClass().getResource("view/LoginView.fxml"));
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
    
    
    
    
    
}
