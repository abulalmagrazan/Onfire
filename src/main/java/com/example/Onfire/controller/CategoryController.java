package com.example.Onfire.controller;

import com.example.Onfire.config.UserDetail;
import com.example.Onfire.dto.response.ResponseCrudDto;
import com.example.Onfire.entity.Category;
import com.example.Onfire.security.CurrentUser;
import com.example.Onfire.service.interfacess.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;



    @GetMapping("/findAll")
    public ResponseCrudDto get(@CurrentUser UserDetail currentUser){
//        try{
        if(currentUser.getRole().toLowerCase().equals("administrator")){
            var data=categoryService.findAll();
            ResponseCrudDto response=new ResponseCrudDto(data.getStatusCode(),"success",data);
            return  response;
        }else{
            return  new ResponseCrudDto(HttpStatus.FAILED_DEPENDENCY,"Access Denied");
        }
//            return new ResponseCrudDto(HttpStatus.OK,"success",dataCategory);

//        }catch (Exception e){
//            return new ResponseCrudDto(HttpStatus.INTERNAL_SERVER_ERROR,"Error");
//        }
    }
}
