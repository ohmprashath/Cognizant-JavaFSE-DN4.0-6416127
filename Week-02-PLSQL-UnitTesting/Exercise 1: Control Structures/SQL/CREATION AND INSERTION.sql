CREATE TABLE Customers (
CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    DOB DATE,
    Balance NUMBER,
    LastModified DATE
);

CREATE TABLE Accounts (
AccountID NUMBER PRIMARY KEY,
CustomerID NUMBER,
AccountType VARCHAR2(20),
    Balance NUMBER,
    LastModified DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Transactions (
TransactionID NUMBER PRIMARY KEY,
AccountID NUMBER,
TransactionDate DATE,
    Amount NUMBER,
TransactionType VARCHAR2(10),
    FOREIGN KEY (AccountID) REFERENCES Accounts(AccountID)
);

CREATE TABLE Loans (
LoanID NUMBER PRIMARY KEY,
CustomerID NUMBER,
LoanAmount NUMBER,
InterestRate NUMBER,
    StartDate DATE,
EndDate DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Employees (
EmployeeID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    Position VARCHAR2(50),
    Salary NUMBER,
    Department VARCHAR2(50),
HireDate DATE
); 


INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified) VALUES (1, 'Abhishek Kumar', TO_DATE('2000-06-10', 'YYYY-MM-DD'), 1200, SYSDATE);
INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified) VALUES (2, 'Vignesh Raj', TO_DATE('1999-09-21', 'YYYY-MM-DD'), 1800, SYSDATE);
INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified) VALUES (3, 'Arul Selvan', TO_DATE('2001-03-14', 'YYYY-MM-DD'), 3500, SYSDATE);
INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified) VALUES (4, 'Divya Nair', TO_DATE('1998-11-02', 'YYYY-MM-DD'), 2700, SYSDATE);
INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified) VALUES (5, 'Neha Singh', TO_DATE('2002-01-25', 'YYYY-MM-DD'), 4200, SYSDATE);

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified) VALUES (1, 1, 'Savings', 11200, SYSDATE);
INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified) VALUES (2, 2, 'Current', 1800, SYSDATE);
INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified) VALUES (3, 3, 'Savings', 3500, SYSDATE);
INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified) VALUES (4, 4, 'Current', 2700, SYSDATE);
INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified) VALUES (5, 5, 'Savings', 41200, SYSDATE);

INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType) VALUES (1, 1, SYSDATE, 300, 'Deposit');
INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType) VALUES (2, 2, SYSDATE, 400, 'Withdrawal');
INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType) VALUES (3, 3, SYSDATE, 600, 'Deposit');
INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType) VALUES (4, 4, SYSDATE, 350, 'Withdrawal');
INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType) VALUES (5, 5, SYSDATE, 700, 'Deposit');

INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate) VALUES (1, 1, 6000, 5, SYSDATE, ADD_MONTHS(SYSDATE, 48));
INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate) VALUES (2, 3, 12000, 6, SYSDATE, ADD_MONTHS(SYSDATE, 72));
INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate) VALUES (3, 5, 8000, 5.5, SYSDATE, ADD_MONTHS(SYSDATE, 60));

INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate) VALUES (1, 'Kavitha Raj', 'Manager', 75000, 'HR', TO_DATE('2018-01-15', 'YYYY-MM-DD'));
INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate) VALUES (2, 'Vikram Iyer', 'Developer', 65000, 'IT', TO_DATE('2019-05-20', 'YYYY-MM-DD'));
INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate) VALUES (3, 'Sneha Reddy', 'Analyst', 58000, 'Finance', TO_DATE('2020-08-10', 'YYYY-MM-DD'));
INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate) VALUES (4, 'Ajay Kumar', 'Support Engineer', 52000, 'IT', TO_DATE('2021-03-25', 'YYYY-MM-DD'));








