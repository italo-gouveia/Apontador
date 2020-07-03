package com.apontador.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apontador.services.IUserService;
import com.apontador.security.AccountCredentialsVO;
import com.apontador.security.AuthenticationVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@Api(tags = "AuthenticationEndpoint")
@RestController
@RequestMapping("/auth")
public class AuthController {
    
    @Autowired
    IUserService service;

    @ApiOperation(value = "Authenticates a user and returns a token")
    @PostMapping(value = "/signin", produces = { "application/json", "application/xml", "application/x-yaml" },
    	consumes = { "application/json", "application/xml", "application/x-yaml" })
    public AuthenticationVO signin(@RequestBody AccountCredentialsVO data) {
    	AuthenticationVO auth = service.auth(data);
    	return auth;
    }
    
    //This endpoint it's hidden from swagger page to be acessed only by a frontend application
    @ApiIgnore
    @Transactional
    @ApiOperation(value = "Create a user and returns a token")
    @PostMapping(value = "/signup", produces = { "application/json", "application/xml", "application/x-yaml" },
            consumes = { "application/json", "application/xml", "application/x-yaml" })
    public AccountCredentialsVO signup(@RequestBody AccountCredentialsVO user) {
    	AccountCredentialsVO auth = service.save(user);
        return auth;
    }
}