DROP DATABASE bank;
CREATE DATABASE IF NOT EXISTS bank;
USE bank;

CREATE TABLE information (
	id INT NOT NULL AUTO_INCREMENT,	
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL UNIQUE,
    phone_number VARCHAR(255) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL,
    dob DATE NOT NULL,
    gender ENUM ('Male', 'Female') NOT NULL,
    balance FLOAT NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE login (
	id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id) REFERENCES information(id),
    FOREIGN KEY (username) REFERENCES information(username)
);