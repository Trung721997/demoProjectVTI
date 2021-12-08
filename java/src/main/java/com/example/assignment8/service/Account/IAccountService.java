package com.example.assignment8.service.Account;

import com.example.assignment8.entity.Account;
import com.example.assignment8.form.Account.AccountFormForCreating;
import com.example.assignment8.form.Account.AccountFormForUpdating;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IAccountService extends UserDetailsService {
    public Account getAccountByUsername(String username);
    public List<Account> getAllAccount();
}
