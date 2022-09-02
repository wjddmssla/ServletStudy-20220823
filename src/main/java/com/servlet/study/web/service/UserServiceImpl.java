package com.servlet.study.web.service;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.servlet.study.web.domain.user.User;
import com.servlet.study.web.domain.user.UserRepository;
import com.servlet.study.web.servlet.dto.PrincipalUser;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	@NonNull
	private final UserRepository userRepository;
	
	@Override
	public String getUserList() {
		return getGson().toJson(userRepository.getUserList());
	}

	@Override
	public String checkUserId(String userId) {
		int result = userRepository.checkUserId(userId);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("checkFlag", result > 0 ? false : true);
		
		return getGson().toJson(resultMap);
	}
	
	@Override
	public String addUser(User user) {
		int result = userRepository.save(user);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("status", result > 0);
		
		return getGson().toJson(resultMap);
	}
	
	@Override
	public String updateUser(User user) {
		int result = userRepository.update(user);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("status", result > 0);
		
		return getGson().toJson(resultMap);
	}
	
	@Override
	public String deleteUser(int userCode) {
		int result = userRepository.delete(userCode);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("status", result > 0);
		
		return getGson().toJson(resultMap);
	}
	
	@Override
	public PrincipalUser signin(String userId, String password) {
		User user = userRepository.findUserByUserId(userId);
		if(user == null) {
			return null;
		}
		if(user.getUser_password().equals(password)) {
			return user.toPrincipal();
		}else {
			return null;
		}
	}
	
	private Gson getGson() {
		return new GsonBuilder()
				.setPrettyPrinting()
				.serializeNulls()
				.create();
	}
	
	

}










