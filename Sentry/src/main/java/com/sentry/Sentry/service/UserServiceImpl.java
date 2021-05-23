package com.sentry.Sentry.service;

import com.sentry.Sentry.entity.Role;
import com.sentry.Sentry.entity.User;
import com.sentry.Sentry.repository.UserRepository;
import com.sentry.Sentry.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByUserName(String userName) {
        return userRepository.findByEmail(userName);
    }

    @Override
    public User save(UserRegistrationDto registrationDto) {
        User user = new User(passwordEncoder.encode(registrationDto.getPassword()), registrationDto.getFirstName(),
                                registrationDto.getLastName(), registrationDto.getEmail(),
                registrationDto.getPhoneNo(), registrationDto.getAddress(), Arrays.asList(new Role("ROLE_USER")));

        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(s);
        if (user == null){
            throw new UsernameNotFoundException("Invalid username or password");

        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

	@Override
	public User update(User theuser) {
		return userRepository.save(theuser);
	}
}


