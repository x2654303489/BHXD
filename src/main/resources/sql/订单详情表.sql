CREATE TABLE OrderDetails
(
    DetailID  INT AUTO_INCREMENT PRIMARY KEY,
    OrderID   INT            NOT NULL,
    ProductID INT            NOT NULL,
    Quantity  INT            NOT NULL,
    UnitPrice DECIMAL(10, 2) NOT NULL, -- 记录订单创建时的价格  
    FOREIGN KEY (OrderID) REFERENCES Orders (OrderID),
    FOREIGN KEY (ProductID) REFERENCES Products (ProductID)
);  