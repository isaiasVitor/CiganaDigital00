create database ciganadigital;

use ciganadigital;

drop table perguntas;

create table perguntas(
	id int(3) auto_increment,
	Pergunta varchar(250),
    alternativaA varchar(150),
    valorA int(2),
    alternativaB varchar(150),
    valorB int(2),
    alternativaC varchar(150) null,
    valorC int(2),
    alternativaD varchar(150) null,
    valorD int(2),
    primary key (id)
    );

insert into perguntas(Pergunta,alternativaA,valorA,alternativaB,valorb,alternativaC,valorC,alternativaD,valorD)
			values ('Enunciado Pergunta num 1','num1 A',10,'num1 B',5,'num1 C',3,'num1 D',6);

insert into perguntas(Pergunta,alternativaA,valorA,alternativaB,valorb,alternativaC,valorC,alternativaD,valorD)
			values ('Enunciado Pergunta num 2','num2 A',-4,'num2 B',-5,'num2 C',-3,'num2 D',-6);
            
insert into perguntas(Pergunta,alternativaA,valorA,alternativaB,valorb)
			values ('Enunciado Pergunta num 3','num3 A',4,'num3 B',6);
            
insert into perguntas(Pergunta,alternativaA,valorA,alternativaB,valorb,alternativaC,valorC)
			values ('Enunciado Pergunta num 4','num4 A',10,'num4 B',5,'num4 C',3);