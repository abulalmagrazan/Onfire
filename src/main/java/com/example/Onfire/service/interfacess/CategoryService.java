package com.example.Onfire.service.interfacess;

import com.example.Onfire.entity.Category;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryService {

    public ResponseEntity<List<Category>> findAll();
}
