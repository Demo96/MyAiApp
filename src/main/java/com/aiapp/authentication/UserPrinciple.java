package com.aiapp.authentication;

import com.aiapp.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserPrinciple implements UserDetails {
	private static final long serialVersionUID = 1L;
	
	private String userName;


    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;



    public UserPrinciple(String nickName, String password, Collection<? extends GrantedAuthority> authorities) {
		super();
		this.userName = nickName;
		this.password = password;
		this.authorities = authorities;
	}

	public static UserPrinciple build(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream().map(role ->
                new SimpleGrantedAuthority(role.getName().name())
        ).collect(Collectors.toList());

        return new UserPrinciple(
                user.getUserName(),
                user.getPassword(),
                authorities
        );
    }




    @Override
	public String getUsername() {
		return userName;
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
}