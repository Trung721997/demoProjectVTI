package com.example.assignment8.entity;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Department")
public class Department implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "DepartmentID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(name = "DepartmentName", length = 30, nullable = false, unique = true)
	private String name;

	@ManyToOne
	@JoinColumn(name = "author_id", nullable = false, updatable = false)
	private  Account  author;

	@Column(name = "CreateDate", updatable = false)
	@Temporal(TemporalType.DATE)
	@CreationTimestamp
	private Date createDate;

	@Column(name = "ModifiedDate", updatable = true)
	@Temporal(TemporalType.DATE)
	@CreationTimestamp
	private Date modifiedDate;

	@ManyToOne
	@JoinColumn(name = "AddressID", updatable = false)
	private  Address  addressId;

	@OneToMany(mappedBy = "departmentID")
	private List<Account> accounts;

	public Department() {
	}

	public Department(String name){
		this.name = name;
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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public Account getAuthor() {
		return author;
	}

	public void setAuthor(Account author) {
		this.author = author;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Address getAddressId() {
		return addressId;
	}

	public void setAddressId(Address addressId) {
		this.addressId = addressId;
	}
}
