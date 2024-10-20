/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Vector;

/**
 *
 * @author SuperStudent-PL
 */
public class song {
    String songTitle;
    Vector<String>authors;
    int numberInAlbum;

    public song(String songName, int numberInAlbum) {
        this.songTitle = songName;
        this.numberInAlbum = numberInAlbum;
    }

    public song(String songTitle, Vector<String> authors, int numberInAlbum) {
        this.songTitle = songTitle;
        this.authors = authors;
        this.numberInAlbum = numberInAlbum;
    }
    
    
    
}

