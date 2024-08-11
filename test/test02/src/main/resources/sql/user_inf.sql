DROP TABLE IF EXISTS `users_inf`;
CREATE TABLE users_inf
(
    id     Int(11) PRIMARY KEY AUTO_INCREMENT,
    email  VARCHAR(50),
    gender CHAR(1),
    age    INT
);
INSERT INTO 'users_inf'
VALUES (1, '123456789@qq.com', 'nan')