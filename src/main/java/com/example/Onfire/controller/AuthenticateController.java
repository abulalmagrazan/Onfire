package com.example.Onfire.controller;

import com.example.Onfire.dto.WebResponse;
import com.example.Onfire.dto.response.RequestRestDto;
import com.example.Onfire.dto.response.ResponseCrudDto;
import com.example.Onfire.utility.JwtToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class AuthenticateController {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtToken jwtToken;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/authenticated")
    public WebResponse<ResponseCrudDto> post(@RequestBody RequestRestDto dto){
        try{
            UserDetails userDetails = userDetailsService.loadUserByUsername(dto.getUsername());
            String token =jwtToken.generateToken(dto.getSubject(), dto.getUsername(), dto.getSecretKey(),dto.getRole(),dto.getAudience());
            var response = new ResponseCrudDto(HttpStatus.OK,"success",token);
            return WebResponse.<ResponseCrudDto>builder().data(response).build();
        }catch (Exception e){
            return WebResponse.<ResponseCrudDto>builder().data(new ResponseCrudDto(HttpStatus.INTERNAL_SERVER_ERROR,"Error")).errors(e.getMessage()).build();
        }
    }


//    @PostMapping("/authenticated")
//    public ResponseCrudDto post(@RequestBody RequestRestDto dto){
//        try{
//            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(dto.getUsername(),dto.getPassword());
//            authenticationManager.authenticate(token);
//        }catch (Exception e){
//
//        }
//        UserDetails userDetails = userDetailsService.loadUserByUsername(dto.getUsername());
//        String token =jwtToken.generateToken(dto.getSubject(), dto.getUsername(), dto.getSecretKey(),dto.getRole(),dto.getAudience());
//        var response = new ResponseCrudDto(HttpStatus.OK,"success",token);
//        return response;
//    }

}
