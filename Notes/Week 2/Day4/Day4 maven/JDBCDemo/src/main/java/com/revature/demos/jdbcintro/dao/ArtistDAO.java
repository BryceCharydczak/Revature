package com.revature.demos.jdbcintro.dao;

import java.util.ArrayList;
import java.util.List;

import com.revature.demos.jdbcintro.pojos.Artist;

public interface ArtistDAO {

	public ArrayList<Artist> getAllArtists();
	public Artist addArtist(Artist newArtist);
	public Artist getArtistByID(int id);
	public ArrayList<Artist> getArtistByName(String name);
	public boolean updateArtist(Artist updatedArtist);
	public boolean removeArtistByID(Artist artist);
	public boolean removeArtistByName(Artist artist);
	public boolean removeArtistsById(ArrayList<Artist> artists);
	
	
	}

/*
 * create sequence artist_seq
 * minvalue 1
 * maxvalue 9999999999
 * increment by 1
 * start with 276;
 */

*/