package com.servlet.study.web.dto.auth;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SignupRequestDto {
	private String userId;
	private String userPassword;
	private String userName;
	private String userEmail;
}
