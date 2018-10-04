package demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;


@Configuration
@EnableResourceServer
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.requestMatchers().antMatchers("/login", "/oauth/authorize")
		.and().authorizeRequests().anyRequest()
		.authenticated().and().formLogin().permitAll();
	}
	
	@Override
	public  void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		 .withUser("user7").password("pass7").roles("user")
		 .and().withUser("user8").password("pass8").roles("user") 
		 .and().withUser("user9").password("pass9").roles("user");
	}


}
