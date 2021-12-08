package com.example.assignment8.controller;

import com.example.assignment8.dto.AccountDTO.AccountGetDTO;
import com.example.assignment8.dto.AccountDTO.DepartmentAcDTO;
import com.example.assignment8.entity.Account;
import com.example.assignment8.form.Account.AccountFormForCreating;
import com.example.assignment8.form.Account.AccountFormForUpdating;
import com.example.assignment8.service.Account.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/accounts")
@CrossOrigin(origins = "*")
public class AccountControllor {
    @Autowired
    private IAccountService service;



}
