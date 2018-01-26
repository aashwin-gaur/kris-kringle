package com.kriskringle.application.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.kriskringle.domain.Member;

public class CustomUserDetails implements UserDetails {

	private static final long serialVersionUID = -8464367169669461944L;
	private String username;
	private String password;

	private Collection<? extends GrantedAuthority> auths;

	public CustomUserDetails(Member user) {
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.auths = user.getRoles().stream().map(t -> new SimpleGrantedAuthority(t.getName().toUpperCase()))
				.collect(Collectors.toList());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return auths;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
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