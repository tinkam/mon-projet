package com.starstel.telcopro.accounts.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.starstel.telcopro.accounts.entities.AppUser;


@Service
public class UserDetailsServiceImpl implements UserDetailsService 
{
	@Autowired
	private AccountService accountService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		AppUser user = accountService.findUserByUsername(username);
		
		if(user == null)
			throw new UsernameNotFoundException(username);
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		user.getRoles().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
		});
		
		return new User(user.getUsername(), user.getPassword(), authorities);
	}

}
