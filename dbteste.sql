-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 08-Nov-2018 às 16:38
-- Versão do servidor: 10.1.36-MariaDB
-- versão do PHP: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbteste`
--
CREATE DATABASE IF NOT EXISTS `dbteste` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `dbteste`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_clientes`
--

DROP TABLE IF EXISTS `tb_clientes`;
CREATE TABLE `tb_clientes` (
  `pk_id_cliente` bigint(20) UNSIGNED NOT NULL,
  `cli_nome` varchar(200) NOT NULL,
  `cli_endereco` varchar(200) NOT NULL,
  `cli_bairro` varchar(200) NOT NULL,
  `cli_cidade` varchar(100) NOT NULL,
  `cli_uf` varchar(2) NOT NULL,
  `cli_cep` varchar(9) DEFAULT NULL,
  `cli_telefone` varchar(16) DEFAULT NULL,
  `cli_cpf` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tb_clientes`
--

INSERT INTO `tb_clientes` (`pk_id_cliente`, `cli_nome`, `cli_endereco`, `cli_bairro`, `cli_cidade`, `cli_uf`, `cli_cep`, `cli_telefone`, `cli_cpf`) VALUES
(1, 'levi', 'Rua Primavera', 'Sobradinho', 'Feira de Santana', 'BA', '6543213', '654654654', '');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_produto`
--

DROP TABLE IF EXISTS `tb_produto`;
CREATE TABLE `tb_produto` (
  `pk_id_produto` bigint(20) UNSIGNED NOT NULL,
  `pro_nome` varchar(200) NOT NULL,
  `pro_valor` double NOT NULL,
  `pro_valor_final` double NOT NULL,
  `pro_estoque` int(11) NOT NULL,
  `pro_validade` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tb_produto`
--

INSERT INTO `tb_produto` (`pk_id_produto`, `pro_nome`, `pro_valor`, `pro_valor_final`, `pro_estoque`, `pro_validade`) VALUES
(1, 'Teste', 100, 150, 2, '2018-11-14'),
(9, 'teste', 150, 200, 5, '2018-11-06'),
(10, 'teste4', 3200, 320, 96, '2018-11-02');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_usuarios`
--

DROP TABLE IF EXISTS `tb_usuarios`;
CREATE TABLE `tb_usuarios` (
  `pk_id_usuario` bigint(20) UNSIGNED NOT NULL,
  `usu_nome` varchar(200) NOT NULL,
  `usu_login` varchar(50) NOT NULL,
  `usu_senha` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tb_usuarios`
--

INSERT INTO `tb_usuarios` (`pk_id_usuario`, `usu_nome`, `usu_login`, `usu_senha`) VALUES
(1, 'levi', 'levi', '123');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_vendas`
--

DROP TABLE IF EXISTS `tb_vendas`;
CREATE TABLE `tb_vendas` (
  `pk_id_vendas` bigint(20) UNSIGNED NOT NULL,
  `fk_cliente` bigint(20) UNSIGNED NOT NULL,
  `ven_data_venda` date NOT NULL,
  `ven_valorLiquido` double NOT NULL,
  `ven_valorBruto` double NOT NULL,
  `ven_desconto` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tb_vendas`
--

INSERT INTO `tb_vendas` (`pk_id_vendas`, `fk_cliente`, `ven_data_venda`, `ven_valorLiquido`, `ven_valorBruto`, `ven_desconto`) VALUES
(8, 1, '2018-11-08', 7150, 7150, 0),
(9, 1, '2018-11-08', 0, 0, 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_vendas_produtos`
--

DROP TABLE IF EXISTS `tb_vendas_produtos`;
CREATE TABLE `tb_vendas_produtos` (
  `pk_id_venda_produto` bigint(20) UNSIGNED NOT NULL,
  `fk_produto` bigint(20) UNSIGNED NOT NULL,
  `fk_vendas` bigint(20) UNSIGNED NOT NULL,
  `ven_pro_valor` double NOT NULL,
  `ven_pro_quantidade` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tb_vendas_produtos`
--

INSERT INTO `tb_vendas_produtos` (`pk_id_venda_produto`, `fk_produto`, `fk_vendas`, `ven_pro_valor`, `ven_pro_quantidade`) VALUES
(1, 10, 8, 3200, 2),
(2, 9, 8, 150, 5);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_clientes`
--
ALTER TABLE `tb_clientes`
  ADD PRIMARY KEY (`pk_id_cliente`),
  ADD UNIQUE KEY `idCliente` (`pk_id_cliente`),
  ADD UNIQUE KEY `cli_cpf` (`cli_cpf`);

--
-- Indexes for table `tb_produto`
--
ALTER TABLE `tb_produto`
  ADD PRIMARY KEY (`pk_id_produto`),
  ADD UNIQUE KEY `pk_idProduto` (`pk_id_produto`);

--
-- Indexes for table `tb_usuarios`
--
ALTER TABLE `tb_usuarios`
  ADD PRIMARY KEY (`pk_id_usuario`),
  ADD UNIQUE KEY `idUsuario` (`pk_id_usuario`);

--
-- Indexes for table `tb_vendas`
--
ALTER TABLE `tb_vendas`
  ADD PRIMARY KEY (`pk_id_vendas`),
  ADD KEY `fkCliente` (`fk_cliente`);

--
-- Indexes for table `tb_vendas_produtos`
--
ALTER TABLE `tb_vendas_produtos`
  ADD PRIMARY KEY (`pk_id_venda_produto`),
  ADD KEY `fkVendas` (`fk_vendas`),
  ADD KEY `fkProduto` (`fk_produto`) USING BTREE;

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_clientes`
--
ALTER TABLE `tb_clientes`
  MODIFY `pk_id_cliente` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tb_produto`
--
ALTER TABLE `tb_produto`
  MODIFY `pk_id_produto` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `tb_usuarios`
--
ALTER TABLE `tb_usuarios`
  MODIFY `pk_id_usuario` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tb_vendas`
--
ALTER TABLE `tb_vendas`
  MODIFY `pk_id_vendas` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `tb_vendas_produtos`
--
ALTER TABLE `tb_vendas_produtos`
  MODIFY `pk_id_venda_produto` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `tb_vendas`
--
ALTER TABLE `tb_vendas`
  ADD CONSTRAINT `tb_vendas_ibfk_1` FOREIGN KEY (`fk_cliente`) REFERENCES `tb_clientes` (`pk_id_cliente`);

--
-- Limitadores para a tabela `tb_vendas_produtos`
--
ALTER TABLE `tb_vendas_produtos`
  ADD CONSTRAINT `tb_vendas_produtos_ibfk_1` FOREIGN KEY (`fk_produto`) REFERENCES `tb_produto` (`pk_id_produto`),
  ADD CONSTRAINT `tb_vendas_produtos_ibfk_2` FOREIGN KEY (`fk_vendas`) REFERENCES `tb_vendas` (`pk_id_vendas`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
