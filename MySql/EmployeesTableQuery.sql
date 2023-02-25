create table Employee
(
Employee_id int auto_increment primary key,
Employee_first_name varchar(500) NOT null,
Employee_last_name varchar(500) NOT null,
Employee_City varchar(1000),
Employee_emailID varchar(500),
Employee_Joining_date date 
);

insert into Employee values
(1,"Harsh","Pandya","Mumbai","harsh@gmail.com",current_date()),
(2,"Meet","Pandya","Mumbai","meet@gmail.com",current_date()),
(3,"Hardik","Pandya","Mumbai","hardik@gmail.com",current_date());

Select * from Employee where Employee_id =1; 
Select * from Employee where Employee_first_name="Harsh";
