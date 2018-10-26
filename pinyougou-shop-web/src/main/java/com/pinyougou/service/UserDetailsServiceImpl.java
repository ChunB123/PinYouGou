package com.pinyougou.service;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YaphetS
 * @date 2018/10/25 9:08 PM
 */
public class UserDetailsServiceImpl implements UserDetailsService {


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		List<SimpleGrantedAuthority> list=new ArrayList<>();
		list.add(new SimpleGrantedAuthority("ROLE_SELLER"));
		return new User(username,"123456",list);
	}
}
