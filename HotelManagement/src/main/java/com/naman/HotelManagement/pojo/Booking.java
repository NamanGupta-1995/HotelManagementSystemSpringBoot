package com.naman.HotelManagement.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="booking")
public class Booking {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int bookingID;
	
	@Column(name="roomNumber")
	private int roomNumber;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="checkinDate")
	private Date checkinDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="checkoutDate")
	private Date checkoutDate;
	
	@Column(name="totalBill")
	private int totalBill;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "booking_bookingID")
	private List<BookingRequest> requests = new ArrayList<>();

	public Booking() {
		super();
	}

	public Booking(int bookingID, int roomNumber, Date checkinDate, Date checkoutDate, int totalBill) {
		super();
		this.bookingID = bookingID;

		this.roomNumber = roomNumber;
		this.checkinDate = checkinDate;
		this.checkoutDate = checkoutDate;
		this.totalBill = totalBill;
	}
	
	public List<BookingRequest> getBookingRequest() {
		return requests;
	}

	public void setBookingRequest(BookingRequest requestID) {
		this.requests.add(requestID);
	}
	

	public int getBookingID() {
		return bookingID;
	}
	
	
	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckinDate() {
		return checkinDate;
	}

	public void setCheckinDate(Date checkinDate) {
		this.checkinDate = checkinDate;
	}

	public Date getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public int getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(int totalBill) {
		this.totalBill = totalBill;
	}
	
	
	
	
}
