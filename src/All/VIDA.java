/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package All;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Jorge V. Vargas Jr.
 */
public class VIDA extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        
            GridPane all = new GridPane();
            
            Parent FarmWorker = FXMLLoader.load(getClass().getResource("/All/MainFarmer.fxml"));
            Parent CrewLead = FXMLLoader.load(getClass().getResource("/All/MainCrewLead.fxml"));
            Parent FarmOwner = FXMLLoader.load(getClass().getResource("/All/MainFarmOwner.fxml"));
            
            all.addRow(0,CrewLead,FarmOwner);
            Scene scene = new Scene(FarmWorker);
            
            stage.setScene(scene);
            stage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(VIDA.class, new String[0]);
    }
    
}
