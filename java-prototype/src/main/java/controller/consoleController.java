/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Scanner;
import java.util.Vector;
import model.library;
import model.song;
import model.user;
import view.consoleView;

/**
 *
 * @author SuperStudent-PL
 */
public class consoleController {
    library lib;
    consoleView view;

    public consoleController(library lib, consoleView view) {
        this.lib = lib;
        this.view = view;
    }
    public void displayMenu(){
        while(Menu()!=7){
        }
    
    }
    
    public void controllerAddUser(){
        view.viewAddUser1();
        String name = getString();      
        view.viewAddUser2();
        String surname = getString();
        if(lib.addUser(name, surname)!=0){
            view.errorAddUserMessage();
        }  
    }
    
    public void controllerAddAdmin(){
        view.viewAddAdmin();
        String name = getString();      
        view.viewAddUser2();
        String surname = getString();
        if(lib.addAdmin(name, surname)!=0){
            view.errorAddUserMessage();
        }  
        
    }
    
    Boolean hasNextLine(){
        Scanner newScanner = new Scanner(System.in);        
        return newScanner.hasNextLine();
    }
    
    void controllerAddAlbum(){     

        //infinite loop for now need to stop on ^Z 
        
        Vector<song>songsInAlbum = new Vector<song>();
        Vector<String> authorsInSong = new Vector<String>();        
        int songNumber = 1;        
        int songAuthorNumber = 1;
        
        view.viewAddAlbum();
        view.viewAddAlbumName();        
        String albumName = getString();     
        
        view.viewAddSongs();
        view.viewSongNumber(songNumber);
        String songName = getString();
        view.viewAddSongAuthorInstructions();
        while(hasNextLine()){
            view.viewSongAuthor();
            view.viewSongAuthorNumber(songAuthorNumber++);
            authorsInSong.add(getString());
        }
        songsInAlbum.add(new song(songName,authorsInSong,songNumber++));
        
    }
    
    public int Menu(){
        view.startMenu();
        int choice = getInt();       
    switch(choice){
        case 1:   
            controllerAddUser();
            break;
        case 2:
            controllerAddAdmin();
            break;
        case 3:
            controllerAddAlbum();
            break;
        case 4:    
            displayUsers();
            break;
        case 5:
            break;
        case 6:
            break;        
    }
    return  choice;
    }
    
    public void displayUsers(){
        for(user usr : lib.getUsers()){
            view.viewDisplayUser(usr);
        }
    
    }
    
    public int getInt(){
        Scanner newScanner = new Scanner(System.in);        
        return newScanner.nextInt();
    }
    public String getString(){
        Scanner newScanner = new Scanner(System.in);        
        return newScanner.nextLine();
    }
    
}
