package com.revature.demos.jdbcintro.dao;

import com.revature.demos.jdbcintro.pojos.Album;
import com.revature.demos.jdbcintro.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AlbumDAOImpl implements AlbumDAO {
    @Override
    public Album getAlbumById(int ID) {
        Album album = new Album();
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "SELECT * FROM album WHERE albumid = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, ID);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                album.setAlbumid(ID);
                album.setArtistid(rs.getInt(3));
                album.setTitle(rs.getString(2));
            }

        } catch(SQLException e){
            e.printStackTrace();
        }
        return album;
    }

    @Override
    public Album getAlbumByTitle(String Title) {
        Album album = new Album();
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "SELECT * FROM album WHERE title = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, Title);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                album.setTitle(Title);
                album.setArtistid(rs.getInt(3));
                album.setAlbumid(rs.getInt(1));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return album;
    }

    @Override
    public ArrayList<Album> getAlbumsByArtistId(int artistid) {

        ArrayList<Album> albums = new ArrayList<Album>();
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "SELECT * FROM album WHERE artistid = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(3, artistid);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Album album = new Album();
                album.setAlbumid(rs.getInt(1));
                album.setTitle(rs.getString("title"));
                album.setArtistid(artistid);
                albums.add(album);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return albums;
    }

    @Override
    public ArrayList<Album> getAllAlbums() {
        ArrayList<Album> albums = new ArrayList<Album>();
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "SELECT * FROM album";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Album album = new Album();
                album.setAlbumid(rs.getInt(1));
                album.setTitle(rs.getString("title"));
                album.setArtistid(rs.getInt(3));
                albums.add(album);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return albums;
    }

    @Override
    public Album addAlbum(Album newAlbum) {
        Album album = new Album();
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            conn.setAutoCommit(false);
            String sql = "INSERT INTO album (title, artistid) VALUES (?)";
            String[] keys = new String [1];
            keys[0] = "artistid";
            PreparedStatement pstmt = conn.prepareStatement(sql, keys);
            pstmt.setString(1, newAlbum.getTitle());
            int rowsUpdated = pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();

            if (rowsUpdated != 0) {
                while (rs.next()) {
                    album.setArtistid(rs.getInt("artistid"));
                    album.setAlbumid(rs.getInt("albumid"));
                    album.setTitle(rs.getString("title"));

                }
                album.setTitle(newAlbum.getTitle());
                conn.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return album;

    }

    @Override
    public Album updateAlbum(Album updatedAlbum) {
        return null;
    }
}
