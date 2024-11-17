/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;


/**
 *
 * @author ssasied
 * main library class
 */
public class library {
   
   private Vector<user> users = new Vector<> ();
   private Map<String,album> albums;
   private user currentUser;
   private int nextAlbumId;
   private int nextUserId;
   
    public library() {
        this.albums = new HashMap<String,album>();
        this.nextAlbumId=1;
        this.nextUserId=1;
        this.currentUser = new user("test","user",0); //login
        
    //read data and update albums vector and current ids
    }
    
    
    /**
     * adds album to albums vector
     * @param albumTitle string title of album
     * @param songs vector of songs in album
     * @return 
     */
    public int addAlbum(String albumTitle, Vector<song> songs){
        if(!albums.containsKey(albumTitle)){
            album newAlbum = new album(albumTitle,nextAlbumId++, songs);
            albums.put(albumTitle,newAlbum);
            return 0;
        }
        else{
            return -1;
        }
    }    
    
    /**
     * overloaded addAlbum function with production date
     * @param albumTitle string title of album
     * @param productionDate LocalDateTime production date
     * @param songs vector of songs in album
     * @return 
     */
    public int addAlbum(String albumTitle, LocalDateTime productionDate,  Vector<song> songs){
        if(!albums.containsKey(albumTitle)){
            album newAlbum = new album(albumTitle,nextAlbumId++,productionDate);            
            newAlbum.setSongs(songs);           
            albums.put(albumTitle,newAlbum);
            return 0;
        }
        else{
            return -1;
        }
    }
    
    /**
     * adds user to users vector
     * @param name 
     * @param surname 
     * @return 
     */
    public int addUser(String name, String surname){
        try{
            users.add(new user(name, surname, nextUserId++));
        }
        catch(Exception e){
            return -1;
        }
        return 0;
    }
    /**
     * adds admin to user vector
     * @param name
     * @param surname
     * @return 
     */
    public int addAdmin(String name, String surname){
        try{
            users.add(new admin(name, surname, nextUserId++));
        }
        catch(Exception e){
            return -1;
        }
        return 0;
    }
    
    
    public Vector<user> getUsers() {
        return users;
    }
    public Vector<user> getAdmins() {
        Vector<user>admins = new Vector();
        for(user us : users){
            if(us instanceof admin){
                admins.add(us);
            }
        }        
        return admins;
    }
    
    public Map<String, album> getAlbums() {
        return albums;
    }

    public int getNextAlbumId() {
        return nextAlbumId;
    }

    public int getNextUserId() {
        return nextUserId;
    }
    
    public Set<String> getAlbumNames(){
        return  albums.keySet();
    }
   public Collection<album> getAlbumValues(){
        return albums.values();
    }
    
}
