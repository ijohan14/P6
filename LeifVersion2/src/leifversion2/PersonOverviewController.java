/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leifversion2;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
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
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import leifversion2.AddPersonController;
/**
 * FXML Controller class
 *
 * @author nathalie
 */
@XmlRootElement(name="Persons")
public class PersonOverviewController {
    @FXML
    private TableView<Person> visDataTabel;
    @FXML
    private TableColumn<Person, String> fornavnKolonne;
    @FXML
    private TableColumn<Person, String> efternavnKolonne;
    @FXML
    private ListView vissibleList;
    
    @FXML Button personOverviewFortrydKnap;
    @FXML Button personOverviewTifojKnap;
    
    @FXML TextField fornavn;
    @FXML TextField efternavn;
    
       
   // ObservableList<Person> p = new AddPersonController().getContent();
//    public ObservableList<Person> getContent() {
//        ObservableList<Person> personData = FXCollections.observableArrayList();
//        personData.add(new Person("Nathalie", "Trane"));
//        personData.add(new Person("Christine", "Grabow")); // your data
//        gem(personData,"h","j");
//        return personData;
//    }
    
    public ObservableList<Person> personData = FXCollections.observableArrayList();
    
    @XmlElements({@XmlElement(name = "Person", type = Person.class)})
    public List<Person> getChildren(){
        return personData;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PersonData:");
        
        for (Person node : personData){
            sb.append("\n");
            sb.append(" " + node.toString());
        }
        return sb.toString();
    }
      
    @FXML
    public void initialize() {
        //vissibleList.setItems(personData);
        fornavnKolonne.setCellValueFactory(new PropertyValueFactory<>("fornavn"));
        efternavnKolonne.setCellValueFactory(new PropertyValueFactory<>("efternavn"));
        
        visDataTabel.getColumns().clear();
        
        visDataTabel.setItems(personData);
        visDataTabel.getColumns().addAll(fornavnKolonne, efternavnKolonne);
        
        
        
        
    }
    
    @FXML
    private void handlePersonOverviewTilfoj() throws IOException{
              
        
        Person person = new Person();
        person.setFornavn(fornavn.getText());
        person.setEfternavn(efternavn.getText());
        personData.add(person);
        //visDataTabel.getItems().add(person);
        fornavn.clear();
        efternavn.clear();
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
