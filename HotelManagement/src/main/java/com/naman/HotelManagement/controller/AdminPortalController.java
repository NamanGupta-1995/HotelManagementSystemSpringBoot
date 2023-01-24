package com.naman.HotelManagement.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.naman.HotelManagement.dao.AdminPortalDao;
import com.naman.HotelManagement.dao.UserLoginDao;
import com.naman.HotelManagement.pojo.Users;
import com.naman.HotelManagement.service.EncryptionConfig;

@Controller
public class AdminPortalController {

	@RequestMapping(value = "admin.htm", method = RequestMethod.GET)
	public ModelAndView adminDisplay(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		if (session.getAttribute("user") != null && session.getAttribute("user").equals("Admin")) {
			return new ModelAndView("admin-landing-view");
		} else {
			return new ModelAndView("login-view");
		}

	}

	@RequestMapping(value = "adminportal.htm", method = RequestMethod.GET)
	public ModelAndView loginDisplay(AdminPortalDao admindao, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		if (session.getAttribute("user") != null && session.getAttribute("user").equals("Admin")) {
			String choice = request.getParameter("choice");
			if (choice.equals("Admin")) {

				List<Users> adminList = admindao.getAllAdmins();
				if (adminList != null) {
					session.setAttribute("adminList", adminList);
					return new ModelAndView("manage-admin");
				}

			} else if (choice.equals("Receptionist")) {
				List<Users> receptionistList = admindao.getAllReceptionists();
				if (receptionistList != null) {
					session.setAttribute("receptionistList", receptionistList);
					return new ModelAndView("manage-receptionist");
				}
			} else if (choice.equals("Manager")) {
				List<Users> managerLists = admindao.getAllManagers();
				if (managerLists != null) {
					session.setAttribute("managerLists", managerLists);
					return new ModelAndView("manage-manager");
				}
			} else if (choice.equals("View Customer")) {
				return new ModelAndView("login-view");
			}

			return new ModelAndView("error");
		} else {
			return new ModelAndView("login-view");
		}

	}

	@RequestMapping(value = "addAdmin.htm", method = RequestMethod.POST)
	public ModelAndView addAdmin(EncryptionConfig config, UserLoginDao userdao, AdminPortalDao admindao, Users user,
			HttpServletRequest request) {

		HttpSession session = request.getSession(true);
		if (session.getAttribute("user") != null && session.getAttribute("user").equals("Admin")) {
			if (user != null) {

				user.setName(request.getParameter("newAdminName"));
				user.setContact(Long.parseLong(request.getParameter("newAdminContact")));
				String email = request.getParameter("newAdminEmail");
				String password = request.getParameter("newAdminPassword");
				String encryptedPassword = config.encryptPassword(password);
				user.setEmail(email);
				user.setPassword(encryptedPassword);
				String role = "Admin";
				user.setRole(role);
				Users userFound = userdao.getUserByEmail(email);
				if (userFound == null) {
					admindao.save(user);
				} else {
					return new ModelAndView("error");
				}
				List<Users> adminList = admindao.getAllAdmins();
				session.setAttribute("adminList", adminList);
				return new ModelAndView("admin-landing-view");

			}

			return new ModelAndView("error");
		} else {
			return new ModelAndView("login-view");
			
		}

	}

	@RequestMapping(value = "back.htm", method = RequestMethod.GET)
	public ModelAndView loginDisplay() {

		return new ModelAndView("admin-landing-view");
	}

}
