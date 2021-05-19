package com.easy2excel.crm.controller;

//import com.app.korero.authentication.config.TokenProvider;

import com.easy2excel.crm.dto.EmailValidationDTO;
import com.easy2excel.crm.dto.RegistrationDTO;
import com.easy2excel.crm.dto.UserPasswordDTO;
import com.easy2excel.crm.dto.view.RegistrationViewDTO;
import com.easy2excel.crm.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;
    //@Autowired
   // private TokenProvider jwtTokenUtil;
    @Transactional
    @PostMapping(value = "/")
    public ResponseEntity<RegistrationViewDTO> doRegister(@RequestBody RegistrationDTO userRegistrationDTO, HttpServletRequest request) {
        return ResponseEntity.ok(registrationService.doRegister(userRegistrationDTO));
    }

    @PostMapping(value = "/emailValidation")
    public boolean emailValidation(@RequestBody EmailValidationDTO emailValidationDTO, HttpServletRequest request) {
        return registrationService.validateEmailAddress(emailValidationDTO);
    }

    @PostMapping(value = "/setPassword")
    public boolean setPassword(@RequestBody UserPasswordDTO passwordRq, HttpServletRequest request) {
        return registrationService.setPassword(passwordRq);
    }

    @GetMapping(value = "/forgotPassword")
    public String forgetPassword(@RequestParam("email") String email, HttpServletRequest request) {
        return registrationService.forgetPassword(email);
    }


    /*@RequestMapping(value = "/changePassword")
    public boolean changePassword(@RequestHeader("Authorization") String authorization,
                                  @RequestBody UserPasswordDTO passwordRq, HttpServletRequest request) {

        if (authorization != null && authorization.startsWith(TOKEN_PREFIX)) {

            String authToken = authorization.replace(TOKEN_PREFIX, "");
            //passwordRq.setEmployeeId(jwtTokenUtil.getUserIdFromToken(authToken));
            return registrationService.setPassword(passwordRq);
        }
        return false;

    }*/

}
