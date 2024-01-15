package com.ipartek.bibliotecaspring.configuraciones;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	// Autenticación
	@Bean
	UserDetailsService userDetailsService() {
		UserDetails javier =
			 User.withDefaultPasswordEncoder()
				.username("javier")
				.password("contra")
				.roles("ADMIN")
				.build();

		UserDetails pepe =
				User.withDefaultPasswordEncoder()
				.username("pepe")
				.password("perez")
				.roles("USER")
				.build();
		
			

		return new InMemoryUserDetailsManager(javier, pepe);
	}
	
	// Autorización
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> requests
				//.requestMatchers("/", "/home").permitAll()
				.requestMatchers("/admin/**").hasRole("ADMIN")
				.requestMatchers("/detalle").authenticated()
				.anyRequest().permitAll()
			)
			.formLogin((form) -> form
				.loginPage("/login")
				.permitAll()
			)
			.logout((logout) -> logout.permitAll());

		return http.build();
	}
}