package com.servlet.study.web.domain.user;

import com.servlet.study.web.servlet.dto.PrincipalUser;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User {
	private int user_code;
	private String user_id;
	private String user_password;
	private String user_name;
	private String user_email;
	private String user_phone;
	private String user_address;
	
	public PrincipalUser toPrincipal() {
		return PrincipalUser.builder()
				.userCode(user_code)
				.userId(user_id)
				.userPassword(user_password)
				.userName(user_name)
				.userEmail(user_email)
				.userPhone(user_phone)
				.userAddress(user_address)
				.build();
	}
}










