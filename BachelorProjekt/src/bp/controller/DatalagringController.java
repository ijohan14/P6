/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bp.controller;

import bp.MainApp;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import bp.model.ForaldreModel;

/**
 * FXML Controller class
 *
 * @author christinemariegrabow
 */
public class DatalagringController {

    @FXML
    public TableView visDataTabel;
    
    @FXML
    public TableColumn<ForaldreModel, String> fornavnKolonne;
    
    @FXML
    public TableColumn<ForaldreModel, String> efternavnKolonne;
    
    @FXML
    public TableColumn<ForaldreModel, String> cprKolonne;
    
    @FXML
    public TableColumn<ForaldreModel, String> familieIDKolonne;
    
    @FXML
    public TableColumn<ForaldreModel, String> brugertypeKolonne;
    
    @FXML
    public TableColumn<ForaldreModel, String> adgangskodeKolonne;
    
    @FXML
    public Button visDataTilbageKnap;
    
   
    
    

    public DatalagringController(){
//        familieData.add(new ForaldreModel("Nathalie", "Trane", "1212070004", "3", false,"07"));
//        familieData.add(new ForaldreModel("Christine", "Grabow", "0101090002", "5", false, "09"));
//        familieData.add(new ForaldreModel("Ingeborg", "Jensen", "04041000006", "8" ,false, "10")); 
//        familieData.add(new ForaldreModel("Lise", "Jensen", "05059200008", "8", true, "92")); 
//        familieData.add(new ForaldreModel("Peter", "Jensen", "0420900003", "8", true, "90"));

        
        
        
    }
    
    

    
    
     
       
    
    @FXML
    private void initialize(){
        fornavnKolonne.setCellValueFactory(cellData -> cellData.getValue().fornavnProperty());
        efternavnKolonne.setCellValueFactory(cellData -> cellData.getValue().efternavnProperty());
        cprKolonne.setCellValueFactory(cellData -> cellData.getValue().cprProperty());
        familieIDKolonne.setCellValueFactory(cellData -> cellData.getValue().familieIDProperty());
        //brugertypeKolonne.setCellValueFactory(cellData -> cellData.getValue().brugertypeProperty());
        adgangskodeKolonne.setCellValueFactory(cellData -> cellData.getValue().adgangskodeProperty());
        
//        visDataTabel.getColumns().clear();
//        visDataTabel.setItems(MainApp.getFamilieData());
//        visDataTabel.getColumns().addAll(fornavnKolonne, efternavnKolonne, cprKolonne, familieIDKolonne, brugertypeKolonne, adgangskodeKolonne);
//        
    }
 
    @FXML
    private void handleTilbage() throws IOException{ 
        Stage stage; 
        Parent root;
        stage = (Stage) visDataTilbageKnap.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/bp/view/StartView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    
}
