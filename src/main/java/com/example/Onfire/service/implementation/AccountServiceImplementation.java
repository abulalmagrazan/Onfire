package com.example.Onfire.service.implementation;

import com.example.Onfire.dao.AccountRepository;
import com.example.Onfire.dto.RegisterAccount;
import com.example.Onfire.service.interfacess.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImplementation implements AccountService {

    @Autowired
    AccountRepository repository;

    @Override
    public void register(RegisterAccount dto) {


    }
}
