package com.revature.dao;

import com.revature.pojo.BearType;
import com.revature.util.HibernateUtil;

public class BearTypeDaoImpl implements BearTypeDao{

	public void deleteBearType(BearType x) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.delete(x);
		t.
	}

	public void updateBearType(BearType x) {
		// TODO Auto-generated method stub
		
	}

}
