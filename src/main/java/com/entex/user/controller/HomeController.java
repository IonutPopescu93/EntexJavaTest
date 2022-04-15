package com.entex.user.controller;

import com.entex.user.model.JwtRequest;
import com.entex.user.model.JwtResponse;
import com.entex.user.service.JwtUserDetailsService;
import com.entex.user.utils.JwtUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class HomeController {

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private JwtUtility jwtUtility;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/home")
    public String getHomePage(){
        return "home" ;
    }

    @GetMapping("/authenticate")
    public String getLoginPage(){
        return "loginPage" ;
    }

    @PostMapping("/login")
    public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getUsername(),
                            jwtRequest.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Invalid credentials", e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(jwtRequest.getUsername());

        final String token = jwtUtility.generateToken(userDetails);

        return new JwtResponse(token);

    }


}
