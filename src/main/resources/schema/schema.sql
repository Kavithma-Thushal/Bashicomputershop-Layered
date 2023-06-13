DROP DATABASE IF EXISTS computershop;
CREATE DATABASE computershop;
USE computershop;

CREATE TABLE customerDTO
(
    id      VARCHAR(5),
    name    VARCHAR(50) NOT NULL,
    nic     VARCHAR(12) NOT NULL UNIQUE,
    email   VARCHAR(50),
    contact VARCHAR(12),
    address VARCHAR(50) NOT NULL,
    CONSTRAINT PRIMARY KEY (id)
);

CREATE TABLE employeeDTO
(
    id       VARCHAR(5),
    name     VARCHAR(50) NOT NULL,
    contact  VARCHAR(12) NOT NULL,
    jobRole  VARCHAR(20) NOT NULL,
    username VARCHAR(20) NOT NULL UNIQUE,
    password VARCHAR(20) NOT NULL UNIQUE,
    CONSTRAINT PRIMARY KEY (id)
);

CREATE TABLE supplier
(
    id      VARCHAR(5),
    name    VARCHAR(50) NOT NULL,
    contact VARCHAR(12) NOT NULL,
    address VARCHAR(50) NOT NULL,
    CONSTRAINT PRIMARY KEY (id)
);

CREATE TABLE itemDTO
(
    code        VARCHAR(5),
    description VARCHAR(100),
    unitPrice   DECIMAL NOT NULL,
    qtyOnHand   INT     NOT NULL,
    CONSTRAINT PRIMARY KEY (code)
);

CREATE TABLE salaryDTO
(
    code       VARCHAR(5),
    employeeId VARCHAR(5) NOT NULL,
    amount     DECIMAL    NOT NULL,
    date       DATE,
    CONSTRAINT PRIMARY KEY (code),
    CONSTRAINT FOREIGN KEY (employeeId) REFERENCES employeeDTO (id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE orders
(
    orderId    VARCHAR(5),
    customerId VARCHAR(5) NOT NULL,
    CONSTRAINT PRIMARY KEY (orderId),
    CONSTRAINT FOREIGN KEY (customerId) REFERENCES customerDTO (id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE buildDTO
(
    code       VARCHAR(5),
    customerId VARCHAR(5) NOT NULL,
    employeeId VARCHAR(5) NOT NULL,
    CONSTRAINT PRIMARY KEY (code),
    CONSTRAINT FOREIGN KEY (customerId) REFERENCES customerDTO (id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FOREIGN KEY (employeeId) REFERENCES employeeDTO (id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE repairs
(
    code       VARCHAR(5),
    customerId VARCHAR(5) NOT NULL,
    employeeId VARCHAR(5) NOT NULL,
    details    VARCHAR(100),
    getDate    DATE       NOT NULL,
    acceptDate DATE,
    CONSTRAINT PRIMARY KEY (code),
    CONSTRAINT FOREIGN KEY (employeeId) REFERENCES employeeDTO (id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FOREIGN KEY (customerId) REFERENCES customerDTO (id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE deliveryDTO
(
    code       VARCHAR(5),
    customerId VARCHAR(5)  NOT NULL,
    employeeId VARCHAR(5)  NOT NULL,
    orderId    VARCHAR(5)  NOT NULL,
    location   VARCHAR(50) NOT NULL,
    date       DATE        NOT NULL,
    CONSTRAINT PRIMARY KEY (code),
    CONSTRAINT FOREIGN KEY (employeeId) REFERENCES employeeDTO (id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FOREIGN KEY (customerId) REFERENCES customerDTO (id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FOREIGN KEY (orderId) REFERENCES orders (orderId) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE order_details
(
    orderId  VARCHAR(5) NOT NULL,
    itemCode VARCHAR(5) NOT NULL,
    qty      INT        NOT NULL,
    total    DECIMAL,
    date     DATE,
    CONSTRAINT PRIMARY KEY (orderId, itemCode),
    CONSTRAINT FOREIGN KEY (orderId) REFERENCES orders (orderId) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FOREIGN KEY (itemCode) REFERENCES itemDTO (code) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE supplier_details
(
    supplierId VARCHAR(5) NOT NULL,
    itemCode   VARCHAR(5) NOT NULL,
    qty        INT,
    date       DATE,
    CONSTRAINT PRIMARY KEY (supplierId, itemCode),
    CONSTRAINT FOREIGN KEY (supplierId) REFERENCES supplier (id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FOREIGN KEY (itemCode) REFERENCES itemDTO (code) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE build_details
(
    buildCode VARCHAR(5) NOT NULL,
    itemCode  VARCHAR(5) NOT NULL,
    qty       INT        NOT NULL,
    total     DECIMAL,
    date      DATE,
    CONSTRAINT PRIMARY KEY (buildCode, itemCode),
    CONSTRAINT FOREIGN KEY (buildCode) REFERENCES buildDTO (code) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FOREIGN KEY (itemCode) REFERENCES itemDTO (code) ON DELETE CASCADE ON UPDATE CASCADE
);
