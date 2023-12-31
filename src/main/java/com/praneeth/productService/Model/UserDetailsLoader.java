package com.praneeth.productService.Model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class UserDetailsLoader implements UserDetails {
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities ( ) {
        List<GrantedAuthority> authorities = new ArrayList<> (  );
        authorities.add ( new SimpleGrantedAuthority ( "admin" ) );
        return authorities;
    }

    @Override
    public String getPassword ( ) {
        return "Admin@123";
    }

    @Override
    public String getUsername ( ) {
        return "Admin";
    }

    @Override
    public boolean isAccountNonExpired ( ) {
        return true;
    }

    @Override
    public boolean isAccountNonLocked ( ) {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired ( ) {
        return true;
    }

    @Override
    public boolean isEnabled ( ) {
        return true;
    }
}
