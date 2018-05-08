/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author st6gr6406
 */
public class StartController {
    //Attributter
    /*
    @FXML
    private TextField fornavnTekstFelt;
    @FXML
    private TextField efternavnTekstFelt;
    @FXML
    private TextField CPRTekstFelt;
    @FXML
    private TextField adgangskodeTekstFelt;
    @FXML
    private TextField familieIDTekstFelt;
    */
    private OpretNyKontoController brugerkonto;
    
        
    public OpretNyKontoController getBrugerkonto(){
        return brugerkonto;
    }
    
    public void setBrugerkonto(OpretNyKontoController brugerkonto) {
        this.brugerkonto = brugerkonto;
        
        
        /*
        //Skal forbindes til OpretNyKontoView
        fornavnTekstFelt.setText(brugerkonto.getFornavn());
        efternavnTekstFelt.setText(brugerkonto.getEfternavn());
        CPRTekstFelt.setText(brugerkonto.getCPR());
        adgangskodeTekstFelt.setText(brugerkonto.getAdgangskode());
        familieIDTekstFelt.setText(Integer.toString(brugerkonto.getFamilieID());
        //Her mangler brugertype og sporgsmålSvar
        */
    }
    
    private void handleOpretNyBrugerKnap() {
    
    }
    
    private void handleLoginKnap() {
        
    }
    
}
