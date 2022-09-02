package com.servlet.study.web.domain.user;

public class UserMain {

	public static void main(String[] args) {
		UserRepository repository = new UserRepository();
		
		repository.getUserList();

	}

}
