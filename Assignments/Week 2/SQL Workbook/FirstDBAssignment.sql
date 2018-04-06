
--2.1 Select

select * from employee;

select * from employee where employee.lastname = 'King';

select * from employee 
where employee.firstname = 'Andrew' 
and employee.reportsto is null;




--2.2 Order By

select * from album order by album.title desc;

select * from customer order by customer.firstname asc;




-- 2.3 Insert Into

insert into genre values (26, 'V A P O R W A V E');
insert into genre values (27, 'Trap');

insert into employee values(9, 'Jenkins', 'Leroy', 'Project Lead', 3, '25-FEB-65', '06-AUG-04', '50 North St', 'Tampa', 'FL', 'USA', 'T2P 5G3', '+1 (203) 363-4463', '+1 (203) 563-4463', 'leroy@chinookcorp.com');
insert into employee values(10, 'Bob', 'Ross', 'Supervisor', 3, '25-MAR-65', '06-SEP-04', '25 North St', 'Tampa', 'FL', 'USA', 'T2P 5G3', '+1 (203) 363-5073', '+1 (203) 563-5643', 'bob@chinookcorp.com'); 

insert into customer(customerid, firstname, lastname, email) values(60, 'Bob', 'Ross','null');
insert into customer(customerid, firstname, lastname, email)  values(61, 'Jamie', 'Danger', 'null');





--2.4 Update

update customer set customer.firstname = 'Robert', customer.lastname = 'Walter'
where customer.firstname = 'Aaron' and customer.lastname = 'Mitchell';

update artist set artist.name = 'CCR'
where artist.name = 'Creedence Clearwater Revival';





--2.5 Like
select * from invoice where invoice.billingaddress like '%T%';




-- 2.6 Between

select * from invoice where invoice.total < 50 and invoice.total > 15;

select * from employee where hiredate between '01-JUN-03' and '01-MAR-04';



--2.7 Delete

--delete from customer 




-- 7.1 Inner Join

