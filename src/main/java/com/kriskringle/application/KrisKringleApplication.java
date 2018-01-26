package com.kriskringle.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import com.kriskringle.application.security.CustomMemberDetailsService;
import com.kriskringle.domain.Member;

@SpringBootApplication
@EnableJpaRepositories(basePackages= {"com.kriskringle.repository"})
@ComponentScan(basePackages={"com.kriskringle"})
@EntityScan("com.kriskringle.domain")
public class KrisKringleApplication {

	public static void main(String[] args) {
		SpringApplication.run(KrisKringleApplication.class, args);
	}
	
	@Autowired
    public void configure(AuthenticationManagerBuilder auth, CustomMemberDetailsService service) throws Exception {
        auth.userDetailsService(service);
    }
	
}
