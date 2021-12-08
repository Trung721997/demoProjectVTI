package com.example.assignment8.form.Account;

public class AccountFormForCreating {
    private String email;
    private String userName;
    private String firstName;
    private String lastName;
    private short department;

    public AccountFormForCreating(String email, String userName, String firstName, String lastName, short department) {
        this.email = email;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public short getDepartment() {
        return department;
    }

    public void setDepartment(short department) {
        this.department = department;
    }
}
