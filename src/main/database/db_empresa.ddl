alter table dir_direccion drop foreign key FK_direccion_localidad;
alter table dir_localidad drop foreign key FK_localidad_provincia;

alter table empresa drop foreign key FK_empresa_direccion;
alter table empresa_rubro drop foreign key FK_empresa_rubro;
alter table empresa_rubro drop foreign key FK_rubro_empresa;

alter table empresa_contacto drop foreign key FK_empresa_contacto;
alter table empresa_contacto drop foreign key FK_contacto_empresa;

drop table dir_provincia, dir_localidad, dir_direccion;
drop table rubro, empresa_rubro, empresa;
drop table contacto, empresa_contacto;

create table dir_direccion (
	id_direccion bigint not null auto_increment,
	calle varchar(255),
	localidad_id bigint,
	primary key (id_direccion)
);

create table dir_localidad (
	id_localidad bigint not null auto_increment,
	nombre varchar(255),
	codigo_postal INT NOT NULL,
	provincia_id bigint,
	primary key (id_localidad)
);

create table dir_provincia (
	id_provincia bigint not null auto_increment,
      nombre varchar(255),
      primary key (id_provincia)
);

alter table dir_direccion add constraint FK_direccion_localidad
		foreign key (localidad_id) references dir_localidad (id_localidad);

alter table dir_localidad add constraint FK_localidad_provincia 
		foreign key (provincia_id) references dir_provincia (id_provincia);
		

CREATE TABLE empresa (
	id_empresa bigint not null auto_increment,
	cuit VARCHAR(255),
	nombre VARCHAR(255),
	observacion VARCHAR(255),
	razon_social VARCHAR(255),
	direccion_id BIGINT NOT NULL,
	PRIMARY KEY (id_empresa)
);

CREATE TABLE rubro (
	id_rubro bigint not null auto_increment,
	nombre VARCHAR(15),
	descripcion VARCHAR(255),
	PRIMARY KEY (id_rubro)
);

CREATE TABLE empresa_rubro (
        id_empresa bigint not null,
        id_rubro bigint not null
);
alter table empresa_rubro add constraint FK_empresa_rubro
		foreign key (id_empresa) references empresa (id_empresa);
alter table empresa_rubro add constraint FK_rubro_empresa
		foreign key (id_rubro) references rubro (id_rubro);
		
alter table empresa add constraint FK_empresa_direccion
		foreign key (direccion_id) references dir_direccion (id_direccion);
		

CREATE TABLE contacto (
	id_contacto bigint not null auto_increment,
	tipo INT,
	dato VARCHAR(255),
	nombre VARCHAR(30),
	observacion VARCHAR(255),	
	PRIMARY KEY (id_contacto)
);		
CREATE TABLE empresa_contacto (
        id_empresa bigint not null,
        id_contacto bigint not null
);
alter table empresa_contacto add constraint FK_empresa_contacto
		foreign key (id_empresa) references empresa (id_empresa);
alter table empresa_contacto add constraint FK_contacto_empresa
		foreign key (id_contacto) references contacto (id_contacto);
		
insert into rubro values(1, 'Desconocido', 'Sin Rubro');		
insert into rubro values(2, 'Repuestos', '');	

insert into dir_provincia values(3, 'Chaco');
insert into dir_provincia values(20, 'Santa Fe');
insert into dir_provincia values(24, 'Desconociada');

insert into dir_localidad values (1, 'Desconocida', 9999, 24);
insert into dir_localidad values (2, 'Villa Minetti', 3061, 20);
insert into dir_localidad values (4, 'Arequito', 2183, 20);
