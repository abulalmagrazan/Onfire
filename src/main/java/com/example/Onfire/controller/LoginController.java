package com.example.Onfire.controller;


import com.example.Onfire.config.UserDetail;
import com.example.Onfire.dto.DataErrorDto;
import com.example.Onfire.dto.RegisterAccount;
import com.example.Onfire.dto.WebResponse;
import com.example.Onfire.dto.response.ResponseCrudDto;
import com.example.Onfire.service.interfacess.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/access")
public class LoginController {

    @Autowired
    AccountService accountService;

    @PostMapping("/register")
    public WebResponse<ResponseCrudDto> register(@Valid @RequestBody RegisterAccount dto,
                                                 BindingResult bindingResult){
        try {
            if (!bindingResult.hasErrors()){
                accountService.register(dto);
                return WebResponse.<ResponseCrudDto>builder().data(new ResponseCrudDto(HttpStatus.OK,"ok")).build();
            }else {
                List<DataErrorDto> dataError=new ArrayList<>();
                var lihat=bindingResult.getAllErrors();

                for(Object o:lihat){
                    FieldError fr =(FieldError) o;
                    dataError.add(new DataErrorDto( fr.getField(),fr.getDefaultMessage()));
                }
                return WebResponse.<ResponseCrudDto>builder().data(new ResponseCrudDto(HttpStatus.EXPECTATION_FAILED,"Error",dataError)).errors("field Error").build();
            }



        }catch (Exception e){
            return WebResponse.<ResponseCrudDto>builder().data(new ResponseCrudDto(HttpStatus.INTERNAL_SERVER_ERROR,"Error")).errors(e.getMessage()).build();

        }

    }

    @PostMapping("/logout")
    public WebResponse<String> logout(HttpSession session){
        session.invalidate();
        SecurityContextHolder.clearContext();
        return WebResponse.<String>builder().data("logout").build();
    }
}
