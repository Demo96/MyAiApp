package com.aiapp.user;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.aiapp.advertisment.Advertisment;
import com.aiapp.chat.ChatMessage;
import com.aiapp.role.Role;


@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank
	@Size(min = 3, max = 30)
	@Column(unique=true)
	private String userName;
	@NotBlank
	@Size(min = 6)
	private String password;
	@NotBlank
	@Size(min = 3, max = 30)
	private String firstName;
	@NotBlank
	@Size(min = 3, max = 30)
	private String sureName;
	@NotBlank
	@Size(min = 9, max = 12)
	private String phoneNumber;
	@NotBlank
	@Size(min = 3, max = 50)
	private String city;
	@NotBlank
	@Size(min = 3, max = 50)
	private String address;
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	@ManyToMany
	private Set<Role> roles = new HashSet<>();
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Advertisment> advertisments = new ArrayList<>();
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<ChatMessage> chatMessages = new ArrayList<>();
	
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public User() {
	};

	public User(String userName, String password, String firstName, String sureName, String phoneNumber, String city,
			String address) {
		super();
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.sureName = sureName;
		this.phoneNumber = phoneNumber;
		this.city = city;
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String name) {
		this.firstName = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String number) {
		this.phoneNumber = number;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String nickName) {
		this.userName = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSureName() {
		return sureName;
	}

	public void setSureName(String sureName) {
		this.sureName = sureName;
	}

	public List<Advertisment> getAdvertisments() {
		return advertisments;
	}

	public void setAdvertisments(List<Advertisment> advertisments) {
		this.advertisments = advertisments;
	}

	public List<ChatMessage> getMessages() {
		return chatMessages;
	}

	public void setMessages(List<ChatMessage> messages) {
		this.chatMessages = messages;
	}
}
