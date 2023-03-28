CREATE TABLE produtos
(
	id NUMBER GENERATED BY DEFAULT AS IDENTITY,
	nome VARCHAR2(128) NOT NULL,
	descricao VARCHAR2(128) NOT NULL,
	preco NUMBER(10, 2) NOT NULL,
	PRIMARY KEY (id)
);

SELECT * FROM produtos;

INSERT INTO produtos (nome, descricao, preco) VALUES ('Livro Java', 'Livro did�tico Java', 200);
INSERT INTO PRODUTOS (nome, descricao, preco) VALUES ('Livro Angular', 'Livro didatico Angular', 230);
commit;

ALTER TABLE PRODUTOS ADD qtd_estoque NUMBER DEFAULT 0 NOT NULL;
ALTER TABLE PRODUTOS MODIFY nome VARCHAR2(100);