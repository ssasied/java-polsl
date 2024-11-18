/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.library.ml;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.stream.Collectors;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import model.album;
import model.library;
import model.user;

/**
 * FXML Controller class
 *
 * @author stani
 */
public class ViewDisplayAlbumsController  {

    
    private static library lib;
    
    private final ObservableList<String> data; 
    
    
    @FXML
    private TableView <String>  albumsTable;
    @FXML
    private TableColumn <String , String>albumsTableColumn;
    @FXML
    private Button goBackButton;
    @FXML
    private Button showDetailsButton;

    public ViewDisplayAlbumsController(library lib) {
        this.lib = lib;    
        Set<String>names = lib.getAlbumNames();
//        for(String name : names){
//        System.out.println(name);
//        
//        }        
        data = FXCollections.observableArrayList(
        names.stream()
             .filter(name -> name.matches("^[a-zA-Z].*")) 
             .collect(Collectors.toList())
        );
    }
    
    
    
    public void initialize() {
        albumsTableColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()));

        albumsTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        albumsTable.setItems(data);
    }    

    @FXML
    private void goBackButton()throws IOException {
        App.setRoot("mainMenu");    
    }

    @FXML
    private void showDetailsButton() throws IOException {
        String selectedAlbum = albumsTable.getSelectionModel().getSelectedItem();
        
        
    }
    
}
