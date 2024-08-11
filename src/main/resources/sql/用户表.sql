CREATE TABLE Users
(
    UserID        INT AUTO_INCREMENT PRIMARY KEY,
    Username      VARCHAR(255) NOT NULL UNIQUE,
    Password      VARCHAR(255) NOT NULL, -- 在实际应用中，密码应加密存储
    Email         VARCHAR(255),
    PhoneNumber   VARCHAR(20),
    RegisterTime  DATETIME                    DEFAULT CURRENT_TIMESTAMP,
    LastLoginTime DATETIME,
    Status        ENUM ('active', 'disabled') DEFAULT 'active'
);  