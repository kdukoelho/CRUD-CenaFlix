CREATE DATABASE `cenaflix`
DEFAULT CHARACTER SET=utf8mb4
DEFAULT COLLATE=utf8mb4_general_ci;

USE `cenaflix`;

CREATE TABLE `filmes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(150) NOT NULL,
  `datalancamento` date NOT NULL,
  `categoria` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;