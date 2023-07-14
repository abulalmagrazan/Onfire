package com.example.Onfire.config;

import com.example.Onfire.dao.AccountRepository;
import com.example.Onfire.entity.Account;
import com.example.Onfire.service.interfacess.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.xml.validation.Validator;

@Service
public class AppUserDetailService implements UserDetailsService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountService service;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        var role = request.getParameter("role");
        Account userLogin= accountRepository.findById(username).orElseThrow(()->new RuntimeException("Username "+username+" not found!!"));

        return new UserDetail(userLogin);
    }
}
