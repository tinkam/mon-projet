package com.starstel.telcopro.accounts.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
	@Autowired // A implementer
	private UserDetailsService userDetailsService;
	
	@Autowired // A instancier (dans le Main)
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override // Definit la manière dont spring sécurié doit aller chercher les utilisateurs
	protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	{	
		// Authentification basé sur un Service Personnalisé (Une Classe qui implemente UserDetailsService)
		// Qu'on doit definir. A la difference de "inMemoryAuthentication" ou "jdbcAuthentication"
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}
	
	@Override // Definit les droits d'accès aux ressources que fournit l'application
	protected void configure(HttpSecurity http) throws Exception 
	{
		// Toutes les Requettes "http" doivent etre authentifier
		http.authorizeRequests().anyRequest().authenticated();
		
		// Autorisation de l'acces au url "login", "register" et "resources" sans demande authentification
		http.authorizeRequests().antMatchers("/login/**", "/register/**", "/resources/**").permitAll();
		
		// Seul L'administrateur peut supprimer
		http.authorizeRequests().antMatchers(HttpMethod.DELETE).hasAuthority("ADMIN");
		
		// Desactivation de la Security aux attaques CSRF utilisé par spring par defaut (Synchronize Token)
		http.csrf().disable();
		
		// Desactivation du Systeme d'authentification par Reference (Les Sessions)
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		// Ajout du filtre de Traitement D'authentification Via Json Web Token
		http.addFilter(new JWTAuthenticationFilter(authenticationManager()));
		http.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
	}
}
