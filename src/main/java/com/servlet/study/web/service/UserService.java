package com.servlet.study.web.service;

import com.servlet.study.web.domain.user.User;
import com.servlet.study.web.servlet.dto.PrincipalUser;

public interface UserService {
	public String getUserList();
	public String checkUserId(String userId);
	public String addUser(User user);
	public String updateUser(User user);
	public String deleteUser(int userCode);
	public PrincipalUser signin(String userId, String password);
}
