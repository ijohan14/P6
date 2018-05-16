/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bp.controller;

//import bp.model.ForaldreModel;
import java.io.IOException;
//import java.net.URL;
//import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import bp.model.ForaldreModel;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    
    String dbAdress   = "jdbc:mysql://db.course.hst.aau.dk:3306/hst_2018_18gr6406?autoReconnect=true&useSSL=false";
    static String dbUser  = "hst_2018_18gr6406";
    static String dbPassword = "aehiechahbuogheebaec";
     java.sql.Connection con;
    
    private ObservableList<ForaldreModel> familieData = FXCollections.observableArrayList();
    
    
    public ObservableList<ForaldreModel> getFamilieData(){
        return familieData;
    }

    public DatalagringController() throws SQLException{
        familieData.add(new ForaldreModel("Nathalie", "Trane", "1212070004", "3", false,"07"));
        familieData.add(new ForaldreModel("Christine", "Grabow", "0101090002", "5", false, "09"));
        familieData.add(new ForaldreModel("Ingeborg", "Jensen", "04041000006", "8" ,false, "10")); 
        familieData.add(new ForaldreModel("Lise", "Jensen", "05059200008", "8", true, "92")); 
        familieData.add(new ForaldreModel("Peter", "Jensen", "0420900003", "8", true, "90"));

//        con = DriverManager.getConnection(dbAdress, dbUser, dbPassword); 
//        
//        hentDB();
    }

    
    
     public void hentDB() throws SQLException {
        try{
            String SQL = "SELECT * FROM `konto`";
           
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
       
    
    @FXML
    private void initialize(){
        fornavnKolonne.setCellValueFactory(cellData -> cellData.getValue().fornavnProperty());
        efternavnKolonne.setCellValueFactory(cellData -> cellData.getValue().efternavnProperty());
        cprKolonne.setCellValueFactory(cellData -> cellData.getValue().cprProperty());
        familieIDKolonne.setCellValueFactory(cellData -> cellData.getValue().familieIDProperty());
        //brugertypeKolonne.setCellValueFactory(cellData -> cellData.getValue().brugertypeProperty());
        adgangskodeKolonne.setCellValueFactory(cellData -> cellData.getValue().adgangskodeProperty());
        
        visDataTabel.getColumns().clear();
        visDataTabel.setItems(getFamilieData());
        visDataTabel.getColumns().addAll(fornavnKolonne, efternavnKolonne, cprKolonne, familieIDKolonne, brugertypeKolonne, adgangskodeKolonne);
        
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
