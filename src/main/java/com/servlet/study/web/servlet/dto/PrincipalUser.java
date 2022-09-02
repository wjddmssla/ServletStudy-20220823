package com.servlet.study.web.servlet.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PrincipalUser {
	private int userCode;
	private String userId;
	private String userPassword;
	private String userName;
	private String userEmail;
	private String userPhone;
	private String userAddress;
}
