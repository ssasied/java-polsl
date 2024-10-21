/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Vector;
import model.admin;
import model.album;
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
     public int Menu(){
        view.startMenu();
        int choice = getInt();       
        switch(choice){
            case 1:  // add user
                controllerAddUser();
                break;
            case 2: // add admin
                controllerAddAdmin();
                break;
            case 3: // add album 
                controllerAddAlbum();
                break;
            case 4: // display users
                displayUsers();
                break;
            case 5: // display admins
                displayAdmins();
                break;
            case 6: // display albums
                displayAlbums();
                break;        
        }
    return  choice;
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
        Vector<song>songsInAlbum = new Vector<song>();    
        int songNumber = 1;        
        int songAuthorNumber = 1;        
        view.viewAddAlbum();
        view.viewAddAlbumName();        
        Scanner scanner = new Scanner(System.in); 
        String albumName = scanner.nextLine();  
        
        do {     
            try {                
                Vector<String> authorsInSong = new Vector<String>();    
                
                view.viewAddSongs();
                view.viewSongNumber(songNumber);
                String songName = scanner.nextLine();
                view.viewAddSongAuthorInstructions(); 
                
                if (songName.trim().isEmpty()) {
                            break; // Stops the loop when an empty line is entered
                }
                songAuthorNumber=1;
                
                do {     
                    try {         
                        view.viewSongAuthor();
                        view.viewSongAuthorNumber(songAuthorNumber++);
                        String line = scanner.nextLine();
                        if (line.trim().isEmpty()) {
                            break; // Stops the loop when an empty line is entered
                        }
                        authorsInSong.add(line);                        
                        songsInAlbum.add(new song(songName,authorsInSong,songNumber++));
                    } catch (NoSuchElementException e) {
                            view.throwNoSuchElementException();   
                            break;
                    }                
                }while (true);  
//                System.out.println(songName+ " ");
//                for(String s : authorsInSong){
//                    
//                System.out.println(s);
//                }
                
                lib.addAlbum(albumName, songsInAlbum);
            }catch (NoSuchElementException e) {
                view.throwNoSuchElementException();   
                break;
            }                
        }while (true);              
    }
            
            
            
    
    
   
    
    public void displayUsers(){
        for(user usr : lib.getUsers()){
            view.viewDisplayUser(usr);
        }    
    }
    public void displayAdmins(){
        for(user usr : lib.getUsers()){
            if (usr instanceof admin)
                view.viewDisplayUser(usr);
        }
    }
    public void displayAlbums(){
        for(Map.Entry<String, album> entry : lib.getAlbums().entrySet()){
            view.viewDisplayAlbum(entry.getValue());
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
