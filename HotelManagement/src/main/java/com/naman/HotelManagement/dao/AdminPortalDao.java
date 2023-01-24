package com.naman.HotelManagement.dao;

import com.naman.HotelManagement.pojo.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.naman.HotelManagement.dao.*;

public class AdminPortalDao extends DAO {

	public AdminPortalDao() {
		System.out.println("*** Admin Portal DAO");
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

	public List<Users> getAllAdmins() {
		
		List<Object> adminlistobject = getSession().createSQLQuery("select * from Users where role = 'Admin'").addEntity(Users.class).list();
		List<Users> adminlist = new ArrayList<Users>(adminlistobject.size());
		for (Object object : adminlistobject) {
			adminlist.add((Users) object);
		}
		return adminlist;
	}
	
	public List<Users> getAllReceptionists() {
		
		List<Object> adminlistobject = getSession().createSQLQuery("select * from Users where role = 'Receptionist'").addEntity(Users.class).list();
		List<Users> adminlist = new ArrayList<Users>(adminlistobject.size());
		for (Object object : adminlistobject) {
			adminlist.add((Users) object);
		}
		return adminlist;
	}
	
	
	public List<Users> getAllManagers() {
		
		List<Object> adminlistobject = getSession().createSQLQuery("select * from Users where role = 'Manager'").addEntity(Users.class).list();
		List<Users> adminlist = new ArrayList<Users>(adminlistobject.size());
		for (Object object : adminlistobject) {
			adminlist.add((Users) object);
		}
		return adminlist;
	}
}
