package com.praneeth.productService.Controller;

import com.praneeth.productService.Model.AuthRequest;
import com.praneeth.productService.Service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "https://foodyres.web.app", maxAge = 3600)
@RestController
public class UserController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping("/auth")
    public String authenticate(@RequestBody AuthRequest authRequest) throws UsernameNotFoundException {
        Authentication authentication=  authenticationManager.authenticate(new UsernamePasswordAuthenticationToken (authRequest.getUsername(),authRequest.getPassword ()));

        if(authentication.isAuthenticated()){
            return jwtService.generateToken(authRequest.getUsername());

        }
        throw new UsernameNotFoundException("User Details Not correct");
    }
}
