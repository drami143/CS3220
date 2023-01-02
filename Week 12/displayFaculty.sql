drop table if exists displayFaculty;

create table displayFaculty(
	id		integer auto_increment primary key,
	name	varchar(255),
	isChair	varchar(255)
);

insert into displayFaculty (name, isChair) values ('Computer Science', '');
insert into displayFaculty (name, isChair) values ('Electrical and Computer Engineering', '');
