package com.easy2excel.crm.service;


import com.easy2excel.crm.dto.UserDTO;

public interface UserService {

	public UserDTO saveUser(UserDTO userDTO);
	
	public UserDTO updateUser(String userId,UserDTO userDTO);
	
	public UserDTO getUser(String userId);

}
