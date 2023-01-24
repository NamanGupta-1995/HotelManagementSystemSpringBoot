package com.naman.HotelManagement.controller;

import java.io.File;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.naman.HotelManagement.dao.*;
import com.naman.HotelManagement.pojo.*;
import com.naman.HotelManagement.service.EncryptionConfig;

@Controller
public class ReceptionistPortalController {

	@Autowired
	private JavaMailSender mailSender;

	@RequestMapping(value = "receptionist.htm", method = RequestMethod.GET)
	public ModelAndView loginReceptionist(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		if (session.getAttribute("user") != null && session.getAttribute("user").equals("Receptionist")) {
			return new ModelAndView("receptionist-landing-view");
		} else {
			return new ModelAndView("login-view");
		}
	}

	@RequestMapping(value = "receptionistRequest.htm", method = RequestMethod.GET)
	public ModelAndView loginDisplay(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		if (session.getAttribute("user") != null && session.getAttribute("user").equals("Receptionist")) {
			String taskChoosen = request.getParameter("taskDD");
			if (taskChoosen.equals("New Booking")) {
				return new ModelAndView("add-new-booking-view");
			} else if (taskChoosen.equals("Raise Request")) {

				return new ModelAndView("raise-new-request");
			} else if (taskChoosen.equals("Checkout")) {
				return new ModelAndView("checkout-customer-view");
			}
			return new ModelAndView("error");
		} else {
			return new ModelAndView("login-view");
		}
	}

	@RequestMapping(value = "addReceptionist.htm", method = RequestMethod.POST)
	public ModelAndView addReceptionist(EncryptionConfig config, UserLoginDao userdao, AdminPortalDao admindao, Users user,
			HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		if (session.getAttribute("user") != null && session.getAttribute("user").equals("Admin")) {
			if (user != null) {

				user.setName(request.getParameter("newReceptionistName"));
				user.setContact(Long.parseLong(request.getParameter("newReceptionistContact")));
				String email = request.getParameter("newReceptionistEmail");
				user.setEmail(email);
				
				String enteredPass = request.getParameter("newReceptionistPassword");
				String encryptedPass = config.encryptPassword(enteredPass);
				user.setPassword(encryptedPass);
				String role = "Receptionist";
				user.setRole(role);
				Users userFound = userdao.getUserByEmail(email);
				if (userFound == null) {
					admindao.save(user);
					admindao.close();
				} else {
					return new ModelAndView("error");
				}
				List<Users> receptionistList = admindao.getAllReceptionists();
				session.setAttribute("receptionistList", receptionistList);
				return new ModelAndView("admin-landing-view");

			}
			return new ModelAndView("error");
		} else {
			return new ModelAndView("login-view");

		}

	}

	@RequestMapping(value = "addRequest.htm", method = RequestMethod.POST)
	public ModelAndView addRequest(BookingRelatedRequestDao requestdao, CustomerDao customerdao, BookingDao bookingDao, Booking booking, Customer customer,
			HttpServletRequest request, BookingRequest bookingRequest) {
		try {
			HttpSession session = request.getSession(true);
			if (session.getAttribute("user") != null && session.getAttribute("user").equals("Receptionist")) {
				int roomNumber = Integer.parseInt(request.getParameter("category"));
				Booking existingBooking = bookingDao.getBookingByRoom(roomNumber);

				if (existingBooking != null && roomNumber == existingBooking.getRoomNumber()) {
					String requestType = request.getParameter("requestDD");
					String requestedTime = request.getParameter("requestTime");
					// request.getParameter("requestTime"), DateTimeFormatter.ofPattern("HH:mm")

					bookingRequest.setRequestType(requestType);
					bookingRequest.setRequestTime(requestedTime);
					bookingRequest.setRoomNumber(roomNumber);

					existingBooking.setBookingRequest(bookingRequest);

					bookingDao.updateBookingRequest(existingBooking);
					
					List<Integer> roomsOfCurrentBooking = new ArrayList<Integer>();
					List<Booking> currentBookings = bookingDao.getAllActiveBookings();
					for (int i = 0; i < currentBookings.size(); i++) {
						roomsOfCurrentBooking.add(currentBookings.get(i).getRoomNumber());
					}

					String x = roomsOfCurrentBooking.toString();
					
					if (x.length() > 2) {
						x = x.substring(1, x.length() - 1);
					}
					List<BookingRequest> activeRequest = requestdao.getAllActiveRequests(x);

					session.setAttribute("openRequests", activeRequest);
				}

				return new ModelAndView("raise-new-request");
			} else {
				return new ModelAndView("login-view");
			}

		} catch (Exception ex) {
			throw (ex);
		}

	}

	@RequestMapping(value = "addBooking.htm", method = RequestMethod.POST)
	public ModelAndView addBooking(@RequestParam("imageFile") MultipartFile imageFile, CustomerDao customerdao, BookingDao bookingDao, Booking booking, Customer customer,
			HttpServletRequest request) throws Exception {
		try {
			HttpSession session = request.getSession(true);
			if (session.getAttribute("user") != null && session.getAttribute("user").equals("Receptionist")) {
				
				//String idPath = request.getParameter("imagefile");
				
				
				String customerFirstName = request.getParameter("customerFirstName");
				String customerLastName = request.getParameter("customerLastName");
				String customerEmail = request.getParameter("customerEmail");
				String customerContact = request.getParameter("customerContact");
				String customerAddress = request.getParameter("customerAddress");
				String customerGender = request.getParameter("customerGender");
				int roomNumber = Integer.parseInt(request.getParameter("roomNumber"));
				String checkinDate = request.getParameter("checkinDate");
				String checkoutDate = request.getParameter("checkoutDate");

				customer.setFirstName(customerFirstName);
				customer.setLastName(customerLastName);
				customer.setEmailAddress(customerEmail);
				customer.setContact(customerContact);
				customer.setAddress(customerAddress);
				customer.setGender(customerGender);				
				String fileName = "img_" + System.currentTimeMillis();
				imageFile.transferTo(new File("/Users/namangupta/Downloads/HotelManagement/src/main/webapp/CUSTOMERID/" + fileName));
				customer.setIdproof(fileName);


				Customer existingCustomer = customerdao.getCustomerByEmail(customerEmail);

				booking.setCheckinDate(Date.valueOf(checkinDate));
				booking.setCheckoutDate(Date.valueOf(checkoutDate));
				booking.setRoomNumber(roomNumber);
				booking.setTotalBill(0);
				
				if (existingCustomer != null) {
					existingCustomer.setBookingID(booking);
					bookingDao.updateCustomerBooking(existingCustomer);
					;
				} else {
					customer.setBookingID(booking);
					bookingDao.save(customer);
				}
				List<Booking> currentBookings = bookingDao.getAllActiveBookings();
				session.setAttribute("currentBookings", currentBookings);
				String from = "dummy.211995@gmail.com";
				String to = customerEmail;

				SimpleMailMessage message = new SimpleMailMessage();

				message.setFrom(from);
				message.setTo(to);
				message.setSubject("Thank you for choosing us.");
				message.setText("Your stay is confirmed with us on " + checkinDate);

				mailSender.send(message);
			} else {
				return new ModelAndView("login-view");
			}

			return new ModelAndView("add-new-booking-view");
		} catch (Exception ex) {
			throw (ex);
		}

	}

	@RequestMapping(value = "checkout.htm", method = RequestMethod.POST)
	public String checkoutCustomer(CustomerDao customerdao, BookingDao bookingDao, Booking booking, Customer customer,
			HttpServletRequest request, BookingRequest bookingRequest) {
		try {
			HttpSession session = request.getSession(true);
			if (session.getAttribute("user") != null && session.getAttribute("user").equals("Receptionist")) {
				int roomNumber = Integer.parseInt(request.getParameter("roomNumber"));
				Date checkoutOn = Date.valueOf(request.getParameter("checkoutOn"));

				int totalBill = Integer.parseInt(request.getParameter("totalBill"));

				bookingDao.checkoutCustomer(roomNumber, checkoutOn, totalBill);
				List<Booking> currentBookings = bookingDao.getAllActiveBookings();
				session.setAttribute("currentBookings", currentBookings);

				return "redirect:/receptionist.htm";
			} else {
				return "login.htm";
			}

		} catch (Exception ex) {
			throw (ex);
		}

	}

}
