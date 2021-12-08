package com.example.assignment8.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Address")
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "AddressID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name = "AddressName", length = 30, nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "addressId")
    private List<Department> departments;

    public Address(){}

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
}
