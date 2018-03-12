select * from users;

create table users(
id  VARCHAR2(8) NOT NULL,
password VARCHAR2(8),
name VARCHAR2(20),
role VARCHAR2(5)
);

--test test123 관리자 Admin 
insert into users(id,password,name,role) 
           values('test','test123','관리자','Admin');
select * from users;           