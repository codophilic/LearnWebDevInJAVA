-- create database UserDetailsDB

create table user
(
user_name varchar(500) primary key,
user_password varchar(500) NOT null
);

insert into user values
("Harsh","harshpandya"),
("Meet","meetpandya");

Select * from user where user_name='JIM';

Select * from user;
DELETE from user WHERE user_name IN ("as","a","hey","Harsh");
