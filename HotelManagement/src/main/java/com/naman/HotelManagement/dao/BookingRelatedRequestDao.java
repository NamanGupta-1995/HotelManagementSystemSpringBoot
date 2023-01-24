package com.naman.HotelManagement.dao;

import java.util.ArrayList;
import java.util.List;

import com.naman.HotelManagement.pojo.Booking;
import com.naman.HotelManagement.pojo.BookingRequest;

public class BookingRelatedRequestDao extends DAO{

	
	public List<BookingRequest> getAllActiveRequests(String x) {
		
		List<Object> activeBookingRequestObject = getSession().createSQLQuery("select * from BookingRequest where roomNumber IN (" +x +")").addEntity(BookingRequest.class).list();
		List<BookingRequest> activeBookingRequestList = new ArrayList<BookingRequest>(activeBookingRequestObject.size());
		for (Object object : activeBookingRequestObject) {
			activeBookingRequestList.add((BookingRequest) object);
		}
		return activeBookingRequestList;
	}
	
}
