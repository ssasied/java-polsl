/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDateTime;
import java.util.Vector;

/**
 *
 * @author SuperStudent-PL
 */
public class album {
    String albumTitle;
    
    int id;
    LocalDateTime productionDate;    
    Vector<song>songs = new Vector<song>();
    int numberOfSongs = 0;

    public album(String title, int id) {
        this.albumTitle = title;
        this.id = id;
        this.numberOfSongs = 0;
    }

    public album(String albumTitle, int id, LocalDateTime productionDate) {
        this.albumTitle = albumTitle;
        this.id = id;
        this.productionDate = productionDate;
        this.numberOfSongs = 0;    
    }

    public album(String albumTitle, int id, Vector<song> songs) {
        this.albumTitle = albumTitle;
        this.id = id;
        this.songs = songs;
    }

    
    
    public String getAlbumTitle() {
        return albumTitle;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getProductionDate() {
        return productionDate;
    }

    public Vector<song> getSongs() {
        return songs;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProductionDate(LocalDateTime productionDate) {
        this.productionDate = productionDate;
    }

    public void setSongs(Vector<song> songs) {
        this.songs = songs;
        this.numberOfSongs = songs.size();    
    }

    public int getNumberOfSongs() {
        return numberOfSongs;
    }
    
    
    
}
