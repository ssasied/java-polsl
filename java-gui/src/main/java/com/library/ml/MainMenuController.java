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
import model.library;
import model.user;
/**
 * FXML Controller class
 *
 * @author SuperStudent-PL
 */
public class MainMenuController {
    private library lib;

    @FXML
    private Button addUserButton;
    @FXML
    private Button addAdminButton;
    @FXML
    private Button addAlbumButton;
    @FXML
    private Button displayUserButton;
    @FXML
    private Button displayAdminButton;
    @FXML
    private Button displayAlbumsButton;

    public MainMenuController(library lib) {
        this.lib = lib;
    }
       
    
    
    public void addUserButton()throws IOException{
        App.setRoot("viewAddUser"); 
    }    
    
    public void addAdminButton() throws IOException{
         App.setRoot("viewAddAdmin"); 
    }
    
    public void addAlbumButton() throws IOException{
         App.setRoot("viewAddAlbum"); 
    }
    
    public void displayUserButton() throws IOException{
         App.setRoot("viewDisplayUser"); 
    }
    
    public void displayAdminsButton() throws IOException{
         App.setRoot("viewDisplayAdmins"); 
    }
    
    public void displayAlbumsButton() throws IOException{
         App.setRoot("viewDisplayAlbums"); 
    }
    
    
}
