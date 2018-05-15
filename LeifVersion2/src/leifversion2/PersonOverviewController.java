/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leifversion2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import leifversion2.LeifVersion2;

/**
 * FXML Controller class
 *
 * @author nathalie
 */
public class PersonOverviewController {
    
    public LeifVersion2 mainApp;

    @FXML
    private TableView<Person> personTable;
    
    @FXML
    private TableColumn<Person, String> fornavn;
    
    @FXML
    private TableColumn<Person, String> efternavn;
    
    
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        fornavn.setCellValueFactory(
            cellData -> cellData.getValue().fornavnProperty());
        efternavn.setCellValueFactory(
            cellData -> cellData.getValue().efternavnProperty());
        
//        personTable.getColumns().clear();
//        personTable.setItems(data);
//        personTable.getColumns().addAll(fornavn,efternavn);

        
    }
    
    
    
}
