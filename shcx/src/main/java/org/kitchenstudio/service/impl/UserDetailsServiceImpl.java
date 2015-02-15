package org.kitchenstudio.service.impl;

import org.kitchenstudio.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private final AccountRepository accountRepository;

	@Autowired
	public UserDetailsServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {

		if (accountRepository.findOne(username) == null)
			throw new UsernameNotFoundException("找不到该用户");

		return accountRepository.findOne(username);
	}

}