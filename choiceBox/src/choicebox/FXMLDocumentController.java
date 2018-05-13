/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package choicebox;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author christinemariegrabow
 */
public class FXMLDocumentController implements Initializable {
ObservableList list=FXCollections.observableArrayList();
    @FXML
    private ChoiceBox<String > series;
    @FXML
    private TextField screen;
 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadDat(); 
    }    

    @FXML
    private void displayValue(ActionEvent event) {
    }
    private void loadDat(){
        list.remove(list);
        String a="game of thrones"; 
        String b="friends"; 
        String c="Supernatural"; 
        list.addAll(a, b, c);
        series.getItems().addAll(list);
    }
}
