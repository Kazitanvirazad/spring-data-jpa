-- Database name = oracleemployee [mysql database]

create database oracleemployee;

use oracleemployee;

create table dept(   
  deptno     int,   
  dname      varchar(14),   
  loc        varchar(13),   
  constraint pk_dept primary key (deptno)   
);

create table emp(   
  empno    int,  
  ename    varchar(10),   
  job      varchar(9),   
  mgr      int, 
  hiredate date,   
  sal      int,  
  comm     int,   
  deptno   int,   
  constraint pk_emp primary key (empno),   
  constraint fk_deptno foreign key (deptno) references dept (deptno)   
);

-- Database name = superhero [postgres database]

create table dchero(
	hid int,
    hname varchar(100),
    hpower varchar(100),
	constraint pk_emp primary key (hid)
);
 insert into dchero (hid,hname,hpower) values
(100,'Batman','Money & Science'),
(101,'Flash','Speed'),
(102,'Superman','Super natural power'),
(103,'Catwoman','Thief'),
(104,'Joker','Madness');


create table laptop(
	lid int,
	laptopBrand varchar(100),
	processor varchar(100),
	laptopModelName varchar(100),
	empno int,
	constraint pk_laptop primary key (lid)
);

insert into laptop (lid,laptopBrand,processor,laptopModelName,empno) values
(101,'Dell','Intel i7 8th Gen vpro','Latitude 5591',7369),(102,'HP','Intel i5 8th Gen','Elitebook',7788),(103,'Sony','Intel i3 2nd Gen','Vaio vpceh35en',7876),(104,'MSI','Intel i7 8th Gen','GL63 8RD-450IN',7566),(105,'Asus','Intel i7 8th Gen','Latitude 5591',7902),(106,'Lenovo','Intel i5 8th Gen','Thinkpad T590',7839),(107,'Lenovo','Intel i5 12th Gen','ThinkBook 14 12th Gen',7782);