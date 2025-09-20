# Write your MySQL query statement below
SELECT p.lastName, p.firstName, a.city, a.state FROM Person as p
LEFT JOIN Address as a on p.personId = a.personId;