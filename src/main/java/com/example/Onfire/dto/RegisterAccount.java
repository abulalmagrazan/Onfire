package com.example.Onfire.dto;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
public class RegisterAccount {

    @NotBlank
    private String username;


    @NotBlank
    @Size(min=8)
    private String password;

    @NotBlank
    private String role;
}
