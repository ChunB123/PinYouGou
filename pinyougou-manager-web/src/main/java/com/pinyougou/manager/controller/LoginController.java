package com.pinyougou.manager.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author YaphetS
 * @date 2018/10/24 2:31 PM
 */
@RestController
@RequestMapping("/login")
public class LoginController {

	@RequestMapping("name")
	public Map name(){
		String name= SecurityContextHolder.getContext().getAuthentication().getName();
		Map map=new HashMap(16);
		map.put("loginName", name);
		return map ;
	}
}
