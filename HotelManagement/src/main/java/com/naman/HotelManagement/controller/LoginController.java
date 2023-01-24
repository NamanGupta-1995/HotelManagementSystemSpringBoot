package com.naman.HotelManagement.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.naman.HotelManagement.dao.BookingDao;
import com.naman.HotelManagement.dao.BookingRelatedRequestDao;
import com.naman.HotelManagement.dao.CustomerDao;
import com.naman.HotelManagement.dao.UserLoginDao;
import com.naman.HotelManagement.pojo.Users;
import com.naman.HotelManagement.service.EncryptionConfig;
import com.naman.HotelManagement.pojo.Booking;
import com.naman.HotelManagement.pojo.BookingRequest;
import com.naman.HotelManagement.pojo.Customer;
import com.naman.HotelManagement.pojo.FeedBack;

@Controller
public class LoginController {

	@RequestMapping(value = "login.htm", method = RequestMethod.GET)
	public ModelAndView loginDisplay() {

		return new ModelAndView("login-view");
	}
	
	@RequestMapping(value = "register.htm", method = RequestMethod.GET)
	public ModelAndView registerDisplay() {

		return new ModelAndView("register-customer-view");
	}
	
	@RequestMapping(value = "logout.htm", method = RequestMethod.GET)
	public ModelAndView logoutUser(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		session.removeAttribute("user");
		session.removeAttribute("customer");
		
		return new ModelAndView("login-view");
	}

	@RequestMapping(value = "login.htm", method = RequestMethod.POST)
	public String authenticateUser(EncryptionConfig config, UserLoginDao userdao, BookingRelatedRequestDao requestdao, BookingDao bookingdao,
			HttpServletRequest request, CustomerDao customerdao) {
		
		String roleOfChoice = request.getParameter("inputRole");
		String email = request.getParameter("email");
		String passwordEntered = request.getParameter("password");
		
		HttpSession session = request.getSession(true);
		
		Users userFound = userdao.getUserByEmail(email);
		Customer customer = customerdao.getCustomerByEmail(email);
		String decryptedPass = "";
		if(userFound != null) {
			String encryptedPass = userFound.getPassword();
			decryptedPass= config.decyptPwd(encryptedPass);
		}
		String custEnteredDecryptedPass= "";
		if(customer != null) {
			String custEnteredEncryptedPass = customer.getPassword();
			custEnteredDecryptedPass = config.decyptPwd(custEnteredEncryptedPass);
		}
		
		List<Booking> currentBookings = bookingdao.getAllActiveBookings();
		List<FeedBack> feedbacks = customerdao.getAllFeedbacks();
		List<Integer> roomsOfCurrentBooking = new ArrayList<Integer>();
		
		session.setAttribute("currentBookings", currentBookings);
		
		for (int i = 0; i < currentBookings.size(); i++) {
			roomsOfCurrentBooking.add(currentBookings.get(i).getRoomNumber());
		}

		String x = roomsOfCurrentBooking.toString();
		
		if (x.length() > 2) {
			x = x.substring(1, x.length() - 1);
		}
		
		if(currentBookings.size()>0) {
		List<BookingRequest> activeRequest = requestdao.getAllActiveRequests(x);

		session.setAttribute("openRequests", activeRequest);
		}
		if(customer != null) {
			session.setAttribute("customer", customer);
			
		}
		if(userFound != null) {
			session.setAttribute("user", userFound.getRole());
		}
		
		if (customer != null && passwordEntered.equals(custEnteredDecryptedPass) && roleOfChoice.equals("Customer")) {

			session.setAttribute("customerDetails", customer);
			return "redirect:/customer.htm";
		}

		else if (userFound != null) {
			if (userFound.getRole().equals("Admin") && passwordEntered.equals(decryptedPass) && roleOfChoice.equals("Admin")) {
				return "redirect:/admin.htm";
			} else if (userFound.getRole().equals("Receptionist") && passwordEntered.equals(decryptedPass) && roleOfChoice.equals("Receptionist")) {
				return "redirect:/receptionist.htm";
			} else if (userFound.getRole().equals("Manager") && passwordEntered.equals(decryptedPass) && roleOfChoice.equals("Manager")) {
				session.setAttribute("feedbacks", feedbacks);
				return "redirect:/manager.htm";
			}
		}
		return "redirect:/login.htm";

	}

	@RequestMapping(value = "error.htm", method = RequestMethod.GET)
	public ModelAndView error() {
		return new ModelAndView("error");
	}
	
	@RequestMapping(value = "updateCust.htm", method = RequestMethod.POST)
	public ModelAndView update() {
		return new ModelAndView("updateProfile");
	}
	
	@RequestMapping(value = "updatePassword.htm", method = RequestMethod.POST)
	public ModelAndView updatePassword(CustomerDao customerdao, EncryptionConfig config, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		
		String email = request.getParameter("enteredEmailCust");
		String updatedPass = request.getParameter("updatedPass");
		
		String encryptedUpdatedPass = config.encryptPassword(updatedPass);
		
		customerdao.registerPassword(email, encryptedUpdatedPass);
		
		session.removeAttribute("user");
		session.removeAttribute("customer");
		
		return new ModelAndView("customer-landing-view");
	}

}
