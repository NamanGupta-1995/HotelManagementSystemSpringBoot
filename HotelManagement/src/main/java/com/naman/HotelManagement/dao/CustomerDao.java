package com.naman.HotelManagement.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.naman.HotelManagement.pojo.Booking;
import com.naman.HotelManagement.pojo.Customer;
import com.naman.HotelManagement.pojo.FeedBack;
import com.naman.HotelManagement.pojo.Users;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class CustomerDao extends DAO{
	
	public CustomerDao() {
		System.out.println("*** Customer DAO");
	}
	public void save(Customer customer) {
		begin();
		getSession().save(customer);
		commit();
	}

	public void update(Customer customer) {
		begin();
		getSession().update(customer);
		commit();
	}

	public void delete(Customer customer) {
		begin();
		getSession().delete(customer);
		commit();
	}
	
	public Customer getCustomerByEmail(String email) {
		Customer userCredential = null;
		try{
			 begin();
			 Criteria crit = getSession().createCriteria(Customer.class);
			 crit.add(Restrictions.eq("emailAddress", email));
			 crit.setMaxResults(1);
			 userCredential = (Customer) crit.uniqueResult();
			 commit();
		} catch (Exception e) {
        	return null;
        }finally {
			close();
		}
		
		
       return userCredential;
        
	}
	
	public void saveCusttomerFeedback(FeedBack feedback) {
		begin();
		getSession().save(feedback);
		commit();
	}
	
	public List<FeedBack> getAllFeedbacks() {

		List<Object> feedbackObjectAvailable = getSession().createSQLQuery("select * from FeedBack").addEntity(FeedBack.class).list();
		List<FeedBack> feedbackAvailable = new ArrayList<FeedBack>(feedbackObjectAvailable.size());
		for (Object object : feedbackObjectAvailable) {
			feedbackAvailable.add((FeedBack) object);
		}
		return feedbackAvailable;
	}
	
//	public void registerPassword(String email)) {
//		begin();
//		//String s = "UPDATE Booking SET totalBill = " +totalAmount +", checkoutDate = '"+ checkoutDate +"' where checkoutDate >= Now() AND roomNumber = "+ roomNumber;
//		//getSession().createSQLQuery(s).executeUpdate();
//		commit();
//	}
	
	public void registerPassword(String email, String password) {
		begin();
		String s = "UPDATE Customer SET password = '" +password +"' where emailAddress = '"+ email +"'";
		getSession().createSQLQuery(s).executeUpdate();
		commit();
	}
}
