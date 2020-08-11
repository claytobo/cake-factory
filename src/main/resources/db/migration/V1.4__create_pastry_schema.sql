create table if not exists addresses(
	email varchar(50) not null primary key,
	firstname varchar(20) not null,
	lastname varchar(20) not null,
	street varchar(50) not null,
	city varchar(50) not null,
	state varchar(50) not null,
	zip varchar(10) not null
);
