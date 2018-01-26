package com.kriskringle.application.security;

import java.util.Arrays;

import org.junit.Test;

import com.kriskringle.domain.Member;
import com.kriskringle.domain.Role;

public class TestUserDetails_Ignore {

	@Test
	public void test() {
		Member m = new Member();
		m.setId(1L);
		m.setName("Ash");
		m.setUsername("abscd232");
		m.setPassword("password");
		m.setRoles(Arrays.asList( new Role("ROLE_USER"), new Role("ROLE_ADMIN")));
		 CustomUserDetails det = new CustomUserDetails(m);
		 System.out.println(det.getAuthorities());
	}

}
