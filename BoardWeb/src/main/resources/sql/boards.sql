select * from BOARD3;
create table board3(
seq number(5) primary key,
title varchar2(200),
writer varchar2(20),
content varchar2(2000),
regdate date,
cnt number(5)
);
insert into board3 values(1,'가입인사','관리자','잘 부탁드립니다.~~ ','2018-02-13', 0); 
insert into board3 values(2,'임시 제목','홍길동','임시내용............ ','2018-02-13', 0);  
insert into board3 values(3,'임시 제목','홍길동',' 임시내용............ ','2018-02-14', 0);  
insert into board3 values(4,'임시 제목',' 홍길동',' 임시내용............ ','2018-02-14', 0);  
insert into board3 values(5,'임시 제목',' 홍길동',' 임시내용............ ','2018-02-14', 0);  
insert into board3 values(6,'임시제목 수정','홍길동',' 임시내용 수정...... ','2018-02-14', 0);  
insert into board3 values(7,'임시 제목',' 홍길동',' 임시내용............ ','2018-02-14', 0);  
insert into board3 values(8,'임시제목 수정 ','홍길동',' 임시내용 수정...... ','2018-02-14', 0);  
insert into board3 values(9,'임시제목 수정 ','홍길동',' 임시내용 수정...... ','2018-02-14', 0);  
insert into board3 values(10,'임시 제목 ','홍길동',' 임시내용............ ','2018-02-14', 0);  
insert into board3 values(11,'임시제목 수정 ','임시내용',' 수정...... 2 ','2018-02-14', 0);  
insert into board3 values(12,'임시 제목 ','홍길동',' 임시내용............ ','2018-02-14', 0);  
insert into board3 values(13,'임시제목 수정 ','임시내용',' 수정...... 4 ','2018-02-14', 0);  
insert into board3 values(14,'임시 제목 ','홍길동','임시내용............ ','2018-02-14', 0); 

select * from board3;