package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.revature.pojo.*;
import com.revature.util.HibernateUtil;

public class BearDaoImpl implements BearDao {

	public List<Bear> getBears() {
		Session s = HibernateUtil.getSession();
		Query q = s.createQuery("from Bear");
		List<Bear> bears = q.list();
		s.close();
		return bears;
	}

	public Bear getBearById(int id) {
		Session s = HibernateUtil.getSession();

		//using load to retrieve your data would be fine in this 
		//instance but only if you accessed the object before you closed the session
		//otherwise, you would get a LazyInitializationException
		
//		Bear b = (Bear) s.load(Bear.class, id); 
//		System.out.println(b);
		
		Bear b = (Bear) s.get(Bear.class, id);
		s.close();
		return b;
	}

	public int addBear(Bear b) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int result = (Integer) s.save(b);
		tx.commit();
		s.close();
		return result;
	}

	public void updateBear(Bear b) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
			s.merge(b);
		tx.commit();
		s.close();
	}

	public void deleteBear(Bear b) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
			s.delete(b);
		tx.commit();
		s.close();
	}

	public List<Bear> findByType(String type) {
		Session s = HibernateUtil.getSession();
		String hql = "from Bear where BEAR_TYPE_ID = "
				+ "(select bearTypeId from BearType where name =:nameParam)";
		Query q = s.createQuery(hql);
		q.setParameter("nameParam", type);
		List bears = q.list();
		s.close(); 
		return bears;
	}

	public List<Bear> findByTypeCrit(String type) {
		Session s = HibernateUtil.getSession();
		Criteria c = s.createCriteria(Bear.class);
		c.createAlias("bearType", "type");
		c.add(Restrictions.ilike("type.name", type));
		List<Bear> bears = c.list();
		s.close();
		return bears;
	}

	public List<Bear> findBearSizeRange(int lowerLim, int upperLim) {
		Session s = HibernateUtil.getSession();
		Criteria c = s.createCriteria(Bear.class);
		c.add(Restrictions.between("bearWeight", lowerLim, upperLim));
		List<Bear> bears = c.list();
		s.close();
		return bears;
	}
	
	public List<Bear> findByTypeAndCave(String type, String cave) {
		Session s = HibernateUtil.getSession();
		Criteria c = s.createCriteria(Bear.class);
		c.createAlias("bearType", "type");
		c.createAlias("cave", "c");
		c.add(Restrictions.ilike("type.name", type));
		c.add(Restrictions.ilike("c.name", cave));
		List<Bear> bears = c.list();
		s.close();
		return bears;
	}

	public List<Bear> findJBear() {
		Session s = HibernateUtil.getSession();
		Criteria c = s.createCriteria(Bear.class);
		c.add(Restrictions.like("name", "J%"));
		c.addOrder(Order.desc("name"));
		List<Bear> bears = c.list();
		s.close();
		return bears;
	}
	
	public void printNumOfRows() {
		Session s = HibernateUtil.getSession();
		Criteria c = s.createCriteria(Bear.class);
		c.setProjection(Projections.rowCount());
		List rows = c.list();
		System.out.println(rows.get(0));
		s.close();
	}
	
	
	public List<Bear> executeNamedQuery(Cave cave){
		Session s = HibernateUtil.getSession();
		Cave c = (Cave) s.get(Cave.class, 4);
		Query q = s.getNamedQuery("findBearByCave");
		q.setInteger("caveIdVar", c.getId());
		List<Bear> bears = q.list();
		s.close();
		return bears;
	}
	
	
	
}