CREATE SCHEMA IF NOT EXISTS `bank-system` DEFAULT CHARACTER SET utf8;
USE `bank-system`;

CREATE TABLE IF NOT EXISTS users
(
    id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    login VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    active   BOOLEAN      NOT NULL,
    role VARCHAR(100) NOT NULL
    )
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS banks
(
    id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
    )
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS managers
(
    id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    bank_id INT NOT NULL,
    user_id INT NOT NULL,

    FOREIGN KEY (bank_id) REFERENCES banks (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
    )
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS companies
(
    id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    bank_id INT NOT NULL,
    type VARCHAR(100) NOT NULL,
    name VARCHAR(255) NOT NULL,
    unp VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,

    FOREIGN KEY (bank_id) REFERENCES banks (id)
    )
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS salary_projects
(
    id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    company_id INT NOT NULL,
    name VARCHAR(255) NOT NULL,

    FOREIGN KEY (company_id) REFERENCES companies (id)
    )
    ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS clients
(
    id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    surname VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    passport_id VARCHAR(255) NOT NULL,
    identity_number INT NOT NULL,
    telephone VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    company_id INT NOT NULL,

    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (company_id) REFERENCES companies (id)

    )
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS client_bank
(
    client_id INT NOT NULL,
    bank_id INT NOT NULL,

    FOREIGN KEY (client_id) REFERENCES clients (id),
    FOREIGN KEY (bank_id) REFERENCES banks (id),

    UNIQUE (client_id, bank_id)
    )
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS company_accounts
(
    id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    company_id INT NOT NULL,
    bank_id INT NOT NULL,
    balance INT NOT NULL,
    currency_type VARCHAR(255) NOT NULL,

    FOREIGN KEY (company_id) REFERENCES companies (id),
    FOREIGN KEY (bank_id) REFERENCES banks (id)
    )
    ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS client_accounts
(
    id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    client_id INT NOT NULL,
    bank_id INT NOT NULL,
    balance INT NOT NULL,
    currency_type VARCHAR(255) NOT NULL,

    FOREIGN KEY (client_id) REFERENCES clients (id),
    FOREIGN KEY (bank_id) REFERENCES banks (id)
    )
    ENGINE = InnoDB;
