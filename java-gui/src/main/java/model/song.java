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
    private String songTitle;
    private Vector<String>authors;
    private int numberInAlbum;

    public song(String songName, int numberInAlbum) {
        this.songTitle = songName;
        this.numberInAlbum = numberInAlbum;
    }

    public song(String songTitle, Vector<String> authors, int numberInAlbum) {
        this.songTitle = songTitle;
        this.authors = authors;
        this.numberInAlbum = numberInAlbum;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public Vector<String> getAuthors() {
        return authors;
    }

    public void setAuthors(Vector<String> authors) {
        this.authors = authors;
    }

    public int getNumberInAlbum() {
        return numberInAlbum;
    }

    public void setNumberInAlbum(int numberInAlbum) {
        this.numberInAlbum = numberInAlbum;
    }
    
    
    
}

