package com.naman.HotelManagement.pojo;


import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "BookingRequest")
public class BookingRequest {

		@Id
		@GeneratedValue
		@Column(name = "requestID")
		private int requestID;

		@Column(name = "roomNumber")
		private int roomNumber;

		@Column(name = "requestType")
		private String requestType;

		@Column(name = "requestTime")
		private String requestTime;

		public BookingRequest() {
			super();
		}

		public BookingRequest(int requestID, int roomNumber, String requestType, String requestTime) {
			super();
			this.requestID = requestID;
			this.roomNumber = roomNumber;
			this.requestType = requestType;
			this.requestTime = requestTime;
		}

		public int getRequestID() {
			return requestID;
		}

		public void setRequestID(int requestID) {
			this.requestID = requestID;
		}

		public int getRoomNumber() {
			return roomNumber;
		}

		public void setRoomNumber(int roomNumber) {
			this.roomNumber = roomNumber;
		}

		public String getRequestType() {
			return requestType;
		}

		public void setRequestType(String requestType) {
			this.requestType = requestType;
		}

		public String getRequestTime() {
			return requestTime;
		}

		public void setRequestTime(String requestTime) {
			this.requestTime = requestTime;
		}
		
	
}