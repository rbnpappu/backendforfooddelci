package com.backendforfooddelci.service;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.backendforfooddelci.Repository.RegisterRepository;
import com.backendforfooddelci.modal.SecurityUser;



@Service
public class CustomUserDetailService implements UserDetailsService {

	private final RegisterRepository userRepo;


	public CustomUserDetailService(RegisterRepository userRepo) {
		this.userRepo = userRepo;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
	 return userRepo
                .findByUserName(username)
                .map(SecurityUser::new)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found: " + username));



	}

}
