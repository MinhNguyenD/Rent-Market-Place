package com.mlproject.quickLease.security;

import com.mlproject.quickLease.entity.UserEntity;
import com.mlproject.quickLease.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final static String USER_NOT_FOUND_EXCEPTION = "User with email %s not found";
    private final UserRepository userRepository;

    public UserDetails loadUserByEmail(String email) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_EXCEPTION, email)));;
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return loadUserByEmail(email);
    }
}
