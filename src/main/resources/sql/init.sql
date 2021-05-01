create database if not exists atm ;
use atm;
create table if not exists user (
    id int auto_increment primary key not null ,
    name varchar(20) not null,
    pwd varchar(20) not null,
    user_id varchar(20) not null,
    deposit int not null
);

create table if not exists cash (
    id int auto_increment primary key not null ,
    value int not null ,
    amount int not null
);

insert into cash values (1,1000,2);
insert into cash values (2,500,3);
insert into cash values (3,100,5);

