package com.revature.demos.jdbcintro.dao;

import java.util.ArrayList;
import java.util.List;

import com.revature.demos.jdbcintro.pojos.Artist;

public interface ArtistDAO {

	public ArrayList<Artist> getAllArtists();
	public Artist addArtist(String name);
	public Artist getArtistByID(int id);
	public ArrayList<Artist> getArtistByName(String name);
	public Artist updateArtist(int id, String newName);
	
}
/*
 * create sequence artist_seq
 * minvalue 1
 * maxvalue 9999999999
 * increment by 1
 * start with 276;
 */

*/