/*
--lga_pid is the unique id for a council
--lga_pid coems from the JSON file features.properties.lga_pid
*/

-- HOME > Council / council and bin details
select      
       l.lga_name
      ,l.recycle_bin 
      ,l.rubbish_bin 
FROM lga l
WHERE l.lga_pid = 'VIC251';


-- HOME> Council / Can be Recycled
select 
      p.product_id
    , p.product
    , p.image_small
from lga_product lp
 inner join product p on
     lp.product_id = p.product_id
where lp.lga_pid = 'VIC251'
and lp.is_accepted = 1;


-- HOME > Council / Can NOT be Recycled
select 
      p.product_id
    , p.product
    , p.image_small
from lga_product lp
 inner join product p on
     lp.product_id = p.product_id
where lp.lga_pid = 'VIC251'
and lp.is_accepted = 0;

--HOME > COUNCIL > Product / Council and Product details
select 
      l.lga_name
    , p.product
    , p.image -- larger image
    , lp.is_accepted -- 1 can be recycled; 0 cannot
from lga l
 inner join lga_product lp on 
    l.lga_pid = lp.lga_pid
 inner join product p on
     lp.product_id = p.product_id
where lp.lga_pid = 'VIC251'
and p.product_id = 3;

--HOME > COUNCIL > Product / Recycling instructions
select product_point 
from product_point pp
where point_type = 'instruction'
and pp.product_id = 1
order by sequence;

--HOME > COUNCIL > Product / did you know 
select product_point 
from product_point pp
where point_type = 'note'
and pp.product_id = 1
order by sequence;


