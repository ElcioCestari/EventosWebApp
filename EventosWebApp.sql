CREATE DATABASE EventosWebApp;

USE EventosWebApp;

CREATE TABLE mapa(
	id_mapa MEDIUMINT  NOT NULL AUTO_INCREMENT,
	PRIMARY KEY(id_mapa) 
);


CREATE TABLE endereco(
	id_endereco MEDIUMINT NOT NULL AUTO_INCREMENT,
	rua VARCHAR(256) NOT NULL,
	numero INT,
	bairro VARCHAR(256) NOT NULL,
	cidade VARCHAR(256) NOT NULL DEFAULT 'Campo Grande',
	estado VARCHAR(2) NOT NULL DEFAULT 'MS',
	id_mapa MEDIUMINT,
	PRIMARY KEY(id_endereco),
	FOREIGN KEY(id_mapa) REFERENCES mapa(id_mapa)
);

CREATE TABLE local(
	id_local MEDIUMINT NOT NULL AUTO_INCREMENT,
	capacidade INT,
	nome VARCHAR(256) NOT NULL,
	id_endereco MEDIUMINT,
	PRIMARY  KEY(id_local),
	FOREIGN KEY(id_endereco) REFERENCES endereco(id_endereco)
);

CREATE TABLE evento(
	tipo_evento VARCHAR(256) NOT NULL DEFAULT 'Festa',
	valor DECIMAL NOT NULL,
	nome VARCHAR(256) NOT NULL,
	id_evento MEDIUMINT NOT NULL AUTO_INCREMENT,
	faixaEtaria INT NOT NULL DEFAULT 1 CHECK (faixaEtaria > 0),	
	curtidas INT DEFAULT 0 CHECK (curtidas >= 0),
	naoCurtidas INT DEFAULT 0 CHECK (naoCurtidas >= 0),
	duracao TIME,
	data TIMESTAMP NOT NULL,
	id_local MEDIUMINT,
	PRIMARY KEY (id_evento),
	FOREIGN KEY (id_local) REFERENCES local(id_local)
);

CREATE TABLE usuario(
	login VARCHAR(256) NOT NULL,
	nome VARCHAR(256) NOT NULL,
	idade int NOT NULL, CHECK (idade > 0),
	id_usuario MEDIUMINT NOT NULL AUTO_INCREMENT,
	senha VARCHAR(256) NOT NULL,
	PRIMARY KEY (id_usuario)
);

CREATE TABLE comentario(
	id_comentario MEDIUMINT NOT NULL AUTO_INCREMENT,
	descricao TEXT NOT NULL,
	PRIMARY KEY(id_comentario),
	id_usuario MEDIUMINT, FOREIGN KEY(id_usuario) REFERENCES usuario(id_usuario),
	id_evento MEDIUMINT, FOREIGN KEY(id_evento) REFERENCES evento(id_evento)
);


ALTER TABLE evento
ADD id_usuario MEDIUMINT;

ALTER TABLE evento
ADD CONSTRAINT FOREIGN KEY(id_usuario) REFERENCES usuario(id_usuario);

ALTER TABLE evento
ADD descricao VARCHAR(256) DEFAULT '';




