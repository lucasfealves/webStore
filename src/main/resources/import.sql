insert into cliente (nome, cpf_cnpj, tipo_entrada, valor_limite, data_criacao) values ('Lucas', '07547187943', '1', 1000.00, '2020-01-01');
insert into cliente (nome, cpf_cnpj, tipo_entrada, valor_limite, data_criacao) values ('Lucas', '07547187943', '1', 1000.00, '2020-01-01');

insert into cliente_fone (cod_cliente, tipo_contato, ddd, telefone, data_criacao) values (1, 1, 41, 995919726, '2020-01-01');
insert into cliente_fone (cod_cliente, tipo_contato, ddd, telefone, data_criacao) values (1, 0, 41, 38012541, '2020-01-01');

insert into grupo_produto (nome) values ('Bebidas'), ('Litros'), ('Comidas');

insert into produto (nome, referencia, valor_custo, valor_venda, cod_grupo, data_criacao) values ('Refrigerante', '100', 3.45, 5.54, 1, '2020-01-01');
insert into produto (nome, referencia, valor_custo, valor_venda, cod_grupo, data_criacao) values ('Agua', '100', 3.45, 5.54, 1, '2020-01-01');

INSERT INTO usuario(chave, data_cad, data_criacao, data_modificacao, login, nome) VALUES ('a', '2020-09-10', '2020-09-10', '2020-09-10', 'a', 'a');

INSERT INTO venda(cod_cliente, cod_usuario) VALUES ((select id from cliente where nome like '%Lucas%' limit 1), (select id from usuario where nome like '%a%'));

INSERT INTO vendas_itens(qtde, valor_uni, cod_item, cod_venda) VALUES (1, 3.45, (select id from produto where nome like '%Refrigerante%'), (select id from venda limit 1));
INSERT INTO vendas_itens(qtde, valor_uni, cod_item, cod_venda) VALUES (1, 3.45, (select id from produto where nome like '%Agua%'), (select id from venda limit 1));
