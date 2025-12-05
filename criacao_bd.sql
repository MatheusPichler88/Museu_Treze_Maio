CREATE DATABASE MuseuTrezeDeMaio;
GO

USE MuseuTrezeDeMaio;
GO

-- Criação da tabela de usuarios
CREATE TABLE usuarios (
    id_usuario INT PRIMARY KEY IDENTITY(1,1),
    nome VARCHAR(255) NOT NULL,
    tipo VARCHAR(50) DEFAULT 'Comunidade',
    telefone VARCHAR(20),
    email VARCHAR(100),
    endereco VARCHAR(255),
    data_cadastro DATETIME DEFAULT GETDATE()
);
GO

-- Criação da tabela de autores
CREATE TABLE autores (
    id_autor INT PRIMARY KEY IDENTITY(1,1),
    nome VARCHAR(255) NOT NULL,
    nacionalidade VARCHAR(50),
    data_nascimento DATE
);
GO

-- Criação da tabela de categorias
CREATE TABLE categorias (
    id_categoria INT PRIMARY KEY IDENTITY(1,1),
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(500)
);
GO

-- Criação da tabela de materias da biblioteca
CREATE TABLE materiais_biblioteca (
    id_material INT PRIMARY KEY IDENTITY(1,1),
    tipo VARCHAR(50) NOT NULL,
    titulo VARCHAR(255) NOT NULL,
    id_autor INT NULL,
    autor_desconhecido VARCHAR(255) NULL,
    ano_publicacao INT,
    id_categoria INT NULL,
    descricao VARCHAR(1000),
    isbn VARCHAR(20),
    editora VARCHAR(100),
    quantidade_exemplares INT DEFAULT 1,
    disponivel BIT DEFAULT 1,
    data_cadastro DATETIME DEFAULT GETDATE()
);
GO
-- Criação da tabela do acervo historico
CREATE TABLE acervo_historico (
    id_item INT PRIMARY KEY IDENTITY(1,1),
    tipo VARCHAR(50) NOT NULL,
    titulo VARCHAR(255) NOT NULL,
    descricao VARCHAR(1000),
    data_item DATE,
    palavra_chave VARCHAR(255),
    local_origem VARCHAR(100),
    doador VARCHAR(100),
    caminho_digitalizacao VARCHAR(500),
    data_cadastro DATETIME DEFAULT GETDATE()
);
GO

-- Criação da tabela de emprestimos
CREATE TABLE emprestimos (
    id_emprestimo INT PRIMARY KEY IDENTITY(1,1),
    id_material INT NOT NULL,
    id_usuario INT NOT NULL,
    data_emprestimo DATETIME DEFAULT GETDATE(),
    data_devolucao_prevista DATE NOT NULL,
    data_devolucao_real DATE NULL,
    status_emprestimo VARCHAR(50) DEFAULT 'Ativo'
);
GO
-- Criação da tabela de logs
CREATE TABLE log_sistema (
    id_log INT PRIMARY KEY IDENTITY(1,1),
    tabela VARCHAR(50) NOT NULL,
    id_item INT NOT NULL,              
    acao VARCHAR(10) NOT NULL,
    data_acao DATETIME DEFAULT GETDATE() 
);
GO

-- Alterações de chaves estrangeiras nas tabelas
ALTER TABLE materiais_biblioteca ADD
    FOREIGN KEY (id_autor) REFERENCES autores(id_autor),
    FOREIGN KEY (id_categoria) REFERENCES categorias(id_categoria);
GO

ALTER TABLE emprestimos ADD
    FOREIGN KEY (id_material) REFERENCES materiais_biblioteca(id_material),
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario);
GO

