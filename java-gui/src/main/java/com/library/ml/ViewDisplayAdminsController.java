/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.library.ml;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.library;
import model.admin;
import model.user;



public class ViewDisplayAdminsController {
    private library lib;

    @FXML
    
    private TableView<user> table;
    @FXML
    private TableColumn<user, Integer> id;
    @FXML
    private TableColumn<user, String> surname;
    @FXML
    private TableColumn<user, String> name;
    
    @FXML
    private Button goBackButton;
    
    private final ObservableList<user> data;    
    private final Vector<user> admins;
    
    
//     public void goBackButtonA()throws IOException{
//        App.setRoot("viewAddUser"); 
//    }    

    
    public ViewDisplayAdminsController(library lib) {
        this.lib = lib;
        
        this.admins = lib.getAdmins();
        data = FXCollections.observableArrayList(admins);
//        for(admin usr: lib.getAdmins()){
//            System.out.println(usr.getName());
//        }
        
    }   
    
    
    
    public void initialize() {
        
    id.setCellValueFactory(new PropertyValueFactory<>("id")); // Assuming 'id' is a property in the admin class
    name.setCellValueFactory(new PropertyValueFactory<>("name")); // Assuming 'name' is a property in the admin class
    surname.setCellValueFactory(new PropertyValueFactory<>("surname")); // Assuming 'surname' is a property in the admin class

    table.setItems(data);
    }

    
    public void goBackButton() throws IOException {
         App.setRoot("mainMenu"); 
    }
}
