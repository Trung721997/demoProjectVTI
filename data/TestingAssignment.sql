-- create database
DROP
DATABASE IF EXISTS TestingSystem;
CREATE
DATABASE TestingSystem;
USE
TestingSystem;

DROP TABLE IF EXISTS Address;
CREATE TABLE Address(
	AddressID 				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    AddressName				NVARCHAR(30) NOT NULL UNIQUE KEY
);

-- create table: Department
DROP TABLE IF EXISTS Department;
CREATE TABLE Department
(
    DepartmentID   	TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    DepartmentName 	NVARCHAR(30) NOT NULL UNIQUE KEY,
    author_id		TINYINT UNSIGNED,
    CreateDate  	DATETIME DEFAULT NOW(),
    ModifiedDate 	DATETIME DEFAULT NOW(),
    AddressID		TINYINT UNSIGNED,
    FOREIGN KEY (AddressID) REFERENCES Address(AddressID)
);

-- create table: Account
DROP TABLE IF EXISTS `Account`;
CREATE TABLE `Account`
(
    AccountID    TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Email        VARCHAR(50) NOT NULL UNIQUE KEY, 
    Username     VARCHAR(50) NOT NULL UNIQUE KEY,
    `Password`	 VARCHAR(500) NOT NULL,
    FirstName    NVARCHAR(50) NOT NULL,
    LastName     NVARCHAR(50) NOT NULL,  
    `Role`		 ENUM ('Admin', 'Manager', 'Employee') NOT NULL DEFAULT 'Employee',
    DepartmentID TINYINT UNSIGNED,       
    CreateDate   DATETIME DEFAULT NOW(),          
    FOREIGN KEY (DepartmentID) REFERENCES Department (DepartmentID) ON DELETE SET NULL
);

