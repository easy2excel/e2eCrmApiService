package com.easy2excel.crm.service;


import com.easy2excel.crm.dto.UserDTO;
import com.esay2excel.crm.domain.User;
import com.esay2excel.crm.repository.OrganizationRepository;
import com.esay2excel.crm.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    OrganizationRepository organizationRepository;
    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        User user = new User();
        setPropertyOnInput(userDTO, user);
        User dbUser = userRepository.save(user);
        return UserDTO.from(dbUser);

    }

    private void setPropertyOnInput(UserDTO userDTO, User user) {
        user.setFirstName(userDTO.getFirstName());
        user.setMiddleName(userDTO.getMiddleName());
        user.setLastName(userDTO.getLastName());
        user.setPhoneNo(userDTO.getPhoneNo());
        user.setDialCode(userDTO.getDialCode());
        user.setAlternativeNo(userDTO.getAlternateNo());
        user.setDialCode1(userDTO.getDialCode1());
        user.setEmail(userDTO.getEmail());
        //Organization organization = organizationRepository.findById(userDTO.getOrgId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Organization not found " + userDTO.getUserId()));
        //user.setOrganization(organization);
    }

    @Override
    public UserDTO updateUser(String userId, UserDTO userDTO) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found " + userId));
        setPropertyOnInput(userDTO, user);
        User updatedUser = userRepository.save(user);
        return UserDTO.from(updatedUser);

    }

    @Override
    public UserDTO getUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found " + userId));
        return UserDTO.from(user);

    }

}
