package com.revature.dao;

import com.revature.dao.*;
import com.revature.pojo.*;
import com.revature.util.*;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.pojo.Bear;
import oracle.net.aso.s;
public class Driver {
	public static void main(String [] args) {
//		Session s = HibernateUtil.getSession();
//		Transaction tx = s.beginTransaction();
//		Cave c = (Cave) s.get(Cave.class, 4);
//		BearType bt = (BearType) s.get(BearType.class, 4);
//		tx.commit();
//		s.close();
//		
//		Bear b = new Bear("JSmokey",623,bt,c);
//		//s.save(b);
//		BearDaoImpl bdi = new BearDaoImpl();
//		bdi.addBear(b);
		
		BearDaoImpl bdi = new BearDaoImpl();
		//System.out.println(bdi.getBears());
		//System.out.println(bdi.findByTypeCrit("Grizzly"));
		
		//System.out.println(bdi.findBearSizeRange(550, 800));
		//System.out.println(bdi.findBearSizeRange(55, 8000));
		
		//System.out.println(bdi.findByTypeAndCave("Grizzly","Florida"));
		
		//System.out.println(bdi.findJBear());

		//bdi.printNumOfRows();
		
		//getting our cave 
		Session s = HibernateUtil.getSession();
		Cave cave = (Cave) s.get(Cave.class, 4);
		s.close();
		
		bdi.executeNamedQuery(cave).forEach(bear -> {
			System.out.println(((Bear) bear).getCave().getName());
		});
	}

}
