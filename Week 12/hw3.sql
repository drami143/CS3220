drop table if exists students;

create table students (

name             varchar(255),
age              integer,
parent           varchar(255),
email            varchar(255),
groups           varchar(255)
);

insert into students values ('John', 4, 'Sue', 'sue@gmail.com', 'Minnows');
insert into students values ('Jane', 9, 'Sue', 'sue@gmail.com', 'Dolphines');
insert into students values ('Luke', 4, 'Josue', 'steve@gmail.com', 'Minnows');
insert into students values ('Tina', 7, 'Paula' ,'paula@gmail.com', '');

drop table if exists g;

create table g(
	g	varchar(255),
	members	varchar(255)
);

insert into g values ('Dolphines', 'Jane');
insert into g values ('Minnows', 'Luke, John');
insert into g values ('', 'Tina');

