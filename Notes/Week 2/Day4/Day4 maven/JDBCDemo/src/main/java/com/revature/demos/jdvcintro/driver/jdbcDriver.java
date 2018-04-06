package com.revature.demos.jdvcintro.driver;

import java.util.ArrayList;

import com.revature.demos.jdbcintro.dao.ArtistDAO;
import com.revature.demos.jdbcintro.dao.ArtistDAOImpl;
import com.revature.demos.jdbcintro.pojos.Artist;

public class jdbcDriver {
	public static void main(String[] args) {
		ArtistDAO artistDao = new ArtistDAOImpl();
		ArrayList<Artist> artists = artistDao.getAllArtists();
		
		for(Artist artist : artists) {
			System.out.println(artist);
			System.out.println();
		}
		System.out.println("end");
}
}
