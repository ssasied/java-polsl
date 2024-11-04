/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.library.ml;

import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import model.library;
/**
 * FXML Controller class
 *
 * @author SuperStudent-PL
 */
public class ViewAddAlbumController implements Initializable {
    private static library lib;
 
    private final ObservableList<String> dataSongs;   
    private final ObservableList<String> currentDataAuthors;   

    
    private final Map<String,ObservableList<String>> songAuthors; 
    
     
    
    
    @FXML
    private TableView  songsTable;
    @FXML
    private TableView authorsTable;
    @FXML
    private Button albumAddSongButton;
    @FXML
    private Button albumAddAuthorButton;
    @FXML
    private Button albumAddAlbumButton;
    @FXML
    private Button albumRemoveSongButton;
    @FXML
    private Button albumRemoveAuthorButton;
    @FXML
    private TextField songNameTextField;
    @FXML
    private TextField authorsNameTextField;
    @FXML
    private TableColumn<Integer, Integer> songId;
    @FXML
    private TableColumn<String, String> songTitle;
    @FXML
    private TableColumn<Integer, Integer> authorId;
    @FXML
    private TableColumn<String, String> authorName;

    public ViewAddAlbumController(library lib) {
        this.songAuthors = new HashMap<String,ObservableList<String>>();
        this.lib = lib;
        dataSongs = FXCollections.observableArrayList();
        currentDataAuthors = FXCollections.observableArrayList();
    }
   
    
    
    
    
    public void initialize(URL url, ResourceBundle rb) {
        songsTable.setItems(dataSongs);
        songId.setCellValueFactory(new PropertyValueFactory<>("firstNname"));
        
    }    
    
    @FXML
    private void albumAddSongButton(ActionEvent event) {
    
        dataSongs.add(songNameTextField.getText());
        
        
    }

    @FXML
    private void albumAddAuthorButton(ActionEvent event) {
    }

    @FXML
    private void albumAddAlbumButton(ActionEvent event) {
    }

    @FXML
    private void albumRemoveSongButton(ActionEvent event) {
    }

    @FXML
    private void albumRemoveAuthorButton(ActionEvent event) {
    }

}
