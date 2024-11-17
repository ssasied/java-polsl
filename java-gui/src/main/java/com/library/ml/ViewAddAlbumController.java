package com.library.ml;

import java.io.IOException;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import model.album;
import model.library;
import model.song;

public class ViewAddAlbumController {

    private static library lib;
    private static final int DISPLAY_LOG_TIME = 2000;
    
    @FXML
    private TableView<song> songsTable;

    @FXML
    private TableColumn<song, String> songTitleColumn;

    @FXML
    private TableColumn<song, String> songNumberColumn;

    @FXML
    private TableView<String> authorsTable;

    @FXML
    private TableColumn<String, String> authorNumberColumn;

    @FXML
    private TableColumn<String, String> authorNameColumn;

    @FXML
    private TextField songTextField;

    @FXML
    private TextField authorTextField;
    @FXML
    private Button addSongButton;
    @FXML
    private Button addAuthorButton;
    @FXML
    private Button addAlbumButton;
    @FXML
    private Button goBackButton;
    @FXML
    private TextField albumTitleTextField;
    @FXML
    private Label log;

    public ViewAddAlbumController(library lib) {
        this.lib = lib;
    }

    private final ObservableList<song> songList = FXCollections.observableArrayList();
    private final ObservableList<String> authorList = FXCollections.observableArrayList();

    public void initialize() {
        songTitleColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSongTitle()));
        songNumberColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getNumberInAlbum())));

        songTitleColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        songTitleColumn.setOnEditCommit(event -> {
            song editedSong = event.getRowValue();
            editedSong.setSongTitle(event.getNewValue());
        });

        authorNumberColumn.setCellValueFactory(cellData -> {
            int index = authorList.indexOf(cellData.getValue());
            return new SimpleStringProperty(String.valueOf(index + 1));
        });
        authorNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()));

        authorNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        authorNameColumn.setOnEditCommit(event -> {
            int index = authorList.indexOf(event.getRowValue());
            authorList.set(index, event.getNewValue());
        });

        songsTable.setItems(songList);
        authorsTable.setItems(authorList);

        songsTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                refreshAuthorsTable(newSelection.getAuthors());
            } else {
                authorList.clear();
            }
        });

        enableTableDeletion();
    }

    
    @FXML
    public void goBackButton()throws IOException {
        App.setRoot("mainMenu");     
    }
   
    @FXML
    public void addSongButton()throws IOException {
        String songTitle = songTextField.getText().trim();
        if (!songTitle.isEmpty()) {
            int songNumber = songList.size() + 1;
            song newSong = new song(songTitle, songNumber);
            newSong.setAuthors(new Vector<>());
            songList.add(newSong);
            songTextField.clear();
        }
    }

    @FXML
    public void addAlbumButton()throws IOException{
        
        if(!albumTitleTextField.getText().trim().isEmpty()){
            lib.addAlbum(albumTitleTextField.getText(),new Vector<song>(songList));
            App.setRoot("mainMenu"); 
}       else showWarning("Fill in album title");
            
    
        
    }
    
    
        
    @FXML
    public void addAuthorButton() throws IOException {
        song selectedSong = songsTable.getSelectionModel().getSelectedItem();
        String authorName = authorTextField.getText().trim();
        if (selectedSong != null && !authorName.isEmpty()) {
            Vector<String> authors = selectedSong.getAuthors();
            authors.add(authorName);
            refreshAuthorsTable(authors);
            authorTextField.clear();
        }
    }

    private void refreshAuthorsTable(Vector<String> authors) {
        authorList.setAll(authors); // Update the observable list with the authors
    }
    
    private void enableTableDeletion() {
    songsTable.setOnKeyPressed(event -> {
        if (event.getCode() == KeyCode.DELETE) {
            song selectedSong = songsTable.getSelectionModel().getSelectedItem();
            if (selectedSong != null) {
                songList.remove(selectedSong);

                updateSongNumbers();

                if (!songList.isEmpty()) {
                    songsTable.getSelectionModel().select(0);
                    refreshAuthorsTable(songsTable.getSelectionModel().getSelectedItem().getAuthors());
                } else {
                    authorList.clear();
                }
            }
        }
    });

    authorsTable.setOnKeyPressed(event -> {
        if (event.getCode() == KeyCode.DELETE) {
            String selectedAuthor = authorsTable.getSelectionModel().getSelectedItem();
            if (selectedAuthor != null) {
                song selectedSong = songsTable.getSelectionModel().getSelectedItem();
                if (selectedSong != null) {
                    selectedSong.getAuthors().remove(selectedAuthor);
                    refreshAuthorsTable(selectedSong.getAuthors());
                }
            }
        }
    });
    }   
    
    private void updateSongNumbers() {
    for (int i = 0; i < songList.size(); i++) {
        song currentSong = songList.get(i);
        currentSong.setNumberInAlbum(i + 1); 
    }
    songsTable.refresh(); 
    }

    

    private void showWarning(String text) {
        log.setText(text);
            
        Timer timer = new java.util.Timer();
        timer.schedule(new TimerTask() {
        @Override
        public void run() {
             Platform.runLater(() -> { log.setText(""); });
        }
        }, DISPLAY_LOG_TIME);
    }
}
