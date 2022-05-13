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