DROP DATABASE IF EXISTS Shop;
CREATE DATABASE Shop;
USE Shop;
CREATE TABLE T_Articles (
IdArticle int(4) PRIMARY KEY AUTO_INCREMENT,
Description varchar(30) NOT NULL,
Brand varchar(30) NOT NULL,
UnitaryPrice float(8) NOT NULL
) ENGINE = InnoDB;
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ('Souris', 'Logitoch', 65);
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ('Clavier', 'Microhard', 49.5);
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ('Systeme d''exploitation', 'Fenetres', 150);
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ('Tapis souris', 'Chapeau', 5);
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ('Cle USB 8 To', 'Syno', 8);
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ('Webcam', 'Logitoch', 0);
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ('Casque Audio', 'Syno', 105);
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ('Office', 'Microsoft', 150);
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ('Galaxy S10', 'Samsung', 65);
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ('Macbook', 'Apple', 65);
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ('Galaxy S22', 'Samsung', 1234);
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ('Iphone50', 'Apple', 20000);
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ('Iphone11', 'Apple', 1126);