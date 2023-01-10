# SQL interview questions
Reference 1:
https://www.toptal.com/sql/interview-questions
https://leetcode.com/explore/learn/card/sql-language
https://leetcode.com/study-plan/sql/?progress=xi2csy6m
https://docs.google.com/spreadsheets/d/1GOO4s1NcxCR8a44F0XnsErz5rYDxNbHAHznu4pJMRkw/edit#gid=0


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

## assign a value in select
- create a case based statement as above
- write an if statement
- ```
  SELECT
  IF (Grade >= 8, Name, NULL),
  Grade,
  Marks
  FROM
  (SELECT
  Name,
  (SELECT Grade FROM Grades WHERE (Min_Mark <= Marks) AND (Marks <= Max_Mark)) AS Grade,
  Marks
  FROM Students) As MyStudents
  ORDER BY Grade DESC, Name;
  ```
  

## dynamic order by
```
SELECT
Case when G.Grade < 8 THEN NULL ELSE S.Name END,
G.Grade,
S.Marks
FROM
Students AS S
INNER JOIN
Grades As G
ON S.Marks BETWEEN G.Min_Mark and G.Max_Mark
ORDER BY

    G.Grade DESC,
    Case when G.Grade < 8 THEN NULL ELSE S.Name END,    
    Case when G.Grade < 8 THEN S.Marks else 0 end

;
```


## Distinct records

```
SELECT DISTINCT age FROM `new_schema`.`users`;
```

## Limit and offset
will show 3 records after skipping 6 records

```
SELECT * FROM `new_schema`.`users` LIMIT 3 OFFSET 6;
```

## Multi-column sorting
```
SELECT * FROM `new_schema`.`users` ORDER BY age DESC, height DESC;
```

## Aggregate functions

```
#returns row count of satisfying condition
SELECT COUNT(*) AS `user_count` FROM `new_schema`.`users` WHERE id > 1;

SELECT SUM(`age`) AS `sum_of_user_ages` FROM `new_schema`.`users`;
SELECT AVG(`height`) AS `avg_user_height` FROM `new_schema`.`users`;
SELECT MIN(`height`) AS `user_min` FROM `new_schema`.`users`;
SELECT MAX(`height`) AS `user_max` FROM `new_schema`.`users`;
SELECT CONCAT(`id`, '-', `name`) AS `identification`, `age` FROM `new_schema`.`users`;

```
- **Note: in the last example, can i do where identification like '%J%'**
  - This is **NO!**
  - **`where` could only be used with a column that exists in the Table**
  - Thats why inorder to do this, we have the sql clause `having`
  - ```SELECT CONCAT(`id`, '-', `name`) AS `identification`, `age` FROM `new_schema`.`users`
    HAVING `identification` LIKE '%J%';```
  - **Do not USE `HAVING` everywhere as its performance is less than `where`**
  - Try to use `where` as much as possible and restrict the use of `having` to wherever required
  

    

## Sign to use group by (when you have to perform distict on multiple columns)

## **The default ordering of ORDER is ascending order from small to large.**

## Get length of the string using SELECT LENGTH("abc") => 3

- The FLOOR() function returns the largest integer value that is smaller than or equal to a number.
- The CEILING() function returns the smallest integer value that is larger than or equal to a number.


