delete
from submission;
delete
from candidate;
delete
from acceleration;
delete
from challenge;
delete
from company;
delete
from users;

insert into users (id, full_name, email, nickname, password, created_at)
values (6001, 'Bruno', 'bruno@gmail.com', 'nick_bruno', '123456', now());

insert into users (id, full_name, email, nickname, password, created_at)
values (6002, 'Fernando', 'fernando@email.com', 'nick_fernando', '123456', now());

insert into users (id, full_name, email, nickname, password, created_at)
values (6003, 'Marcela', 'marcela@email.com', 'nick_marcela', '123456', now());

insert into users (id, full_name, email, nickname, password, created_at)
values (6004, 'Geovanna', 'geovanna@email.com', 'nick_geovanna', '123456', now());

insert into users (id, full_name, email, nickname, password, created_at)
values (6005, 'Alisson', 'alisson@email.com', 'nick_alisson', '123456', now());

insert into company (id, created_at, name, slug)
VALUES (5001, now(), 'Blue Company', 'Blue Slug');

insert into company (id, created_at, name, slug)
VALUES (5002, now(), 'Green Company', 'Green Slug');

insert into challenge (id, created_at, name, slug)
values (1001, now(), 'Challenge A', 'The A Slug');

insert into challenge (id, created_at, name, slug)
values (1002, now(), 'Challenge B', 'The B Slug');

insert into challenge (id, created_at, name, slug)
values (1003, now(), 'Challenge C', 'The C Slug');

insert into acceleration (id, created_at, name, slug, challenge_id)
values (2001, now(), 'Metallica Acceleration', 'Black Album', 1001);

insert into acceleration (id, created_at, name, slug, challenge_id)
values (2002, now(), 'Slipknot Acceleration', 'IOWA', 1003);

insert into candidate (created_at, status, user_id, company_id, acceleration_id)
values (now(), 1, 6001, 5001, 2001);

insert into candidate (created_at, status, user_id, company_id, acceleration_id)
values (now(), 1, 6002, 5001, 2001);

insert into candidate (created_at, status, user_id, company_id, acceleration_id)
values (now(), 1, 6003, 5001, 2001);

insert into candidate (created_at, status, user_id, company_id, acceleration_id)
values (now(), 1, 6004, 5002, 2002);

insert into candidate (created_at, status, user_id, company_id, acceleration_id)
values (now(), 1, 6005, 5002, 2002);

insert into candidate (created_at, status, user_id, company_id, acceleration_id)
values (now(), 1, 6003, 5002, 2002);

insert into submission (created_at, score, user_id, challenge_id)
values (now(), 99, 6001, 1003);

insert into submission (created_at, score, user_id, challenge_id)
values (now(), 67, 6002, 1003);

insert into submission (created_at, score, user_id, challenge_id)
values (now(), 98, 6003, 1003);

insert into submission (created_at, score, user_id, challenge_id)
values (now(), 67, 6004, 1002);

/*
INSERT INTO Challenge (id,name, slug) values (1,'Desafio Java', 'Ativo');
INSERT INTO Challenge (id,name, slug) values (2,'Desafio Python', 'Ativo');
INSERT INTO Challenge (id,name, slug) values (3,'Desafio Oracle', 'Ativo');

INSERT INTO users (id, email, full_name, nickname, password) values (1, 'email1@codenation.dev', 'Aluno 001', 'Nick001','pass001');
INSERT INTO users (id, email, full_name, nickname, password) values (2, 'email2@codenation.dev', 'Aluno 002', 'Nick002','pass002');
INSERT INTO users (id, email, full_name, nickname, password) values (3, 'email3@codenation.dev', 'Aluno 003', 'Nick003','pass003');
INSERT INTO users (id, email, full_name, nickname, password) values (4, 'email4@codenation.dev', 'Aluno 004', 'Nick004','pass004');
INSERT INTO users (id, email, full_name, nickname, password) values (5, 'email5@codenation.dev', 'Aluno 005', 'Nick005','pass005');
INSERT INTO users (id, email, full_name, nickname, password) values (6, 'email6@codenation.dev', 'Aluno 006', 'Nick006','pass006');

INSERT INTO acceleration (id, name, slug, challenge_id) values (1, 'Java OnLine', 'Ativo', 1);
INSERT INTO acceleration (id, name, slug, challenge_id) values (2, 'Python OnLine', 'Ativo', 2);
INSERT INTO acceleration (id, name, slug, challenge_id) values (3, 'Oracle OnLine', 'Ativo', 3);


INSERT INTO submission (user_id, challenge_id, score) values (1,1,70.00);
INSERT INTO submission (user_id, challenge_id, score) values (2,2,90.00);
INSERT INTO submission (user_id, challenge_id, score) values (3,3,23.00);
INSERT INTO submission (user_id, challenge_id, score) values (4,3,80.00);
INSERT INTO submission (user_id, challenge_id, score) values (5,3,100.00);
INSERT INTO submission (user_id, challenge_id, score) values (6,2,100.00);

insert into company (id, name, slug, created_at) values (1,'Codenation', 'ativa', now());
insert into company (id, name, slug, created_at) values (2,'Evoluum', 'ativa', now());
insert into company (id, name, slug, created_at) values (3,'Conta Azul', 'ativa', now());

insert into candidate (user_id, acceleration_id, company_id, status, created_at) values (1,1,1,1, now());
insert into candidate (user_id, acceleration_id, company_id, status, created_at) values (2,2,2,1, now());
insert into candidate (user_id, acceleration_id, company_id, status, created_at) values (3,3,3,1, now());
insert into candidate (user_id, acceleration_id, company_id, status, created_at) values (4,3,3,1, now());
insert into candidate (user_id, acceleration_id, company_id, status, created_at) values (5,3,3,1, now());
insert into candidate (user_id, acceleration_id, company_id, status, created_at) values (6,2,2,0, now());
*/