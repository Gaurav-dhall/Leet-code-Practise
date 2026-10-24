# Write your MySQL query statement below
SELECT w1.id
FROM Weather w1
inner join 
Weather w2

WHERE DATEDIFF(w1.recordDate,w2.RecordDate)=1
AND 
w1.temperature>w2.temperature;