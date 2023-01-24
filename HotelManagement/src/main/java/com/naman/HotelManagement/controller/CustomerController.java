package com.naman.HotelManagement.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.naman.HotelManagement.dao.CustomerDao;
import com.naman.HotelManagement.pojo.Booking;
import com.naman.HotelManagement.pojo.Customer;
import com.naman.HotelManagement.pojo.FeedBack;
import com.naman.HotelManagement.service.EncryptionConfig;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
	
	@RequestMapping(value = "customer.htm", method = RequestMethod.GET)
	public ModelAndView loginDisplay(HttpServletRequest request, CustomerDao customerdao) {
		HttpSession session = request.getSession(true);

		if(session.getAttribute("customer") != null) {
		Customer customerRecord = (Customer) session.getAttribute("customerDetails");
		List<Booking> bookingsDoneByCustomer = customerRecord.getBookings();
		
		session.setAttribute("currentBookings", bookingsDoneByCustomer);
		return new ModelAndView("customer-landing-view");
		}
		else {
			return new ModelAndView("login-view");
		}
	}
	@RequestMapping(value = "feedback.htm", method = RequestMethod.POST)
	public ModelAndView feedbackDisplay(HttpServletRequest request, CustomerDao customerdao) {
		return new ModelAndView("customer-feedback-view");
	}
	
	@RequestMapping(value = "feedbackSubmit.htm", method = RequestMethod.POST)
	public String submitFeedback(HttpServletRequest request, CustomerDao customerdao, FeedBack feedback) {
		
		HttpSession session = request.getSession(true);

		if(session.getAttribute("customer") != null) {
			
		feedback.setCheckinDate(Date.valueOf(request.getParameter("checkindate")));
		feedback.setLengthOfStay(Integer.parseInt(request.getParameter("days")));
		feedback.setRoomNumber(Integer.parseInt(request.getParameter("room")));
		feedback.setManagerAttended(request.getParameter("manager"));
		feedback.setReasonOfVisit(request.getParameter("reason"));
		feedback.setRating(Integer.parseInt(request.getParameter("rating")));
		feedback.setFeedback(request.getParameter("feedback"));
		
		customerdao.saveCusttomerFeedback(feedback);
		return "redirect:/customer.htm";
		}
		else {
			return "login.htm";
		}
	}
	
	@RequestMapping(value = "register.htm", method = RequestMethod.POST)
	public String customerRegister(EncryptionConfig config,HttpServletRequest request, CustomerDao customerdao) {
			
			String custEmail = request.getParameter("customerEmail");
			String custPass = request.getParameter("customerPassword");
			String encryptedPass = config.encryptPassword(custPass);
			Customer cust = customerdao.getCustomerByEmail(custEmail);
			
			if(cust != null && cust.getPassword() == null) {
				customerdao.registerPassword(custEmail, encryptedPass);
				
			}
			return "redirect:/login.htm";

	}
	
	@RequestMapping(value = "update.htm", method = RequestMethod.POST)
	public String updatePassword(EncryptionConfig config,HttpServletRequest request, CustomerDao customerdao) {
			
			String custEmail = request.getParameter("customerEmail");
			String custPass = request.getParameter("customerPassword");
			String encryptedPass = config.encryptPassword(custPass);
			Customer cust = customerdao.getCustomerByEmail(custEmail);
			
			if(cust != null && cust.getPassword() == null) {
				customerdao.registerPassword(custEmail, encryptedPass);
				
			}
			return "redirect:/login.htm";

	}
	
	
}
