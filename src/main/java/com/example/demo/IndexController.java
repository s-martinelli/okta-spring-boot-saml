package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.*;
import org.springframework.security.core.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.saml.SAMLCredential;


@Controller
public class IndexController {

    private SAMLCredential saml;

    @RequestMapping("/")
    public String index() {
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        saml = (SAMLCredential) auth.getCredentials();
        //System.out.println("Attributes: "+saml.getAttributes());
        //System.out.println("Username: "+saml.getNameID().getValue());
        return "index";
    }
}