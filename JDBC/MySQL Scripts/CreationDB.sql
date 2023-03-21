# create database employees

create table Employee
(
Employee_id int auto_increment primary key,
Employee_name varchar(500) NOT null
);

insert into Employee values
(1,"Harsh"),
(2,"Meet"),
(3,"Hardik");


Select * from Employee where Employee_id =1; 
Select * from Employee where Employee_name="Harsh";

