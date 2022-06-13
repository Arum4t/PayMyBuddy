package com.paymybuddy.webapp.model.specific;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.Email;
import java.util.Collection;

public class PersonDetails implements UserDetails {

    private static final long serialVersionUID = 1L;

    private Long id;

    @Email
    private String email;

    private String password;

    public PersonDetails(Long id, String email, String password){
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public Long getId(){
        return id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
