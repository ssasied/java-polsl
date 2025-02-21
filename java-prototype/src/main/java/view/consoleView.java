/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.consoleController;
import model.album;
import model.library;
import model.song;
import model.user;

/**
 *
 * @author SuperStudent-PL
 */
public class consoleView {

    public consoleView() {
    }    
    
    public void Display(){
       
    }
    
    public void startMenu(){
    System.out.println("Welcome to the library");
    System.out.println("Choose action by typing a number:");
    System.out.println("1. create user");
    System.out.println("2. create admin");
    System.out.println("3. add album");
    System.out.println("4. display users");
    System.out.println("5. display admins");
    System.out.println("6. display albums");
    System.out.println("7. exit");
    System.out.print("Choice: ");
    }
    
    public void viewAddAlbum(){    
        System.out.println("Add Album");
    }
    public void viewAddAlbumName(){
        System.out.print("Album name: ");    
    }
    public void viewAddSongs(){
        System.out.println("Adding songs.");      
    }
    public void viewSongNumber(int n){
        System.out.print(n+". ");    
    }
    
    public void viewAddSongTitle(){        
        System.out.print("Title: ");   
    }
    
    public void viewAddSongAuthorInstructions(){
        System.out.println("Add Authors. To stop adding press enter without typing anything.");      
    }
    
    public void viewSongAuthor(){
        System.out.print("Author ");    
    }
    
    public void viewSongAuthorNumber(int n){
        System.out.println("no. " + n + ": ");    
    }
    public void viewAddUser1(){
        System.out.println("Create User");
        System.out.print("Name: ");
    }
    public void viewAddAdmin(){
        System.out.println("Create Admin");
        System.out.print("Name: ");
    }
    
    public void viewAddUser2(){
        System.out.print("Surname: ");          
    }
    
    public void viewDisplayAlbum(album alb){             
        System.out.println("Title: " + alb.getAlbumTitle());
        System.out.println("Production date: " + alb.getProductionDate());
        System.out.println("Songs: " + alb.getNumberOfSongs());
        int iterator = 1;
        for(song so : alb.getSongs()){
            System.out.println(iterator++ + ": " + so.getSongTitle());
            System.out.print("By: " );
            for(String author : so.getAuthors()){
                System.out.print(author + ", ");
            }
            System.out.print('\n');            
        }        
    }
    
    public void errorAddUserMessage(){
            System.out.println("Failed to add user: ");       
    }
    
    public void throwNoSuchElementException(){
        System.out.println("Input not allowed,exiting the loop"+'\n');
    }
    
    public void viewDisplayUser(user usr){
        System.out.println(usr.getId() +". "+ usr.getName() + " " + usr.getSurname()+ '\n');
    }
}
