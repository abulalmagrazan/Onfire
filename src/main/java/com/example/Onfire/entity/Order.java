package com.example.Onfire.entity;

import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
@Entity(name = "Order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdOrder")
    private Long idOrder;

    @Column(name = "OrderDate")
    private LocalDate orderDate;

    @Column(name = "IdCustomer")
    private Long idCustomer;

    @Column(name = "IdEmployee")
    private Long idEmployee;

    @Column(name = "IdTable")
    private Long idTable;

    @Column(name = "IdAddress")
    private Long idAddress;


    @Column(name = "Discount")
    private Double discount;

    @Column(name = "Description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdCustomer",insertable = false,updatable = false)
    public Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdEmployee",insertable = false,updatable = false)
    public Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdTable",insertable = false,updatable = false)
    public Table table ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdAddress",insertable = false,updatable = false)
    public Address address;


    public Order(Long idOrder, LocalDate orderDate, Long idCustomer, Long idEmployee, Long idTable, Long idAddress, Double discount, String description) {
        this.idOrder = idOrder;
        this.orderDate = orderDate;
        this.idCustomer = idCustomer;
        this.idEmployee = idEmployee;
        this.idTable = idTable;
        this.idAddress = idAddress;
        this.discount = discount;
        this.description = description;
    }
}
