package com.naman.HotelManagement.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="FeedBack")
public class FeedBack {

	@Id
	@GeneratedValue
	@Column(name="feedbackID")
	private int feedbackID;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="checkinDate")
	private Date checkinDate;
	
	@Column(name="lengthOfStay")
	private int lengthOfStay;
	
	@Column(name="roomNumber")
	private int roomNumber;
	
	@Column(name="managerAttended")
	private String managerAttended;
	
	@Column(name="reasonOfVisit")
	private String reasonOfVisit;
	
	@Column(name="rating")
	private int rating;
	
	@Column(name="feedback")
	private String feedback;

	public FeedBack() {
		super();
	}

	public FeedBack(int feedbackID, Date checkinDate, int lengthOfStay, int roomNumber, String managerAttended,
			String reasonOfVisit, int rating, String feedback) {
		super();
		this.feedbackID = feedbackID;
		this.checkinDate = checkinDate;
		this.lengthOfStay = lengthOfStay;
		this.roomNumber = roomNumber;
		this.managerAttended = managerAttended;
		this.reasonOfVisit = reasonOfVisit;
		this.rating = rating;
		this.feedback = feedback;
	}

	public int getFeedbackID() {
		return feedbackID;
	}

	public void setFeedbackID(int feedbackID) {
		this.feedbackID = feedbackID;
	}

	public Date getCheckinDate() {
		return checkinDate;
	}

	public void setCheckinDate(Date checkinDate) {
		this.checkinDate = checkinDate;
	}

	public int getLengthOfStay() {
		return lengthOfStay;
	}

	public void setLengthOfStay(int lengthOfStay) {
		this.lengthOfStay = lengthOfStay;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getManagerAttended() {
		return managerAttended;
	}

	public void setManagerAttended(String managerAttended) {
		this.managerAttended = managerAttended;
	}

	public String getReasonOfVisit() {
		return reasonOfVisit;
	}

	public void setReasonOfVisit(String reasonOfVisit) {
		this.reasonOfVisit = reasonOfVisit;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
	
}
