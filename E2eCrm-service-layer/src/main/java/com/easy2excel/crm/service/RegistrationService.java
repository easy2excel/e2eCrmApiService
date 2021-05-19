package com.easy2excel.crm.service;


import com.easy2excel.crm.dto.EmailValidationDTO;
import com.easy2excel.crm.dto.RegistrationDTO;
import com.easy2excel.crm.dto.UserPasswordDTO;
import com.easy2excel.crm.dto.view.RegistrationViewDTO;

public interface RegistrationService {

	public RegistrationViewDTO doRegister(RegistrationDTO userRegistrationDTO);

	public boolean validateEmailAddress(EmailValidationDTO emailValidationDTO);

	public boolean setPassword(UserPasswordDTO passwordRq);

	public String forgetPassword(String email);


}
