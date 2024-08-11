CREATE TABLE Payments
(
    PaymentID     INT AUTO_INCREMENT PRIMARY KEY,
    OrderID       INT                         NOT NULL,
    PaymentAmount DECIMAL(10, 2)              NOT NULL,
    PaymentStatus ENUM ('success', 'failure') NOT NULL,
    PaymentTime   DATETIME DEFAULT CURRENT_TIMESTAMP,
    PaymentMethod VARCHAR(50),
    FOREIGN KEY (OrderID) REFERENCES Orders (OrderID)
);