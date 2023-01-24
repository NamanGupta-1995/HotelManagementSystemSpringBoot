package com.naman.HotelManagement.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.naman.HotelManagement.pojo.*;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class BookingDao extends DAO {

	public BookingDao() {
		System.out.println("*** Booking DAO");
	}

	public void save(Customer customer) {
		begin();
		getSession().save(customer);
		commit();
	}

	public void updateCustomerBooking(Customer customer) {
		begin();
		getSession().saveOrUpdate(customer);
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

	public List<Booking> getAllActiveBookings() {

		List<Object> activeBookinglistobject = getSession().createSQLQuery("select * from Booking where checkoutDate >= Now()").addEntity(Booking.class).list();
		List<Booking> activeBookingList = new ArrayList<Booking>(activeBookinglistobject.size());
		for (Object object : activeBookinglistobject) {
			activeBookingList.add((Booking) object);
		}
		for (int i = 0; i < activeBookingList.size(); i++) {
			System.out.println(activeBookingList.get(i).getBookingID());
		}
		return activeBookingList;
	}

	public Booking getBookingByRoom(int roomNumber) {
		Booking userBooking = null;
		try{
			 begin();
			 Criteria crit = getSession().createCriteria(Booking.class);
			 crit.add(Restrictions.eq("roomNumber", roomNumber));
			 crit.setMaxResults(1);
			 userBooking = (Booking) crit.uniqueResult();
			 commit();
		} catch (Exception e) {
        	return null;
        }finally {
			close();
		}

        return userBooking;	
	}
	
	public void updateBookingRequest(Booking booking) {
		begin();
		getSession().saveOrUpdate(booking);
		commit();
	}
	
	public void checkoutCustomer(int roomNumber, Date checkoutDate, int totalAmount) {
		begin();
		String s = "UPDATE Booking SET totalBill = " +totalAmount +", checkoutDate = '"+ checkoutDate +"' where checkoutDate >= Now() AND roomNumber = "+ roomNumber;
		getSession().createSQLQuery(s).executeUpdate();
		commit();
	}
	
	

}
