INSERT INTO CLIENTE_ENTITY(nome, cpf, data_nasc) VALUES ('Arthur', '83817273', '02/03/1994');
INSERT INTO CLIENTE_ENTITY(nome, cpf, data_nasc) VALUES ('Appio', '1882939193', '15/08/1950');

INSERT INTO SESSAO_ENTITY(valor, titulo) VALUES (23.50, 'AS BRANQUELAS');
INSERT INTO SESSAO_ENTITY(valor, titulo) VALUES (39.99, 'SHREK 2');

INSERT INTO SALA_ENTITY(capacidade) VALUES (150);
INSERT INTO SALA_ENTITY(capacidade) VALUES (100);

INSERT INTO VENDA_ENTITY(cliente_id, sessao_id, sala_id) VALUES (1, 2, 2);
INSERT INTO VENDA_ENTITY(cliente_id, sessao_id, sala_id) VALUES(2, 1, 1);

INSERT INTO USUARIO_ENTITY(username, password) VALUES('usuarioteste', '$2a$12$7FaFlSUb5iY/mXHeE2ZeK.m4mWf9Tcak0JVHqSwRtKGXib1gNM4Ky')