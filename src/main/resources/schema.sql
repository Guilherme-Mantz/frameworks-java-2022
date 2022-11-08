CREATE TABLE carro (
   placa VARCHAR(8) PRIMARY KEY,
   marca VARCHAR(20) NOT NULL,
   modelo VARCHAR(20) NOT NULL,
   cor VARCHAR(20) NOT NULL,
   ano INT NOT NULL,
   quilometragem INT NOT NULL,
   diaria FLOAT NOT NULL
);

CREATE TABLE cliente (
                         cliente_key INT PRIMARY KEY AUTO_INCREMENT,
                         nome VARCHAR(100) NOT NULL,
                         cpf BIGINT NOT NULL,
                         email VARCHAR(50) NOT NULL,
                         celular BIGINT NOT NULL
);

CREATE TABLE endereco (
                          endereco_key INT PRIMARY KEY AUTO_INCREMENT,
                          rua VARCHAR(50) NOT NULL,
                          numero INT NOT NULL,
                          complemento VARCHAR(50),
                          bairro VARCHAR(50) NOT NULL,
                          cidade VARCHAR(50) NOT NULL,
                          estado VARCHAR(2) NOT NULL,
                          cliente_key INT NOT NULL,
                          foreign key (cliente_key) references cliente(cliente_key)
);

CREATE TABLE vendedor (
  vendedor_key INT PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(100) NOT NULL,
  cpf BIGINT NOT NULL,
  data_admissao DATE NOT NULL
);

CREATE TABLE conta_corrente (
  conta_corrente_key INT PRIMARY KEY AUTO_INCREMENT,
  banco VARCHAR(50) not null,
  agencia INT NOT NULL,
  conta_corrente INT NOT NULL,
  vendedor_key INT NOT NULL,
  foreign key (vendedor_key) references vendedor(vendedor_key)
);

CREATE TABLE aluguel (
	aluguel_key INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	cliente_key INT NOT NULL,
	vendedor_key INT NOT NULL,
	carro_placa VARCHAR(8) NOT NULL,
	quantidade_de_dias_alugado INT NOT NULL,
	data_do_aluguel DATE NOT NULL,
	valor_total FLOAT NOT NULL,
	foreign key (cliente_key) references cliente(cliente_key),
	foreign key (vendedor_key) references vendedor(vendedor_key),
	foreign key (carro_placa) references carro(placa)
);

CREATE TABLE comissao(
    comissao_key INT PRIMARY KEY AUTO_INCREMENT,
    valor_comissao FLOAT NOT NULL,
    vendedor_key INT NOT NULL,
    aluguel_key INT NOT NULL,
    foreign key (vendedor_key) references vendedor(vendedor_key),
    foreign key (aluguel_key) references aluguel(aluguel_key)
);