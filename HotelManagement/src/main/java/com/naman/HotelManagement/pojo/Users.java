

package com.naman.HotelManagement.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Users")
public class Users {
	@Id
	@GeneratedValue
	@Column(name="userID")
	private int userID;
	
	@Column(name="name")
	private String name;
	
	@Column(name="contact")
	private long contact;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="role")
	private String role;

	public Users(int id, String name, long contact, String email, String password, String role) {
		this.userID = id;
		this.name = name;
		this.contact = contact;
		this.email = email;
		this.password = password;
		this.role = role;
	}
	
	public Users() {
		System.out.println("Users Constructor");
	}

	public int getId() {
		return userID;
	}

	public void setId(int id) {
		this.userID = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
