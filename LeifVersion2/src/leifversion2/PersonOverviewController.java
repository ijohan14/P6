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

/**
 * FXML Controller class
 *
 * @author nathalie
 */
public class PersonOverviewController {// implements Initializable {
    @FXML
    private TableView<Person> visDataTabel;
    @FXML
    private TableColumn<Person, String> fornavnKolonne;
    @FXML
    private TableColumn<Person, String> efternavnKolonne;
    
    @FXML
    private Button opretKontoKnap;
    @FXML
    private Button opretKontoFortrydKnap;
    @FXML
    private Button opretKontoGemKnap;    
    @FXML
    private TextField fornavnFelt;    
    @FXML
    private TextField efternavnFelt; 
    
    
   
    ObservableList<Person> personData = FXCollections.observableArrayList(new Person("Nathalie", "Trane"), new Person("Christine", "Grabow"));
    
   
    @FXML
    public void init() {
        fornavnKolonne.setCellValueFactory(new PropertyValueFactory<>("fornavn"));
        efternavnKolonne.setCellValueFactory(new PropertyValueFactory<>("efternavn"));
        
        visDataTabel.getColumns().clear();
        
        visDataTabel.setItems(personData);
        visDataTabel.getColumns().addAll(fornavnKolonne, efternavnKolonne);
    }
    
   

    @FXML
    private void handleOpretKonto(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        if(event.getSource() == opretKontoKnap){
            stage = (Stage) opretKontoKnap.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("AddPerson.fxml"));
        } else {
            stage = (Stage) opretKontoFortrydKnap.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("PersonOverview.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show(); 
    }
    
    
    
//    @FXML
//    private void handleOpretKontoGem(ActionEvent event) throws IOException {
//        Stage stage;
//        Parent root;
//            if(event.getSource() == opretKontoGemKnap){
//               if(opretKontoValid()){
//                    personData.add(new Person(fornavnFelt.getText(), efternavnFelt.getText()));
//                    System.out.println("Fornavn: "+fornavnFelt.getText()+"\nEfternavn: "+efternavnFelt.getText());
//                }
//               stage = (Stage) opretKontoGemKnap.getScene().getWindow();
//                root = FXMLLoader.load(getClass().getResource("PersonOverview.fxml"));
//            } else {
//                stage = (Stage) opretKontoFortrydKnap.getScene().getWindow();
//                root = FXMLLoader.load(getClass().getResource("PersonOverview.fxml"));
//            
//        }
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }
//    
//    private boolean opretKontoValid(){
//        String errorMessage = "";
//        
//        if (fornavnFelt.getText() == null || fornavnFelt.getText().length() == 0) {
//            errorMessage += "Intet valid fornavn!\n"; 
//        }
//        if (efternavnFelt.getText() == null || efternavnFelt.getText().length() == 0) {
//            errorMessage += "Intet valid efternavn!\n"; 
//        }
//        
//        if (errorMessage.length() == 0) {
//            return true;
//        } else {
//            System.out.println(errorMessage);
//            return false;
//        }
//    }

//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        
//    }
    
}
