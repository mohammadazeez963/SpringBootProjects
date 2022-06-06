package com.zensar.messageapi.security.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.zensar.messageapi.entity.ZensarUser;
import com.zensar.messageapi.repository.ZensarUserRepository;

@Service
public class ZensarUserServiceImpl implements UserDetailsService{
	
	@Autowired
	  private ZensarUserRepository repo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		// Here we are fetching from DB
		ZensarUser foundUser = this.repo.findByUsername(username);
		
		// If founduser is null means the username is not in DB
		if (foundUser == null) {
			throw new UsernameNotFoundException(username);
		}
		
		User authenticatedUser = new User(foundUser.getUsername(), foundUser.getPassword(), AuthorityUtils.createAuthorityList("USER"));
		
		return authenticatedUser;

	}
}
