package com.group6.swp391.service;


import com.group6.swp391.model.User;
import com.group6.swp391.request.OTPRequest;
import com.group6.swp391.request.OTPValidationRequest;
import jakarta.mail.MessagingException;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface UserService {

    public List<User> findAll(String role);

    public void save(User user);

    public boolean sendVerificationEmail(User user, String siteUrl) throws MessagingException, UnsupportedEncodingException;

    public boolean verifyAccount(String code);

    public User getUserByID(int userID);

    public User getUserByEmail(String email);

    public boolean lockedUser(int id);

    public boolean deleteUser(int id);

    public boolean verifyRecaptcha(String gRecaptchaResponse);

    public boolean sendSMS(OTPRequest otpRequest);

    public boolean validateOTP(OTPValidationRequest otpValidationRequest);
}
