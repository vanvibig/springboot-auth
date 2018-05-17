package com.kv.springbootlogin.service;

import com.kv.springbootlogin.model.CustomUserDetail;
import com.kv.springbootlogin.model.User;
import com.kv.springbootlogin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{

        Optional<User> optionalUser = userRepository.findByName(username);
        optionalUser.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        return optionalUser.map(CustomUserDetail::new).get();

    }
}
