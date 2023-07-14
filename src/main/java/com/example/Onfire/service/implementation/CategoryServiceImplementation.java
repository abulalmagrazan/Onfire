package com.example.Onfire.service.implementation;

import com.example.Onfire.dao.CategoryRepository;
import com.example.Onfire.entity.Category;
import com.example.Onfire.service.interfacess.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImplementation implements CategoryService {

    @Autowired
    CategoryRepository repository;

    @Override
    public ResponseEntity<List<Category>> findAll() {
        List<Category> data= repository.findAll();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
