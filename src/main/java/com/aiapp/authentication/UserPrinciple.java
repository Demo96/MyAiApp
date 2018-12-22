package com.aiapp.authentication;

import com.aiapp.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserPrinciple implements UserDetails {
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String userName;
	
	private String firstName;
	
	private String sureName;
	
	private String phoneNumber;
	
	private String city;
	
	private String address;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;



    public UserPrinciple(Integer id, String nickName, String firstName, String sureName, String phoneNumber,
			String city, String address, String password, Collection<? extends GrantedAuthority> authorities) {
		super();
		this.id = id;
		this.userName = nickName;
		this.firstName = firstName;
		this.sureName = sureName;
		this.phoneNumber = phoneNumber;
		this.city = city;
		this.address = address;
		this.password = password;
		this.authorities = authorities;
	}

	public static UserPrinciple build(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream().map(role ->
                new SimpleGrantedAuthority(role.getName().name())
        ).collect(Collectors.toList());

        return new UserPrinciple(
                user.getId(),
                user.getUserName(),
                user.getFirstName(),
                user.getSurename(),
                user.getPhoneNumber(),
                user.getCity(),
                user.getAddress(),
                user.getPassword(),
                authorities
        );
    }



    public Integer getId() {
		return id;
	}

    @Override
	public String getUsername() {
		return userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getSureName() {
		return sureName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getCity() {
		return city;
	}

	public String getAddress() {
		return address;
	}

	public String getPassword() {
		return password;
	}

	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        UserPrinciple user = (UserPrinciple) o;
        return Objects.equals(id, user.id);
    }
}