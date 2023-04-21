use qatar2022;

create table empleados(
	EmpDNI int(10) not null,
    EmpNombre varchar(30) not null,
    EmpApellido varchar(30) not null,
    EmpNacionalidad varchar(30) not null,
    primary key (EmpDNI),
    EmpDepartamento int(5), 
    foreign key(EmpDepartamento) references departamento(NroDep) on delete no action on update no action
) engine = InnoDB;