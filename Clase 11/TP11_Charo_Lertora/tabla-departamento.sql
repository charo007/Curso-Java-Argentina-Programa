use qatar2022;

create table departamento (
	NroDep int(5) not null,
    DepNombre varchar(30) not null,
    DepPresumuesto decimal(4,2) not null,
	primary key (NroDep)
) engine = InnoDB;
