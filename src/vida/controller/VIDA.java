/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vida.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    public void start(Stage stage) {
        
        try {
            GridPane all = new GridPane();
            System.out.println("I just created the GridPane");
            
            Parent FarmWorker = FXMLLoader.load(getClass().getResource("/vida/View/FarmWorker/MainFarmer.fxml"));
            System.out.println("I created the Parent for MainFarmer");
            Parent CrewLead = FXMLLoader.load(getClass().getResource("/vida/View/CrewLeaders/MainCrewLead.fxml"));
            System.out.println("I created the Parent for CrewLead");
            Parent FarmOwner = FXMLLoader.load(getClass().getResource("/vida/View/FarmOwner/MainFarmOwner.fxml"));
            System.out.println("I created the Parent for FarmOwner");
            
            all.addColumn(0, FarmWorker, CrewLead, FarmOwner);
            System.out.println("I just made a row");
            Scene scene = new Scene(all);
            System.out.println("I made the scene");
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(VIDA.class, new String[0]);
    }
    
}
