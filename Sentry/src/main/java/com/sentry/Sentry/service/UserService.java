package com.sentry.Sentry.service;

import com.sentry.Sentry.entity.User;
import com.sentry.Sentry.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
   User findByUserName(String userName);
   User save(UserRegistrationDto registrationDto);
}
