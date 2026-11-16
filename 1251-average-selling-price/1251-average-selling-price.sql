# Write your MySQL query statement below
select  p.product_id,ROUND(coalesce(SUM(s.units * p.price) / SUM(s.units),0), 2) AS average_price
from Prices p left join UnitsSold s
on p.product_id =s.product_id
and purchase_date>=start_date and purchase_date<=end_date
group by p.product_id;