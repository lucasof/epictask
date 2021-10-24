--51:37
CREATE TABLE task (
	id bigint primary key auto_increment,
	title varchar(200),
	description varchar(200),
	points int
);


insert into task(title, description, points) values ('alterar tela do usuário','inserir os campos novos na tela',100);

insert into task(title, description, points) values ('fazer testes unitários','fazer teste unitários das classes criadas',200);

insert into task(title, description, points) values ('gerar relatório','gerar relatório de logins',150);