/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vida.View.FarmWorker;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Jorge V. Vargas Jr.
 */
public class MainFarmerController implements Initializable {
    
    @FXML ProgressBar progress;
    @FXML TextField valueTextField;
    @FXML Pane alertPane;
    @FXML Pane vitalsPane;
    @FXML Label alertLabel;
    @FXML Button vitalsBtn;
    
    @FXML
    private void handleVitals(ActionEvent event) {
        vitalsPane.setVisible(true);
    }
    @FXML
    private void handleNonVitals(ActionEvent event){
        vitalsPane.setVisible(false);
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        if(valueTextField.getText()!=null){
//            valueTextField.setOnAction(new EventHandler<ActionEvent>() {
//                @Override
//                public void handle(ActionEvent event) {
//                    setBar(Double.parseDouble(valueTextField.getText()));
//                }
//            });
//        }
    }  
    public void setField(String my){
        valueTextField.setText(my);
    }
    public void setBar(double val){
        if(val<=.5) {
            progress.setStyle("-fx-accent: green");
            alertPane.setVisible(false);
            alertLabel.setText(null);
        }
        else if(val>.5&&val<=.8){ 
            progress.setStyle("-fx-accent: yellow");
            alertPane.setVisible(true);
            alertLabel.setText("DRINK WATER");
        }
        else if(val>.8) {
            progress.setStyle("-fx-accent: red");
            alertPane.setVisible(true);
            alertLabel.setText("DRINK WATER IMMEDIATELY");
        }
        progress.setProgress(val);
    }
}
