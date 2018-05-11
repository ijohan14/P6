/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bp.controller;

import bp.model.ForaldreModel;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author christinemariegrabow
 */
public class DatalagringController implements Initializable {

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
    public TableColumn<ForaldreModel, String> adgangskodeKolonne;
    
    @FXML
    public Button visDataTilbageKnap;
    
    private ObservableList<ForaldreModel> familieData = FXCollections.observableArrayList();

    public DatalagringController(){
        familieData.add(new ForaldreModel("Nathalie", "T", "1", "2","5"));
    }
    
    public ObservableList<ForaldreModel> getFamilieData(){
        return familieData;
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
    @FXML
    private void initialize(){
        fornavnKolonne.setCellValueFactory(cellData -> cellData.getValue().fornavnProperty());
    }
 
    @FXML
    private void handleTilbage(ActionEvent event) throws IOException{ 
        Stage stage; 
        Parent root;
        if (event.getSource() == visDataTilbageKnap) {
                stage = (Stage) visDataTilbageKnap.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("/bp/view/StartView.fxml"));
            } 
        else {
                stage = (Stage) visDataTilbageKnap.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("/bp/view/StartView.fxml"));
            
            }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
