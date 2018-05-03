package com.revature.dao;

import java.util.List;

import com.revature.pojo.Bear;

public interface BearDao {
	
	public List<Bear> getBears();
	public Bear getBearById(int id);
	public int addBear(Bear b);
	public void updateBear(Bear b);
	public void deleteBear(Bear b);
	
	public List<Bear> findByType(String type);
	public List<Bear> findByTypeCrit(String type);
	
	public List<Bear> findBearSizeRange(int lowerLim, int upperLim);
	
	public List<Bear> findJBear();

}