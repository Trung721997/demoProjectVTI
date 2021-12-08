package com.example.assignment8.dto.AccountDTO;

public class AccountGetDTO {
    private short id;
    private String userName;
    private String fullName;
    private String role;

    public AccountGetDTO(short id, String userName, String fullName, String role) {
        this.id = id;
        this.userName = userName;
        this.fullName = fullName;
        this.role = role;
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
