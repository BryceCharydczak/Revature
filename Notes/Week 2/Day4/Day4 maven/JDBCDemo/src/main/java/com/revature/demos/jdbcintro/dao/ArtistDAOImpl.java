package com.revature.demos.jdbcintro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.demos.jdbcintro.pojos.Artist;
import com.revature.demos.jdbcintro.util.ConnectionFactory;

public class ArtistDAOImpl implements ArtistDAO{

	
	public ArrayList<Artist> getAllArtists() {
		ArrayList<Artist> artists = new ArrayList<Artist>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql = "SELECT * FROM ARTIST";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				Artist temp = new Artist();
				temp.setArtistID(rs.getInt(1));
				temp.setName(rs.getString(2));
				artists.add(temp);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return artists;
	}

	public Artist addArtist(Artist newArtist) {
		Artist artist = new Artist();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "INSERT INTO artist (name) VALUES (?)";
			String[] keys = new String [1];
			keys[0] = "artistid";
			PreparedStatement pstmt = conn.prepareStatement(sql, keys);
			pstmt.setString(1, newArtist.getName());
			int rowsUpdated = pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			
			if (rowsUpdated != 0) {
				while (rs.next()) {
					artist.setArtistID(rs.getInt(1));
				}
				artist.setName(newArtist.getName());
				conn.commit();
			}
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return artist;
	
	}

	public Artist getArtistByID(int id) {
		Artist art = new Artist();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT * FROM artist WHERE artistid = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				art.setArtistID(id);
				art.setName(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return art;
	}

	public ArrayList<Artist> getArtistByName(String name) {
		
		ArrayList<Artist> artists = new ArrayList<Artist>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT * FROM artist WHERE name = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Artist artist = new Artist();
				artist.setArtistID(rs.getInt(1));
				artist.setName(rs.getString("name"));
				artists.add(artist);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return artists;
	}

	public boolean updateArtist(Artist updatedArtist) {
		boolean bool;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "UPDATE artist SET name = ? WHERE artistid = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  updatedArtist.getName());
			pstmt.setInt(2,  updatedArtist.getArtistID());
			
			int rowsUpdated = pstmt.executeUpdate();
			
			if (rowsUpdated != 0) {
				conn.commit();
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
		
	}
	@Override
	public boolean removeArtistByID(Artist artist) {

		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "DELETE FROM artist WHERE artistid = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,  artist.getArtistID());
			
			int rowsUpdated = pstmt.executeUpdate();
			
			if (rowsUpdated != 0) {
				conn.commit();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean removeArtistByName(Artist artist) {

		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "DELETE FROM artist WHERE name = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  artist.getName());
			
			int rowsUpdated = pstmt.executeUpdate();
			
			if (rowsUpdated != 0) {
				conn.commit();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean removeArtistsById(ArrayList<Artist> artists) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			int totalRowsRemoved = 0;
			String sql = "DELETE FROM artist WHERE artistid = ?";
			for (Artist art: artists) {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, art.getArtistID());
				
				int rowsUpdated = pstmt.executeUpdate();
				if (rowsUpdated != 0) {
					totalRowsRemoved++;
					continue;
					
				} else {
					break;
				}
			} if (totalRowsRemoved == artists.size()) {
				conn.commit();
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


	
	

}
