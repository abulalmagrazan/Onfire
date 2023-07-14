package com.example.Onfire.entity;
import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
@Entity(name = "Table")
public class Table {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdTable")
    private Long idTable;

    @Column(name = "TableNumber")
    private String tableNumber;

    @Column(name = "Type")
    private String type;

    @Column(name = "IsBooked")
    private Boolean isBooked;

    @Column(name = "Description")
    private String description;
}
