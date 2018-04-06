package com.revature.demos.jdbcintro.pojos;

import java.util.Objects;

public class Album {
    private int albumid;
    private String title;
    private int artistid;

    public Album(){

    }
    public Album(int albumid, String title, int artistid){
        super();
        this.albumid = albumid;
        this.title = title;
        this.artistid = artistid;
    }

    public int getAlbumid() {
        return albumid;
    }

    public void setAlbumid(int albumid) {
        this.albumid = albumid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getArtistid() {
        return artistid;
    }

    public void setArtistid(int artistid) {
        this.artistid = artistid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return albumid == album.albumid &&
                artistid == album.artistid &&
                Objects.equals(title, album.title);
    }

    @Override
    public int hashCode() {

        return Objects.hash(albumid, title, artistid);
    }


    @Override
    public String toString() {
        return "Album{" +
                "albumid=" + albumid +
                ", title='" + title + '\'' +
                ", artistid=" + artistid +
                '}';
    }

}
