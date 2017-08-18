create table tb_signo(
	signo varchar(15) not null,
    significado text null

);

ALTER TABLE ciganadigital.tb_nomes CONVERT TO CHARACTER SET utf8;


select * from tb_signo;

INSERT INTO tb_signo( signo, significado) VALUES( 'Leao','Leao é o rei da floresta :D');
