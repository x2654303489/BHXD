CREATE TABLE Products
(
    ProductID     INT AUTO_INCREMENT PRIMARY KEY,
    ProductName   VARCHAR(255)   NOT NULL,
    Description   TEXT,
    Price         DECIMAL(10, 2) NOT NULL,
    StockQuantity INT            NOT NULL,
    ImageURL      VARCHAR(255),
    CategoryID    INT NOT NULL,
    UserID        INT NOT NULL,
    Status        ENUM ('NotShelves', 'Audit','Shelves') DEFAULT 'NotShelves',
    CreateTime    DATETIME DEFAULT CURRENT_TIMESTAMP,
    UpdateTime    DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (CategoryID) REFERENCES Categories (CategoryID),
    FOREIGN KEY (UserID) REFERENCES users (UserID)
);  