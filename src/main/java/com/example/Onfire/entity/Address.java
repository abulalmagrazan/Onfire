package com.example.Onfire.entity;
import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
@Entity(name = "Address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdAddress")
    private Long idAddress;

    @Column(name = "IdCustomer")
    private Long idCustomer;

    @Column(name = "IdProvince")
    private Long idProvince;

    @Column(name = "IdCity")
    private Long idCity;

    @Column(name = "IdDistrict")
    private Long idDistrict;

    @Column(name = "IdVillage")
    private Long idVillage;

    @Column(name = "Address")
    private String address;

    @Column(name = "PostCode")
    private Long postCode;

    @Column(name = "PhoneNumber")
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdCustomer",insertable = false,updatable = false)
    public Customer customer;


    public Address(Long idAddress, Long idCustomer, Long idProvince, Long idCity, Long idDistrict, Long idVillage, String address, Long postCode, String phoneNumber) {
        this.idAddress = idAddress;
        this.idCustomer = idCustomer;
        this.idProvince = idProvince;
        this.idCity = idCity;
        this.idDistrict = idDistrict;
        this.idVillage = idVillage;
        this.address = address;
        this.postCode = postCode;
        this.phoneNumber = phoneNumber;
    }
}
