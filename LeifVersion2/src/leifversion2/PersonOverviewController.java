/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leifversion2;

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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import leifversion2.AddPersonController;
/**
 * FXML Controller class
 *
 * @author nathalie
 */
public class PersonOverviewController {
    @FXML
    private TableView<Person> visDataTabel;
    @FXML
    private TableColumn<Person, String> fornavnKolonne;
    @FXML
    private TableColumn<Person, String> efternavnKolonne;
    
    @FXML Button personOverviewFortrydKnap;
    
       
    ObservableList<Person> p = new AddPersonController().getContent();
//    public ObservableList<Person> getContent() {
//        ObservableList<Person> personData = FXCollections.observableArrayList();
//        personData.add(new Person("Nathalie", "Trane"));
//        personData.add(new Person("Christine", "Grabow")); // your data
//        gem(personData,"h","j");
//        return personData;
//    }
    
   
      
    @FXML
    public void initialize() {
        fornavnKolonne.setCellValueFactory(new PropertyValueFactory<>("fornavn"));
        efternavnKolonne.setCellValueFactory(new PropertyValueFactory<>("efternavn"));
        
        visDataTabel.getColumns().clear();
        
        visDataTabel.setItems(p);
        visDataTabel.getColumns().addAll(fornavnKolonne, efternavnKolonne);
        
        
    }
    
    @FXML
    private void handlePersonOverviewFortryd() throws IOException{
        Stage stage;
        Parent root;
        stage = (Stage) personOverviewFortrydKnap.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
   
    
}
