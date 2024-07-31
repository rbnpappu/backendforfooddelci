package com.backendforfooddelci.controller;



import org.slf4j.LoggerFactory;

import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.backendforfooddelci.service.AuthenticationManager;
import com.backendforfooddelci.service.TokenService;



@RestController
public class AuthController {

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(AuthController.class);

    private final TokenService tokenService;

    public AuthController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping("/token")
    public String token(org.springframework.security.core.Authentication authentication) {
    	System.out.print(authentication+"auth");
    	LOG.debug("Token requested for user: '{}'", authentication.getName());
        String token = tokenService.generateToken(authentication);
        LOG.debug("Token granted: {}", token);
        return token;
    }
    
    @PostMapping("/Login/token")
    public String faceBookSocialSignIn() {
		// TODO Auto-generated method stub
    	
    
    	//String token =  tokenService.generateToken(authentication);
    	return "genrates";
    	
    }
    @GetMapping("/user")
    @PreAuthorize("hasAuthority('SCOPE_ROLE_user')")
    public String checkForUser() {
        return "User role sign in";
    }


    
    
//    @PostMapping("/admin")
//    public String admin(Authentication authentication) {
//        LOG.debug("Token requested for user: '{}'", authentication.getName());
//        String token = tokenService.generateToken(authentication);
//        LOG.debug("Token granted: {}", token);
//        return token;
//    }

}