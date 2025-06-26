SET SERVEROUTPUT ON;

-- SCENARIO 1-------------------------
BEGIN
  FOR cust_loan IN (
    SELECT l.LoanID, l.InterestRate, c.DOB, c.CustomerID
    FROM Loans l
    JOIN Customers c ON l.CustomerID = c.CustomerID
  ) LOOP
    IF FLOOR(MONTHS_BETWEEN(SYSDATE, cust_loan.DOB) / 12) > 60 THEN
      UPDATE Loans
      SET InterestRate = InterestRate - 1
      WHERE LoanID = cust_loan.LoanID;

      DBMS_OUTPUT.PUT_LINE('Loan ' || cust_loan.LoanID || ': Interest rate reduced by 1% for Customer ' || cust_loan.CustomerID);
    END IF;
  END LOOP;
  COMMIT;
END;
/

SELECT l.LoanID, c.Name, l.InterestRate
FROM Loans l
JOIN Customers c ON l.CustomerID = c.CustomerID
ORDER BY l.LoanID;

--- SCENARIO 2------------

DECLARE
  v_count NUMBER;
BEGIN
  SELECT COUNT(*) INTO v_count
  FROM user_tab_columns
  WHERE table_name = 'CUSTOMERS'
    AND column_name = 'ISVIP';

  IF v_count = 0 THEN
    EXECUTE IMMEDIATE 'ALTER TABLE ADD ISVIP';
  END IF;
END;
/

SET SERVEROUTPUT ON;

BEGIN
  UPDATE Customers
  SET IsVIP = CASE WHEN Balance > 10000 THEN 'TRUE' ELSE 'FALSE' END;

  COMMIT;

  FOR cust IN (SELECT CustomerID, Name FROM Customers WHERE IsVIP = 'TRUE') LOOP
    DBMS_OUTPUT.PUT_LINE('Customer ' || cust.CustomerID || ' (' || cust.Name || ') marked as VIP');
  END LOOP;
END;
/

SELECT CustomerID, Name, Balance, IsVIP
FROM Customers
ORDER BY CustomerID;


-- SCENARIO 3 ----------------------------------
BEGIN
  FOR loan_info IN (
    SELECT l.LoanID, c.Name, l.EndDate
    FROM Loans l
    JOIN Customers c ON l.CustomerID = c.CustomerID
    WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30
  ) LOOP
    DBMS_OUTPUT.PUT_LINE('Reminder: Loan ' || loan_info.LoanID || ' for ' || loan_info.Name || ' is due on ' || TO_CHAR(loan_info.EndDate, 'DD-MON-YYYY'));
  END LOOP;
END;  
/

SELECT l.LoanID, c.Name, l.LoanAmount, l.EndDate
FROM Loans l
JOIN Customers c ON l.CustomerID = c.CustomerID
ORDER BY l.EndDate;
