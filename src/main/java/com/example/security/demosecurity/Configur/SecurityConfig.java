package com.example.security.demosecurity.Configur;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		return http.csrf(customizer->customizer.disable())
				.authorizeHttpRequests(req->req
						.requestMatchers("/h2-console/**").permitAll()
						.anyRequest().authenticated())
				//.formLogin(Customizer.withDefaults())
				.headers(h->h.frameOptions(f->f.disable()))
				.httpBasic(Customizer.withDefaults())
				.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.build();
	}
	
	
	@Bean
	public UserDetailsService userDetaailsService() {
		UserDetails user1=User.withUsername("user")
				.password(passwordEncoder().encode("pass"))
				.roles("USER")
				.build();
		
		UserDetails user2=User.withUsername("vinay")
				.password(passwordEncoder().encode("v@123"))
				.roles("USER")
				.build();
		
		
		return new InMemoryUserDetailsManager(user1,user2);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
