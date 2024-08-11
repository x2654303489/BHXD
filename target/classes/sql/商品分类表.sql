CREATE TABLE Categories
(
    CategoryID       INT AUTO_INCREMENT PRIMARY KEY,
    CategoryName     VARCHAR(255) NOT NULL,
    State            INT      NOT NULL DEFAULT 0,
    ParentCategoryID INT,
    CreateTime       DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (ParentCategoryID) REFERENCES Categories (CategoryID)
);  