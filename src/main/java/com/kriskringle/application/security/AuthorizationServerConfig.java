package com.kriskringle.application.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Value("${resource.id:spring-boot-application}")
	private String resourceId;
	@Value("${access_token.validity_period:3600}")
	int accessTokenValiditySeconds = 3600;
	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(this.authenticationManager);
	}

	@Override	
	public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
		oauthServer
			.checkTokenAccess("isAuthenticated()");
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
			.withClient("normal-app")
			.authorizedGrantTypes("authorization_code", "implicit").authorities("ROLE_CLIENT")
			.scopes("read", "write").resourceIds(resourceId)
			.accessTokenValiditySeconds(accessTokenValiditySeconds)
			.and()
			.withClient("trusted-app")
			.authorizedGrantTypes("client_credentials", "password").authorities("ROLE_CLIENT","ROLE_TRUSTED_CLIENT")
			.scopes("read", "write").resourceIds(resourceId)
			.accessTokenValiditySeconds(accessTokenValiditySeconds)
			.secret("secret");
	}
}
