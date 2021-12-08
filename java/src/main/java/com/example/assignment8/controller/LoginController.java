package com.example.assignment8.controller;

import com.example.assignment8.dto.AccountDTO.LoginDTO;
import com.example.assignment8.entity.Account;
import com.example.assignment8.service.Account.IAccountService;
import com.example.assignment8.service.Department.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping(value = "api/v1/login")
@CrossOrigin(origins = "*")
public class LoginController {
    @Autowired
    private IAccountService accountService;

    @GetMapping()
    public ResponseEntity<?> login(Principal principal){
        String username = principal.getName();
        Account account = accountService.getAccountByUsername(username);
        LoginDTO loginDTO = new LoginDTO(account.getId(), account.getFullName(), account.getRole());
        return new ResponseEntity<>(loginDTO, HttpStatus.OK );
    }
}
