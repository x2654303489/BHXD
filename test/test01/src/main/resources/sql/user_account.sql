DROP TABLE IF EXISTS `user_account`;
CREATE TABLE `user_account`
(
    `id`           INT(11)      NOT NULL AUTO_INCREMENT,
    `username`     VARCHAR(255) NOT NULL,
    `userpassword` VARCHAR(255) NOT NULL,
    `permissions`  INT,
    PRIMARY KEY (`id`),
    UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

INSERT INTO `user_account` (`username`, `userpassword`, `permissions`)
VALUES ('admin', '123456', 1);