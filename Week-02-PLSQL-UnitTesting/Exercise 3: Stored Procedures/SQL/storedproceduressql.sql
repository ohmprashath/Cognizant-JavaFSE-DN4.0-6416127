-- scenario 1
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
  UPDATE Accounts
  SET Balance = Balance + (Balance * 0.01),
      LastModified = SYSDATE
  WHERE AccountType = 'Savings';
END;
/

EXEC ProcessMonthlyInterest;

SELECT * FROM Accounts;

-- scenario 2

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
  dept IN VARCHAR2,
  bonus_pct IN NUMBER
) AS
BEGIN
  UPDATE Employees
  SET Salary = Salary + (Salary * bonus_pct / 100)
  WHERE Department = dept;
END;
/

EXEC UpdateEmployeeBonus('IT', 10);

SELECT * FROM Employees;

-- scenario 3

CREATE OR REPLACE PROCEDURE TransferFunds(
  from_acc IN NUMBER,
  to_acc IN NUMBER,
  amt IN NUMBER
) AS
  from_balance NUMBER;
BEGIN
  SELECT Balance INTO from_balance FROM Accounts WHERE AccountID = from_acc FOR UPDATE;

  IF from_balance >= amt THEN
    UPDATE Accounts
    SET Balance = Balance - amt,
        LastModified = SYSDATE
    WHERE AccountID = from_acc;

    UPDATE Accounts
    SET Balance = Balance + amt,
        LastModified = SYSDATE
    WHERE AccountID = to_acc;
  END IF;
END;
/

EXEC TransferFunds(1, 2, 500);

SELECT * FROM Accounts;
