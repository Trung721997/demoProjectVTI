package com.example.assignment8.repository;

import com.example.assignment8.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Integer> {
    Account findByUserName(String userName);
    Account findById(short id);
}
