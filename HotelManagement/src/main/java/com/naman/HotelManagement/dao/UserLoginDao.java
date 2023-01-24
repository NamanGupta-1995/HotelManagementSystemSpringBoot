package com.naman.HotelManagement.dao;

import com.naman.HotelManagement.pojo.*;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

import com.naman.HotelManagement.dao.DAO;

public class UserLoginDao extends DAO {

	public UserLoginDao() {
		System.out.println("*** User Login DAO");
	}
	public void save(Users user) {
		begin();
		getSession().save(user);
		commit();
	}

	public void update(Users user) {
		begin();
		getSession().update(user);
		commit();
	}

	public void delete(Users user) {
		begin();
		getSession().delete(user);
		commit();
	}

	
	public Users getUserByEmail(String email) {
		Users userCredential = null;
		try{
			 begin();
			 Criteria crit = getSession().createCriteria(Users.class);
			 crit.add(Restrictions.eq("email", email));
			 crit.setMaxResults(1);
			 userCredential = (Users) crit.uniqueResult();
			 commit();
		} catch (Exception e) {
        	return null;
        }finally {
			close();
		}
		
		
            return userCredential;
        
	}
}
