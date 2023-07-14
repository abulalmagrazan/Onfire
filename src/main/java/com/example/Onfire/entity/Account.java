package com.example.Onfire.entity;
import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
@Entity(name = "Account")
public class Account {

    @Id
    @Column(name = "Username")
    public String username;

    @Column(name = "Password")
    public String password;

    @Column(name = "Role")
    public String role;




}
