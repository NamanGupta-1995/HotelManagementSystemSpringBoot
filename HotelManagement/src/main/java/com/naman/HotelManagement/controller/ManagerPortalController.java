package com.naman.HotelManagement.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.naman.HotelManagement.dao.AdminPortalDao;
import com.naman.HotelManagement.dao.UserLoginDao;
import com.naman.HotelManagement.pojo.Users;
import com.naman.HotelManagement.service.EncryptionConfig;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ManagerPortalController {

	@RequestMapping(value = "manager.htm", method = RequestMethod.GET)
	public ModelAndView loginDisplay(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		if (session.getAttribute("user") != null && session.getAttribute("user").equals("Manager")) {
			return new ModelAndView("manager-landing-view");
		} else {
			return new ModelAndView("login-view");
		}
	}

	@RequestMapping(value = "addManager.htm", method = RequestMethod.POST)
	public ModelAndView addAdmin(EncryptionConfig config, UserLoginDao userdao, AdminPortalDao admindao, Users user,
			HttpServletRequest request) {

		HttpSession session = request.getSession(true);
		if (session.getAttribute("user") != null && session.getAttribute("user").equals("Admin")) {
			if (user != null) {

				user.setName(request.getParameter("newManagerName"));
				user.setContact(Long.parseLong(request.getParameter("newManagerContact")));
				String email = request.getParameter("newManagerEmail");
				String enteredPassword = request.getParameter("newManagerPassword");
				String encryptedPass = config.encryptPassword(enteredPassword);
				user.setEmail(email);
				user.setPassword(encryptedPass);
				String role = "Manager";
				user.setRole(role);
				Users userFound = userdao.getUserByEmail(email);
				if (userFound == null) {
					admindao.save(user);
				} else {
					return new ModelAndView("error");
				}
				List<Users> managerLists = admindao.getAllManagers();
				session.setAttribute("managerLists", managerLists);
				return new ModelAndView("admin-landing-view");

			}
			return new ModelAndView("error");
		} else {
			return new ModelAndView("login-view");
		}

	}
}
