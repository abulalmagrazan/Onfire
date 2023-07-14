package com.example.Onfire.entity;

import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
@Entity(name = "Category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdCategory")
    private Long idCategory;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;
}
