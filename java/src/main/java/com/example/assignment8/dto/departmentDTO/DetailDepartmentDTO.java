package com.example.assignment8.dto.departmentDTO;

import com.example.assignment8.dto.departmentDTO.AccountDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class DetailDepartmentDTO {

    private short id;

    private String name;

    private AccountDTO author;

    private Date createDate;

    public DetailDepartmentDTO(){}

    public DetailDepartmentDTO(short id, String name, AccountDTO author, Date createDate) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.createDate = createDate;
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AccountDTO getAuthor() {
        return author;
    }

    public void setAuthor(AccountDTO author) {
        this.author = author;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
