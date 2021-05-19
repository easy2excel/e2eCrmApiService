package com.easy2excel.crm.service;

import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {


    @Override
    public String prepareForgetPasswordLink(String emailId) {
        return null;
    }

    @Override
    public String prepareEmailValidationLink(String emailId, String employeeId, String orgId, String name) {
        return null;
    }

    @Override
    public void sendMail(String from, String to, String subject, String text) {

    }
}
