drop database if exists oi2fit;
CREATE database IF NOT EXISTS oi2fit DEFAULT CHARACTER SET utf8MB4 ;
USE oi2fit;
#SET SQL_SAFE_UPDATES = 0;

CREATE TABLE IF NOT EXISTS Colaborador (
  id_colab integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
  nome_colab VARCHAR(45) NOT NULL,
  login_colab VARCHAR(45) NOT NULL,
  senha_colab VARCHAR(100) NOT NULL,
  cpf_colab BIGINT(11) NOT NULL,
  Unique(cpf_colab),
  Unique(login_colab));

CREATE TABLE IF NOT EXISTS Aluno (
  id_alu integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
  nome_alu VARCHAR(45) NOT NULL,
  cpf_alu BIGINT(11) NOT NULL,
  sexo_alu VARCHAR(45) NOT NULL,
  idade_alu INT NOT NULL,
  email_alu VARCHAR(80) NOT NULL,
  data_matricula_alu DATE NULL,
  id_colab INT NULL,
  id_treino INT NULL,
  constraint fk_aluno_colaborador foreign key (id_colab) references Colaborador(id_colab)
  );  
  
  CREATE TABLE IF NOT EXISTS Treino(
	id_treino integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
    atividade VARCHAR(1000) NOT NULL,
	id_alu INT NOT NULL,
	constraint fk_aluno_treino foreign key (id_alu) references Aluno(id_alu)
);

CREATE TABLE IF NOT EXISTS Medidas (
  id_medida integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
  data_medidas TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  peso_kg float NOT NULL,
  altura_m float NOT NULL,
  imc float NOT NULL,
  id_alu INT NOT NULL,
  constraint fk_aluno_medida foreign key (id_alu) references Aluno(id_alu)
);

CREATE TABLE IF NOT EXISTS Logs_Aluno  (
	id_log integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
	updated_at datetime DEFAULT NOW(),
    id_alu INT NOT NULL,
	constraint fk_Aluno_log foreign key (id_log) references Aluno(id_alu)
);

CREATE TABLE IF NOT EXISTS Logs_Colaborador  (
	id_log integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
	updated_at datetime DEFAULT NOW(),
    id_colab INT NOT NULL,
	constraint fk_Colaborador_log foreign key (id_log) references Aluno(id_colab)
);

INSERT INTO Colaborador (nome_colab, login_colab, senha_colab, cpf_colab) VALUES ('Administrador', 'adm', '86f65e28a754e1a71b2df9403615a6c436c32c42a75a10d02813961b86f1e428', '12312312312'); 
INSERT INTO Colaborador (nome_colab, login_colab, senha_colab, cpf_colab) VALUES ('Administrador2', 'adm2', '86f65e28a754e1a71b2df9403615a6c436c32c42a75a10d02813961b86f1e428', '12312312333'); 

INSERT INTO Aluno (nome_alu, cpf_alu, sexo_alu, idade_alu, email_alu, data_matricula_alu, id_colab) VALUES ('Guilherme', '09853680974', 'Masculino', '18', 'gui@gmail.com', '2022-09-20', 1); 
INSERT INTO Aluno (nome_alu, cpf_alu, sexo_alu, idade_alu, email_alu, data_matricula_alu, id_colab) VALUES ('Jonas', '12345678901', 'Masculino', '20', 'jon@gmail.com', '2022-12-25', 1); 
INSERT INTO Aluno (nome_alu, cpf_alu, sexo_alu, idade_alu, email_alu, data_matricula_alu, id_colab) VALUES ('Michelle', '11111111113', 'Feminino', '22', 'michelle@gmail.com', '2022-10-24', 1); 
INSERT INTO Aluno (nome_alu, cpf_alu, sexo_alu, idade_alu, email_alu, data_matricula_alu, id_colab) VALUES ('Laura', '12398787494', 'Feminino', '13', 'laulau@gmail.com', '2022-11-27', 1); 

INSERT INTO Medidas (peso_kg, altura_m, imc, id_alu) VALUES ('70', '1.70', '25', '4'); 
INSERT INTO Medidas (peso_kg, altura_m, imc, id_alu) VALUES ('65', '1.70', '24', '4');
INSERT INTO Medidas (peso_kg, altura_m, imc, id_alu) VALUES ('60', '1.70', '20', '4');
INSERT INTO Medidas (peso_kg, altura_m, imc, id_alu) VALUES ('80', '1.80', '30', '3'); 

INSERT INTO Treino (atividade, id_alu) VALUES ('Treino A de posterior', '4'); 
INSERT INTO Treino (atividade, id_alu) VALUES ('Treino A de inferior', '3'); 


DELIMITER $$

CREATE TRIGGER aluno_update
AFTER UPDATE
ON Aluno FOR EACH ROW
BEGIN
        INSERT INTO Logs_Aluno(id_alu,updated_at)
        VALUES(old.id_alu, current_timestamp());
END$$

DELIMITER ;

DELIMITER $$

CREATE TRIGGER colaborador_update
AFTER UPDATE
ON Colaborador FOR EACH ROW
BEGIN
        INSERT INTO Logs_Colaborador(id_colab,updated_at)
        VALUES(old.id_colab, current_timestamp());
END$$

DELIMITER ;

select * from aluno;
select * from colaborador;
select * from medidas;
select * from treino;
select * from Logs_Aluno;
select * from Logs_Colaborador;
