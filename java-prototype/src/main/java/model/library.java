/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;


/**
 *
 * @author SuperStudent-PL
 */
public class library {
   
   Vector<user> users = new Vector<> ();
   Map<String,album> albums;
   user currentuser;
   int nextAlbumid;
   int nextUserid;
    public library() {
        this.albums = new HashMap<String,album>();
        this.nextAlbumid=1;
        this.nextUserid=1;
        this.currentuser = new user("test","user",0); //login
        
    //read data and update albums vector and current ids
    }
    
    public int addAlbum(String albumTitle, Vector<song> songs){
        if(!albums.containsKey(albumTitle)){
            album newAlbum = new album(albumTitle,nextAlbumid++);
            newAlbum.setSongs(songs);                   
            albums.put(albumTitle,newAlbum);
            return 0;
        }
        else{
            return -1;
        }
    }    
    public int addAlbum(String albumTitle, LocalDateTime productionDate,  Vector<song> songs){
        if(!albums.containsKey(albumTitle)){
            album newAlbum = new album(albumTitle,nextAlbumid++,productionDate);            
            newAlbum.setSongs(songs);           
            albums.put(albumTitle,newAlbum);
            return 0;
        }
        else{
            return -1;
        }
    }
    
    public int addUser(String name, String surname){
        try{
            users.add(new user(name, surname, nextUserid++));
        }
        catch(Exception e){
            return -1;
        }
        return 0;
    }
    
    public int addAdmin(String name, String surname){
        try{
            users.add(new admin(name, surname, nextUserid++));
        }
        catch(Exception e){
            return -1;
        }
        return 0;
    }

    public Vector<user> getUsers() {
        return users;
    }

    public Map<String, album> getAlbums() {
        return albums;
    }

    public int getNextAlbumid() {
        return nextAlbumid;
    }

    public int getNextUserid() {
        return nextUserid;
    }
    

   
    
}
