# Write your MySQL query statement below
SELECT email as Email FROM (SELECT email, count(*) as count FROM Person GROUP BY email) as g WHERE g.count > 1;