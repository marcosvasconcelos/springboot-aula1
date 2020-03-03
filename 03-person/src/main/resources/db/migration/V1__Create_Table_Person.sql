CREATE TABLE mydb.person (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `endereco` varchar(100) NOT NULL,
  `genero` varchar(8) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `sobre_nome` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
);