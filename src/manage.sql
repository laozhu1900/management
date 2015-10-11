create database management;

create database management character set gbk collate gbk_general_ci;

create table users(
		id varchar(40) primary key  ,
		name varchar(40) not null unique,
		password varchar(80) not null,
		cellphone varchar(80) not null,
		email varchar(40) not null,
		address varchar(255) not null,
		position varchar(80) not null,
		limitation varchar(80) 
	);
	
	insert into user(id,name,password,cellphone,email,address,position,limitation) values("1001","admin","admin","111111","111111@qq.com","江苏师大","总经理","admin");
	insert into user(id,name,password,cellphone,email,address,position,limitation) values("1002","zzx","111111","111111","111111@qq.com","江苏师大","部门经理","haha");
	insert into user(id,name,password,cellphone,email,address,position,limitation) values("1003","zzj","111111","111111","111111@qq.com","江苏师大","部门经理","haha");
	
create table customers(
	id varchar(40) primary key,
	name varchar(40) not null unique,
	charger varchar(60),
	type varchar(10),
	cellphone varchar(60) not  null,
	level varchar(40) not null,
	introduction varchar(255) 
);

create table orders(
	id varchar(40) primary key,
	name varchar(60) not null,
	price decimal(8,2) not null,
	customer_name varchar(40) not null,
	user_name varchar(40) not null,
	introduction varchar(255) 
);



