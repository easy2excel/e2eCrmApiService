package com.easy2excel.crm.service;


import com.easy2excel.crm.dto.EmailValidationDTO;
import com.easy2excel.crm.dto.RegistrationDTO;
import com.easy2excel.crm.dto.UserPasswordDTO;
import com.easy2excel.crm.dto.view.RegistrationViewDTO;
import com.esay2excel.crm.domain.Organization;
import com.esay2excel.crm.domain.User;
import com.esay2excel.crm.domain.UserSettings;
import com.esay2excel.crm.repository.OrganizationRepository;
import com.esay2excel.crm.repository.UserAddressRepository;
import com.esay2excel.crm.repository.UserRepository;
import com.esay2excel.crm.repository.UserSettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	OrganizationRepository organizationRepository;
	@Autowired
	UserSettingsRepository userSettingsRepository;
	@Autowired
	UserAddressRepository addressRepository;

	//private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public RegistrationViewDTO doRegister(RegistrationDTO registrationDTO) {

		User user = new User();
		user.setFirstName(registrationDTO.getFirstName());
		user.setMiddleName(registrationDTO.getMiddleName());
		user.setLastName(registrationDTO.getLastName());
		user.setDialCode(registrationDTO.getDialCode());
		user.setPhoneNo(registrationDTO.getPhoneNo());

		//User userAfterSave = userRepository.save(user);

		Organization organization = new Organization();
		organization.setCompanySize(registrationDTO.getSize());
		organization.setCountry(registrationDTO.getCountry());
		organization.setDialCode(registrationDTO.getDialCode());
		organization.setOrgName(registrationDTO.getOrgName());
		organization.setUrl(registrationDTO.getUrl());
		organization.setUser(Arrays.asList(user));

		Organization organizationAfterSave = organizationRepository.saveAndFlush(organization);
		return RegistrationViewDTO.from(organizationAfterSave);
	}


	@Override
	public boolean validateEmailAddress(EmailValidationDTO emailValidationDTO) {
		UserSettings userSettings = userSettingsRepository.getUserSettingsByEmail(emailValidationDTO.getEmailId());
		if(null!=userSettings){
			userSettings.setEmailValInd(true);
			userSettings.setUserActiveInd(true);
			userSettingsRepository.save(userSettings);
		}
		return false;
	}

	@Override
	public boolean setPassword(UserPasswordDTO passwordRq) {
		if(null!=passwordRq.getEmailId()) {
			UserSettings dbuserSettings =userSettingsRepository.getUserSettingsByEmail(passwordRq.getEmailId()) ;
			//dbuserSettings.setPassword(new BCryptPasswordEncoder().encode(passwordRq.getPassword()));
			dbuserSettings.setPasswordActiveInd(true);
			UserSettings userSettings = userSettingsRepository.save(dbuserSettings);
			return true;
		}
		return false;
	}

	@Override
	public String forgetPassword(String email) {

		return null;
	}

}
