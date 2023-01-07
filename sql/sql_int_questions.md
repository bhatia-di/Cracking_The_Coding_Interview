# SQL interview questions
Reference 1:
https://www.toptal.com/sql/interview-questions
https://leetcode.com/list/e97a9e5m/

Different Types of SQL JOINs
Here are the different types of the JOINs in SQL:

* (INNER) JOIN: Returns records that have matching values in both tables 
* LEFT (OUTER) JOIN: Returns all records from the left table, and the matched records from the right table
* RIGHT (OUTER) JOIN: Returns all records from the right table, and the matched records from the left table
* FULL (OUTER) JOIN: Returns all records when there is a match in either left or right table


# STRING CHECKS IN SQL
LIKE and the equality operator have different purposes, they don't do the same thing:
= is much faster, whereas LIKE can interpret wildcards. Use = wherever you can and LIKE wherever you must.
```
SELECT * FROM user WHERE login LIKE 'Test%';
```

# NOT equal in sql;
```
SELECT name FROM customer WHERE referee_Id <> 2;
SELECT name FROM customer WHERE referee_Id != 2;
```

**Note: This where clause will not bring the null values. i.e if there are any columns with referee_Id == null then those rows WILL NOT be included in the result** 

Why are null values not included?
MySQL uses three-valued logic -- TRUE, FALSE and UNKNOWN. 
Anything compared to NULL evaluates to the third value: UNKNOWN. 
That “anything” includes NULL itself! That’s why MySQL provides the IS NULL and 
IS NOT NULL operators to specifically check for NULL.

**That is why be careful while using where and beware of the logic if null values are required in the result**

## Case based statement
```
SELECT OrderID, Quantity,
CASE
WHEN Quantity > 30 THEN "The quantity is greater than 30"
WHEN Quantity = 30 THEN "The quantity is 30"
ELSE "The quantity is under 30"
END
FROM OrderDetails;
```


## How to create a computed column?
```
select  employee_id,
(CASE
WHEN MOD(employee_id, 2) <> 0 AND name NOT LIKE 'M%'
THEN salary
ELSE 0 END) as bonus from Employees order by employee_id;
```