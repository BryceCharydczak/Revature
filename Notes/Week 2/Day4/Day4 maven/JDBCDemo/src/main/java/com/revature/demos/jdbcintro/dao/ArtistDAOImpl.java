package com.revature.demos.jdbcintro.dao;

import java.sql.Connection;
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
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return artists;
	}

	public Artist addArtist(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public Artist getArtistByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Artist> getArtistByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public Artist updateArtist(int id, String newName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
