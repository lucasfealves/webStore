insert into cliente (nome, cpf_cnpj, tipo_entrada, valor_limite, data_criacao) values ('Lucas', '07547187943', '1', 1000.00, '2020-01-01');
insert into cliente (nome, cpf_cnpj, tipo_entrada, valor_limite, data_criacao) values ('Lucas', '07547187943', '1', 1000.00, '2020-01-01');

insert into cliente_fone (cod_cliente, tipo_contato, ddd, telefone, data_criacao) values (1, 1, 41, 995919726, '2020-01-01');
insert into cliente_fone (cod_cliente, tipo_contato, ddd, telefone, data_criacao) values (1, 0, 41, 38012541, '2020-01-01');

insert into grupo_produto (nome) values ('Bebidas'), ('Litros'), ('Comidas');

insert into produto (nome, referencia, valor_custo, valor_venda, cod_grupo, data_criacao) values ('Refrigerante', '100', 3.45, 5.54, 1, '2020-01-01');
insert into produto (nome, referencia, valor_custo, valor_venda, cod_grupo, data_criacao) values ('Agua', '100', 3.45, 5.54, 1, '2020-01-01');
