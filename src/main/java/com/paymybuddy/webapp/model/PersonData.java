package com.paymybuddy.webapp.model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class PersonData implements Serializable {


    @NotEmpty(message = "Email can not be empty")
    @Email(message = "Please provide a valid email")
    private String email;

    @NotEmpty(message = "Password can not be empty")
    private String password;
}
