INSERT INTO CLIENTE_ENTITY(nome, cpf, data_nasc) VALUES ('Arthur', '83817273', '02/03/1994');
INSERT INTO CLIENTE_ENTITY(nome, cpf, data_nasc) VALUES ('Appio', '1882939193', '15/08/1950');

INSERT INTO SALA_ENTITY(numero, capacidade) VALUES (1, 150);
INSERT INTO SALA_ENTITY(numero, capacidade) VALUES (2, 100);

INSERT INTO SESSAO_ENTITY(valor, titulo, sala_id) VALUES (23.50, 'AS BRANQUELAS', 2);
INSERT INTO SESSAO_ENTITY(valor, titulo, sala_id) VALUES (39.99, 'SHREK 2', 1);

INSERT INTO VENDA_ENTITY(cliente_id) VALUES (1);
INSERT INTO VENDA_ENTITY(cliente_id) VALUES(2);

INSERT INTO VENDA_SESSAO(venda_id, sessao_id) VALUES (2,1);
INSERT INTO VENDA_SESSAO(venda_id, sessao_id) VALUES (1,2);

INSERT INTO USUARIO_ENTITY(username, password) VALUES('usuarioteste', '$2a$12$7FaFlSUb5iY/mXHeE2ZeK.m4mWf9Tcak0JVHqSwRtKGXib1gNM4Ky')