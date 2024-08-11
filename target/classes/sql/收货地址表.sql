CREATE TABLE Addresses
(
    AddressID       INT AUTO_INCREMENT PRIMARY KEY,
    UserID          INT          NOT NULL,
    RecipientName   VARCHAR(255) NOT NULL,
    PhoneNumber     VARCHAR(20),
    Province        VARCHAR(100),
    City            VARCHAR(100),
    DetailedAddress TEXT         NOT NULL,
    IsDefault       BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (UserID) REFERENCES Users (UserID)
);  