package com.apontador.services;

import com.apontador.data.model.User;
import com.apontador.security.AccountCredentialsVO;
import com.apontador.security.AuthenticationVO;

public interface IUserService {
	 public User findByUsernameOrEmail(String username, String email);   
	 //public User save(AccountCredentialsVO vo);
	 //public AuthenticationVO findByUsernameOrEmail(String username, String email);
	 public AccountCredentialsVO save(AccountCredentialsVO vo);
	 public AuthenticationVO auth(AccountCredentialsVO vo);
}
