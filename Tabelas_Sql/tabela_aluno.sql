CREATE TABLE ALUNO(
	RGMALUNO INT(8) NOT NULL,
	NOME VARCHAR(80) NOT NULL,
    DTANASC VARCHAR(10) NOT NULL,
    CPF VARCHAR(14) NOT NULL,
    EMAIL VARCHAR(60) NOT NULL,
    ENDERECO VARCHAR(150) NOT NULL,
    MUNICIPIO VARCHAR(50) NOT NULL,
    UF CHAR(2) NOT NULL,
    CELULAR VARCHAR(15) NOT NULL,
    CURSO VARCHAR(50) NOT NULL,
    CAMPUS VARCHAR(15) NOT NULL,
    PERIODO VARCHAR(15) NOT NULL,
    CONSTRAINT PK_ALUNO PRIMARY KEY (RGMALUNO)
	
)ENGINE = INNODB;