package com.easy2excel.crm.service;

public interface EmailService {
    public String prepareForgetPasswordLink(String emailId);

    public String prepareEmailValidationLink(String emailId,String employeeId,String orgId,String name);

    public void sendMail(String from, String to, String subject, String text) ;
}
