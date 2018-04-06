package com.revature.demos.jdbcintro.dao;

import com.revature.demos.jdbcintro.pojos.Album;

import java.util.ArrayList;

public interface AlbumDAO {
    public Album getAlbumById(int ID);
    public Album getAlbumByTitle(String Title);
    public ArrayList<Album> getAlbumsByArtistId(int artistid);
    public ArrayList<Album> getAllAlbums();
    public Album addAlbum();
    public Album updateAlbum(Album updatedAlbum);

}
