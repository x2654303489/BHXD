CREATE TABLE Orders
(
    OrderID        INT AUTO_INCREMENT PRIMARY KEY,
    UserID         INT            NOT NULL,
    OrderStatus    ENUM ('pending', 'paid', 'shipped', 'completed', 'cancelled') DEFAULT 'pending',
    TotalAmount    DECIMAL(10, 2) NOT NULL,
    CreateTime     DATETIME                                                      DEFAULT CURRENT_TIMESTAMP,
    PaymentTime    DATETIME,
    CompletionTime DATETIME,
    FOREIGN KEY (UserID) REFERENCES Users (UserID)
);  