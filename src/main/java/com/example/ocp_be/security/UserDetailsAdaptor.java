package com.example.ocp_be.security;

import com.example.ocp_be.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserDetailsAdaptor implements UserDetails {

    private final User user;

    public UserDetailsAdaptor(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(user.getRole()), new SimpleGrantedAuthority("ROLE_SIMPLE_USER"));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

//    Am suprascris metoda asta ca sa creez un username pentru useri
    @Override
    public String getUsername() {
        String firstName = user.getFirstName();
        String lastName = user.getFirstName();
        String username = firstName.concat(lastName);

        return username;
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
