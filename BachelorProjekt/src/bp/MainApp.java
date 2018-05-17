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
import bp.controller.DatalagringController;
import bp.model.ForaldreModel;
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
    
    java.sql.Connection con;
    Database database = new Database();
    DatalagringController dc;
    
    private ObservableList<ForaldreModel> familieData = FXCollections.observableArrayList();
    public ObservableList<ForaldreModel> getFamilieData(){
        return familieData;
    }

    public MainApp() {
        this.dc = new DatalagringController();
    }
    
    
    @Override
    public void start(Stage primaryStage) throws IOException, SQLException {
        con = database.getConnection();
        hentDB();
        
        Parent root = FXMLLoader.load(getClass().getResource("view/StartView.fxml"));
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
    
    public void hentDB() throws SQLException {
         
        try{
            String SQL = "SELECT * FROM konto";
           
            ResultSet rs = con.createStatement().executeQuery(SQL);
            
            while(rs.next()){
                ForaldreModel f = new ForaldreModel();
                f.setFornavn(rs.getString("Fornavn"));
                f.setEfternavn(rs.getString("Efternavn"));
               
                familieData.add(f);
            }
            for (ForaldreModel foraldreModel : familieData){
                System.out.println(foraldreModel.getFornavn()+" "+foraldreModel.getEfternavn());
            }
        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println("Fejl ved data!");
        }
}
    
}
