DROP DATABASE IF EXISTS User;
CREATE DATABASE User;
USE Users;
CREATE TABLE T_Users (
IdUser int(4) PRIMARY KEY AUTO_INCREMENT,
Login varchar(20) NOT NULL,
Password varchar(20) NOT NULL
) ENGINE = InnoDB;

INSERT INTO T_Users (Login, Password) VALUES ('Dylandu93', '123456789');
INSERT INTO T_Users (Login, Password) VALUES ('RobertleRoutier', 'password');
INSERT INTO T_Users (Login, Password) VALUES ('LudovicLeGeek', 'geekman');