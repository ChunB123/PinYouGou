package com.pinyougou.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbSeller;
import com.pinyougou.sellergoods.service.SellerService;
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
	/*
	* 实现访问用户从数据库校验:
	* 1.注入sellerService
	* 2.校验用户名是否存在,status是否为1,密码是否正确
	* */
	private SellerService sellerService;
	public void setSellerService(SellerService sellerService) {
		this.sellerService = sellerService;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		List<SimpleGrantedAuthority> list=new ArrayList<>();
		list.add(new SimpleGrantedAuthority("ROLE_SELLER"));

		TbSeller tbSeller=sellerService.findOne(username);
		if(tbSeller!=null&&tbSeller.getStatus().equals("1")){
			return new User(username,tbSeller.getPassword(),list);
		}else{
			return null;
		}


	}
}
