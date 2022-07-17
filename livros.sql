

create table `cliente` (
  `idcliente` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `enderecoCompleto` varchar(60) NOT NULL,
  `telefone` varchar(11) NOT NULL,
  `cpf` varchar(11) DEFAULT NULL,
  `cnpj` varchar(14) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `compra` (
  `idcliente` int(11) NOT NULL,
  `idlivro` int(11) NOT NULL,
  `dataCompra` date NOT NULL,
  `quantCompra` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `editora` (
  `ideditora` int(11) NOT NULL,
  `nomeEditora` varchar(45) NOT NULL,
  `endereco` varchar(60) NOT NULL,
  `telefone` varchar(11) NOT NULL,
  `gerente` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `livro` (
  `idlivro` int(11) NOT NULL,
  `tituloLivro` varchar(45) NOT NULL,
  `isbn` varchar(13) NOT NULL,
  `assunto` varchar(45) NOT NULL,
  `autor` varchar(45) NOT NULL,
  `estoque` int(11) NOT NULL,
  `valor` decimal(10,2) NOT NULL,
  `ideditora` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;