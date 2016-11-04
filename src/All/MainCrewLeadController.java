/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package All;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Jorge V. Vargas Jr.
 */
public class MainCrewLeadController implements Initializable {

    @FXML Label myLabel;
    @FXML Pane myPane;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    public void setAlert(){
        myPane.setVisible(true);
        myLabel.setText("Farmer needs a cup of water!");
    }
    public void removeAlert(){
        myPane.setVisible(false);
        myLabel.setText(null);
    }
    
}
