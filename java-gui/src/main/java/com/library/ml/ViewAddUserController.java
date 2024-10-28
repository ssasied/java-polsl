/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.library.ml;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.library;
import model.user;
/**
 * FXML Controller class
 *
 * @author SuperStudent-PL
 */
public class ViewAddUserController {
    private library lib;

    @FXML
    private Label nameLabel;
    @FXML
    private Label surnameLabel;
    @FXML
    private Label AddingUserLabel;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField surnameTextField;
    @FXML
    private Button addUserButton;

    

    
    public ViewAddUserController(library lib) {
        this.lib = lib;
    }  
    
    
    public void addUserButton()throws IOException {
        try{
            String name = nameTextField.getText();
            String surname = surnameTextField.getText();
            lib.addUser(name, surname);
            App.setRoot("mainMenu");
        } catch(IllegalArgumentException  ex){
            
        }        
         
    }
    
}
