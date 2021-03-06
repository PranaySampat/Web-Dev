package com.me.finalproject.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="user")
@PrimaryKeyJoinColumn(name="personID")

public class User extends Person{
	@Column(name="username",unique=true)
	private String username;
	@Column(name="password",nullable=false)
	private String password;
	@Column(name="catcode",nullable=false)
	private String category;
	@Column(name="status")
	private String status;
	@OneToMany
	private Set<Order> orders = new HashSet<Order>();
		public User(){
	}
	public User(String username, String password, String category, String status) {
		this.username = username;
		this.password = password;
		this.category = category;
		this.status = status;
		
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
		
}
