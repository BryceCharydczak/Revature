package com.revature.dao;

import java.util.List;

import com.revature.pojo.Bear;

public class BearDaoImpl implements BearDao {
	
	public List<Bear> getBears();
	public Bear getBearById(int id);
	public int addBear(Bear b);
	public void updateBear(Bear b);
	public void deleteBear(Bear b);
	

}
