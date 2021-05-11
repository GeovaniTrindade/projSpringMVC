create database projDesafio01;
use projDesafio01;

create table USUARIO(
		IDUSUARIO	integer			auto_increment,
        NOME		varchar(150)	not null unique,
        CPF		    varchar(100)	not null unique,
        DATA_NASCIMENTO		Date	not null,          
        primary key(IDUSUARIO));
        
create table CARGO(	
		IDCARGO  	integer			auto_increment,
        GERENTE		  varchar(50)	not null,
        SUPERVISOR	  varchar(50)	not null,
        ADMINISTRADOR varchar(50)	not null,
        IDUSUARIO	integer			not null,  
        primary key(IDCARGO),
        foreign key(IDUSUARIO) references USUARIO(IDUSUARIO));
        
create table PERFIL(	
		IDPERFIL     integer			auto_increment,
        ADMINISTRADOR varchar(150)	not null,
        COMUM     varchar(150)	not null,
        USUARIO	  varchar(150)	not null,            
        IDUSUARIO	integer			not null,
        primary key (IDPERFIL),
        foreign key(IDUSUARIO) references USUARIO(IDUSUARIO));   
        
select * from usuario;        
drop database projDesafio01;        